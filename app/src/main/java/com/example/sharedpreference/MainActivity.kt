package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileNotFoundException
import java.io.IOException

//teste teste
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSalvar.setOnClickListener(View.OnClickListener {
            val saudacaoPersistencia = this.getSharedPreferences( "saudacao", Context.MODE_PRIVATE)
            val editor = saudacaoPersistencia.edit()

            editor.putString("nome", txtNome.text.toString())
            editor.apply()

            Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show()


        })

        btnExibir.setOnClickListener(View.OnClickListener {



            val intent = Intent(this, SaudacaoActivity :: class.java)
            startActivity(intent)
        })



    }

    fun gravarDadoArquivo(filename: String, data: String) {
        try {
            val fs = openFileOutput(filename, Context.MODE_PRIVATE);
            fs.write(data.toByteArray())
            fs.close()
        }
        catch (e: FileNotFoundException) { log.i("gravaDadoArquivo", "FileNotFoundException")}
        catch (e: IOException){ log.i( "gravarDadosArquivo", "IOException")}
    }
}