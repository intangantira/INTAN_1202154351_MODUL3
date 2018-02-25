package com.example.android.intan_1202154351_modul3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by Intan Gantira on 2/25/2018.
 */

public class Splash extends AppCompatActivity {
    //inisialisasi waktu selama 3 detik
    private static int splashInterval = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //menjadwalkan kapan di eksekusi dan lama penundaan sampai runnable di eksekusi
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //berpindah dari splashscreen ke menu utama
                startActivity(new Intent(Splash.this, MainActivity.class));
                //menampilkan toast
                Toast.makeText(Splash.this, "Selamat datang", Toast.LENGTH_SHORT).show();
                finish();
            }
        },splashInterval);

    }
}
