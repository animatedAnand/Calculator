package com.adpth.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.adpth.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var operator: String = ""
    private var value1: Double = 0.0
    private var value2: Double = 0.0
    private var result: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btn0.setOnClickListener { btn_click(binding.btn0) }
        binding.btn1.setOnClickListener { btn_click(binding.btn1) }
        binding.btn2.setOnClickListener { btn_click(binding.btn2) }
        binding.btn3.setOnClickListener { btn_click(binding.btn3) }
        binding.btn4.setOnClickListener { btn_click(binding.btn4) }
        binding.btn5.setOnClickListener { btn_click(binding.btn5) }
        binding.btn6.setOnClickListener { btn_click(binding.btn6) }
        binding.btn7.setOnClickListener { btn_click(binding.btn7) }
        binding.btn8.setOnClickListener { btn_click(binding.btn8) }
        binding.btn9.setOnClickListener { btn_click(binding.btn9) }
        binding.btnDecimal.setOnClickListener { btn_click(binding.btnDecimal) }

        binding.btnClear.setOnClickListener { btn_click(binding.btnClear) }
        binding.btnDel.setOnClickListener { btn_click(binding.btnDel) }

        binding.btnAdd.setOnClickListener { btn_operation(binding.btnAdd) }
        binding.btnMinus.setOnClickListener { btn_operation(binding.btnMinus) }
        binding.btnPercentage.setOnClickListener { btn_operation(binding.btnPercentage) }
        binding.btnMul.setOnClickListener { btn_operation(binding.btnMul) }
        binding.btnDiv.setOnClickListener { btn_operation(binding.btnDiv) }

        binding.btnResult.setOnClickListener { btn_result() }

    }

    var numberclk = false
    fun btn_click(visible: View) {

        numberclk = true
        var value = binding.Output.text.toString()

        when (visible.id) {

            binding.btn0.id -> {
                value += "0"
            }
            binding.btn1.id -> {
                value += "1"
            }
            binding.btn2.id -> {
                value += "2"
            }
            binding.btn3.id -> {
                value += "3"
            }
            binding.btn4.id -> {
                value += "4"
            }
            binding.btn5.id -> {
                value += "5"
            }
            binding.btn6.id -> {
                value += "6"
            }
            binding.btn7.id -> {
                value += "7"
            }
            binding.btn8.id -> {
                value += "8"
            }
            binding.btn9.id -> {
                value += "9"
            }
            binding.btnDecimal.id -> {
                value += "."
            }
            binding.btnClear.id -> {
                value = ""
            }
            binding.btnDel.id -> {
                value = binding.Output.text.toString()
                if (value.length > 0) {
                    value = value.substring(0, value.length - 1)
                }
            }

        }
        binding.Output.setText(value)
    }

    fun btn_operation(visible: View) {

        when (visible.id) {
            binding.btnAdd.id -> {
                operator = "+"
            }
            binding.btnMinus.id -> {
                operator = "-"
            }
            binding.btnDiv.id -> {
                operator = "/"
            }
            binding.btnPercentage.id -> {
                operator = "%"
            }
            binding.btnMul.id -> {
                operator = "*"
            }
        }

        val value = binding.Output.text.toString()
        if (numberclk) {
            value1 = value.toDouble()
        }
        numberclk = false
        binding.Output.setText("")

    }

    fun btn_result() {

        val value = binding.Output.text.toString()
        value2 = value.toDouble()

        when (operator) {

            "+" -> {
                result = value1 + value2
            }
            "-" -> {
                result = value1 - value2
            }
            "/" -> {
                result = value1 / value2
            }
            "%" -> {
                result = value1 % value2
            }
            "*" -> {
                result = value1 * value2
            }
        }
        binding.Output.setText(result.toString())
    }
}