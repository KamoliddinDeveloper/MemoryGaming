package com.example.memorygaming

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.memorygaming.databinding.ActivityMemoryGaming2Binding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.image_1
import kotlinx.android.synthetic.main.activity_main.image_2
import kotlinx.android.synthetic.main.activity_main.image_3
import kotlinx.android.synthetic.main.activity_main.image_4
import kotlinx.android.synthetic.main.activity_main.image_5
import kotlinx.android.synthetic.main.activity_main.image_6
import kotlinx.android.synthetic.main.activity_memory_gaming2.*
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_10
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_11
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_12
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_7
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_8
import kotlinx.android.synthetic.main.activity_memory_gaming2.image_9
import kotlinx.android.synthetic.main.activity_memory_gaming3.*
import kotlinx.android.synthetic.main.activity_main.takrorlash as takrorlash1

class MemoryGaming2 : AppCompatActivity() {

    val listImageOchiqYopiq = arrayOf(false,false,false,false,false,false,false,false,false,false,false,false)
    val imageIndex = arrayOfNulls<Int>(2)
    val rasmid = arrayOfNulls<Int>(2)
    var ochiqRasm = 0
    var animationDoing = false

private val binding by lazy { ActivityMemoryGaming2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        menyu.setOnClickListener {
            finish()
        }
        takrorlash.setOnClickListener {
            recreate()
        }
        object : CountDownTimer(25000,1000){
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
               binding.txtTime.text ="00:${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                recreate()
            }
        }.start()

        image_1.setOnClickListener {
            imageClic(image_1, R.drawable.cat, 0)
        }
        image_2.setOnClickListener {
            imageClic(image_2, R.drawable.rabbit, 1)
        }
        image_3.setOnClickListener {
            imageClic(image_3, R.drawable.dog, 2)
        }
        image_4.setOnClickListener {
            imageClic(image_4, R.drawable.fox, 3)
        }
        image_5.setOnClickListener {
            imageClic(image_5, R.drawable.lion, 4)
        }
        image_6.setOnClickListener {
            imageClic(image_6, R.drawable.tiger, 5)
        }
        image_7.setOnClickListener {
            imageClic(image_7, R.drawable.dog, 6)
        }
        image_8.setOnClickListener {
            imageClic(image_8, R.drawable.fox, 7)
        }
        image_9.setOnClickListener {
            imageClic(image_9, R.drawable.lion, 8)
        }
        image_10.setOnClickListener {
            imageClic(image_10, R.drawable.cat, 9)
        }
        image_11.setOnClickListener {
            imageClic(image_11, R.drawable.rabbit, 10)
        }
        image_12.setOnClickListener {
            imageClic(image_12, R.drawable.tiger, 11)
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
                    val animation2  = AnimationUtils.loadAnimation(this@MemoryGaming2, R.anim.anim2)
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
                val animation2  = AnimationUtils.loadAnimation(this@MemoryGaming2, R.anim.anim2)
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

    fun imageViewAniqla(index: Int?):ImageView{
        var imageView:ImageView? = null
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
        }
        return imageView!!
    }
//    fun restart(){
//        for (i in 0 until listImageOchiqYopiq.size){
//            listImageOchiqYopiq[i]=false
//        }
//        animationDoing=false
//        animationYopilishi(image_1,R.drawable.fox, 0)
//        animationYopilishi(image_2,R.drawable.rabbit,0)
//        animationYopilishi(image_3,R.drawable.cat,0)
//        animationYopilishi(image_4,R.drawable.tiger,0)
//        animationYopilishi(image_5,R.drawable.lion,0)
//        animationYopilishi(image_6,R.drawable.fox, 0)
//        animationYopilishi(image_7,R.drawable.dog, 0)
//        animationYopilishi(image_8,R.drawable.rabbit,0)
//        animationYopilishi(image_9,R.drawable.lion,0)
//        animationYopilishi(image_10,R.drawable.tiger,0)
//        animationYopilishi(image_11,R.drawable.cat,0)
//        animationYopilishi(image_12,R.drawable.dog, 0)
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
//    }

    }