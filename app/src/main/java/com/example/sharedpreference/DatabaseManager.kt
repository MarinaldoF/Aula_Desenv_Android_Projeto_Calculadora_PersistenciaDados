package com.example.sharedpreference

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager (context: Context, name: String?) : SQLiteOpenHelper(context,name,null, 1)
{

    //criar uma tabela
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
                "\tID_SAUDACAO INT NOT NULL,\n" +
                "\tNOME VARCHAR(20),\n" +
                "\tTRATAMENTO VARCHAR(20),\n" +
                "\tPRIMARY KEY(ID_SAUDACAO)\n" +
                "\t);")

    }
    //apaga tabela caso exista e cria outra
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS SAUDACAO")
        p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
                "\tID_SAUDACAO INT NOT NULL,\n" +
                "\tNOME VARCHAR(20),\n" +
                "\tTRATAMENTO VARCHAR(20),\n" +
                "\tPRIMARY KEY(ID_SAUDACAO)\n" +
                "\t);")
    }

    // colocar os dados no banco
    fun insereSaudacao(id: Int, nome: String, tratamento: String){
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put("ID_SAUDACAO", id)
        cv.put("NOME", nome)
        cv.put("TRATAMENTO", tratamento)
        db.insert("SAUDACAO", "ID_SAUDACAO", cv)
    }

    // dar um select nos dados que vai ser exibido
    fun listaSaudacao(): Cursor {
        var db = this.readableDatabase
        var cur = db.rawQuery("select nome, tratamento from saudacao", null)
        return cur
    }

    //Apaga a tabela
    fun removeSaudacao(){
        var db = this.writableDatabase
        db.delete("SAUDACAO", "ID_SAUDACAO=1", null)
    }

}