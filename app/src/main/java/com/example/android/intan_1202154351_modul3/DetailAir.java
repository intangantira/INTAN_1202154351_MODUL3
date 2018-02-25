package com.example.android.intan_1202154351_modul3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Intan Gantira on 2/25/2018.
 */

public class DetailAir extends AppCompatActivity {

    private Button plus, minus;
    private ImageView progress, gambar;
    private TextView judul, Detail, Stats;
    private int level =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailair);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        progress = findViewById(R.id.isiBatre);

        judul = findViewById(R.id.lblJudul);
        Detail = findViewById(R.id.lblDetail);
        gambar = findViewById(R.id.gambar);
        Stats = findViewById(R.id.Status);

        Intent in = getIntent();
        String title=in.getStringExtra("etitle");
        String description=in.getStringExtra("edesc");
        if(description.length()<1){description="Hayolo\n";}
        int imgRes = in.getIntExtra("eimg",1);

        setTitle(title);
        judul.setText(title);
        Detail.setText(description);
        gambar.setImageResource(imgRes);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahIsi();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kurangIsi();
            }
        });
    }


    public void tambahIsi(){
        status();
        if (progress.getDrawable().getLevel() + 1 <=6) {
            //volume air akan ditambah sebanyak 1 liter
            level=level+1;
            //set text view dengan ukuran yang sudah dihitung
            Stats.setText(level + "L");
            //maka set image battery dengan battery satu tingkat sebelum level tertinggi
            progress.setImageLevel(progress.getDrawable().getLevel() + 1);
        } else {
            //apabila level battery penuh
            progress.setImageLevel(6);
            //maka akan muncul toast yang memberi tahu bahwa air sudah penuh
            Toast.makeText(this, "Full!", Toast.LENGTH_LONG).show();
        }
    }

    public void kurangIsi(){
        status();
        if (progress.getDrawable().getLevel() - 1 >= 1) {
            //volume air akan dikurangi sebanyak 1 Liter
            level=level-1;
            //set text view dengan ukuran yang sudah dihitung
            Stats.setText(level + "L");
            //maka set image battery dengan battery satu tingkat sebelum level terendah
            progress.setImageLevel(progress.getDrawable().getLevel() - 1);
        } else {
            //apabila battery dikurangi sampai level paling rendah
            progress.setImageLevel(0);
            //maka akan muncul toast yang memberi tahu bahwa air hampir habis
            Toast.makeText(this, "Almost empty!", Toast.LENGTH_LONG).show();
        }
    }

    public void status(){
        Stats.setText(""+level+"L");
    }
}
