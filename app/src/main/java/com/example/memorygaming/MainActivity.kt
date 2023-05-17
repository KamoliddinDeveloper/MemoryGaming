package com.example.memorygaming

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.example.memorygaming.databinding.ActivityMainBinding
import com.google.android.material.slider.RangeSlider
import kotlinx.android.synthetic.main.activity_animation.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listImajOchiqYopiq = arrayOf(false,false,false,false,false,false)
    val imageIndex = arrayOfNulls<Int>(2)
    val rasmId = arrayOfNulls<Int>(2)
    var ochiqRasm = 0
    var animationDing = false
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        bosh.setOnClickListener {
            finish()
        }

        takrorlash.setOnClickListener {
          recreate()
        }
        object : CountDownTimer(15000,1000){
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                binding.txtTime.text ="00:${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                recreate()
            }
        }.start()

            image_1.setOnClickListener {
                imageClic(image_1, R.drawable.lion, 0)
            }
        image_2.setOnClickListener {
            imageClic(image_2, R.drawable.tiger,1)
        }
        image_3.setOnClickListener {
            imageClic(image_3, R.drawable.elephant,2)
        }
        image_4.setOnClickListener {
            imageClic(image_4, R.drawable.lion, 3)
        }
        image_5.setOnClickListener {
            imageClic(image_5, R.drawable.tiger,4)
        }
        image_6.setOnClickListener {
            imageClic(image_6, R.drawable.elephant,5)
        }

        }
    fun imageClic(imageView: ImageView, rasm: Int, index:Int){
        if (!animationDing) {
            if (listImajOchiqYopiq[index] == false) {
                animationOchilishi(imageView, rasm, index)
            } else {
                animationYopilishi(imageView, rasm, index)
            }
        }
    }
    fun animationOchilishi(imageView: ImageView, rasm:Int, index: Int){
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animationDing = true
            }

            override fun onAnimationEnd(animation: Animation?) {
               val animtaion2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim2)
                imageView.startAnimation(animtaion2)
                imageView.setImageResource(rasm)
                animtaion2.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        listImajOchiqYopiq[index] = true
                        imageIndex[ochiqRasm] = index
                        rasmId[ochiqRasm] = rasm
                        ochiqRasm++

                        if (ochiqRasm == 2){
                            if (rasmId[0] == rasmId[1]){
                                imageViewAniqla(imageIndex[0]).visibility = View.INVISIBLE
                                ochiqRasm--
                                imageViewAniqla(imageIndex[1]).visibility = View.INVISIBLE
                                ochiqRasm--
                            }else{
                                animationYopilishi(imageViewAniqla(imageIndex[0]), -1, imageIndex[0])
                                animationYopilishi(imageViewAniqla(imageIndex[1]), -1, imageIndex[1])
                            }
                        }
                        animationDing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
    }


    fun animationYopilishi(imageView: ImageView, rasm:Int, index: Int?){
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animationDing = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                val animtaion2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim2)
                imageView.startAnimation(animtaion2)
                imageView.setImageResource(R.drawable.ic_yulduzcha)
                animtaion2.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        animationDing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
        listImajOchiqYopiq[index!!] = false
        ochiqRasm--
    }

    fun imageViewAniqla(index: Int?):ImageView{
        var imageView:ImageView? = null
        when(index){
            0 -> imageView = image_1
            1 -> imageView = image_2
            2 -> imageView = image_3
            3 -> imageView = image_4
            4 -> imageView = image_5
            5 -> imageView = image_6
        }
        return imageView!!
    }

//    fun restart(){
//        for (i in 0 until listImajOchiqYopiq.size){
//            listImajOchiqYopiq[i]=false
//        }
//        animationDing=false
//        animationYopilishi(image_1,R.drawable.lion, 0)
//        animationYopilishi(image_2,R.drawable.tiger,0)
//        animationYopilishi(image_3,R.drawable.elephant,0)
//        animationYopilishi(image_4,R.drawable.lion,0)
//        animationYopilishi(image_5,R.drawable.elephant,0)
//        animationYopilishi(image_6,R.drawable.lion, 0)
//        ochiqRasm = 0
//        image_1.visibility = View.VISIBLE
//        image_2.visibility = View.VISIBLE
//        image_3.visibility = View.VISIBLE
//        image_4.visibility = View.VISIBLE
//        image_5.visibility = View.VISIBLE
//        image_6.visibility = View.VISIBLE
//    }

       }

