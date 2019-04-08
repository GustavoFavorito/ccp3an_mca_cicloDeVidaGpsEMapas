package br.usjt.ciclodevidagpsemapas;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListarLocalizacoesActivity extends AppCompatActivity {

    private ListView localizacoesListView;
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_localizacoes);
        localizacoesListView = findViewById(R.id.localizacoesListView);
        final Intent origemIntent = getIntent();

        final ArrayList<String> localizacoes =
                origemIntent.getStringArrayListExtra("localizacoes");

        latitude = origemIntent.getDoubleExtra("latitude", 0);
        longitude = origemIntent.getDoubleExtra("longitude", 0);

        ArrayAdapter adapter =
                new ArrayAdapter<>(
                        this, android.R.layout.simple_list_item_1, localizacoes);
        localizacoesListView.setAdapter(adapter);

        localizacoesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextActivity =
                        new Intent(
                                ListarLocalizacoesActivity.this,
                                DetalhesLocalizacoesActivity.class);
                nextActivity.putExtra("latitude", latitude);
                nextActivity.putExtra("longitude", longitude);
                startActivity(nextActivity);
            }
        });
    }
}
