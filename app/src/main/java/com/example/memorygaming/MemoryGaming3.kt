package com.example.memorygaming

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_memory_gaming2.*
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_1
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_10
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_11
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_12
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_2
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_3
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_4
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_5
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_6
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_7
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_8
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_9
import kotlinx.android.synthetic.main.activity_memory_gaming3.*

class MemoryGaming3 : AppCompatActivity() {
    val listImageOchiqYopiq = arrayOf(false,false,false,false,false,false,false,false,false,false,false,false,
        false,false,false,false,false,false,false,false)
    val imageIndex = arrayOfNulls<Int>(2)
    val rasmid = arrayOfNulls<Int>(2)
    var ochiqRasm = 0
    var animationDoing = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory_gaming3)

        ortga.setOnClickListener {
            finish()
        }
        qaytadan.setOnClickListener {
            recreate()
        }



        image_1.setOnClickListener {
            imageClic(image_1, R.drawable.fox, 0)
        }
        image_2.setOnClickListener {
            imageClic(image_2, R.drawable.fox, 1)
        }
        image_3.setOnClickListener {
            imageClic(image_3, R.drawable.horse, 2)
        }
        image_4.setOnClickListener {
            imageClic(image_4, R.drawable.dog, 3)
        }
        image_5.setOnClickListener {
            imageClic(image_5, R.drawable.horse, 4)
        }
        image_6.setOnClickListener {
            imageClic(image_6, R.drawable.elephant, 5)
        }
        image_7.setOnClickListener {
            imageClic(image_7, R.drawable.dog, 6)
        }
        image_8.setOnClickListener {
            imageClic(image_8, R.drawable.lion, 7)
        }
        image_9.setOnClickListener {
            imageClic(image_9, R.drawable.elephant, 8)
        }
        image_10.setOnClickListener {
            imageClic(image_10, R.drawable.cat, 9)
        }
        image_11.setOnClickListener {
            imageClic(image_11, R.drawable.fox, 10)
        }
        image_12.setOnClickListener {
            imageClic(image_12, R.drawable.snake, 11)
        }
        image_13.setOnClickListener {
            imageClic(image_13, R.drawable.tiger, 12)
        }
        image_14.setOnClickListener {
            imageClic(image_14, R.drawable.cat, 13)
        }
        image_15.setOnClickListener {
            imageClic(image_15, R.drawable.snake, 14)
        }
        image_16.setOnClickListener {
            imageClic(image_16, R.drawable.fox, 15)
        }
        image_17.setOnClickListener {
            imageClic(image_17, R.drawable.tiger, 16)
        }
        image_18.setOnClickListener {
            imageClic(image_18, R.drawable.snake, 17)
        }
        image_19.setOnClickListener {
            imageClic(image_19, R.drawable.snake, 18)
        }
        image_20.setOnClickListener {
            imageClic(image_20, R.drawable.lion, 19)
        }
    }

    fun imageClic(imageView: ImageView, rasm:Int, index : Int){
        if (animationDoing == false){
            if (listImageOchiqYopiq[index] == false){
                animationOchilishi(imageView, rasm, index)
            }else{
                animationYopilishi(imageView, rasm, index)
            }
        }
    }
    fun  animationOchilishi(imageView: ImageView, rasm:Int, index: Int){
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animationDoing = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                val animation2  = AnimationUtils.loadAnimation(this@MemoryGaming3, R.anim.anim2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(rasm)
                animation2.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        listImageOchiqYopiq[index] = true
                        imageIndex[ochiqRasm] = index
                        rasmid[ochiqRasm] =rasm
                        ochiqRasm++

                        if (ochiqRasm == 2 ){
                            if (rasmid[0] == rasmid[1]){
                                imageViewAniqla(imageIndex[0]).visibility = View.INVISIBLE
                                ochiqRasm--
                                imageViewAniqla(imageIndex[1]).visibility = View.INVISIBLE
                                ochiqRasm--
                            }else{
                                animationYopilishi(imageViewAniqla(imageIndex[0]),-1, imageIndex[0])
                                animationYopilishi(imageViewAniqla(imageIndex[1]),-1, imageIndex[1])
                            }
                        }
                        animationDoing = false
                    }
                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })
            }
            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
    }
    fun  animationYopilishi(imageView: ImageView, rasm:Int, index: Int?){
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animationDoing = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                val animation2  = AnimationUtils.loadAnimation(this@MemoryGaming3, R.anim.anim2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(R.drawable.ic_yulduzcha)
                animation2.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        animationDoing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                })
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
        listImageOchiqYopiq[index!!]= false
        ochiqRasm--
    }

    fun imageViewAniqla(index: Int?): ImageView {
        var imageView: ImageView? = null
        when(index){
            0 -> imageView = image_1
            1 -> imageView = image_2
            2 -> imageView = image_3
            3 -> imageView = image_4
            4 -> imageView = image_5
            5-> imageView = image_6
            6 -> imageView = image_7
            7 -> imageView = image_8
            8 -> imageView = image_9
            9 -> imageView = image_10
            10 -> imageView = image_11
            11-> imageView = image_12
            12 -> imageView = image_13
            13 -> imageView = image_14
            14 -> imageView = image_15
            15 -> imageView = image_16
            16 -> imageView = image_17
            17-> imageView = image_18
            18 -> imageView = image_19
            19 -> imageView = image_20

        }
        return imageView!!
    }
//    fun restart(){
//        for (i in 0 until listImageOchiqYopiq.size){
//            listImageOchiqYopiq[i]=false
//        }
//        animationDoing=false
//        animationYopilishi(image_1,R.drawable.tiger, 0)
//        animationYopilishi(image_2,R.drawable.lion,0)
//        animationYopilishi(image_3,R.drawable.snake,0)
//        animationYopilishi(image_4,R.drawable.tiger,0)
//        animationYopilishi(image_5,R.drawable.snake,0)
//        animationYopilishi(image_6,R.drawable.tiger, 0)
//        animationYopilishi(image_7,R.drawable.tiger, 0)
//        animationYopilishi(image_8,R.drawable.lion,0)
//        animationYopilishi(image_9,R.drawable.snake,0)
//        animationYopilishi(image_10,R.drawable.tiger,0)
//        animationYopilishi(image_11,R.drawable.snake,0)
//        animationYopilishi(image_12,R.drawable.tiger, 0)
//        animationYopilishi(image_13,R.drawable.tiger, 0)
//        animationYopilishi(image_14,R.drawable.tiger, 0)
//        animationYopilishi(image_15,R.drawable.lion,0)
//        animationYopilishi(image_16,R.drawable.snake,0)
//        animationYopilishi(image_17,R.drawable.tiger,0)
//        animationYopilishi(image_18,R.drawable.snake,0)
//        animationYopilishi(image_19,R.drawable.tiger, 0)
//        animationYopilishi(image_20,R.drawable.tiger, 0)
//        ochiqRasm = 0
//        image_1.visibility = View.VISIBLE
//        image_2.visibility = View.VISIBLE
//        image_3.visibility = View.VISIBLE
//        image_4.visibility = View.VISIBLE
//        image_5.visibility = View.VISIBLE
//        image_6.visibility = View.VISIBLE
//        image_7.visibility = View.VISIBLE
//        image_8.visibility = View.VISIBLE
//        image_9.visibility = View.VISIBLE
//        image_10.visibility = View.VISIBLE
//        image_11.visibility = View.VISIBLE
//        image_12.visibility = View.VISIBLE
//        image_13.visibility = View.VISIBLE
//        image_14.visibility = View.VISIBLE
//        image_15.visibility = View.VISIBLE
//        image_16.visibility = View.VISIBLE
//        image_17.visibility = View.VISIBLE
//        image_18.visibility = View.VISIBLE
//        image_19.visibility = View.VISIBLE
//        image_20.visibility = View.VISIBLE
//    }
}