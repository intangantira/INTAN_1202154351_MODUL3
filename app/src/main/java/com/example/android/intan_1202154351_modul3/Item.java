package com.example.android.intan_1202154351_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Intan Gantira on 2/25/2018.
 */

public class Item extends AppCompatActivity {
    private String judul, keterangan, detail;
    private int gambar;

    public Item(String judul, String keterangan, String detail, int gambar) {
        this.judul = judul;
        this.keterangan = keterangan;
        this.detail = detail;
        this.gambar = gambar;
    }

    public static Intent toClick(Context context, String title, String desc, @DrawableRes int img){
        Intent in = new Intent(context, DetailAir.class);
        in.putExtra("EXTRA_TITLE",title);
        in.putExtra("EXTRA_DESC",desc);
        in.putExtra("EXTRA_IMG",img);
        return in;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getInfo() {
        return keterangan;
    }

    public void setInfo(String info) {
        this.keterangan = keterangan;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}

