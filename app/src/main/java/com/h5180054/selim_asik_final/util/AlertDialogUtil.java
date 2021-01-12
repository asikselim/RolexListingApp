package com.h5180054.selim_asik_final.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.h5180054.selim_asik_final.R;

public class AlertDialogUtil {
    public static void dialogGoster(Context context, String baslik, String mesajBilgisi, String pozitifButon, String negatifButon  , String ekranBilgisi)
    {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setTitle(baslik);
        builder.setMessage(mesajBilgisi);
        builder.setPositiveButton(pozitifButon, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(ekranBilgisi.toString() == context.getResources().getString(R.string.ekranBilgisi)){
                    Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                    context.startActivity(intent);
                }
                else if(ekranBilgisi.toString()==context.getResources().getString(R.string.ekranBilgisi2)){
                    ((Activity)context).onBackPressed();
                    ((Activity)context).finish();
                }

            }
        });

        builder.setNegativeButton(negatifButon, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(ekranBilgisi.toString() == context.getResources().getString(R.string.ekranBilgisi)){
                    ((Activity)context).finish();
                }
                else if(ekranBilgisi.toString()==context.getResources().getString(R.string.ekranBilgisi2)){
                    window.dismiss();
                }

            }
        });
        builder.show();
    }
}
