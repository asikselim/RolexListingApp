package com.h5180054.selim_asik_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.h5180054.selim_asik_final.R;
import com.h5180054.selim_asik_final.model.SaatModel;
import com.h5180054.selim_asik_final.util.GlideUtil;

import java.util.List;

public class SaatAdaptor extends RecyclerView.Adapter<SaatViewHolder> {

    List<SaatModel> saatler;
    Context context;
    OnItemClickListener listener;
    public interface OnItemClickListener {
        void onClik(int position);
    }
    public SaatAdaptor(List<SaatModel> burclar, Context context, OnItemClickListener listener) {
        this.saatler = burclar;
        this.context = context;
        this.listener =listener;
    }

    @NonNull
    @Override
    public SaatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_saat,parent,false);
        return new SaatViewHolder(itemView,listener);
    }
    @Override
    public void onBindViewHolder(@NonNull SaatViewHolder viewHolder, int position) {
        viewHolder.txtSaatAdi.setText(saatler.get(position).getModel());
        viewHolder.txtCamTipi.setText(saatler.get(position).getCamTipi());
        viewHolder.txtKasaCapi.setText(saatler.get(position).getKasaCapi());

        GlideUtil.resmiIndiripGoster(context,saatler.get(position).getLogoUrl(),viewHolder.imgSaatLogo);
    }
    @Override
    public int getItemCount() {
        return saatler.size();
    }
}