package com.delivery.appdelivery1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tela_cadastro1 extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_nome, edit_cpf, edit_tel, edit_email, edit_senha, edit_conf_senha;
    private Button bt_Cadastrar;
    private BancoController bancoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro1);

        // Inicializa os componentes da interface
        edit_nome = (EditText) findViewById(R.id.edit_nome);
        edit_cpf = (EditText) findViewById(R.id.edit_cpf);
        edit_tel = (EditText) findViewById(R.id.edit_tel);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_senha = (EditText) findViewById(R.id.edit_senha);
        edit_conf_senha = (EditText) findViewById(R.id.edit_conf_senha);
        bt_Cadastrar = (Button) findViewById(R.id.bt_cadastrar);


        // Configura os listeners de clique para os botões
        bt_Cadastrar.setOnClickListener(this);


        // Inicializa o controlador do banco de dados
        bancoController = new BancoController(this);
    }


    @Override
    public void onClick(View view) {
        String nome = edit_nome.getText().toString();
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();
        String confsenha = edit_conf_senha.getText().toString();
        String msg;
        if(!senha.equals(confsenha)){
            msg = "As senhas nao conferem!";
            Toast.makeText(getApplicationContext(), msg , Toast.LENGTH_LONG).show();
        }else{
            if (edit_nome.length()==0 || edit_email.length()<8)
            {
                msg = "Atenção! Os campos Nome e E-mail devem ser preenchidos!";
                Toast.makeText(getApplicationContext(), msg , Toast.LENGTH_LONG).show();
            }else{
                //gravar os dados
                BancoController bd = new BancoController(getBaseContext());
                String resultado;

                resultado = bd.insereDadosUsuario(nome, email, senha);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                edit_nome.setText("");
                edit_email.setText("");
                edit_senha.setText("");
                edit_conf_senha.setText("");



            }

        }

    }
}








