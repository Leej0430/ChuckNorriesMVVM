package com.example.chucknorriesmvvm.Model

import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.chucknorriesmvvm.NorrisApplication
import com.google.gson.Gson

class NorrisNetwork {

    private val enqueue = Volley
        .newRequestQueue(NorrisApplication.norrisContext)

    val urlRandom = "http://api.icndb.com/jokes/random"
    val urlNamed = "http://api.icndb.com/jokes/random?firstName=%s&lastName=%s"
    val urlNeverEnding = "http://api.icndb.com/jokes/random/20"

    fun getSingleRandomJoke(callBack: (NorriesResponse)->Unit){
        val stringReques = StringRequest(
            urlRandom,
            Response.Listener{
                val gson = Gson()
                val response=
                gson.fromJson(it,NorriesResponse::class.java)
                callBack.invoke(response)
                //How to pass into RXJava Observable
                //Observabla.create(it)
            },
            Response.ErrorListener {
                //todo notify error data
            }
        )
        enqueue.add(stringReques)
    }

    fun getSingleNamedJoke(firstName:String, lastName:String,
    callBack: (NorriesResponse) -> Unit){
enqueue.add( StringRequest(
            urlNamed.format(firstName,lastName),
                    Response.Listener{
                callBack.invoke(
                    Gson().run {
                        fromJson(it,NorriesResponse::class.java)
                    }
                )
            },
            Response.ErrorListener {
                //todo notify error data
            }
        )
)
    }
}
