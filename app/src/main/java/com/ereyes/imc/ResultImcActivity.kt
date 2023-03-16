package com.ereyes.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
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
        initUI(result)
    }

    private fun initUI(result: Double) {
        when(result){
            in 0.00..18.50 -> {
                dataUI(result, R.string.bajo_peso, R.string.bajo_peso_description, R.color.peso_bajo)
            }
            in 18.51..24.99 -> {
                dataUI(result, R.string.normal_peso, R.string.normal_peso_description, R.color.peso_normal)
            }
            in 25.00..29.99 -> {
                dataUI(result, R.string.sobrepeso, R.string.sobrepreso_description, R.color.peso_sobrepeso)
            }
            in 30.00..99.00 -> {
                dataUI(result, R.string.obesidad, R.string.obesidad_description, R.color.obesidad)
            }
            else -> {
                dataUI(0.0, R.string.text_error, R.string.text_error, R.color.obesidad)
            }
        }
    }

    private fun dataUI(result: Double, resultIMCText: Int, description: Int, color: Int){
        mBinding.tvResultIMC.text = result.toString()
        mBinding.tvResultIMCText.text = getString(resultIMCText)
        mBinding.tvResultIMCText.setTextColor(ContextCompat.getColor(this, color))
        mBinding.tvResultDescription.text = getString(description)
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