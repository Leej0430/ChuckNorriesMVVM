package com.example.chucknorriesmvvm.Model

class NorrisRepository{

    private lateinit var norrisDao:NorrisDao
    private lateinit var norrisNetwork:NorrisNetwork

    fun getSingleRandomJoke(){
        //todo query Network
        //todo insert
        //todo query from Dao
        norrisNetwork.getSingleRandomJoke {
            val dataSet = listOf(it.value)
            norrisDao.saveCacheSingle(dataSet)
            norrisDao.getSingleJoke(it.value.id)
        }


    }
    fun getNamedRandomJoke(firstName: String, lastName:String){

    }
    fun getNeverEndingList(){

    }

}