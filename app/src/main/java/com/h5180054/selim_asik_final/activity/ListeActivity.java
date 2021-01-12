package com.h5180054.selim_asik_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;


import com.h5180054.selim_asik_final.R;
import com.h5180054.selim_asik_final.adaptor.SaatAdaptor;
import com.h5180054.selim_asik_final.model.SaatModel;
import com.h5180054.selim_asik_final.network.Service;
import com.h5180054.selim_asik_final.util.AlertDialogUtil;
import com.h5180054.selim_asik_final.util.Constants;
import com.h5180054.selim_asik_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        progressDialog = new ProgressDialog(ListeActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.lutfen_bekleyiniz));
        progressDialog.show();
        init();


    }

    private  void  init()
    {
        saatleriGetir();
    }

    void  saatleriGetir()
    {

        new Service().getServiceApi().saatleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<SaatModel>>() {

                    List<SaatModel> saatler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<SaatModel> saatList) {
                        Log.e("RETROFIT","onNext : ");
                        progressDialog.dismiss();
                        saatler=saatList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");
                        progressDialog.dismiss();

                        if(saatler.size()>0) {



                            initRecycleView(saatler);
                        }
                    }
                });
    }


    private  void  initRecycleView(List<SaatModel> saatList)
    {
        recyclerView =findViewById(R.id.rcvSaat);
        SaatAdaptor saatAdaptor =new SaatAdaptor(saatList, getApplicationContext(), new SaatAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {

                SaatModel tiklananSaat =saatList.get(position);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.tiklanan_adi) + tiklananSaat.getModel(), Toast.LENGTH_SHORT).show();
                opennextActivity(tiklananSaat);

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(saatAdaptor);
    }
    private void opennextActivity(SaatModel tiklananSaat){
        Intent secondActivityIntent=new Intent(getApplicationContext(), SaatDetayActivity.class);
        String tiklananSaatString= ObjectUtil.saatToJsonString(tiklananSaat);
        secondActivityIntent.putExtra(Constants.TIKANAN_SAAT_TASINANIN_BASLIGI,tiklananSaatString);
        startActivity(secondActivityIntent);
    }
    @Override
    public void onBackPressed() {

        AlertDialogUtil.dialogGoster(ListeActivity.this,getResources().getString(R.string.uygulamadan_cıkmak_uzersiniz),
                getResources().getString(R.string.cıkmak_istediginize_eminmisiniz),
                getResources().getString(R.string.cikis),getResources().getString(R.string.vazgec),getResources().getString(R.string.ekranBilgisi2));






    }   }