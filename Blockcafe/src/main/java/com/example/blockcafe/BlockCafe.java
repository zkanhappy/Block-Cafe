package com.example.blockcafe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class BlockCafe extends Application {
    static File currentDir = new File(".");

    static String path2 = currentDir.getAbsolutePath()+"\\src\\main\\resources\\com\\example\\blockcafe\\kullaniciVeri.txt";
    static String path = currentDir.getAbsolutePath()+"\\src\\main\\resources\\com\\example\\blockcafe\\kullaniciDosya.txt";
    static String path3 = currentDir.getAbsolutePath()+"\\src\\main\\resources\\com\\example\\blockcafe\\menubilgi.txt";
    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        primaryStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(BlockCafe.class.getResource("sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        primaryStage.setTitle("Block Cafe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changeScane(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }


    public static void main(String[] args) {

        File kullaniciDosya = new File(path);
        launch();
        try {
            if (!kullaniciDosya.exists()) {
                kullaniciDosya.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            }

        File kullaniciVeri = new File(path2);
        try{
            if(!kullaniciVeri.exists()) {
                kullaniciVeri.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File menubilgi = new File(path3);

        try {
            if (!menubilgi.exists()) {
                menubilgi.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
