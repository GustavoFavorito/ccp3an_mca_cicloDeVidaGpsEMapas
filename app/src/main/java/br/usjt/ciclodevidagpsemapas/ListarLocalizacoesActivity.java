package br.usjt.ciclodevidagpsemapas;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
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
import java.util.Locale;

public class ListarLocalizacoesActivity extends AppCompatActivity {

    private ListView localizacoesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_localizacoes);
        localizacoesListView = findViewById(R.id.localizacoesListView);
        final Intent origemIntent = getIntent();

        final ArrayList<String> localizacoes =
                origemIntent.getStringArrayListExtra("localizacoes");

        final ArrayList<String> local =
                origemIntent.getStringArrayListExtra("local");

        final ArrayAdapter adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, local);
        localizacoesListView.setAdapter(adapter);

        localizacoesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri gmmIntentUri = Uri.parse("geo: " + local.get((int)id));
                System.out.println(gmmIntentUri);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
