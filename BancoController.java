package com.delivery.appdelivery1;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }


    public String insereDadosPedido(int _idUser, int _qtdDoce01, double _precoDoce01,
                                    int _qtdDoce02, double _precoDoce02, int _qtdDoce03, double _precoDoce03,
                                    int _qtdDoce04, double _precoDoce04, int _qtdDoce05, double _precoDoce05,
                                    int _qtdDoce06, double _precoDoce06,double _totalgeral)
    {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("idUsuario",_idUser);
        valores.put("qtdDoce01", _qtdDoce01);
        valores.put("precoDoce01", _precoDoce01);
        valores.put("qtdDoce02", _qtdDoce02);
        valores.put("precoDoce02", _precoDoce02);
        valores.put("qtdDoce03", _qtdDoce03);
        valores.put("precoDoce03", _precoDoce03);
        valores.put("qtdDoce04", _qtdDoce04);
        valores.put("precoDoce04", _precoDoce04);
        valores.put("qtdDoce05", _qtdDoce05);
        valores.put("precoDoce05", _precoDoce05);
        valores.put("qtdDoce06", _qtdDoce06);
        valores.put("precoDoce06", _precoDoce06);
        valores.put("totalGeral", _totalgeral);

        resultado = db.insert("pedidos", null, valores);
        db.close();

        if (resultado == -1)
            return "Pedido Registrado com sucesso";
        else
            return "Erro ao gravar o pedido!!!";
    }



    public Cursor carregaDadosParaLogin(String email, String senha) {
        Cursor cursor;
        String[] campos = {"codigo", "nome", "email", "senha"};
        String filtro = "email='" + email + "' and senha='" + senha + "'";

        db = banco.getReadableDatabase();
        cursor = db.query("usuarios", campos, filtro, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaDadosPeloCodigo(int id) {
        Cursor cursor;
        String[] campos = {"codigo", "nome", "email"};
        String where = "codigo=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query("contatos", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    // programa do cadastre_Se
    public String insereDadosUsuario(String edit_nome, String edit_email, String edit_senha) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("nome", edit_nome);
        valores.put("email", edit_email);
        valores.put("senha", edit_senha);

        resultado = db.insert("usuarios", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir o registro do usuário";
        else
            return "Registro do usuário inserido com sucesso";
    }
}


