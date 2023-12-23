package com.delivery.appdelivery1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco_cadastro.db";
    private static final int VERSAO = 1;

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE usuarios (" +
                "codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT," +
                "cpf TEXT," +
                "telefone TEXT," +
                "email TEXT," +
                "senha TEXT)";

        db.execSQL(sql);
        sql = "CREATE TABLE pedidos ("
                + "codigo integer primary key autoincrement,"
                + "idUsuario int,"
                + "qtdDoce01 int,"
                + "precoDoce01 double,"
                + "qtdDoce02 int,"
                + "precoDoce02 double,"
                + "qtdDoce03 int,"
                + "precoDoce03 double,"
                + "qtdDoce04 int,"
                + "precoDoce04 double,"
                + "qtdDoce05 int,"
                + "precoDoce05 double,"
                + "qtdDoce06 int,"
                + "precoDoce06 double,"
                + "totalGeral double)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS pedidos");

        // Caso você faça alguma atualização futura no banco de dados
        // Você pode implementar aqui o código para atualização da estrutura do banco
    }
}
