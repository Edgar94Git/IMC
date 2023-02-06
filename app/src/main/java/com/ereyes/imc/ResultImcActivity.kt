package com.ereyes.imc

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.MenuItem
import android.view.View
import com.ereyes.imc.databinding.ActivityResultImcBinding

class ResultImcActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityResultImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityResultImcBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        getIntentExtras()
        setUpButton()
        setUpActionBar()
    }

    private fun setUpActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.title_result_imc)
    }

    private fun getIntentExtras(){
        val result = intent.extras?.getDouble(Constants.RESULT_IMC) ?: -1.0
        mBinding.tvResultIMC.text = result.toString()
    }

    private fun setUpButton(){
        mBinding.btnReCalculate.setOnClickListener { finish() }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}