
package br.usjt.ciclodevidagpsemapas.viewHolder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.usjt.ciclodevidagpsemapas.R;

public class LocaisViewHolder extends RecyclerView.ViewHolder {
    public TextView latitudeTextView;
    public TextView longitudeTextView;

    public LocaisViewHolder(View itemView) {
        super(itemView);
        latitudeTextView = itemView.findViewById(R.id.latitudeTextView);
        longitudeTextView = itemView.findViewById(R.id.longitudeTextView);
    }
}