package com.example.blockcafe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.example.blockcafe.BlockCafe.path;
import static com.example.blockcafe.BlockCafe.path2;


public class Mudur extends calisan implements satis{

    public Mudur() throws IOException {
    }

    public Mudur(String isim, String maas) throws IOException {
        super(isim, maas);

    }


    @Override
    public String satisYazdir() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path2));
        BufferedReader reader2 = new BufferedReader(new FileReader(path));
        double toplamkazanc = 0.0;
        String text = "";
        String satir = reader.readLine();
        String satir2 = reader2.readLine();
        while (satir != null) {

            String arr[] = satir.split(" ", 4);
            String arr2[] = satir2.split(" ",3);
            if(arr2[2].equals("false")) {
                text += String.format("%" + (-22) + "s" + "%" + (-20) + "s" + "%" + "s" + "₺\n", arr[0], arr[2], arr[3]);
                toplamkazanc += Double.valueOf(arr[3]);
            }
            satir = reader.readLine();
            satir2 = reader2.readLine();
        }
        return toplamkazanc+" " +text;
    }
}


