package com.example.sharedpreference

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_saudacao.*

class SaudacaoActivity : AppCompatActivity() {
    //função que carrega aos configurações ao inicia a tela
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)
        //pega os valores da persistencia
        val saudacaoPeristencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
        //pega a sttring da persistencia
        val nome = saudacaoPeristencia.getString("nome", "")
        val tratamento = saudacaoPeristencia.getString("tratamento", "")
        //condição que verifica se foi feito um tipo de tratamento
        if (tratamento.equals("Sem Tratamento")) {

            lbSaudacao.text = nome
        }else{
            lbSaudacao.text = tratamento + "" + nome
        }

    }

}