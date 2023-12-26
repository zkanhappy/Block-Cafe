package com.example.blockcafe;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.blockcafe.BlockCafe.*;

public class afterLogin extends girisMenu implements Initializable {

    @FXML
    private JFXButton menuGoster;

    @FXML
    private JFXButton defButton;

    @FXML
    private JFXButton calisanGoster;

    @FXML
    private TextField tf1;
    @FXML
    private JFXButton satisgoster;

    @FXML
    private Pane menupane;

    @FXML
    private Pane toplamsatispane;

    @FXML
    private Label menutext;

    @FXML
    public Label tx1;

    @FXML
    public Label tx2;

    @FXML
    public Label tx3;

    @FXML
    public Label tx4;
    @FXML
    public Label i1;
    @FXML
    public Text ss;

    @FXML
    public Label i2;

    @FXML
    public Label i3;

    @FXML
    public Label i4;

    @FXML
    public Label i5;

    @FXML
    public Label i6;

    @FXML
    public Label i7;

    @FXML
    public Label i8;

    @FXML
    public Label i9;

    @FXML
    private Label sonuc1;

    @FXML
    public Label i10;

    @FXML
    public Label f1;

    @FXML
    public Label f2;

    @FXML
    public Label f3;

    @FXML
    public Label f4;

    @FXML
    public Label f5;

    @FXML
    public Label f6;

    @FXML
    public Label f7;

    @FXML
    public Label f8;

    @FXML
    public Label f9;

    @FXML
    public Label f10;

    @FXML
    public Label t1;

    @FXML
    public Label t2;

    @FXML
    public Label t3;

    @FXML
    public Label t4;

    @FXML
    public Label t5;

    @FXML
    public Label t6;

    @FXML
    public Label t7;

    @FXML
    public Label t8;

    @FXML
    public Label t9;

    @FXML
    public Label t10;

    @FXML
    public JFXButton lb1;

    @FXML
    private JFXButton geribut;

    @FXML
    private Label toplamtutar;

    @FXML
    private JFXButton satinal;

    @FXML
    private Pane satinalpane;

    @FXML
    private JFXTextArea scrolltext;

    @FXML
    private ScrollPane scroll;

    public double tutar;

    @FXML
    private Label toplamgetiri;

    @FXML
    private Pane calisansatispane;

    @FXML
    private Label calisantoplamsatis;

    @FXML
    private Pane calisanpane;

    @FXML
    JFXComboBox<String> choicebox;

    @FXML
    private TextArea tumcalisan;

    @FXML
    private Line cizgi1;
    @FXML
    private Line cizgi2;
    @FXML
    private Line cizgi3;

    @FXML
    private Text text1;
    @FXML
    private Text text2;
    @FXML
    private Text text3;
    @FXML
    private Text text4;
    @FXML
    private Pane kimlikpane;
    @FXML
    private Pane alexpane;
    @FXML
    private Pane stevepane;
    @FXML
    private Text yenimaas;
    @FXML
    private JFXButton onaylabutton;
    @FXML
    private JFXButton vazgecbutton;
    @FXML
    private JFXButton maasduzenle;
    @FXML
    private JFXButton kullanicisil;


    public int []miktar = new int[10];
    public String[] fiyat = new String[10];
    public String[] isim = new String[10];
    ArrayList<Mudur> mudurList = new ArrayList<>();
    ArrayList<Kasiyer> kasiyerList = new ArrayList<>();
    public boolean control= false;



    @FXML
    public void defButton(ActionEvent actionEvent) throws IOException{
        menupane.setVisible(false);
        menutext.setVisible(false);
        geribut.setVisible(true);
        toplamtutar.setVisible(false);
        satinal.setVisible(false);
        satinalpane.setVisible(false);
        toplamsatispane.setVisible(false);
        calisansatispane.setVisible(false);
        calisanpane.setVisible(false);
        menuSifirla();

    }
    public void menuSifirla(){
        for(int i= 0;i<10;i++){
            miktar[i] =0;
        }
        tutar=0;
        toplamtutar.setText("Toplam: " + tutar + "₺");
        t1.setText("0");
        t2.setText("0");
        t3.setText("0");
        t4.setText("0");
        t5.setText("0");
        t6.setText("0");
        t7.setText("0");
        t8.setText("0");
        t9.setText("0");
        t10.setText("0");
    }

    @FXML
    public void menuGoster(ActionEvent actionEvent) throws IOException {
        defButton(actionEvent);
        geribut.setVisible(false);

        if (mudurMu == true) {
            satinal.setVisible(false);
            toplamtutar.setLayoutX(393);
            toplamtutar.setVisible(true);
            menupane.setVisible(true);

            menu();

        } else {
            toplamtutar.setLayoutX(554);
            satinal.setVisible(true);
            toplamtutar.setVisible(true);
            menupane.setVisible(true);
            menu();

        }
    }
    @FXML
    public void satinal(ActionEvent actionEvent) throws IOException{
        if(tutar != 0.0) {
            menupane.setVisible(false);
            satinalpane.setVisible(true);
            satinal.setVisible(false);
            toplamtutar.setLayoutX(393);
        }
    }
    @FXML
    public void cashbutton(ActionEvent actionEvent) throws IOException{
        satisSayisiArttir(kullanici);
        defButton(actionEvent);
    }
    @FXML
    public void cardbutton(ActionEvent actionEvent) throws IOException{
        satisSayisiArttir(kullanici);
        defButton(actionEvent);
    }
    public void tekilKartDoldur(String isim) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path2));

        String line = reader.readLine();

        while(line != null) {

            String arr[] = line.split(" ", 4);

            if(isim.equals(arr[0])) {
                tx1.setText(arr[0]);
                tx2.setText(arr[1]);
                tx3.setText(arr[2]);
                tx4.setText("Kasiyer");
                break;
            }
            line = reader.readLine();
        }
    }
    @FXML void calisangoster(ActionEvent actionEvent) throws IOException{
        defButton(actionEvent);
        calisanpane.setVisible(true);
        if(mudurMu) {

            if (!control) {
                nesneYarat();
            }

            tumcalisan.setText(calisanTablo());

        }else {
            tekilKartDoldur(kullanici);
            maasduzenle.setVisible(false);
            kullanicisil.setVisible(false);
            tumcalisan.setVisible(false);
            goster(false);
            kimlikpane.setVisible(true);
            alexpane.setVisible(true);
            alexpane.toFront();
        }
    }
    public void goster(boolean dogru) throws IOException{
        cizgi1.setVisible(dogru);
        cizgi2.setVisible(dogru);
        cizgi3.setVisible(dogru);
        text1.setVisible(dogru);
        text2.setVisible(dogru);
        text3.setVisible(dogru);
        text4.setVisible(dogru);
        tumcalisan.setVisible(dogru);
    }
    public String calisanTablo() throws IOException{

        String text = "";

        for(int i = 0; i < mudurList.size(); i++) {
            text += String.format("%" + (-18) + "s" + "%" + (-25) + "s" + "Müdür\n", mudurList.get(i).getIsim(), mudurList.get(i).getMaas());
        }
        for(int i = 0; i < kasiyerList.size(); i++) {
            text += String.format("%" + (-18) + "s" + "%" + (-12) + "s" +  "%" + (-12) + "s" + "Kasiyer\n", kasiyerList.get(i).getIsim(), kasiyerList.get(i).getMaas(), kasiyerList.get(i).getSatisSayisi(), kasiyerList.get(i).getGetiri());
        }

        return text;

    }
    public void isimOku() throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedReader reader2 = new BufferedReader(new FileReader(path));


        String line = reader.readLine();
        choicebox.getItems().add("Tümünü Seç");
        while(line != null) {
            String arr[] = line.split(" ", 3);

            if (arr[2].equals("true")) {
                choicebox.getItems().add(arr[0]);
            }
            line = reader.readLine();
        }

        line = reader2.readLine();
        while(line != null) {
            String arr[] = line.split(" ", 3);

            if (arr[2].equals("false")) {
                choicebox.getItems().add(arr[0]);
            }
            line = reader2.readLine();
        }

    }
    public void nesneYarat() throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedReader reader2 = new BufferedReader(new FileReader(path2));

        String line = reader.readLine();
        String line2 = reader2.readLine();

        while(line != null) {
            String arr[] = line.split(" ", 3);
            String arr2[] = line2.split(" ", 4);

            if(arr[2].equals("true"))
                mudurList.add(new Mudur(arr[0], arr2[1]));
            else kasiyerList.add(new Kasiyer(arr[0], arr2[1], arr2[2], arr2[3]));

            line = reader.readLine();
            line2 = reader2.readLine();
        }
        control = true;
    }
    public void mudurKartDoldur(Mudur mudur){
        tx1.setText(mudur.getIsim());
        tx2.setText(mudur.getMaas());
        tx3.setVisible(false);
        ss.setVisible(false);
        tx4.setText("Müdür");

    }
    public void kasiyerKartDoldur(Kasiyer kasiyer){
        tx1.setText(kasiyer.getIsim());
        tx2.setText(kasiyer.getMaas());
        tx3.setVisible(true);
        tx3.setText(kasiyer.getSatisSayisi());
        tx4.setText("Kasiyer");

    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(mudurMu) {
            try {
                isimOku();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            choicebox.setVisible(false);
        }
    }


    @FXML
    public void select(ActionEvent actionEvent) throws IOException{
        if(mudurMu) {
            if (choicebox.getSelectionModel().getSelectedIndex() <= 0) {
                tumcalisan.setVisible(true);
                kimlikpane.setVisible(false);
                goster(true);

            } else {
                int mudurRange = mudurList.size();
                int index = choicebox.getSelectionModel().getSelectedIndex();

                if(index  <= mudurRange) {
                    mudurKartDoldur(mudurList.get(index-1));

                    stevepane.setVisible(true);
                    alexpane.setVisible(false);
                    ss.setVisible(false);
                }else {
                    kasiyerKartDoldur(kasiyerList.get(index - mudurRange-1));
                    ss.setVisible(true);
                    alexpane.setVisible(true);
                    stevepane.setVisible(false);
                }
                    goster(false);
                kimlikpane.setVisible(true);
                kullanicisil.setVisible(true);
                maasduzenle.setVisible(true);

            }
        }
        else{
            choicebox.setVisible(false);
        }
    }
    public void hesapSil(calisan calisan) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedReader reader2 = new BufferedReader(new FileReader(path2));

        String line = reader.readLine();
        String line2 = reader2.readLine();
        String text = "";
        String text2 = "";

        while(line != null) {
            String arr[] = line.split(" ", 3);

            if(!(arr[0].equals(calisan.getIsim()))) {
                text += line + "\n";
                text2 += line2 + "\n";
            }

            line = reader.readLine();
            line2 = reader2.readLine();
        }

        FileWriter fileWriter = new FileWriter(path);
        FileWriter fileWriter2 = new FileWriter(path2);

        fileWriter.write(text);
        fileWriter.close();

        fileWriter2.write(text2);
        fileWriter2.close();
    }
    @FXML
    public void kullanicisil(ActionEvent actionEvent)throws IOException {
        int mudurRange = mudurList.size();
        int index = choicebox.getSelectionModel().getSelectedIndex() - 1;

        if (index < mudurRange) {
            hesapSil(mudurList.get(index));
            mudurList.remove(index);
        } else {
            hesapSil(kasiyerList.get(index  - mudurRange));
            kasiyerList.remove(index-mudurRange);
        }

        choicebox.getItems().removeAll(choicebox.getItems());
        tumcalisan.setText(calisanTablo());
        isimOku();
    }
    public void maasDuzenle(calisan calisan,String maas) throws IOException {
        calisan.setMaas(maas);
        BufferedReader reader = new BufferedReader(new FileReader(path2));

        String line = reader.readLine();
        String text = "";

        while(line != null) {
            String arr[] = line.split(" ", 3);

            if(!(arr[0].equals(calisan.getIsim())))
                text += line + "\n";
            else text += arr[0]+" " + maas+" " + arr[2] + "\n";

            line = reader.readLine();
        }

        FileWriter fileWriter = new FileWriter(path2);
        fileWriter.write(text);
        fileWriter.close();

    }
    public void duzenle(boolean value){
        tf1.setVisible(value);
        tf1.setText("");
        tf1.setEditable(value);
        yenimaas.setVisible(value);
        vazgecbutton.setVisible(value);
        onaylabutton.setVisible(value);
    }
    @FXML
    public void maasduzenle(ActionEvent actionEvent)throws IOException{

        duzenle(true);
    }
    public static boolean isNumeric(String string) {
        int intValue;

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    @FXML
    public void onayla(ActionEvent actionEvent)throws IOException {
        if (tf1.getText().isEmpty()) {
            sonuc1.setText("Maaş Boş Olamaz");

        }else if(!isNumeric(tf1.getText())) {
            sonuc1.setText("Geçersiz Değer");
        }
        else if(tf1.getText().equals(tx2.getText())){
            sonuc1.setText("Eski Maaşa Eşit Olamaz");
        }else if(Integer.parseInt(tf1.getText())<4250){
            sonuc1.setText("Maaş 4250'den Az Olamaz");
        }

        else {
            int mudurRange = mudurList.size();
            int index = choicebox.getSelectionModel().getSelectedIndex() - 1;

            if (index < mudurRange) {
                maasDuzenle(mudurList.get(index), tf1.getText());

            } else {
                maasDuzenle(kasiyerList.get(index - mudurRange), tf1.getText());

            }
            tx2.setText(tf1.getText());
            sonuc1.setText("");
            duzenle(false);
        }
    }
    @FXML
    public void vazgec(ActionEvent actionEvent)throws IOException{

        duzenle(false);
    }

    @FXML void toplamsatis(ActionEvent actionEvent) throws IOException{
        if(mudurMu) {
            defButton(actionEvent);
            toplamsatispane.setVisible(true);
            Mudur mudur = new Mudur();
            String arr[] = mudur.satisYazdir().split(" ", 2);
            toplamgetiri.setText("Toplam Kazanç: " + arr[0] +"₺");
            scrolltext.setText(arr[1]);
        }
        else{
            defButton(actionEvent);
            geribut.setVisible(false);
            calisansatispane.setVisible(true);
            Kasiyer kasiyer = new Kasiyer();
            calisantoplamsatis.setText(kasiyer.satisYazdir());

        }
    }
    @FXML void lb1(ActionEvent actionEvent) throws IOException {
        if (miktar[0] != 0){
            miktar[0]--;
            tutar -= Double.parseDouble(fiyat[0]);
            toplamtutar.setText("Toplam: " + tutar + "₺");
            t1.setText(String.valueOf(miktar[0]));
        }
    }
    @FXML void lb2(ActionEvent actionEvent) throws IOException {
        if (miktar[1] != 0){
            miktar[1]--;
            tutar -= Double.parseDouble(fiyat[1]);
            toplamtutar.setText("Toplam: " + tutar + "₺");
            t2.setText(String.valueOf(miktar[1]));
        }
    }
    @FXML void lb3(ActionEvent actionEvent) throws IOException {
        if (miktar[2] != 0){
            miktar[2]--;
            tutar -= Double.parseDouble(fiyat[2]);
            toplamtutar.setText("Toplam: " + tutar + "₺");
            t3.setText(String.valueOf(miktar[2]));
        }
    }
    @FXML void lb4(ActionEvent actionEvent) throws IOException {
        if (miktar[3] != 0){
            miktar[3]--;
            tutar -= Double.parseDouble(fiyat[3]);
            toplamtutar.setText("Toplam: " + tutar + "₺");
            t4.setText(String.valueOf(miktar[3]));
        }
    }
    @FXML void lb5(ActionEvent actionEvent) throws IOException {
        if (miktar[4] != 0){
            miktar[4]--;
            tutar -= Double.parseDouble(fiyat[4]);
            toplamtutar.setText("Toplam: " + tutar + "₺");
            t5.setText(String.valueOf(miktar[4]));
        }
    }
    @FXML void lb6(ActionEvent actionEvent) throws IOException {
        if (miktar[5] != 0){
            miktar[5]--;
            tutar -= Double.parseDouble(fiyat[5]);
            toplamtutar.setText("Toplam: " + tutar + "₺");
            t6.setText(String.valueOf(miktar[5]));
        }
    }
    @FXML void lb7(ActionEvent actionEvent) throws IOException {
        if (miktar[6] != 0){
            miktar[6]--;
            tutar -= Double.parseDouble(fiyat[6]);
            toplamtutar.setText("Toplam: " + tutar + "₺");
            t7.setText(String.valueOf(miktar[6]));
        }
    }
    @FXML void lb8(ActionEvent actionEvent) throws IOException {
        if (miktar[7] != 0){
            miktar[7]--;
            tutar -= Double.parseDouble(fiyat[7]);
            toplamtutar.setText("Toplam: " + tutar + "₺");
            t8.setText(String.valueOf(miktar[7]));
        }
    }
    @FXML void lb9(ActionEvent actionEvent) throws IOException {
        if (miktar[8] != 0){
            miktar[8]--;
            tutar -= Double.parseDouble(fiyat[8]);
            toplamtutar.setText("Toplam: " + tutar + "₺");
            t9.setText(String.valueOf(miktar[8]));
        }
    }
    @FXML void lb10(ActionEvent actionEvent) throws IOException {
        if (miktar[9] != 0){
            miktar[9]--;
            tutar -= Double.parseDouble(fiyat[9]);
            toplamtutar.setText("Toplam: " + tutar + "₺");
            t10.setText(String.valueOf(miktar[9]));
        }
    }
    @FXML void rb1(ActionEvent actionEvent) throws IOException {
        miktar[0]++;
        tutar += Double.parseDouble(fiyat[0]);
        toplamtutar.setText("Toplam: " + tutar + "₺");
        t1.setText(String.valueOf(miktar[0]));
    }
    @FXML void rb2(ActionEvent actionEvent) throws IOException {
        miktar[1]++;
        tutar += Double.parseDouble(fiyat[1]);
        toplamtutar.setText("Toplam: " + tutar + "₺");
        t2.setText(String.valueOf(miktar[1]));
    }
    @FXML void rb3(ActionEvent actionEvent) throws IOException {
        miktar[2]++;
        tutar += Double.parseDouble(fiyat[2]);
        toplamtutar.setText("Toplam: " + tutar + "₺");
        t3.setText(String.valueOf(miktar[2]));
    }
    @FXML void rb4(ActionEvent actionEvent) throws IOException {
        miktar[3]++;
        tutar += Double.parseDouble(fiyat[3]);
        toplamtutar.setText("Toplam: " + tutar + "₺");
        t4.setText(String.valueOf(miktar[3]));
    }
    @FXML void rb5(ActionEvent actionEvent) throws IOException {
        miktar[4]++;
        tutar += Double.parseDouble(fiyat[4]);
        toplamtutar.setText("Toplam: " + tutar + "₺");
        t5.setText(String.valueOf(miktar[4]));
    }
    @FXML void rb6(ActionEvent actionEvent) throws IOException {
        miktar[5]++;
        tutar += Double.parseDouble(fiyat[5]);
        toplamtutar.setText("Toplam: " + tutar + "₺");
        t6.setText(String.valueOf(miktar[5]));
    }
    @FXML void rb7(ActionEvent actionEvent) throws IOException {
        miktar[6]++;
        tutar += Double.parseDouble(fiyat[6]);
        toplamtutar.setText("Toplam: " + tutar + "₺");
        t7.setText(String.valueOf(miktar[6]));
    }
    @FXML void rb8(ActionEvent actionEvent) throws IOException {
        miktar[7]++;
        tutar += Double.parseDouble(fiyat[7]);
        toplamtutar.setText("Toplam: " + tutar + "₺");
        t8.setText(String.valueOf(miktar[7]));
    }
    @FXML void rb9(ActionEvent actionEvent) throws IOException {
        miktar[8]++;
        tutar += Double.parseDouble(fiyat[8]);
        toplamtutar.setText("Toplam: " + tutar + "₺");
        t9.setText(String.valueOf(miktar[8]));
    }
    @FXML void rb10(ActionEvent actionEvent) throws IOException {
        miktar[9]++;
        tutar += Double.parseDouble(fiyat[9]);
        toplamtutar.setText("Toplam: " + tutar + "₺");
        t10.setText(String.valueOf(miktar[9]));
    }
    public void satisSayisiArttir(String gelenkullaniciadi) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(path2));

        String satir = reader.readLine();
        String text ="";
        Double kazanc = 0.0;
        int satisSayisi = 0;
        String maas = "4250";
        while(satir!=null){

            String arr[] = satir.split(" ", 4);
            gelenkullaniciadi = arr[0];
            maas = arr[1];
            kazanc = Double.valueOf(arr[3]);
            satisSayisi = Integer.valueOf(arr[2]);
            if(kullanici.equals(gelenkullaniciadi)) {
                satisSayisi++;
                kazanc+=tutar;
                break;
            }
            satir = reader.readLine();
        }
        String updatedLine = kullanici + " " + maas + " " + satisSayisi + " "+ kazanc +"\n";
        BufferedReader reader2 = new BufferedReader(new FileReader(path2));

        String line = reader2.readLine();

        while(line != null) {
            String arr[] = line.split(" ", 2);
            if(!kullanici.equals(arr[0])) {
                text += line + "\n";
            } else text += updatedLine;

            line = reader2.readLine();
        }

        FileWriter fileWriter = new FileWriter(path2);


        fileWriter.write(text);
        fileWriter.close();
    }

    public void menu() throws FileNotFoundException {



        BufferedReader reader = new BufferedReader(new FileReader(path3));

        for(int i = 0; i < 10; i++) {

            String satir = null;
            try {
                satir = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String arr[] = satir.split(" ", 2);
            fiyat[i] = arr[1];
            isim[i] = arr[0];

        }

        i1.setText(isim[0]);
        i2.setText(isim[1]);
        i3.setText(isim[2]);
        i4.setText(isim[3]);
        i5.setText(isim[4]);
        i6.setText(isim[5]);
        i7.setText(isim[6]);
        i8.setText(isim[7]);
        i9.setText(isim[8]);
        i10.setText(isim[9]);

        f1.setText(fiyat[0] + "₺");
        f2.setText(fiyat[1] + "₺");
        f3.setText(fiyat[2] + "₺");
        f4.setText(fiyat[3] + "₺");
        f5.setText(fiyat[4] + "₺");
        f6.setText(fiyat[5] + "₺");
        f7.setText(fiyat[6] + "₺");
        f8.setText(fiyat[7] + "₺");
        f9.setText(fiyat[8] + "₺");
        f10.setText(fiyat[9]+ "₺");

        t1.setText(String.valueOf(miktar[0]));
        t2.setText(String.valueOf(miktar[1]));
        t3.setText(String.valueOf(miktar[2]));
        t4.setText(String.valueOf(miktar[3]));
        t5.setText(String.valueOf(miktar[4]));
        t6.setText(String.valueOf(miktar[5]));
        t7.setText(String.valueOf(miktar[6]));
        t8.setText(String.valueOf(miktar[7]));
        t9.setText(String.valueOf(miktar[8]));
        t10.setText(String.valueOf(miktar[9]));




    }
    @FXML
    public void gerigel(ActionEvent actionEvent) throws IOException{
        control = false;
        mudurList.clear();
        kasiyerList.clear();
        BlockCafe m = new BlockCafe();
        m.changeScane("sample.fxml");
    }


    public afterLogin() throws IOException {

        }
    }



