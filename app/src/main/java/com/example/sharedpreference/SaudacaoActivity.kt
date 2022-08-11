package com.example.sharedpreference

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_saudacao.*
//teste
class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        val saudacaoPeristencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)

        val nome = saudacaoPeristencia.getString("nome", "")
        val tratamento = saudacaoPeristencia.getString("tratamento", "")

        if (tratamento.equals("Sem Tratamento")) {
            lbSaudacao.text = nome
        }else{
            lbSaudacao.text = tratamento + "" + nome
        }

    }

}