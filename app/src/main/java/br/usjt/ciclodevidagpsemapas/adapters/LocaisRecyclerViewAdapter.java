
package br.usjt.ciclodevidagpsemapas.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.usjt.ciclodevidagpsemapas.R;
import br.usjt.ciclodevidagpsemapas.model.Localizacao;
import br.usjt.ciclodevidagpsemapas.viewHolder.LocaisViewHolder;

public class LocaisRecyclerViewAdapter extends RecyclerView.Adapter<LocaisViewHolder> {

    private List<Localizacao> localizacoes;

    public LocaisRecyclerViewAdapter(List<Localizacao> localizacoes){
        this.localizacoes = localizacoes;
    }

    @NonNull
    @Override
    public LocaisViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View raiz = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

        return new LocaisViewHolder(raiz);
    }

    @Override
    public void onBindViewHolder(@NonNull LocaisViewHolder locaisViewHolder, int i) {
        Localizacao localizacao = localizacoes.get(i);
        locaisViewHolder.longitudeTextView.setText("Longitude: " + localizacao.getLongitude());
        locaisViewHolder.latitudeTextView.setText("Latitude: " + localizacao.getLatitude());
    }

    @Override
    public int getItemCount() {
        return localizacoes.size();
    }
}