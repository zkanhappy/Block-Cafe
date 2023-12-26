package com.example.blockcafe;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.example.blockcafe.BlockCafe.path;
import static com.example.blockcafe.BlockCafe.path2;

public class girisMenu extends kayitlimi{
    @FXML
    private JFXButton girisyap;

    @FXML
    private TextField kullaniciadi;


    @FXML
    private PasswordField sifre;

    @FXML
    private Label sonuc;

    @FXML
    private JFXButton kayitButonu;

    static String kullanici;

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    static boolean mudurMu;
    public boolean sifreDogruMu(String gelenkullaniciadi, String gelensifre) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(path));

        String satir = reader.readLine();

        while(satir!=null){

            String arr[] = satir.split(" ", 3);
            String kullaniciadi = arr[0];
            String sifre = arr[1];


            if(arr[2].equals("true"))
                mudurMu = true;
            else
                mudurMu = false;

            if(gelenkullaniciadi.equals(kullaniciadi) && gelensifre.equals((sifre)))
                return true;
            satir = reader.readLine();
        }
        return false;
    }
    @FXML
    public void girisyap(ActionEvent actionEvent) throws IOException {

        if (!kayitlimi(kullaniciadi.getText())) {
            sonuc.setText("Kayıt Bulunamadı");
        }else if(!sifreDogruMu(kullaniciadi.getText(),sifre.getText())){
            sonuc.setText("Parola Hatalı");
        }
        else{
            setKullanici(kullaniciadi.getText());
            sonuc.setText("Giriş Yapılıyor");
            BlockCafe m = new BlockCafe();
            m.changeScane("afterLogin.fxml");
        }


    }
    @FXML
    public void kayitEkrani(ActionEvent actionEvent) throws IOException {

        BlockCafe m = new BlockCafe();
        m.changeScane("registerScreen.fxml");
    }

    public girisMenu() throws IOException {
    }
}
