package com.example.android.intan_1202154351_modul3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Intan Gantira on 2/25/2018.
 */

public class ListAir extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter mAdapter;

    public static ArrayList<Item> DATA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listair);

        DATA = isi();
        recyclerView = (RecyclerView)findViewById(R.id.RecyclerList);
        mAdapter = new Adapter(DATA);
        recyclerView.setAdapter(mAdapter);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

    }

    public ArrayList<Item> isi(){
        ArrayList<Item> data = new ArrayList<>();
        data.add(new Item("Aqua","Ini adalah AMDK merk AQUA","Aqua adalah air minum kemasan yang harganya cukup mahal dibanding yang lain ",R.drawable.aqua));
        data.add(new Item("Amidis","Ini adalah AMDK merk AMIDIS","Amidis sering digunakan di asrama Telkom University",R.drawable.amidis));
        data.add(new Item("Cleo","Ini adalah AMDK merk CLEO","Cleo memiliki kemasan botol yang unik",R.drawable.cleo));
        data.add(new Item("Club","Ini adalah AMDK merk CLUB","",R.drawable.club));
        data.add(new Item("Equil","Ini adalah AMDK merk EQUIL","Equil adalah air minum yang cukup terkenal di kalangan menengah atas",R.drawable.equil));
        data.add(new Item("Evian","Ini adalah AMDK merk EVIAN","",R.drawable.evian));
        data.add(new Item("Le Minerale","Ini adalah AMDK merk LE MINERALE","Ada manis-masnisnya gitu",R.drawable.leminerale));
        data.add(new Item("Nestle","Ini adalah AMDK merk NESTLE","Memiliki kemasan botol yang tipis",R.drawable.nestle));
        data.add(new Item("Pristine","Ini adalah AMDK merk PRISTINE","Cukup mahal juga ya",R.drawable.pristine));
        data.add(new Item("Vit","Ini adalah AMDK merk VIT","Cukup terkenal untuk danus",R.drawable.vit));
        return data;
    }
}


