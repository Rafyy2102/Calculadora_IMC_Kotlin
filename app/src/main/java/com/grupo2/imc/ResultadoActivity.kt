package com.grupo2.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grupo2.imc.extension.format
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //Criando variaveis para chamar os textView

        val txtP = intent.getStringExtra("Peso")!!.toDouble()
        val txtA = intent.getStringExtra("Altura")!!.toDouble() / 100


        //Criando variavel para o calculo
        val imc = txtP / (txtA * txtA)

        val result = imc.format(2)

        //Criando condições para o calculo do peso e altura
        if(imc <= 18.5){
            txtResultado2.text = "Abaixo do peso " + result
        }
        else if (imc <= 24.9){
            txtResultado2.text = "Peso ideal (Parabéns) " + result
        }
        else if (imc <= 29.9){
            txtResultado2.text = "Levemente acima do peso " + result
        }
        else if (imc <= 34.9){
            txtResultado2.text = "Obsidade grau I " + result
        }
        else if (imc <= 39.9){
            txtResultado2.text = "Obsidade grau II (Severa) " + result
        }
        else {
            txtResultado2.text = "Obsidade grau III (Mórbida)" + result
        }


    }
}


