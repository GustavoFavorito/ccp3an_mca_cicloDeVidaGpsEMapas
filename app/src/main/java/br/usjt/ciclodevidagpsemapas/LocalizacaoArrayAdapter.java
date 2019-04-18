package br.usjt.ciclodevidagpsemapas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class LocalizacaoArrayAdapter extends ArrayAdapter<Localizacao> {

    LocalizacaoArrayAdapter(Context context, List<Localizacao> localizacao) {
        super(context, -1, localizacao);
    }

    public View getView (int position, View convertView, ViewGroup parent) {
        Localizacao localizacao = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(getContext());

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView latitude = convertView.findViewById(R.id.latitudeTextView);
        TextView longitude = convertView.findViewById(R.id.longitudeTextView);

        latitude.setText(String.format("Latitude: %.5f", localizacao.getLatitude()));
        longitude.setText(String.format("Longitude: %.5f", localizacao.getLongitude()));

        return convertView;
    }
}