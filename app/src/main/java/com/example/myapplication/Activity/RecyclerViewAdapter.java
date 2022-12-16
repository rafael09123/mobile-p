package com.example.myapplication.Activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.room.Mahasiswa;

import java.security.PublicKey;
import java.util.List;

public class RecyclerviewUserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public TextView tvAlamat;
    public TextView tvKejuruan;
    public TextView tvNama;
    public TextView tvNim;

    public  MyViewHolder(@NonNull View itemView) {
        super();
        (itemView);
        tvAlamat = itemView.findViewById(R.id.tvAlamat);
        tvKejuruan = itemView.findViewById(R.id.tvKejuruan);
        tvNim = itemView.findViewById(R.id.tvNim);
        tvNama = itemView.findViewById(R.id.tvNama);
    }
}
    public RecyleviewUserAdapter(Context mContext, List<Mahasiswa>) albumList){
        this.mContext=mContext;
        this.myList=albumList;
        }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View itemView = LayoutInflater.from(viewGroup.getContext())
        .inflate(R,layout.item_mahasiswa, viewGroup, false);

    return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
    final Mahasiswa album = myList.get(i);
    myViewHolder.tvNama.setText(album.getNama());
    myViewHolder.tvNim.setText(album.getNim());

    }

    @Override
    public int getItemCount() {
        return myList.size();


    }
}
