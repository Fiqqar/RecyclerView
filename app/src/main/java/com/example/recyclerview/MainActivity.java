package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MakananAdapter.onItemClickListener {

    RecyclerView rvListMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rvListMakanan = (RecyclerView) findViewById(R.id.rvListMakanan);
        rvListMakanan.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ModelMakanan> listMakanan = new ArrayList<>();
        listMakanan.add(new ModelMakanan("Sate Padang", "Rp 35.000", R.drawable.satepadang));
        listMakanan.add(new ModelMakanan("Soto Betawi", "Rp 25.000", R.drawable.sotobetawi));
        listMakanan.add(new ModelMakanan("Nasi Padang", "Rp 20.000", R.drawable.nasipadang));
        listMakanan.add(new ModelMakanan("Mie Ayam", "Rp 15.000", R.drawable.mieayam));
        listMakanan.add(new ModelMakanan("Ayam Goreng", "Rp 24.000", R.drawable.ayamgoreng));
        listMakanan.add(new ModelMakanan("Kare Katsu", "Rp 45.000", R.drawable.karekatsu));
        listMakanan.add(new ModelMakanan("Chicken Katsu", "Rp 20.000", R.drawable.katsu));

        MakananAdapter makananAdapter = new MakananAdapter(listMakanan, this);
        rvListMakanan.setAdapter(makananAdapter);
    }

    @Override
    public void onItemClick(ModelMakanan modelMakanan) {
        Toast.makeText(this, modelMakanan.getMakanan() + ", " + modelMakanan.getHargaMakanan(), Toast.LENGTH_SHORT).show();
        Intent dtl = new Intent(MainActivity.this, DetailMakanan.class);
        dtl.putExtra("namaMakanan", modelMakanan.getMakanan());
        dtl.putExtra("HargaMakanan", modelMakanan.getHargaMakanan());
        dtl.putExtra("image", modelMakanan.getImgGambar());
        startActivity(dtl);
    }
}