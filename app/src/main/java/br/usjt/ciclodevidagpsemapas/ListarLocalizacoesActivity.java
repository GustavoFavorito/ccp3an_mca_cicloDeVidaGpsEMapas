package br.usjt.ciclodevidagpsemapas;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ListarLocalizacoesActivity extends AppCompatActivity {

    private ListView localizacoesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_localizacoes);
        localizacoesListView = findViewById(R.id.localizacoesListView);
        Intent origemIntent = getIntent();
        final List<Location> localizacoes =
                (List<Location>)origemIntent.getSerializableExtra("localizacoes");

        ArrayAdapter adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, localizacoes);
        localizacoesListView.setAdapter(adapter);
    }
}
