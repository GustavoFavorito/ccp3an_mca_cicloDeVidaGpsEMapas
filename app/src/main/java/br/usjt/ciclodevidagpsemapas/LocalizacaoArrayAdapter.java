package br.usjt.ciclodevidagpsemapas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class LocalizacaoArrayAdapter extends ArrayAdapter<Localizacao> {

    public LocalizacaoArrayAdapter(Context context, List<Localizacao> localizacao) {
        super(context, -1, localizacao);
    }

    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        if (convertView == null) {
            convertView = inflater.inflate(
                    R.layout.activity_listar_localizacoes, parent, false);
        }
        return convertView;
    }
}