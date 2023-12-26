package com.example.blockcafe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.example.blockcafe.BlockCafe.path;

public abstract class kayitlimi extends Controller{

    public kayitlimi() throws IOException {
    }

    public boolean kayitlimi(String kayitkullaniciadi) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(path));

        String satir = reader.readLine();

        while(satir!=null){

            String arr[] = satir.split(" ", 2);
            String kullaniciadi = arr[0];
            if(kayitkullaniciadi.equals(kullaniciadi)) {
                return true;
            }
            satir = reader.readLine();
        }
        return false;

    }
}

