package com.example.chucknorriesmvvm.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_joke")
open class NorrisEntity(
    @ColumnInfo()
    @PrimaryKey
    open val id:Int,
    @ColumnInfo(name = "joke_entry")
     open val joke: String,
    @ColumnInfo(name = "list_category")
     open val categories: List<String>
)