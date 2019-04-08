package br.usjt.ciclodevidagpsemapas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

public class DetalhesLocalizacoesActivity extends AppCompatActivity {

    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_localizacoes);

        final Intent origemIntent = getIntent();

        latitude = origemIntent.getDoubleExtra("latitude", 0);
        longitude = origemIntent.getDoubleExtra("longitude", 0);

        System.out.println(latitude + " " + longitude);

        Uri gmmIntentUri = Uri.parse(
                String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
