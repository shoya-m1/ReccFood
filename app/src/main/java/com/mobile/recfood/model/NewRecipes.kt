package com.mobile.recfood.model

data class ApiResponse(
    val result: Result
)

data class Result(
    val recipe_list: List<Recipe>
)

data class Recipe(
    val title: String,
    val thumb: String,
    val endpoint: String,
    val features: Features
)

data class Features(
    val times: String,
    val difficulty: String,
    val kkal: String?
)
