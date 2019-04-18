package br.usjt.ciclodevidagpsemapas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class LocalizacaoRecyclerViewAdapter extends
        RecyclerView.Adapter <LocalizacaoRecyclerViewAdapter.LocalizacaoViewHolder> {

    private List<Localizacao> localizacoes;

    public LocalizacaoRecyclerViewAdapter(List<Localizacao> localizacoes) {
        this.localizacoes = localizacoes;
    }

    @NonNull
    @Override
    public LocalizacaoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View raiz = LayoutInflater.from(
                viewGroup.getContext()).inflate(R.layout.list_item, viewGroup,false);

        return new LocalizacaoViewHolder(raiz);
    }

    @Override
    public int getItemCount() {
        return localizacoes.size();
    }

    @Override
    public void onBindViewHolder(@NonNull LocalizacaoViewHolder localizacaoViewHolder, int i) {

        Localizacao localizacao = localizacoes.get(i);

        localizacaoViewHolder.latitude.setText(
                String.format(Locale.ENGLISH, "Latitude: %.5f", localizacao.getLatitude()));
        localizacaoViewHolder.longitude.setText(
                String.format(Locale.ENGLISH, "Longitude: %.5f", localizacao.getLongitude()));
    }


    class LocalizacaoViewHolder extends RecyclerView.ViewHolder {

        public TextView latitude;
        public TextView longitude;

        public LocalizacaoViewHolder (View v) {
            super(v);
            latitude = v.findViewById(R.id.latitudeTextView);
            longitude = v.findViewById(R.id.longitudeTextView);
        }
    }
}
