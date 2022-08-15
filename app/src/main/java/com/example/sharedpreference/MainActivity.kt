package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileNotFoundException
import java.io.IOException

//teste teste teste
class MainActivity : AppCompatActivity() {
    //função que carrega aos configurações ao inicia a tela
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSalvar.setOnClickListener{
//          //salva os valores
            val data = txtNome.text.toString() + ": " + listTratamento.selectedItem.toString()

            //grava dados no arquivo
            gravaDadoArquivo("saudacao", data)

//           //informa uma mensagem para o usuário
            Toast.makeText(this,"Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        }

        // carrega outra tela
        btnExibir.setOnClickListener{
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        }
    }

    //grava os dados em um arquivo
    fun gravaDadoArquivo(filename: String, data: String){

        //tratamentos de erros
        try{
            //abre um arquivo caso nao tem
            val fs = openFileOutput(filename, Context.MODE_PRIVATE);


            fs.write(data.toByteArray())

            //Fecha o arquivo
            fs.close()
            //Tratamento dos erros
        } catch ( e: FileNotFoundException){
            Log.i ("GravaDadoArquivo", "FileNotFoundException")
        } catch (e: IOException){
            Log.i("GravaDadoArquivo", "IOException")
        }
    }
}