package com.example.blockcafe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.example.blockcafe.BlockCafe.path2;

public class Kasiyer extends calisan implements satis{
    private String satisSayisi ="0";
    private String getiri = "0";

    public String getGetiri() {
        return getiri;


    }

    public void setGetiri(String getiri) {
        this.getiri = getiri;
    }

    public Kasiyer(String isim, String maas, String satisSayisi, String getiri) throws IOException {
        super(isim, maas);
        this.satisSayisi = satisSayisi;
        this.getiri = getiri;
    }

    public String getSatisSayisi() {
        return satisSayisi;
    }

    public void setSatisSayisi(String satisSayisi) {
        this.satisSayisi = satisSayisi;
    }

    public Kasiyer() throws IOException {

    }


    @Override
    public String satisYazdir() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path2));

        String text = "";
        String satir = reader.readLine();

        while (satir != null) {

            String arr[] = satir.split(" ", 4);
            if(arr[0].equals(kullanici)) {
                text += String.format("" +
                        "" +
                        "" +
                        "%" + (-22) + "s" + "%" + (-20) + "s" + "%" + "s" + "₺\n", arr[0], arr[2], arr[3]);
                return text;
            }

            satir = reader.readLine();
        }
        return null;
    }
}
