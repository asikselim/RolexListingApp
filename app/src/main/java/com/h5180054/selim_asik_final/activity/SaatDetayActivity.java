package com.h5180054.selim_asik_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5180054.selim_asik_final.R;
import com.h5180054.selim_asik_final.model.SaatModel;
import com.h5180054.selim_asik_final.util.Constants;
import com.h5180054.selim_asik_final.util.GlideUtil;
import com.h5180054.selim_asik_final.util.ObjectUtil;


public class SaatDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtModelDetay;
    TextView txtYilDetay;
    TextView txtKasaCapiDetay;
    TextView txtCamTipiDetay;
    TextView txtMekanizmaDetay;
    TextView txtKordonMalzemesiDetay;
    TextView txtSaatTarziDetay;
    TextView txtGreyMarketFiyatiDetay;
    TextView txtsaatDetay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saat_detay);
        init();



    }
    private void init(){

        String tasinanBurcString=getIntent().getStringExtra(Constants.TIKANAN_SAAT_TASINANIN_BASLIGI);
        SaatModel saatModel= ObjectUtil.jsonStringToSaat(tasinanBurcString);

        imgKapak=findViewById(R.id.imgKapak);
        txtBaslik=findViewById(R.id.txtBaslik);
        txtModelDetay=findViewById(R.id.txtModel_detay);

        txtYilDetay=findViewById(R.id.txtyil_detay);
        txtKasaCapiDetay=findViewById(R.id.txtKasaCapi_detay);
        txtCamTipiDetay=findViewById(R.id.txtCamTipi_detay);
        txtMekanizmaDetay=findViewById(R.id.txtMekanizma_detay);
        txtKordonMalzemesiDetay=findViewById(R.id.txtKordonMalzemesi_detay);
        txtSaatTarziDetay=findViewById(R.id.txtSaatTarzi_detay);
        txtGreyMarketFiyatiDetay=findViewById(R.id.txtGreyMarketFiyat_detay);

        txtsaatDetay=findViewById(R.id.txtsaatDetay);
        String saatDetay=saatModel.getSaatDetayi();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            txtsaatDetay.setText(Html.fromHtml(saatDetay, Html.FROM_HTML_MODE_LEGACY));
        }
        else{
            txtsaatDetay.setText(Html.fromHtml(saatDetay));
        }
        txtBaslik.setText((saatModel.getModel()));
        txtModelDetay.setText(saatModel.getCamTipi());
        txtYilDetay.setText(saatModel.getYil());
        txtKasaCapiDetay.setText(saatModel.getKasaCapi());
        txtCamTipiDetay.setText(saatModel.getCamTipi());
        txtMekanizmaDetay.setText(saatModel.getMekanizma());
        txtKordonMalzemesiDetay.setText(saatModel.getKordonMalzemesi());
        txtSaatTarziDetay.setText(saatModel.getSaatTarzi());
        txtGreyMarketFiyatiDetay.setText(saatModel.getGreyMarketFiyati());
        GlideUtil.resmiIndiripGoster(getApplicationContext(),saatModel.getBannerUrl(),imgKapak);



    }
}