

package br.usjt.ciclodevidagpsemapas.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import br.usjt.ciclodevidagpsemapas.adapters.LocaisRecyclerViewAdapter;
import br.usjt.ciclodevidagpsemapas.model.Localizacao;
import br.usjt.ciclodevidagpsemapas.dao.LocalizacaoDAO;
import br.usjt.ciclodevidagpsemapas.R;

public class ListaLocaisActivity extends AppCompatActivity {

    private LocalizacaoDAO localizacaoDAO;
    private RecyclerView locationsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_locais);
        localizacaoDAO = new  LocalizacaoDAO(this);
        ArrayList<Localizacao> localizacoes = (ArrayList<Localizacao>) localizacaoDAO.lista();
        locationsRecyclerView = findViewById(R.id.localizacoesRecyclerView);
        locationsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        LocaisRecyclerViewAdapter adapter = new LocaisRecyclerViewAdapter(localizacoes);
        locationsRecyclerView.setAdapter(adapter);

    }
}
