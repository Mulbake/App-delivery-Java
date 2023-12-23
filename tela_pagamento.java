package com.delivery.appdelivery1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class tela_pagamento extends AppCompatActivity {

    private Spinner spinner_formas_pagamento;
    private TextView selectedOptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pagamento);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("TOTAL_GERAL")) {
            float totalGeral = intent.getFloatExtra("TOTAL_GERAL", 0.0f);

            // Agora você pode usar 'totalGeral' como desejar, por exemplo, exibi-lo em um TextView.
            TextView textView = findViewById(R.id.lblTotalGeral);
            textView.setText("Total Geral: R$" + totalGeral);
        }

        // Inicializa o Spinner
        Spinner spinner = findViewById(R.id.spinner_formas_pagamento);

        // Adiciona as opções de pagamento
        String[] opcoes = {"Pix", "Dinheiro", "Cartão de crédito (Visa, Mastercard e Elo)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opcoes);
        spinner.setAdapter(adapter);
        String valorSelecionado = spinner.getSelectedItem().toString();

        // Atribua um listener ao botão
        Button botao = findViewById(R.id.bt_comprar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Exiba a mensagem
                Toast.makeText(getApplicationContext(), "Seu pedido será entregue em até 40min, obrigado por nos escolher", Toast.LENGTH_LONG).show();

                // Adicione um método intent para tela_principal
                Intent intent = new Intent(tela_pagamento.this, tela_principal.class);
                startActivity(intent);

            }
        });
    }
}