package com.example.sharedpreference

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_saudacao.*
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class SaudacaoActivity : AppCompatActivity() {
    //função que carrega aos configurações ao inicia a tela
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)


        //pega o id
        val lbSaudacao = findViewById<TextView>(R.id.lbSaudacao)

        //recupera dadoos do arquivo
        val data = recuperaDadoArquivo("saudacao")

        //transforma a string em token
        val tokenizer = StringTokenizer(data, ":")

        //condição que verifica se tem dados
        val nome = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem nome"

        //verifica se tem dados caso não tenha exibi uma mensagem
        val tratamento = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem Tratamento"

        //condição que verifica se tem tratamento
        if(tratamento.equals("Sem Tratamento")){
            lbSaudacao.text = nome
        }else{
            lbSaudacao.text = tratamento + " " + nome
        }
    }

    // recupera dados do arquivo
    fun recuperaDadoArquivo(filename: String) : String{

        //tratamento de possiveis erros
        try{

            val fi = openFileInput(filename)

            val data = fi.readBytes()

            fi.close()

            data.toString()

            //Retorna os dados
            return data.toString(Charset.defaultCharset())
            //Tratamento de possiveis erros
        } catch (e: FileNotFoundException){
            return ""
        } catch (e: IOException){
            return ""
        }
    }
}

