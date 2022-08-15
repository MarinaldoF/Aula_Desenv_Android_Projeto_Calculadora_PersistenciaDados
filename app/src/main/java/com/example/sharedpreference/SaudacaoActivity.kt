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
    //função que carrega aos configurações ao inicia a tela
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        //Encontra o elemento pelo ID
        val lbSaudacao = findViewById<TextView>(R.id.lbSaudacao)

        val db = DatabaseManager(this, "saudacoes")
        val cursor = db.listaSaudacao()
        //variáveis que serão preenchida no banco
        var nome = ""
        var tratamento = ""
        //se tem dados na tabela, é inserido algo nas variáveis criada
        if(cursor.count > 0){
            cursor.moveToFirst()
            nome = cursor.getString(cursor.getColumnIndex("NOME"))
            tratamento = cursor.getString(cursor.getColumnIndex("TRATAMENTO"))
        }
        //condição que verifica se tem dados tratamento
        if(tratamento.equals("Sem Tratamento")){
            lbSaudacao.text = nome
        } else{
            lbSaudacao.text = tratamento + " " + nome
        }
    }
    //função que le o arquivo e passa para string
    fun recuperaArquivo(filename: String): String {
        try {
            //carrega o arquivo
            val fi = openFileInput(filename)
            //carrega os dados que estão salvo no arquivo
            val data = fi.readBytes()
            fi.close()
            data.toString()
            return data.toString(Charset.defaultCharset())

        }
        //se não tem arquivo retornara vazio
        catch (e: FileNotFoundException){
            return ""
        }
        //ser der algum erro retornara vazio
        catch (e: IOException) {
            return ""
        }
    }

}