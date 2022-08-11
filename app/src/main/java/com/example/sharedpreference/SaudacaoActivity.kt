package com.example.sharedpreference

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_saudacao.*
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset

//teste
class SaudacaoActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        //Encontra o elemento pelo ID
        val lbSaudacao = findViewById<TextView>(R.id.lbSaudacao)

        val db = DatabaseManager(this, "saudacoes")
        val cursor = db.listaSaudacao()
        var nome = ""
        var tratamento = ""
        if(cursor.count > 0){
            cursor.moveToFirst()
            nome = cursor.getString(cursor.getColumnIndex("NOME"))
            tratamento = cursor.getString(cursor.getColumnIndex("TRATAMENTO"))
        }
        if(tratamento.equals("Sem Tratamento")){
            lbSaudacao.text = nome
        } else{
            lbSaudacao.text = tratamento + " " + nome
        }
    }

    fun recuperaArquivo(filename: String): String {
        try {
            val fi = openFileInput(filename)
            val data = fi.readBytes()
            fi.close()
            data.toString()
            return data.toString(Charset.defaultCharset())

        }
        catch (e: FileNotFoundException){
            return ""
        }
        catch (e: IOException) {
            return ""
        }
    }

}