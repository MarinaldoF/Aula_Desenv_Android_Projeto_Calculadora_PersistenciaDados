package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //função que carrega aos configurações ao inicia a tela
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSalvar.setOnClickListener(View.OnClickListener {
            //carrega a biblioteca de preferences
            val saudacaoPersistencia = this.getSharedPreferences( "saudacao", Context.MODE_PRIVATE)
            //pega o objeto responsavel pela edição dos dados da preferencias
            val editor = saudacaoPersistencia.edit()

            editor.putString("nome", txtNome.text.toString())
            editor.apply()
            //exibe uma mensagem para o usuario que foi salvo com sucesso
            Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show()


        })

        //exibe outra tela com outro layout

        btnExibir.setOnClickListener(View.OnClickListener {


            //inicia a nova tela que o usuário irá navegar
            val intent = Intent(this, SaudacaoActivity :: class.java)
            startActivity(intent)
        })
    }
}