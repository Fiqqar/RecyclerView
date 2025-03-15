package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailMakanan extends AppCompatActivity {

    TextView tvNamaMakananDetail, tvHargaMakananDetail;
    ImageView imgMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_makanan);

        tvNamaMakananDetail = (TextView) findViewById(R.id.tvNamaMakananDetail);
        tvHargaMakananDetail = (TextView) findViewById(R.id.tvHargaMakananDetail);
        imgMakanan = (ImageView) findViewById(R.id.imgMakanan);

        Intent intent = getIntent();
        String namaMakanan = intent.getStringExtra("namaMakanan");
        String hargaMakanan = intent.getStringExtra("HargaMakanan");
        int imgMakanana = intent.getIntExtra("image", 0);

        tvNamaMakananDetail.setText(namaMakanan);
        tvHargaMakananDetail.setText(hargaMakanan);
        imgMakanan.setImageResource(imgMakanana);
    }
}