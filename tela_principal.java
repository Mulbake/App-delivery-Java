package com.delivery.appdelivery1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tela_principal extends AppCompatActivity implements View.OnClickListener {

    Button btcardapio,btsair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        btcardapio = (Button) findViewById(R.id.bt_cardapio);
        btsair = (Button) findViewById(R.id.bt_logout);
        btcardapio.setOnClickListener(this);
        btsair.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.bt_cardapio){
            // ir para a activity cardapio
            Intent intent = new Intent(this, tela_cardapio.class);
            startActivity(intent);
        }

        if (view.getId()==R.id.bt_logout){
            // ir para a activity cardapio
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}