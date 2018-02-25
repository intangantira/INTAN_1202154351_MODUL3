package com.example.android.intan_1202154351_modul3;

/**
 * Created by Intan Gantira on 2/25/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MineralViewHolder>{
    //untuk recyclerview yang akan menampilkan layout list per item

    public ArrayList<Item> data;

    public Adapter(ArrayList<Item> data) {
        //menyiapkan layout untuk daftar air mineral
        this.data = data;


        Log.d("JUMLAH_ARRAYLIST","Items: "+getItemCount());
    }

    @Override
    public MineralViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //membuat view baru
        View view = layoutInflater.inflate(R.layout.activity_item, parent, false);
        return new MineralViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MineralViewHolder holder, int position) {
        //menghubungkan data dengan view holder pada recyclerview
        final  Item item = data.get(position);
        //mngambil isi view dari item
        holder.bindTo(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(view.getContext().getApplicationContext(),DetailAir.class);
                go.putExtra("etitle",item.getJudul());
                go.putExtra("edesc",item.getDetail());
                go.putExtra("eimg",item.getGambar());
                view.getContext().startActivity(go);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    //menghitung ukuran daata yang akan ditampilkan

    class MineralViewHolder extends RecyclerView.ViewHolder{

        private TextView mMineralJudul;
        private TextView mMineralInfo;
        private ImageView mMineralImg;
        private Context mContext;
        private Item mCurrentMineral;

        public MineralViewHolder(View itemView) {
            super(itemView);
            //untuk akses judul info dan gambar pada layout
            mMineralJudul = (TextView)itemView.findViewById(R.id.itemjudul);
            mMineralInfo = (TextView)itemView.findViewById(R.id.itemDeskripsi);
            mMineralImg = (ImageView)itemView.findViewById(R.id.itemMenu);
        }

        public void bindTo(Item mineral){
            //untuk menampilkan judul info, gambar dan jenis air mineral
            mCurrentMineral = mineral;
            mMineralImg.setImageResource(mineral.getGambar());
            mMineralJudul.setText(mineral.getJudul());
            mMineralInfo.setText(mineral.getInfo());
        }
    }
}
