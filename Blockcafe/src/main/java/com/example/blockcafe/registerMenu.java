package com.example.blockcafe;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;


import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.io.IOException;

import static com.example.blockcafe.BlockCafe.path;
import static com.example.blockcafe.BlockCafe.path2;

public class registerMenu extends kayitlimi{

    @FXML
    private CheckBox mudurbox;

    @FXML
    private CheckBox kasiyerbox;

    @FXML
    private TextField kayitkullaniciadi;

    @FXML
    private PasswordField kayitsifre;

    @FXML
    private Label kayitsonuc;

    @FXML
    public void kasiyerboxaction(){
        if(kasiyerbox.isSelected()){
            mudurbox.setSelected(false);
        }
    }


    @FXML
    public void mudurboxaction() {
        if(mudurbox.isSelected()) {
            kasiyerbox.setSelected(false);
        }
    }

    @FXML
    public void geributton(ActionEvent actionEvent) throws IOException {
        BlockCafe m = new BlockCafe();
        m.changeScane("sample.fxml");
    }

    @FXML
    public void kayitButonu(ActionEvent actionEvent) throws IOException {


        if(kayitkullaniciadi.getText().isEmpty() || kayitsifre.getText().isEmpty()){
            kayitsonuc.setText("Kullanıcı Adı veya Parola Boş Olamaz");

        }

        else if((!mudurbox.isSelected()) && (!kasiyerbox.isSelected())){
            kayitsonuc.setText("Seçim Kutuları Boş Bırakılamaz");

        }
        else if(kayitkullaniciadi.getText().contains(" ") || kayitsifre.getText().contains(" ")){
            kayitsonuc.setText("Kullanıcı Adı veya Parola Boşluk İçeremez");
        }
        else if(kayitkullaniciadi.getText().length()>15){
            kayitsonuc.setText("Kullanıcı Adı 15 Karekterden Büyük Olamaz");
        }
        else if(kayitlimi(kayitkullaniciadi.getText())){
            kayitsonuc.setText("Kullanıcı Adı Zaten Mevcut");
        }
        else{

            try {
                boolean mudurmu = true;
                if(kasiyerbox.isSelected()){
                    mudurmu = false;
                }


                 FileWriter fileWriter = new FileWriter(path,true);
                String text1="";
                String text = kayitkullaniciadi.getText() + " " + kayitsifre.getText() + " " + mudurmu + "\n";
                fileWriter.write(text);
                fileWriter.close();

                FileWriter fileWriter1 = new FileWriter(path2,true);
                if(mudurmu) {
                    text1 = kayitkullaniciadi.getText() + " " + "6000" + " " + "0" + " " + "0" + "\n";
                }else text1 = kayitkullaniciadi.getText() + " " + "4250" + " " + "0" + " " + "0" + "\n";
                fileWriter1.write(text1);
                fileWriter1.close();
                BlockCafe m = new BlockCafe();
                m.changeScane("sample.fxml");

            } catch (IOException e) {

            }

        }
    }


    public registerMenu() throws IOException {


    }
}
