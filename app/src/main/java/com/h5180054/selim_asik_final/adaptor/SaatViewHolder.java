package com.h5180054.selim_asik_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5180054.selim_asik_final.R;


public class SaatViewHolder extends RecyclerView.ViewHolder {
    ImageView imgSaatLogo;
    TextView txtSaatAdi;
    TextView txtCamTipi;
    TextView txtKasaCapi;
    public SaatViewHolder(@NonNull View cardView, SaatAdaptor.OnItemClickListener listener) {
        super(cardView);
        imgSaatLogo =cardView.findViewById(R.id.imgSaatLogo);
        txtSaatAdi =cardView.findViewById(R.id.txtSaatAdi);
        txtCamTipi =cardView.findViewById(R.id.txtCamTipi);
        txtKasaCapi=cardView.findViewById(R.id.txtKasaCapi);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClik(getAdapterPosition());
            }
        });
    }
}