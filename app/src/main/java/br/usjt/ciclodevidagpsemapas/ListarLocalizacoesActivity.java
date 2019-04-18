package br.usjt.ciclodevidagpsemapas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarLocalizacoesActivity extends AppCompatActivity {


    private RecyclerView localizacoesRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_localizacoes);
        Intent origemIntent = getIntent();
        final ArrayList<Localizacao> localizacoes =
                (ArrayList<Localizacao>) origemIntent.getSerializableExtra("localizacoes");
        localizacoesRecycleView = findViewById(R.id.localizacoesRecyclerView);
        localizacoesRecycleView.setLayoutManager(new LinearLayoutManager(this));

        LocalizacaoRecyclerViewAdapter adapter =
                new LocalizacaoRecyclerViewAdapter(localizacoes);

        localizacoesRecycleView.setAdapter(adapter);

//        localizacoesRecycleView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Uri gmmIntentUri = Uri.parse("geo:" + localizacoes.get((int)id));
//                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                mapIntent.setPackage("com.google.android.apps.maps");
//                startActivity(mapIntent);
//            }
//        });
    }
}
