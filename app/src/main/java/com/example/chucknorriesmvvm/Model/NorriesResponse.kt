package com.example.chucknorriesmvvm.Model

data class NorriesResponse(
        val value: NorriesJokeValue
)

data class NorriesResponseList(
        val value : List<NorriesJokeValue>
)

data class NorriesJokeValue(
        override val id : Int,
        override val joke:String,
        override val categories: List<String>
):NorrisEntity(id,joke, categories)