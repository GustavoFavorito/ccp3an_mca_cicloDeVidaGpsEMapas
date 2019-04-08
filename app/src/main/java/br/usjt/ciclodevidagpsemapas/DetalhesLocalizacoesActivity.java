package br.usjt.ciclodevidagpsemapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetalhesLocalizacoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_localizacoes);
        Intent origemIntent = getIntent();

    }
}
