package br.usjt.ciclodevidagpsemapas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListarLocalizacoesActivity extends AppCompatActivity {


    private RecyclerView localizacoesRecycleView;
    private LocalizacaoDAO localizacaoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_localizacoes);
        Intent origemIntent = getIntent();
        localizacaoDAO = new LocalizacaoDAO(this);

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