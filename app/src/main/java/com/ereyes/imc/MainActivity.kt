package com.ereyes.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.ereyes.imc.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private var weight = 60
    private var height = 120f
    private var age = 28
    private var genre: eTypeGenre = eTypeGenre.NOT_ASSIGNED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setUpCardView()
        setUpButton()
        setUpSlider()
        initialize()
    }

    private fun initialize(){
        mBinding.tvWeight.text = weight.toString()
        mBinding.tvHeightNumber.text = height.toString()
        mBinding.tvAge.text = age.toString()
    }

    private fun setUpSlider(){
        mBinding.sliderHeight.addOnChangeListener { _, value, _ ->
            height = value
            mBinding.tvHeightNumber.text = height.toString()
        }
    }

    private fun setUpButton() {
        with(mBinding){
            btnPlusWeight.setOnClickListener {
                weight += 1
                tvWeight.text = weight.toString()
            }
            btnSubtractWeight.setOnClickListener {
                weight -= 1
                tvWeight.text = weight.toString()
            }
            btnPlusAge.setOnClickListener {
                age += 1
                tvAge.text = age.toString()
            }
            btnSubtractAge.setOnClickListener {
                age -= 1
                tvAge.text = age.toString()
            }
            btnCalculate.setOnClickListener {
                val imc = calculateIMC()
                openResultIntent(imc)
            }
        }
    }

    private fun openResultIntent(imc: Double) {
        val intent = Intent(this, ResultImcActivity::class.java)
        intent.putExtra(Constants.RESULT_IMC, imc)
        startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = weight / ((height.toDouble()/100) * (height.toDouble()/100))
        return df.format(imc).toDouble()
    }

    private fun setUpCardView(){
        with(mBinding){
            cardMale.setOnClickListener {
                setBackGroundColor(eTypeGenre.MALE)
            }
            cardFemale.setOnClickListener {
                setBackGroundColor(eTypeGenre.FEMALE)
            }
        }
    }

    private fun setBackGroundColor(typeGenre: eTypeGenre){
        genre = typeGenre
        mBinding.cardMale.setCardBackgroundColor(getCardBackgroundColor(typeGenre == eTypeGenre.MALE))
        mBinding.cardFemale.setCardBackgroundColor(getCardBackgroundColor(typeGenre == eTypeGenre.FEMALE))
    }

    private fun getCardBackgroundColor(selected: Boolean): Int{
        val realColor = if(selected){
            R.color.background_fab
        } else {
            R.color.black
        }

        return ContextCompat.getColor(this, realColor)
    }
}