

package br.usjt.ciclodevidagpsemapas.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import br.usjt.ciclodevidagpsemapas.R;
import br.usjt.ciclodevidagpsemapas.adapter.LocalizacaoRecyclerViewAdapter;
import br.usjt.ciclodevidagpsemapas.dao.LocalizacaoDAO;
import br.usjt.ciclodevidagpsemapas.model.Localizacao;

public class ListarLocalizacoesActivity extends AppCompatActivity {

    private LocalizacaoDAO localizacaoDAO;
    private RecyclerView locationsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_localizacoes);
        localizacaoDAO = new  LocalizacaoDAO(this);
        ArrayList<Localizacao> localizacoes = (ArrayList<Localizacao>) localizacaoDAO.listarLocalizacoes();
        locationsRecyclerView = findViewById(R.id.localizacoesRecyclerView);
        locationsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        LocalizacaoRecyclerViewAdapter adapter = new LocalizacaoRecyclerViewAdapter(localizacoes);
        locationsRecyclerView.setAdapter(adapter);

    }
}
