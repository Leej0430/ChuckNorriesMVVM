package com.example.chucknorriesmvvm.View

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.chucknorriesmvvm.R


class JokeDisplay(val customContext: Context):
    ViewGroup(customContext){

    private lateinit var attr: AttributeSet
    private lateinit var cardView :CardView
    private lateinit var textView: TextView


    constructor(context:Context,
                 attributeSet: AttributeSet): this(context){

        this.attr = attributeSet

    }
    /**
    *TypedArray contains the Array fashion
    *Collection of attributes in your SML
     */

    fun initView(){
        val layoutInFlater = LayoutInflater.from(customContext)


        val customAttributes = customContext.theme
            .obtainStyledAttributes(attr,
            R.styleable.JokeDisplay,
                0,
                0)

        val view = layoutInFlater.inflate(
            R.layout.joke_display_layout,
            this,
            false)

        textView.text = customAttributes
                .getString(R.styleable.JokeDisplay_text_joke_display)
        textView.textSize= customAttributes
                .getDimension(R.styleable.JokeDisplay_text_joke_display,12F)
        cardView.setCardBackgroundColor(customAttributes
                .getColor(R.styleable.JokeDisplay_background_card_view_display,
                Color.CYAN))
        cardView.cardElevation = customAttributes
                .getDimension(R.styleable.JokeDisplay_cardElevation,0f)
        //Recycle the TypedArray

        customAttributes.recycle()

    }
    /**
     * Called from layout when this view should assign
     * a size and position to each of its children.
     * Derived classes with children should override this
     * method and call layout on each of their children.
     */
    override fun onLayout(changed: Boolean,
                          p1: Int,
                          p2: Int,
                          p3: Int,
                          p4: Int) {


    }

}
