package com.delivery.appdelivery1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class tela_cardapio extends AppCompatActivity implements View.OnClickListener {
    TextView lblQtdDoce01, lblQtdDoce02, lblQtdDoce03,lblQtdDoce04,lblQtdDoce05,lblQtdDoce06, lblTotalGeral;
    Button btMaisDoce01, btMenosDoce01;
    Button btMaisDoce02, btMenosDoce02;
    Button btMaisDoce03, btMenosDoce03;
    Button btMaisDoce04, btMenosDoce04;
    Button btMaisDoce05, btMenosDoce05;
    Button btMaisDoce06, btMenosDoce06;
    Button  btGravarPedido;

    float totalgeral = 0, precoDoce01 = 20, precoDoce02 = 15, precoDoce03 = 15, precoDoce04 = 15, precoDoce05 = 15, precoDoce06 = 15;
    int   qtdDoce01 = 0, qtdDoce02 = 0, qtdDoce03 = 0, qtdDoce04 = 0, qtdDoce05 = 0, qtdDoce06 = 0, codigo_user;

    String nome, email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cardapio);


        lblQtdDoce01 =(TextView) findViewById(R.id.lblQtdDoce01);
        lblQtdDoce02 =(TextView) findViewById(R.id.lblQtdDoce02);
        lblQtdDoce03 =(TextView) findViewById(R.id.lblQtdDoce03);
        lblQtdDoce04 =(TextView) findViewById(R.id.lblQtdDoce04);
        lblQtdDoce05 =(TextView) findViewById(R.id.lblQtdDoce05);
        lblQtdDoce06 =(TextView) findViewById(R.id.lblQtdDoce06);
        lblTotalGeral =(TextView) findViewById(R.id.lblTotalGeral);

        btMaisDoce01 =(Button) findViewById(R.id.btMaisDoce01);
        btMaisDoce02 =(Button) findViewById(R.id.btMaisDoce02);
        btMaisDoce03 =(Button) findViewById(R.id.btMaisDoce03);
        btMaisDoce04 =(Button) findViewById(R.id.btMaisDoce04);
        btMaisDoce05 =(Button) findViewById(R.id.btMaisDoce05);
        btMaisDoce06 =(Button) findViewById(R.id.btMaisDoce06);
        btMenosDoce01 = (Button) findViewById(R.id.btMenosDoce01);
        btMenosDoce02 = (Button) findViewById(R.id.btMenosDoce02);
        btMenosDoce03 = (Button) findViewById(R.id.btMenosDoce03);
        btMenosDoce04 = (Button) findViewById(R.id.btMenosDoce04);
        btMenosDoce05 = (Button) findViewById(R.id.btMenosDoce05);
        btMenosDoce06 = (Button) findViewById(R.id.btMenosDoce06);
        btGravarPedido =(Button) findViewById(R.id.btGravarPedido);

        btMaisDoce01.setOnClickListener(this);
        btMenosDoce01.setOnClickListener(this);
        btMaisDoce02.setOnClickListener(this);
        btMenosDoce02.setOnClickListener(this);
        btMaisDoce03.setOnClickListener(this);
        btMenosDoce03.setOnClickListener(this);
        btMaisDoce04.setOnClickListener(this);
        btMenosDoce04.setOnClickListener(this);
        btMaisDoce05.setOnClickListener(this);
        btMenosDoce05.setOnClickListener(this);
        btMaisDoce06.setOnClickListener(this);
        btMenosDoce06.setOnClickListener(this);
        btGravarPedido.setOnClickListener(this);

        qtdDoce01 = Integer.parseInt(lblQtdDoce01.getText().toString());
        qtdDoce02 = Integer.parseInt(lblQtdDoce02.getText().toString());
        qtdDoce03 = Integer.parseInt(lblQtdDoce03.getText().toString());
        qtdDoce04 = Integer.parseInt(lblQtdDoce04.getText().toString());
        qtdDoce05 = Integer.parseInt(lblQtdDoce05.getText().toString());
        qtdDoce06 = Integer.parseInt(lblQtdDoce06.getText().toString());

    }

    @Override
    public void onClick( View view) {

        if (view.getId()==R.id.btGravarPedido)
        {
            gravarPedido();
        }
        if (view.getId()==R.id.btMaisDoce01){
            qtdDoce01++;
            lblQtdDoce01.setText(""+qtdDoce01);
        }
        if (view.getId()==R.id.btMenosDoce01){
            qtdDoce01--;
            if (qtdDoce01<0){
                qtdDoce01=0;
            }
            lblQtdDoce01.setText(""+qtdDoce01);
        }
        //doce 2
        if (view.getId()==R.id.btMaisDoce02){
            qtdDoce02++;
            lblQtdDoce02.setText(""+qtdDoce02);
        }
        if (view.getId()==R.id.btMenosDoce02){
            qtdDoce02--;
            if (qtdDoce02<0){
                qtdDoce02=0;
            }
            lblQtdDoce02.setText(""+qtdDoce02);
        }
        // doce 3
        if (view.getId()==R.id.btMaisDoce03){
            qtdDoce03++;
            lblQtdDoce03.setText(""+qtdDoce03);
        }
        if (view.getId()==R.id.btMenosDoce03){
            qtdDoce03--;
            if (qtdDoce03<0){
                qtdDoce03=0;
            }
            lblQtdDoce03.setText(""+qtdDoce03);
        }
        // doce 4
        if (view.getId()==R.id.btMaisDoce04){
            qtdDoce04++;
            lblQtdDoce04.setText(""+qtdDoce04);
        }
        if (view.getId()==R.id.btMenosDoce04){
            qtdDoce04--;
            if (qtdDoce04<0){
                qtdDoce04=0;
            }
            lblQtdDoce04.setText(""+qtdDoce04);
        }
        // doce 5
        if (view.getId()==R.id.btMaisDoce05){
            qtdDoce05++;
            lblQtdDoce05.setText(""+qtdDoce05);
        }
        if (view.getId()==R.id.btMenosDoce05){
            qtdDoce05--;
            if (qtdDoce05<0){
                qtdDoce05=0;
            }
            lblQtdDoce05.setText(""+qtdDoce05);
        }
        // doce 6
        if (view.getId()==R.id.btMaisDoce06){
            qtdDoce06++;
            lblQtdDoce06.setText(""+qtdDoce06);
        }
        if (view.getId()==R.id.btMenosDoce06){
            qtdDoce06--;
            if (qtdDoce06<0){
                qtdDoce06=0;
            }
            lblQtdDoce06.setText(""+qtdDoce06);
        }
        totalgeral = qtdDoce01 * precoDoce01 + qtdDoce02 * precoDoce02 + qtdDoce03 * precoDoce03+ qtdDoce04 * precoDoce04+ qtdDoce05 * precoDoce05+ qtdDoce06 * precoDoce06;
        lblTotalGeral.setText(""+totalgeral);
    }

    public void gravarPedido(){
        String resultado = "";
        if (totalgeral <= 0){
            // pedido em branco
            resultado = "ATENÇÃO-Não é possível gravar um pedido em branco, adicione um produto!";
            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        } else {
            // gravar o pedido
            BancoController bd = new BancoController(getBaseContext());

            resultado = bd.insereDadosPedido(codigo_user, qtdDoce01, precoDoce01, qtdDoce02, precoDoce02,
                    qtdDoce03, precoDoce03, qtdDoce04, precoDoce04, qtdDoce05, precoDoce05, qtdDoce06, precoDoce06, totalgeral);

            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

            // Abrir a nova Activity com o valor total como extra
            Intent intent = new Intent(tela_cardapio.this, tela_pagamento.class);
            intent.putExtra("TOTAL_GERAL", totalgeral);
            startActivity(intent);

        }
    }
}