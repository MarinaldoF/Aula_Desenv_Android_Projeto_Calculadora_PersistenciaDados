package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //instancia do banco
        var db = DatabaseManager(this, "saudacoes")

        btnSalvar.setOnClickListener(View.OnClickListener {

            //remove os item do banco
            db.removeSaudacao()
            //insere no banco os dados
            db.insereSaudacao(1, txtNome.text.toString(), listTratamento.selectedItem.toString())
            // mostra uma mensagem de sucesso
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()

        })
        //exibe outra tela
        btnExibir.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SaudacaoActivity :: class.java)
            startActivity(intent)
        })
    }
}