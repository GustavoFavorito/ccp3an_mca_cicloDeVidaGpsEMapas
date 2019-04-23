
package br.usjt.ciclodevidagpsemapas.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.usjt.ciclodevidagpsemapas.R;
import br.usjt.ciclodevidagpsemapas.model.Localizacao;
import br.usjt.ciclodevidagpsemapas.viewHolder.LocalizacaoViewHolder;

public class LocalizacaoRecyclerViewAdapter extends RecyclerView.Adapter<LocalizacaoViewHolder> {

    private List<Localizacao> localizacoes;

    public LocalizacaoRecyclerViewAdapter(List<Localizacao> localizacoes){
        this.localizacoes = localizacoes;
    }

    @NonNull
    @Override
    public LocalizacaoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View raiz = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

        return new LocalizacaoViewHolder(raiz);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalizacaoViewHolder localizacaoViewHolder, int i) {
        Localizacao localizacao = localizacoes.get(i);
        localizacaoViewHolder.longitudeTextView.setText("Longitude: " + localizacao.getLongitude());
        localizacaoViewHolder.latitudeTextView.setText("Latitude: " + localizacao.getLatitude());
    }

    @Override
    public int getItemCount() {
        return localizacoes.size();
    }
}