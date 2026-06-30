package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.AppDatabase
import com.example.data.VocationalRepository
import com.example.data.VocationalResult
import com.example.model.QuestionData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class VocationalViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: VocationalRepository

    init {
        val database = AppDatabase.getDatabase(application)
        repository = VocationalRepository(database.dao())
    }

    // Observable past result list
    val history: StateFlow<List<VocationalResult>> = repository.allResults
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    private val _currentScreen = MutableStateFlow<Screen>(Screen.Welcome)
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> = _userName.asStateFlow()

    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: StateFlow<Int> = _currentIndex.asStateFlow()

    private val _answers = MutableStateFlow<Map<Int, Int>>(emptyMap())
    val answers: StateFlow<Map<Int, Int>> = _answers.asStateFlow()

    private val _activeResult = MutableStateFlow<VocationalResult?>(null)
    val activeResult: StateFlow<VocationalResult?> = _activeResult.asStateFlow()

    fun updateUserName(name: String) {
        _userName.value = name
    }

    fun startTest() {
        _currentIndex.value = 0
        _answers.value = emptyMap()
        _activeResult.value = null
        _currentScreen.value = Screen.Test
    }

    fun answerCurrentQuestion(score: Int) {
        val currentQuestion = QuestionData.questions[_currentIndex.value]
        val updatedAnswers = _answers.value.toMutableMap()
        updatedAnswers[currentQuestion.id] = score
        _answers.value = updatedAnswers
    }

    fun nextQuestion() {
        if (_currentIndex.value < QuestionData.questions.size - 1) {
            _currentIndex.value += 1
        } else {
            finishTestAndCalculate()
        }
    }

    fun previousQuestion() {
        if (_currentIndex.value > 0) {
            _currentIndex.value -= 1
        }
    }

    fun goToHistoryScreen() {
        _currentScreen.value = Screen.History
    }

    fun goToWelcomeScreen() {
        _userName.value = ""
        _currentScreen.value = Screen.Welcome
    }

    fun deleteHistoryResult(id: Int) {
        viewModelScope.launch {
            repository.delete(id)
        }
    }

    fun viewResult(result: VocationalResult) {
        _activeResult.value = result
        _currentScreen.value = Screen.Results
    }

    private fun finishTestAndCalculate() {
        val ans = _answers.value
        var r = 0
        var i = 0
        var a = 0
        var s = 0
        var e = 0
        var c = 0

        for (q in QuestionData.questions) {
            val score = ans[q.id] ?: 0
            when (q.dimension) {
                "R" -> r += score
                "I" -> i += score
                "A" -> a += score
                "S" -> s += score
                "E" -> e += score
                "C" -> c += score
            }
        }

        val dimensionSums = listOf(
            "R" to r,
            "I" to i,
            "A" to a,
            "S" to s,
            "E" to e,
            "C" to c
        )

        // Sort desc, then break ties alphabetically
        val sortedDimensions = dimensionSums.sortedWith(
            compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first }
        )

        val topThree = sortedDimensions.take(3).map { it.first }.joinToString("")

        val newResult = VocationalResult(
            userName = _userName.value.ifBlank { "Evaluado" },
            rScore = r,
            iScore = i,
            aScore = a,
            sScore = s,
            eScore = e,
            cScore = c,
            topThree = topThree,
            timestamp = System.currentTimeMillis()
        )

        viewModelScope.launch {
            repository.insert(newResult)
            _activeResult.value = newResult
            _currentScreen.value = Screen.Results
        }
    }

    sealed class Screen {
        object Welcome : Screen()
        object Test : Screen()
        object Results : Screen()
        object History : Screen()
    }
}
