package com.ereyes.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ereyes.imc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private var weight = 50
    private var height = 150
    private var age = 28

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
        }
    }

    private fun setUpCardView(){
        with(mBinding){
            cardMale.setOnClickListener {
                Snackbar.make(mBinding.root, "Hombre", Snackbar.LENGTH_LONG).show()
            }
            cardFemale.setOnClickListener {
                Snackbar.make(mBinding.root, "Mujer", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}