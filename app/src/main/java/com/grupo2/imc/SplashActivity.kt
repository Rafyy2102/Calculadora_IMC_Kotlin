package com.grupo2.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Esperando e abrindo a próxima tela
        Handler().postDelayed({
            //Criando a inteção de ir para outra tela
            val intentTelaInicio = Intent(this@SplashActivity,
                CalculoActivity::class.java)

            //Iniciando a próxima activity (executando a intent)
            startActivity(intentTelaInicio)

            //Encerrando a tela de Splash
            finish()

        },2500)
    }
}