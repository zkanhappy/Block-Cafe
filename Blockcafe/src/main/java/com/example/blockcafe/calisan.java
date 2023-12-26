package com.example.blockcafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public abstract class calisan extends afterLogin{
    public calisan() throws IOException {
    }

    public calisan(String isim, String maas) throws IOException {
        this.isim = isim;
        this.maas = maas;
    }

    private String isim;
    private String maas;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getMaas() {
        return maas;
    }

    public void setMaas(String maas) {
        this.maas = maas;
    }


}
