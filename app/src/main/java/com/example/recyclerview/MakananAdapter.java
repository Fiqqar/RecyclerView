package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.MyViewHolder>  {
    ArrayList<ModelMakanan> listMakanan;
    private final onItemClickListener listener;

    public interface onItemClickListener {
        void onItemClick(ModelMakanan modelMakanan);
    }

    public MakananAdapter(ArrayList<ModelMakanan> listMakanan, onItemClickListener listener) {
        this.listMakanan = listMakanan;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelMakanan makanan = listMakanan.get(position);

        holder.tvNamaMakanan.setText(makanan.getMakanan());
        holder.tvHargaMakanan.setText(makanan.getHargaMakanan());
        holder.imgGambar.setImageResource(makanan.getImgGambar());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(makanan));
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaMakanan;
        TextView tvHargaMakanan;
        ImageView imgGambar;

        public MyViewHolder(View view) {
            super(view);
            imgGambar = (ImageView) view.findViewById(R.id.imgGambar);
            tvNamaMakanan = (TextView) view.findViewById(R.id.tvNamaMakanan);
            tvHargaMakanan = (TextView) view.findViewById(R.id.tvHargaMakanan);
        }
    }
}
