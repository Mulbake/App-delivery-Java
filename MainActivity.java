package com.delivery.appdelivery1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btcadastro, btentrar;
    EditText txtEmailLogin, txtSenhaLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btcadastro = (Button) findViewById(R.id.btcadastro);
        btentrar = (Button) findViewById(R.id.bt_entrar);
        txtEmailLogin = (EditText) findViewById(R.id.login_email);
        txtSenhaLogin = (EditText)  findViewById(R.id.login_senha);
        btcadastro.setOnClickListener(this);
        btentrar.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btcadastro){
            // ir para a activity Cadastre_se
            Intent intencao = new Intent(this, tela_cadastro1.class);
            startActivity(intencao);
        }
        if (view.getId()==R.id.bt_entrar){
            String email = txtEmailLogin.getText().toString();
            String senha = txtSenhaLogin.getText().toString();

            BancoController bd = new BancoController(getBaseContext());

            Cursor dados = bd.carregaDadosParaLogin(email, senha) ;

            // se encontrou os dados
            if(dados.moveToFirst()){
            // ir para a tela de menu, levando o nome do usuario (variavel nome)
                int codigo = dados.getInt(0);
                String nome = dados.getString(1);  //nome
                Intent intencao = new Intent(this, tela_principal.class);
                //cria o objeto parametro que ir enviar no nome da pessoal para a outra tela
                Bundle parametros = new Bundle();
                parametros.putString("nome",nome);
                parametros.putString("email",email);
                parametros.putString("senha", senha);
                parametros.putInt("codigo", codigo);
                intencao.putExtras(parametros);
                //ir para a outra tela
                startActivity(intencao);
            }else {
                String msg = "Usuário/senha invalidos ou não existe !";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        }
    }
}