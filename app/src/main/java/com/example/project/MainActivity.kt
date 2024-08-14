package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.project.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    private var canAddOperation=false
    private var canAddDecimal=false
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.zero.setOnClickListener{appendOnExpression("0",true)}
        binding.one.setOnClickListener{appendOnExpression("1",true)}
        binding.two.setOnClickListener{appendOnExpression("2",true)}
        binding.three.setOnClickListener{appendOnExpression("3",true)}
        binding.four.setOnClickListener{appendOnExpression("4",true)}
        binding.five.setOnClickListener{appendOnExpression("5",true)}
        binding.six.setOnClickListener{appendOnExpression("6",true)}
        binding.seven.setOnClickListener{appendOnExpression("7",true)}
        binding.eight.setOnClickListener{appendOnExpression("8",true)}
        binding.nine.setOnClickListener{appendOnExpression("9",true)}
        binding.add.setOnClickListener{appendOnExpression("+",true)}
        binding.divison.setOnClickListener{appendOnExpression("/",true)}
        binding.mult.setOnClickListener{appendOnExpression("*",true)}
        binding.sub.setOnClickListener{appendOnExpression("-",true)}

        binding.clear.setOnClickListener{
            binding.rusltsTv.text=""
            binding.tvExpresstion.text=""
        }
        binding.equal.setOnClickListener{
            try {
                val expression= ExpressionBuilder(binding.tvExpresstion.text.toString()).build()
                val result =expression.evaluate()
                val long=result.toLong()
                if(result == long.toDouble()) {
                    binding.rusltsTv.text=long.toString()
                }
                else {
                    binding.rusltsTv.text=result.toString()
                }
            }catch (e:Exception){
                Log.d("Exception","message :"+e.message)
            }

        }

    }
    fun appendOnExpression( string:String ,canClear:Boolean){
        if(canClear){
            binding.rusltsTv.text=""
            binding.tvExpresstion.append(string)
        }
        else{
            binding.tvExpresstion.append( binding.rusltsTv.text)
            binding.tvExpresstion.append(string)
            binding.rusltsTv.text=""
        }
    }

}