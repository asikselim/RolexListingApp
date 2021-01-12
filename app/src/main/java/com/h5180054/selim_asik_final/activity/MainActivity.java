package com.h5180054.selim_asik_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

import com.h5180054.selim_asik_final.R;
import com.h5180054.selim_asik_final.activity.ListeActivity;
import com.h5180054.selim_asik_final.util.AlertDialogUtil;
import com.h5180054.selim_asik_final.util.NetworkUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }


    private void init() {
        startTimer();
        

    }

    public void startTimer(){ CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
        @Override
        public void onTick(long l) {
        }
        @Override
        public void onFinish() {
            if(NetworkUtil.checkInternet(getApplicationContext())) {
                Intent ListeActivity=new Intent(getApplicationContext(), ListeActivity.class);
                startActivity(ListeActivity);
                finish();
            }
            else{
                isInternetOpen();
            }
        } };
        countDownTimer.start();

    }

    public void isInternetOpen() {
        AlertDialogUtil.dialogGoster(MainActivity.this,getResources().getString(R.string.internet_baglantiniz_yok),
                getResources().getString(R.string.uygulamayi_kullanmak_icin_internet_gereklidir),
                getResources().getString(R.string.ayarlara_git),getResources().getString(R.string.kapat),getResources().getString(R.string.ekranBilgisi));

    }
}

