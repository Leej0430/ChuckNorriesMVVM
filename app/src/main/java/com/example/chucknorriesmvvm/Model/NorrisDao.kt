package com.example.chucknorriesmvvm.Model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NorrisDao {

    //Insert One or Many jokes from Remote
    @Insert(entity = NorrisEntity::class,
        onConflict =OnConflictStrategy.REPLACE )
    fun saveCacheSingle(dataSet: List<NorrisEntity>)

    // To filter with Params use ':paramName'
    @Query("SELECT * FROM  table_joke WHERE id =:id")
    fun getSingleJoke(id: Int): NorrisEntity

    //SELECT * FROM table_joke WHERE joke_entry like :PARAM

    @Query("SELECT * FROM table_joke LIMIT 20")
    fun getNeverEndingList()

}