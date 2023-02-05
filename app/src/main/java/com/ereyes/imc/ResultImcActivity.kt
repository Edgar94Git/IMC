package com.ereyes.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ereyes.imc.databinding.ActivityResultImcBinding

class ResultImcActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityResultImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityResultImcBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        getIntentExtras()
        setUpButton()
    }

    private fun getIntentExtras(){
        val result = intent.extras?.getDouble(Constants.RESULT_IMC) ?: -1.0
        mBinding.tvResultIMC.text = result.toString()
    }

    private fun setUpButton(){
        mBinding.btnReCalculate.setOnClickListener { finish() }
    }
}