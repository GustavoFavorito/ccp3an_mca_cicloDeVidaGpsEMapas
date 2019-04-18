package br.usjt.ciclodevidagpsemapas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import java.util.Locale;

public class LocalizacaoArrayAdapter extends ArrayAdapter<Localizacao> {

    LocalizacaoArrayAdapter(Context context, List<Localizacao> localizacao) {
        super(context, -1, localizacao);
    }

    public View getView (int position, View convertView, ViewGroup parent) {
        Localizacao localizacao = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        ViewHolder vh;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);

            vh = new ViewHolder();

            vh.latitude = convertView.findViewById(R.id.latitudeTextView);
            vh.longitude = convertView.findViewById(R.id.longitudeTextView);

            convertView.setTag(vh);
        }

        vh = (ViewHolder) convertView.getTag();

        vh.latitude.setText(
                String.format(Locale.ENGLISH, "Latitude: %.5f", localizacao.getLatitude()));
        vh.longitude.setText(
                String.format(Locale.ENGLISH, "Longitude: %.5f", localizacao.getLongitude()));

        return convertView;
    }

    private class ViewHolder {
        TextView latitude;
        TextView longitude;
    }
}