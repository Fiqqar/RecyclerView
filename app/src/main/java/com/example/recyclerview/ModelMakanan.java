package com.example.recyclerview;

public class ModelMakanan {
    private String makanan;
    private String hargaMakanan;
    private int imgGambar;

    public ModelMakanan(String makanan, String hargaMakanan, int imgGambar) {
        this.makanan = makanan;
        this.hargaMakanan = hargaMakanan;
        this.imgGambar = imgGambar;
    }

    public String getMakanan() {
        return makanan;
    }

    public String getHargaMakanan() {
        return hargaMakanan;
    }

    public int getImgGambar() {
        return imgGambar;
    }
}
