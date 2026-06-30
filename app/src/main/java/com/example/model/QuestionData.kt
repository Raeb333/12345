package com.example.model

object QuestionData {
    val questions = listOf(
        // Realista (R)
        Question(1, "Reparar o dar mantenimiento a aparatos mecánicos, eléctricos o electrónicos en casa.", "R"),
        Question(2, "Trabajar al aire libre cultivando plantas, cuidando animales o en proyectos de agricultura.", "R"),
        Question(3, "Construir o armar cosas con mis propias manos utilizando herramientas y madera o metal.", "R"),
        Question(4, "Operar maquinaria, equipos técnicos o herramientas especializadas con precisión.", "R"),
        Question(5, "Aprender el funcionamiento técnico de vehículos, motores o sistemas de ingeniería.", "R"),

        // Investigador (I)
        Question(6, "Investigar de manera profunda el origen de fenómenos científicos o problemas de salud.", "I"),
        Question(7, "Resolver problemas abstractos usando razonamiento matemático, fórmulas o lógica avanzada.", "I"),
        Question(8, "Realizar experimentos en laboratorios o analizar datos complejos para encontrar explicaciones.", "I"),
        Question(9, "Leer artículos científicos o técnicos para comprender cómo funciona el cuerpo humano o el universo.", "I"),
        Question(10, "Diseñar hipótesis y metodologías para responder a dudas intelectuales o de investigación científica.", "I"),

        // Artístico (A)
        Question(11, "Expresarme de forma creativa a través del dibujo, la pintura, la fotografía o la escultura.", "A"),
        Question(12, "Escribir historias ficticias, poemas, guiones de teatro o artículos literarios creativos.", "A"),
        Question(13, "Tocar un instrumento musical, componer melodías o experimentar con la producción de audio.", "A"),
        Question(14, "Diseñar el aspecto visual de algo (sitios web, ropa, interiores, publicidad o marcas).", "A"),
        Question(15, "Actuar, bailar o participar en el diseño creativo de producciones escénicas y artísticas.", "A"),

        // Social (S)
        Question(16, "Explicar temas difíciles a otras personas de forma que me entiendan con claridad (enseñar).", "S"),
        Question(17, "Escuchar activamente a alguien que tiene problemas emocionales o personales y ofrecerle mi apoyo.", "S"),
        Question(18, "Participar en actividades de voluntariado o servicio social para ayudar a comunidades vulnerables.", "S"),
        Question(19, "Guiar y mediar en la resolución de conflictos interpersonales para lograr la armonía grupal.", "S"),
        Question(20, "Trabajar de manera colaborativa en equipos multidisciplinarios para el bienestar colectivo.", "S"),

        // Emprendedor (E)
        Question(21, "Liderar a un equipo de trabajo para alcanzar una meta o un proyecto comercial ambicioso.", "E"),
        Question(22, "Persuadir a la gente y vender ideas, productos o servicios con facilidad.", "E"),
        Question(23, "Tomar iniciativa y asumir riesgos para iniciar un negocio, startup o proyecto de emprendimiento.", "E"),
        Question(24, "Negociar acuerdos comerciales, contratos o convencer a socios para que inviertan en una idea.", "E"),
        Question(25, "Hablar en público frente a audiencias grandes presentando propuestas, proyectos o discursos.", "E"),

        // Convencional (C)
        Question(26, "Organizar información numérica o bases de datos con un alto nivel de orden y precisión.", "C"),
        Question(27, "Seguir instrucciones detalladas y procedimientos establecidos con rigurosa disciplina.", "C"),
        Question(28, "Revisar facturas, presupuestos o reportes financieros para asegurar que no tengan errores.", "C"),
        Question(29, "Establecer archivos ordenados de documentos físicos o digitales bajo un sistema claro de clasificación.", "C"),
        Question(30, "Planificar paso a paso cronogramas de actividades rutinarias y coordinar detalles logísticos.", "C")
    )

    data class DimensionDetail(
        val code: String,
        val name: String,
        val description: String,
        val highlight: String,
        val careers: List<String>
    )

    val dimensionsMap = mapOf(
        "R" to DimensionDetail(
            code = "R",
            name = "Realista",
            description = "Te agrada realizar actividades prácticas, trabajar con tus manos, herramientas, maquinaria, plantas o animales. Prefieres la acción directa y soluciones concretas sobre debates teóricos.",
            highlight = "habilidades prácticas, destreza manual, orientación a la acción y resolución de problemas materiales",
            careers = listOf(
                "Ingeniería Mecatrónica, Robótica o Civil",
                "Agronomía o Medicina Veterinaria",
                "Arquitectura o Diseño Industrial",
                "Ciencias Ambientales o Ingeniería Forestal",
                "Redes y Telecomunicaciones"
            )
        ),
        "I" to DimensionDetail(
            code = "I",
            name = "Investigador",
            description = "Posees una mente analítica, curiosa y científica. Disfrutas explorar por qué ocurren las cosas, investigar con datos, realizar experimentos y resolver problemas abstractos o complejos.",
            highlight = "pensamiento analítico, investigación científica, rigurosidad mental y resolución de enigmas complejos",
            careers = listOf(
                "Biotecnología, Bioquímica o Medicina",
                "Física, Matemáticas o Química pura",
                "Ciencia de Datos / Inteligencia Artificial",
                "Psicología Científica o Neurociencias",
                "Astronomía, Astrofísica o Geología"
            )
        ),
        "A" to DimensionDetail(
            code = "A",
            name = "Artístico",
            description = "Eres altamente creativo, original e independiente. Valoras la libre expresión, la innovación estética, el diseño y las actividades artísticas como la música, escritura, artes visuales o escénicas.",
            highlight = "creatividad desbordante, expresión emocional, sensibilidad estética y pensamiento independiente",
            careers = listOf(
                "Diseño Gráfico, Multimedia, Animación 3D",
                "Artes Visuales o Escritura Creativa",
                "Cinematografía, Fotografía o Producción Audiovisual",
                "Composición, Música o Producción Sonora",
                "Arquitectura, Diseño de Interiores o Moda"
            )
        ),
        "S" to DimensionDetail(
            code = "S",
            name = "Social",
            description = "Te apasiona el apoyo humano, la enseñanza, curar, orientar y colaborar con otros. Tu empatía y habilidades de comunicación interpersonal son clave para tu satisfacción laboral.",
            highlight = "empatía sincera, vocación de servicio, mediación de conflictos y facilitación del aprendizaje",
            careers = listOf(
                "Psicología Clínica, Educativa u Organizacional",
                "Educación Preescolar, Primaria o Secundaria",
                "Enfermería, Fisioterapia u Optometría",
                "Trabajo Social, Sociología o Tutoría",
                "Relaciones Públicas, Comunicación o Recursos Humanos"
            )
        ),
        "E" to DimensionDetail(
            code = "E",
            name = "Emprendedor",
            description = "Tienes madera de líder, facilidad de palabra y ambición. Te motiva dirigir equipos, negociar, persuadir, emprender iniciativas, asumir riesgos y lograr metas corporativas.",
            highlight = "liderazgo asertivo, capacidad de persuasión, iniciativa proactiva y toma de decisiones comerciales",
            careers = listOf(
                "Administración de Empresas o Creación de Negocios",
                "Mercadotecnia, Publicidad o Brand Strategy",
                "Finanzas, Banca o Dirección Comercial",
                "Derecho o Ciencias Políticas",
                "Relaciones Internacionales o Comercio Exterior"
            )
        ),
        "C" to DimensionDetail(
            code = "C",
            name = "Convencional",
            description = "Sobresales en la organización, el detalle, la estructuración de datos y el cumplimiento de normas o presupuestos. Prefieres un marco de trabajo ordenado, claro, lógico y bien planificado.",
            highlight = "precisión milimétrica, organización sistemática, análisis de datos y control de directrices",
            careers = listOf(
                "Contaduría Pública, Auditoría o Finanzas",
                "Actuaría o Estadística Aplicada",
                "Análisis de Datos Financieros o Business Intelligence",
                "Gestión de Operaciones, Logística y Distribución",
                "Administración de Archivos y Bibliotecología"
            )
        )
    )

    fun getRecommendations(topCodes: List<String>): List<String> {
        val list = mutableListOf<String>()
        if (topCodes.isEmpty()) return emptyList()

        // Distribute careers starting from top 1, 2, 3
        val lists = topCodes.mapNotNull { dimensionsMap[it]?.careers }
        var idx = 0
        while (list.size < 9 && idx < 5) {
            for (careersList in lists) {
                if (idx < careersList.size) {
                    val career = careersList[idx]
                    if (!list.contains(career)) {
                        list.add(career)
                    }
                }
            }
            idx++
        }
        return list.take(9)
    }
}
