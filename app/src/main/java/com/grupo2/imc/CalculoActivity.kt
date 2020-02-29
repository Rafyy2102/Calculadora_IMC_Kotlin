package com.grupo2.imc

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculo.*


class CalculoActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo)

        //Criando a lista do spinner
        val listaSexo = arrayListOf("Selecione o sexo", "Feminino", "Masculino")

        //Criando o adaptador do spinner
        val adapterSexo = ArrayAdapter(
            this@CalculoActivity,
                android.R.layout.simple_spinner_dropdown_item, listaSexo)

        //Anexando o adaptador no spinner
        spnSexo.adapter = adapterSexo


       //val floatAltura = .2f

        // Criando o Seekbar
        skbPeso.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, p: Int, b: Boolean) {
                txtP.text = "$p"
               skbPeso.max = 200
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // escolha o peso e star
                Toast.makeText(applicationContext, "Selecione o peso",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Display o curso do SeekBar


                // escolha o peso e fim
                Toast.makeText(applicationContext, "Peso selecionada",
                    Toast.LENGTH_SHORT).show()
            }
        })

        // Criando o Seekbar
        skbAltura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, a: Int, b: Boolean) {
                // Display o curso do SeekBar
                txtA.text = "$a"
                skbAltura.max = 200


            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // escolha o peso e star
                Toast.makeText(applicationContext, "Selecione a Altura",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // escolha o peso e fim
                Toast.makeText(applicationContext, "Altura selecionada",
                    Toast.LENGTH_SHORT).show()
            }
        })

        //Criando o clique do botão Calcular
        btnCalcular.setOnClickListener {

            //startActivity(Intent(this@CalculoActivity, ResultadoActivity::class.java))

            val telaResultado = Intent(this,
                    ResultadoActivity::class.java)

            telaResultado.putExtra("Peso", txtP.text)

            telaResultado.putExtra("Altura", txtA.text)

            startActivity(telaResultado)

        }

        //Criando o clique do botão Tabela
        btnTabela.setOnClickListener {

            if (spnSexo.selectedItem == "Feminino") {


                startActivity(Intent(this@CalculoActivity,
                        TabelaFActivity::class.java))

            }
            else if (spnSexo.selectedItem == "Masculino") {

                startActivity(Intent(this@CalculoActivity,
                        TabelaMActivity::class.java))

            } else {
                //Imprimindo a mensagem de erro no Toast
                Toast.makeText(this@CalculoActivity, "Preencha todos os campos",
                        Toast.LENGTH_LONG).show()
            }

        }

    }
}


