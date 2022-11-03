package com.example.estudeaqui.activities

data class Quiz(
    var id: String,
    var titulo: String,
    var questoes: MutableMap<String, Question> = mutableMapOf()
)
