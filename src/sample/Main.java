// Java program to create a line with starting
// and ending coordinates set using function
// setStartX(), setStartY() setEndX(),
// setEndY() function
package sample;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.util.Duration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main extends Application {
    private int tutx=6;
    private int tuty=5;
    private String sirin;
    private boolean basildimi=false;
    private int ti=0;
    private int t=0;
    private int altın1;
    private int altın2;
    private int altın3;
    private int altın4;
    private int altın5;
    private int mantar1;
    private int durum;
    private int sıra=0;
    ArrayList<Rectangle> kareler=new ArrayList<>();

    public ArrayList<Rectangle> getKareler() {
        return kareler;
    }

    public int getSıra() {
        return sıra;
    }

    public void setSıra(int sıra) {
        this.sıra = sıra;
    }

    public void setKareler(ArrayList<Rectangle> kareler) {
        this.kareler = kareler;
    }

    public int getDurum() {
        return durum;
    }

    public void setDurum(int durum) {
        this.durum = durum;
    }

    public int getMantar1() {
        return mantar1;
    }

    public void setMantar1(int mantar1) {
        this.mantar1 = mantar1;
    }

    public void setTutx(int tutx) {
        this.tutx = tutx;
    }

    public void setTuty(int tuty) {
        this.tuty = tuty;
    }

    public int getAltın1() {
        return altın1;
    }

    public void setAltın1(int altın1) {
        this.altın1 = altın1;
    }

    public int getAltın2() {
        return altın2;
    }

    public void setAltın2(int altın2) {
        this.altın2 = altın2;
    }

    public int getAltın3() {
        return altın3;
    }

    public void setAltın3(int altın3) {
        this.altın3 = altın3;
    }

    public int getAltın4() {
        return altın4;
    }

    public void setAltın4(int altın4) {
        this.altın4 = altın4;
    }

    public int getAltın5() {
        return altın5;
    }

    public void setAltın5(int altın5) {
        this.altın5 = altın5;
    }

    public int getTutx() {
        return tutx;
    }

    public int getTuty() {
        return tuty;
    }

    public String getSirin() {
        return sirin;
    }

    public void setSirin(String sirin) {
        this.sirin = sirin;
    }

    public boolean isBasildimi() {
        return basildimi;
    }

    public void setBasildimi(boolean basildimi) {
        this.basildimi = basildimi;
    }

    public int bul(ImageView ımage)
    {
        Obje obje = new Obje();
        for (int i = 0; i <77 ; i++) {
            if (obje.getMatris()[i][0]==ımage.getX()&&obje.getMatris()[i][1]==ımage.getY()) {
                return i;
            }
        }
        return 0;
    }

    public void start(Stage stage)
    {

        stage.setTitle("Window");

        int matris[][];
        matris= new int[][]{{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}};




        Group group = new Group();
        Group group1=new Group();
        Oyuncu oyuncu = new Oyuncu();


        Scene scene = new Scene(group, 1100, 800);
        Scene scene1=new Scene(group1,500,400);
        Label label=new Label("Oyun Bitti");
        label.setLayoutX(170);
        label.setLayoutY(100);
        label.setFont(new Font("Arial", 30));




        group1.getChildren().addAll(label);

        String filename= "src/harita.txt";
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            list = stream.filter(line -> line.startsWith("Karakter:"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        String[] dizi=new String[4];
        String[] dizi1=new String[4];
        if(list.size()==1)
        {
            dizi1=null;
        }
        for (int i = 0; i <list.size() ; i++) {
            if(i==0)
            {
                String dusman1=list.get(0);
                dizi=dusman1.split("[:,]");
            }
            else
            {
                String dusman2=list.get(1);
                 dizi1=dusman2.split("[:,]");
            }

        }


        for (int i = 0; i < 12; i++) {
            Line line = new Line(50,50*(i+1),700,50*(i+1));
            group.getChildren().add(line);
        }
        for (int i = 0; i < 14; i++) {
            Line line = new Line(50*(i+1),50,50*(i+1),600);
            group.getChildren().add(line);
        }


        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <13; j++) {
                if (matris[i][j]==0){
                    Rectangle kare=new Rectangle();
                    kare.setStroke(Color.BLUE);
                    kare.setHeight(50);
                    kare.setWidth(50);
                    kare.setX(50*(j+1));
                    kare.setY(50*(i+1));
                    group.getChildren().add(kare);
                }

            }
        }


        ImageView murat = new ImageView("images.jpg");
        group.getChildren().add(murat);
        murat.setX(750);
        murat.setY(0);
        ImageView akilli=new ImageView("gozluklu1.jpg");
        group.getChildren().add(akilli);
        akilli.setX(750);
        akilli.setY(350);
        Button murat1=new Button("Tembel");
        murat1.setLayoutX(950);
        murat1.setLayoutY(80);
        murat1.setMinSize(100,70);
        Button akilli1= new Button("Akıllı");
        akilli1.setLayoutX(950);
        akilli1.setLayoutY(480);
        akilli1.setMinSize(100,70);
        group.getChildren().addAll(murat1,akilli1);


        String[] finalDizi = dizi;
        String[]  finalDizi1=dizi1;

        Dusman dusman1 = new Dusman();
        dusman1.setDusmanAdi(finalDizi[1]);
        Dusman dusman2 = new Dusman();
        if(list.size()==1)
        {
            dusman2.setDusmanAdi("aaaaaaaaaaaaaaaaaaaaaaaaa");
        }
        else
        {
            dusman2.setDusmanAdi(finalDizi1[1]);
        }



        Random random = new Random();
        int zaman =random.nextInt(11);

        Obje obje1=new Obje();

        Karakter karakter = new Karakter();
        Karakter karakter1 = new Karakter();
        Gargamel gargamell=new Gargamel();
        Azman azmann = new Azman();


        List<String> finalList = list;
        ImageView sirine= new ImageView("sirine1.jpg");
        sirine.setX(700);
        sirine.setY(400);
        group.getChildren().add(sirine);

        murat1.setOnAction(e ->{

            setBasildimi(true);
            murat1.setVisible(false);
            akilli1.setVisible(false);
            murat.setVisible(false);
            akilli.setVisible(false);
            ImageView altinn1= new ImageView("altin.jpg");
            group.getChildren().add(altinn1);
            ImageView altinn2= new ImageView("altin.jpg");
            group.getChildren().add(altinn2);
            ImageView altinn3= new ImageView("altin.jpg");
            group.getChildren().add(altinn3);
            ImageView altinn4= new ImageView("altin.jpg");
            group.getChildren().add(altinn4);
            ImageView altinn5= new ImageView("altin.jpg");
            group.getChildren().add(altinn5);
            ImageView mantar=new ImageView("mantar1.jpg");
            group.getChildren().add(mantar);
            ImageView gargamel= new ImageView("gargamel1.jpg");
            ImageView azman= new ImageView("azman1.png");

            Label dumana_uzaklik= new Label();
            dumana_uzaklik.setLayoutX(50);
            dumana_uzaklik.setLayoutY(650);
            dumana_uzaklik.setFont(new Font("Blue",35));
            Label dumana_uzaklik1= new Label();
            dumana_uzaklik1.setLayoutX(50);
            dumana_uzaklik1.setLayoutY(700);
            dumana_uzaklik1.setFont(new Font("Blue",35));


           if(dusman1.getDusmanAdi().equals("Gargamel")&&finalDizi[3].equals("A"))
           {

               gargamel.setX(200);
               gargamel.setY(50);
               gargamell.setBaslangicX(200);
               gargamell.setBaslangicY(50);
               group.getChildren().add(gargamel);
               karakter.En_Kisa_Yol(35,73);
               dumana_uzaklik.setText("Gargamelin Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));


           }
           else if(dusman1.getDusmanAdi().equals("Gargamel")&&finalDizi[3].equals("B"))
            {

                gargamel.setX(550);
                gargamel.setY(50);
                gargamell.setBaslangicX(550);
                gargamell.setBaslangicY(50);
                group.getChildren().add(gargamel);
                karakter.En_Kisa_Yol(35,74);
                dumana_uzaklik.setText("Gargamelin Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

            }
           else if(dusman1.getDusmanAdi().equals("Gargamel")&&finalDizi[3].equals("C"))
           {

               gargamel.setX(50);
               gargamel.setY(300);
               gargamell.setBaslangicX(50);
               gargamell.setBaslangicY(300);
               group.getChildren().add(gargamel);
               karakter.En_Kisa_Yol(35,75);
               dumana_uzaklik.setText("Gargamelin Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

           }
           else if(dusman1.getDusmanAdi().equals("Gargamel")&&finalDizi[3].equals("D"))
           {

               gargamel.setX(200);
               gargamel.setY(550);
               gargamell.setBaslangicX(200);
               gargamell.setBaslangicY(550);
               group.getChildren().add(gargamel);
               karakter.En_Kisa_Yol(35,76);
               dumana_uzaklik.setText("Gargamelin Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

           }
           else if(dusman1.getDusmanAdi().equals("Azman")&&finalDizi[3].equals("A"))
           {

               azman.setX(200);
               azman.setY(50);
               azmann.setBaslangicX(200);
               azmann.setBaslangicY(50);
               group.getChildren().add(azman);
               karakter.En_Kisa_Yol(35,73);
               dumana_uzaklik.setText("Azmanın Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

           }
           else if(dusman1.getDusmanAdi().equals("Azman")&&finalDizi[3].equals("B"))
           {

               azman.setX(550);
               azman.setY(50);
               azmann.setBaslangicX(550);
               azmann.setBaslangicY(50);
               group.getChildren().add(azman);
               karakter.En_Kisa_Yol(35,74);
               dumana_uzaklik.setText("Azmanın Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

           }
           else if(dusman1.getDusmanAdi().equals("Azman")&&finalDizi[3].equals("C"))
           {

               azman.setX(50);
               azman.setY(300);
               azmann.setBaslangicX(50);
               azmann.setBaslangicY(300);
               group.getChildren().add(azman);
               karakter.En_Kisa_Yol(35,75);
               dumana_uzaklik.setText("Azmanın Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

           }
           else if(dusman1.getDusmanAdi().equals("Azman")&&finalDizi[3].equals("D"))
           {

               azman.setX(200);
               azman.setY(550);
               azmann.setBaslangicX(200);
               azmann.setBaslangicY(550);
               group.getChildren().add(azman);
               karakter.En_Kisa_Yol(35,76);
               dumana_uzaklik.setText("Azmanın Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

           }
            if(dusman2.getDusmanAdi().equals("Gargamel")&&finalDizi1[3].equals("A"))
            {

                gargamel.setX(200);
                gargamel.setY(50);
                gargamell.setBaslangicX(200);
                gargamell.setBaslangicY(50);
                group.getChildren().add(gargamel);
                karakter1.En_Kisa_Yol(35,73);
                dumana_uzaklik1.setText("Gargamel Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Gargamel")&&finalDizi1[3].equals("B"))
            {

                gargamel.setX(550);
                gargamel.setY(50);
                gargamell.setBaslangicX(550);
                gargamell.setBaslangicY(50);
                group.getChildren().add(gargamel);
                karakter1.En_Kisa_Yol(35,74);
                dumana_uzaklik1.setText("Gargamel Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Gargamel")&&finalDizi1[3].equals("C"))
            {

                gargamel.setX(50);
                gargamel.setY(300);
                gargamell.setBaslangicX(50);
                gargamell.setBaslangicY(300);
                group.getChildren().add(gargamel);
                karakter1.En_Kisa_Yol(35,75);
                dumana_uzaklik1.setText("Gargamel Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Gargamel")&&finalDizi1[3].equals("D"))
            {

                gargamel.setX(200 );
                gargamel.setY(550);
                gargamell.setBaslangicX(200);
                gargamell.setBaslangicY(550);
                group.getChildren().add(gargamel);
                karakter1.En_Kisa_Yol(35,76);
                dumana_uzaklik1.setText("Gargamel Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Azman")&&finalDizi1[3].equals("A"))
            {

                azman.setX(200 );
                azman.setY(50);
                azmann.setBaslangicX(200);
                azmann.setBaslangicY(50);
                group.getChildren().add(azman);
                karakter1.En_Kisa_Yol(35,73);
                dumana_uzaklik1.setText("Azman Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Azman")&&finalDizi1[3].equals("B"))
            {

                azman.setX(550 );
                azman.setY(50);
                azmann.setBaslangicX(550);
                azmann.setBaslangicY(50);
                group.getChildren().add(azman);
                karakter1.En_Kisa_Yol(35,74);
                dumana_uzaklik1.setText("Azman Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Azman")&&finalDizi1[3].equals("C"))
            {

                azman.setX(50 );
                azman.setY(300);
                azmann.setBaslangicX(50);
                azmann.setBaslangicY(300);
                group.getChildren().add(azman);
                karakter1.En_Kisa_Yol(35,75);
                dumana_uzaklik1.setText("Azman Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Azman")&&finalDizi1[3].equals("D"))
            {

                azman.setX(200 );
                azman.setY(550);
                azmann.setBaslangicX(200);
                azmann.setBaslangicY(550);
                group.getChildren().add(azman);
                karakter1.En_Kisa_Yol(35,76);
                dumana_uzaklik1.setText("Azman Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }


            if(isBasildimi())
            {
                Label SkorLabeli=new Label();
                SkorLabeli.setLayoutX(750);
                SkorLabeli.setLayoutY(50);
                Label SkorLabeli2= new Label();
                SkorLabeli2.setLayoutX(750);
                SkorLabeli2.setLayoutY(100);
                SkorLabeli2.setFont(new Font("Blue",35));
                oyuncu.setSkor(20);
                SkorLabeli2.setText(""+oyuncu.getSkor());



                SkorLabeli.setFont(new Font("Blue",45));
                SkorLabeli.setText("Puan Durumu");
                group.getChildren().add(SkorLabeli);

                group.getChildren().add(SkorLabeli2);


                String add="images7.jpg";
                ImageView image=new ImageView(add);
                image.setX(350);
                image.setY(300);
                group.getChildren().add(image);


                group.getChildren().addAll(dumana_uzaklik,dumana_uzaklik1);

                for (int i = 1; i < karakter.getGidiş_yolu().size()-1; i++) {
                    Rectangle kare1=new Rectangle();
                    kare1.setHeight(50);
                    kare1.setWidth(50);
                    kare1.setFill(Color.rgb(0,0,255,0.3));
                    kare1.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][0]);
                    kare1.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][1]);
                    group.getChildren().add(kare1);
                    kareler.add(kare1);
                }
                for (int i = 1; i < karakter1.getGidiş_yolu().size()-1; i++) {
                    Rectangle kare1=new Rectangle();
                    kare1.setHeight(50);
                    kare1.setWidth(50);
                    kare1.setFill(Color.rgb(0,0,255,0.3));
                    kare1.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][0]);
                    kare1.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][1]);
                    group.getChildren().add(kare1);
                    kareler.add(kare1);
                }


                karakter.setGidiş_yolu();
                karakter1.setGidiş_yolu();



                scene.setOnKeyPressed(a -> {


                    if (a.getCode() == KeyCode.UP) {


                        if(matris[tuty-1][tutx]!=0)
                        {
                            setTuty(getTuty()-1);
                            image.setY(image.getY()-50);
                            durum=bul(image);
                            if(image.getX()==azman.getX()&&image.getY()==azman.getY())
                            {
                                azman.setX(azmann.getBaslangicX());
                                azman.setY(azmann.getBaslangicY());
                                oyuncu.setSkor(oyuncu.getSkor()-5);
                                SkorLabeli2.setText(""+oyuncu.getSkor());
                            }
                            if(image.getX()==gargamel.getX()&&image.getY()==gargamel.getY())
                            {
                                gargamel.setX(gargamell.getBaslangicX());
                                gargamel.setY(gargamell.getBaslangicY());
                                oyuncu.setSkor(oyuncu.getSkor()-15);
                                SkorLabeli2.setText(""+oyuncu.getSkor());
                            }
                            ArrayList<Integer> tut=new ArrayList<Integer>();

                            karakter.setGidiş_yolu();
                            karakter1.setGidiş_yolu();


                            if(finalList.size()==1 && dusman1.getDusmanAdi().equals("Gargamel"))
                            {
                                int konumu=bul(gargamel);
                                karakter.En_Kisa_Yol(durum,konumu);

                            }
                            else if(finalList.size()==1 && dusman1.getDusmanAdi().equals("Azman"))
                            {
                                int konumu=bul(azman);
                                karakter1.En_Kisa_Yol(durum,konumu);
                            }
                            if(finalList.size()==2)
                            {
                                int konumu=bul(gargamel);
                                int konumu1=bul(azman);
                                karakter.En_Kisa_Yol(durum,konumu);
                                karakter1.En_Kisa_Yol(durum,konumu1);
                            }
                            System.out.println(karakter.getGidiş_yolu());
                            System.out.println(karakter1.getGidiş_yolu());
                            for (int i = 0; i < kareler.size(); i++) {
                                group.getChildren().remove(kareler.get(i));
                            }
                            for (int i = 3; i < karakter.getGidiş_yolu().size()-1; i++) {
                                Rectangle kare1=new Rectangle();
                                kare1.setHeight(50);
                                kare1.setWidth(50);
                                kare1.setFill(Color.rgb(0,0,255,0.3));
                                kare1.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][0]);
                                kare1.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][1]);
                                group.getChildren().add(kare1);
                                kareler.add(kare1);
                            }
                            for (int i = 2; i < karakter1.getGidiş_yolu().size()-1; i++) {
                                Rectangle kare1=new Rectangle();
                                kare1.setHeight(50);
                                kare1.setWidth(50);
                                kare1.setFill(Color.rgb(0,0,255,0.3));
                                kare1.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][0]);
                                kare1.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][1]);
                                group.getChildren().add(kare1);
                                kareler.add(kare1);
                            }
                                if(karakter.getGidiş_yolu().size()>=2)
                                {

                                    for (int i = 0; i < 2; i++) {
                                        gargamel.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i+1)][0]);
                                        gargamel.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i+1)][1]);
                                        if (image.getX()==gargamel.getX()&&image.getY()==gargamel.getY())
                                        {
                                            gargamel.setX(gargamell.getBaslangicX());
                                            gargamel.setY(gargamell.getBaslangicY());
                                            oyuncu.setSkor(oyuncu.getSkor()-15);
                                            SkorLabeli2.setText(""+oyuncu.getSkor());

                                            break;
                                        }
                                        dumana_uzaklik.setText("Gargamelin Şirine uzaklıgı="+(karakter.getGidiş_yolu().size()-3));
                                    }
                                }

                                if(karakter1.getGidiş_yolu().size()!=0)
                                {
                                    azman.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][0]);
                                    azman.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][1]);
                                    if (image.getX()==azman.getX()&&image.getY()==azman.getY())
                                    {
                                        azman.setX(azmann.getBaslangicX());
                                        azman.setY(azmann.getBaslangicY());
                                        oyuncu.setSkor(oyuncu.getSkor()-5);
                                        SkorLabeli2.setText(""+oyuncu.getSkor());

                                    }
                                    dumana_uzaklik1.setText("Azman Şirine uzaklıgı="+(karakter1.getGidiş_yolu().size()-2));

                                }


                        }
                        if(image.getX()==mantar.getX()&&image.getY()==mantar.getY()&&mantar.isVisible())
                        {
                            mantar.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+50);
                            SkorLabeli2.setText(""+oyuncu.getSkor());

                        }
                        if(image.getX()==altinn1.getX()&&image.getY()==altinn1.getY()&&altinn1.isVisible())
                        {
                            altinn1.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn2.getX()&&image.getY()==altinn2.getY()&&altinn2.isVisible())
                        {
                            altinn2.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn3.getX()&&image.getY()==altinn3.getY()&&altinn3.isVisible())
                        {
                            altinn3.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn4.getX()&&image.getY()==altinn4.getY()&&altinn4.isVisible())
                        {
                            altinn4.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn5.getX()&&image.getY()==altinn5.getY()&&altinn5.isVisible())
                        {
                            altinn5.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }




                    }
                    if(a.getCode()==KeyCode.DOWN)
                    {

                        if(matris[tuty+1][tutx]!=0)
                        {
                            setTuty(getTuty()+1);
                            image.setY(image.getY()+50);
                            durum=bul(image);
                            if(image.getX()==azman.getX()&&image.getY()==azman.getY())
                            {
                                azman.setX(azmann.getBaslangicX());
                                azman.setY(azmann.getBaslangicY());
                                oyuncu.setSkor(oyuncu.getSkor()-5);
                                SkorLabeli2.setText(""+oyuncu.getSkor());
                            }
                            if(image.getX()==gargamel.getX()&&image.getY()==gargamel.getY())
                            {
                                gargamel.setX(gargamell.getBaslangicX());
                                gargamel.setY(gargamell.getBaslangicY());
                                oyuncu.setSkor(oyuncu.getSkor()-15);
                                SkorLabeli2.setText(""+oyuncu.getSkor());
                            }
                            ArrayList<Integer> tut=new ArrayList<Integer>();
                            karakter.setGidiş_yolu();
                            karakter1.setGidiş_yolu();

                            if(finalList.size()==1 && dusman1.getDusmanAdi().equals("Gargamel"))
                            {
                                int konumu=bul(gargamel);
                                karakter.En_Kisa_Yol(durum,konumu);

                            }
                            else if(finalList.size()==1 && dusman1.getDusmanAdi().equals("Azman"))
                            {
                                int konumu=bul(azman);
                                karakter1.En_Kisa_Yol(durum,konumu);
                            }
                            if(finalList.size()==2)
                            {
                                int konumu=bul(gargamel);
                                int konumu1=bul(azman);
                                karakter.En_Kisa_Yol(durum,konumu);
                                karakter1.En_Kisa_Yol(durum,konumu1);
                            }
                            System.out.println(karakter.getGidiş_yolu());
                            System.out.println(karakter1.getGidiş_yolu());
                            for (int i = 0; i < kareler.size(); i++) {
                                group.getChildren().remove(kareler.get(i));
                            }
                            for (int i = 3; i < karakter.getGidiş_yolu().size()-1; i++) {
                                Rectangle kare1=new Rectangle();
                                kare1.setHeight(50);
                                kare1.setWidth(50);
                                kare1.setFill(Color.rgb(0,0,255,0.3));
                                kare1.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][0]);
                                kare1.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][1]);
                                group.getChildren().add(kare1);
                                kareler.add(kare1);
                            }
                            for (int i = 2; i < karakter1.getGidiş_yolu().size()-1; i++) {
                                Rectangle kare1=new Rectangle();
                                kare1.setHeight(50);
                                kare1.setWidth(50);
                                kare1.setFill(Color.rgb(0,0,255,0.3));
                                kare1.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][0]);
                                kare1.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][1]);
                                group.getChildren().add(kare1);
                                kareler.add(kare1);
                            }
                            if(karakter.getGidiş_yolu().size()>=2)
                            {
                                for (int i = 0; i < 2; i++) {
                                    gargamel.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i+1)][0]);
                                    gargamel.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i+1)][1]);
                                    if (image.getX()==gargamel.getX()&&image.getY()==gargamel.getY())
                                    {
                                        gargamel.setX(gargamell.getBaslangicX());
                                        gargamel.setY(gargamell.getBaslangicY());
                                        oyuncu.setSkor(oyuncu.getSkor()-15);
                                        SkorLabeli2.setText(""+oyuncu.getSkor());

                                        break;
                                    }
                                    dumana_uzaklik.setText("Gargamelin Şirine uzaklıgı="+(karakter.getGidiş_yolu().size()-3));
                                }
                            }

                            if(karakter1.getGidiş_yolu().size()!=0)
                            {
                                azman.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][0]);
                                azman.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][1]);
                                if (image.getX()==azman.getX()&&image.getY()==azman.getY())
                                {
                                    azman.setX(azmann.getBaslangicX());
                                    azman.setY(azmann.getBaslangicY());
                                    oyuncu.setSkor(oyuncu.getSkor()-5);
                                    SkorLabeli2.setText(""+oyuncu.getSkor());

                                }
                                dumana_uzaklik1.setText("Azman Şirine uzaklıgı="+(karakter1.getGidiş_yolu().size()-2));
                            }
                        }
                        if(image.getX()==mantar.getX()&&image.getY()==mantar.getY()&&mantar.isVisible())
                        {
                            mantar.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+50);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn1.getX()&&image.getY()==altinn1.getY()&&altinn1.isVisible())
                        {
                            altinn1.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn2.getX()&&image.getY()==altinn2.getY()&&altinn2.isVisible())
                        {
                            altinn2.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn3.getX()&&image.getY()==altinn3.getY()&&altinn3.isVisible())
                        {
                            altinn3.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn4.getX()&&image.getY()==altinn4.getY()&&altinn4.isVisible())
                        {
                            altinn4.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn5.getX()&&image.getY()==altinn5.getY()&&altinn5.isVisible())
                        {
                            altinn5.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }

                    }
                    if(a.getCode()==KeyCode.RIGHT)
                    {

                        if(matris[tuty][tutx+1]!=0)
                        {
                            setTutx(getTutx()+1);
                            image.setX(image.getX()+50);
                            durum=bul(image);
                            if(image.getX()==azman.getX()&&image.getY()==azman.getY())
                            {
                                azman.setX(azmann.getBaslangicX());
                                azman.setY(azmann.getBaslangicY());
                                oyuncu.setSkor(oyuncu.getSkor()-5);
                                SkorLabeli2.setText(""+oyuncu.getSkor());
                            }
                            if(image.getX()==gargamel.getX()&&image.getY()==gargamel.getY())
                            {
                                gargamel.setX(gargamell.getBaslangicX());
                                gargamel.setY(gargamell.getBaslangicY());
                                oyuncu.setSkor(oyuncu.getSkor()-15);
                                SkorLabeli2.setText(""+oyuncu.getSkor());
                            }
                            ArrayList<Integer> tut=new ArrayList<Integer>();
                            karakter.setGidiş_yolu();
                            karakter1.setGidiş_yolu();

                            if(finalList.size()==1 && dusman1.getDusmanAdi().equals("Gargamel"))
                            {
                                int konumu=bul(gargamel);
                                karakter.En_Kisa_Yol(durum,konumu);

                            }
                            else if(finalList.size()==1 && dusman1.getDusmanAdi().equals("Azman"))
                            {
                                int konumu=bul(azman);
                                karakter1.En_Kisa_Yol(durum,konumu);
                            }
                            if(finalList.size()==2)
                            {
                                int konumu=bul(gargamel);
                                int konumu1=bul(azman);
                                karakter.En_Kisa_Yol(durum,konumu);
                                karakter1.En_Kisa_Yol(durum,konumu1);
                            }
                            System.out.println(karakter.getGidiş_yolu());
                            System.out.println(karakter1.getGidiş_yolu());
                            for (int i = 0; i < kareler.size(); i++) {
                                group.getChildren().remove(kareler.get(i));
                            }
                            for (int i = 3; i < karakter.getGidiş_yolu().size()-1; i++) {
                                Rectangle kare1=new Rectangle();
                                kare1.setHeight(50);
                                kare1.setWidth(50);
                                kare1.setFill(Color.rgb(0,0,255,0.3));
                                kare1.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][0]);
                                kare1.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][1]);
                                group.getChildren().add(kare1);
                                kareler.add(kare1);
                            }
                            for (int i = 2; i < karakter1.getGidiş_yolu().size()-1; i++) {
                                Rectangle kare1=new Rectangle();
                                kare1.setHeight(50);
                                kare1.setWidth(50);
                                kare1.setFill(Color.rgb(0,0,255,0.3));
                                kare1.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][0]);
                                kare1.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][1]);
                                group.getChildren().add(kare1);
                                kareler.add(kare1);
                            }
                            if(karakter.getGidiş_yolu().size()>=2)
                            {
                                for (int i = 0; i < 2; i++) {
                                    gargamel.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i+1)][0]);
                                    gargamel.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i+1)][1]);
                                    if (image.getX()==gargamel.getX()&&image.getY()==gargamel.getY())
                                    {
                                        gargamel.setX(gargamell.getBaslangicX());
                                        gargamel.setY(gargamell.getBaslangicY());
                                        oyuncu.setSkor(oyuncu.getSkor()-15);
                                        SkorLabeli2.setText(""+oyuncu.getSkor());

                                        break;
                                    }
                                    dumana_uzaklik.setText("Gargamelin Şirine uzaklıgı="+(karakter.getGidiş_yolu().size()-3));
                                }
                            }

                            if(karakter1.getGidiş_yolu().size()!=0)
                            {
                                azman.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][0]);
                                azman.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][1]);
                                if (image.getX()==azman.getX()&&image.getY()==azman.getY())
                                {
                                    azman.setX(azmann.getBaslangicX());
                                    azman.setY(azmann.getBaslangicY());
                                    oyuncu.setSkor(oyuncu.getSkor()-5);
                                    SkorLabeli2.setText(""+oyuncu.getSkor());

                                }
                                dumana_uzaklik1.setText("Azman Şirine uzaklıgı="+(karakter1.getGidiş_yolu().size()-2));
                            }
                        }
                        if(image.getX()==mantar.getX()&&image.getY()==mantar.getY()&&mantar.isVisible())
                        {

                            mantar.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+50);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn1.getX()&&image.getY()==altinn1.getY()&&altinn1.isVisible())
                        {
                            altinn1.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn2.getX()&&image.getY()==altinn2.getY()&&altinn2.isVisible())
                        {
                            altinn2.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn3.getX()&&image.getY()==altinn3.getY()&&altinn3.isVisible())
                        {
                            altinn3.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn4.getX()&&image.getY()==altinn4.getY()&&altinn4.isVisible())
                        {
                            altinn4.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn5.getX()&&image.getY()==altinn5.getY()&&altinn5.isVisible())
                        {
                            altinn5.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }

                    }
                    if(a.getCode()==KeyCode.LEFT)
                    {

                        if(matris[tuty][tutx-1]!=0)
                        {
                            setTutx(getTutx()-1);
                            image.setX(image.getX()-50);
                            durum=bul(image);
                            if(image.getX()==azman.getX()&&image.getY()==azman.getY())
                            {
                                azman.setX(azmann.getBaslangicX());
                                azman.setY(azmann.getBaslangicY());
                                oyuncu.setSkor(oyuncu.getSkor()-5);
                                SkorLabeli2.setText(""+oyuncu.getSkor());
                            }
                            if(image.getX()==gargamel.getX()&&image.getY()==gargamel.getY())
                            {
                                gargamel.setX(gargamell.getBaslangicX());
                                gargamel.setY(gargamell.getBaslangicY());
                                oyuncu.setSkor(oyuncu.getSkor()-15);
                                SkorLabeli2.setText(""+oyuncu.getSkor());
                            }
                            ArrayList<Integer> tut=new ArrayList<Integer>();
                            karakter.setGidiş_yolu();
                            karakter1.setGidiş_yolu();

                            if(finalList.size()==1 && dusman1.getDusmanAdi().equals("Gargamel"))
                            {
                                int konumu=bul(gargamel);
                                karakter.En_Kisa_Yol(durum,konumu);

                            }
                            else if(finalList.size()==1 && dusman1.getDusmanAdi().equals("Azman"))
                            {
                                int konumu=bul(azman);
                                karakter1.En_Kisa_Yol(durum,konumu);
                            }
                            if(finalList.size()==2)
                            {
                                int konumu=bul(gargamel);
                                int konumu1=bul(azman);
                                karakter.En_Kisa_Yol(durum,konumu);
                                karakter1.En_Kisa_Yol(durum,konumu1);
                            }
                            System.out.println(karakter.getGidiş_yolu());
                            System.out.println(karakter1.getGidiş_yolu());
                            for (int i = 0; i < kareler.size(); i++) {
                                group.getChildren().remove(kareler.get(i));
                            }
                            for (int i = 3; i < karakter.getGidiş_yolu().size()-1; i++) {
                                Rectangle kare1=new Rectangle();
                                kare1.setHeight(50);
                                kare1.setWidth(50);
                                kare1.setFill(Color.rgb(0,0,255,0.3));
                                kare1.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][0]);
                                kare1.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][1]);
                                group.getChildren().add(kare1);
                                kareler.add(kare1);
                            }
                            for (int i = 2; i < karakter1.getGidiş_yolu().size()-1; i++) {
                                Rectangle kare1=new Rectangle();
                                kare1.setHeight(50);
                                kare1.setWidth(50);
                                kare1.setFill(Color.rgb(0,0,255,0.3));
                                kare1.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][0]);
                                kare1.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][1]);
                                group.getChildren().add(kare1);
                                kareler.add(kare1);
                            }
                            if(karakter.getGidiş_yolu().size()>=2)
                            {
                                for (int i = 0; i < 2; i++) {
                                    gargamel.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i+1)][0]);
                                    gargamel.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i+1)][1]);
                                    if (image.getX()==gargamel.getX()&&image.getY()==gargamel.getY())
                                    {
                                        gargamel.setX(gargamell.getBaslangicX());
                                        gargamel.setY(gargamell.getBaslangicY());
                                        oyuncu.setSkor(oyuncu.getSkor()-15);
                                        SkorLabeli2.setText(""+oyuncu.getSkor());


                                        break;
                                    }
                                    dumana_uzaklik.setText("Gargamelin Şirine uzaklıgı="+(karakter.getGidiş_yolu().size()-3));
                                }
                            }

                            if(karakter1.getGidiş_yolu().size()!=0)
                            {
                                azman.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][0]);
                                azman.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][1]);
                                if (image.getX()==azman.getX()&&image.getY()==azman.getY())
                                {
                                    azman.setX(azmann.getBaslangicX());
                                    azman.setY(azmann.getBaslangicY());
                                    oyuncu.setSkor(oyuncu.getSkor()-5);
                                    SkorLabeli2.setText(""+oyuncu.getSkor());

                                }
                                dumana_uzaklik1.setText("Azman Şirine uzaklıgı="+(karakter1.getGidiş_yolu().size()-2));
                            }

                        }
                        if(image.getX()==mantar.getX()&&image.getY()==mantar.getY()&&mantar.isVisible())
                        {

                            mantar.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+50);
                            SkorLabeli2.setText(""+oyuncu.getSkor());

                        }
                        if(image.getX()==altinn1.getX()&&image.getY()==altinn1.getY()&&altinn1.isVisible())
                        {
                            altinn1.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn2.getX()&&image.getY()==altinn2.getY()&&altinn2.isVisible())
                        {
                            altinn2.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn3.getX()&&image.getY()==altinn3.getY()&&altinn3.isVisible())
                        {
                            altinn3.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn4.getX()&&image.getY()==altinn4.getY()&&altinn4.isVisible())
                        {
                            altinn4.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn5.getX()&&image.getY()==altinn5.getY()&&altinn5.isVisible())
                        {
                            altinn5.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }

                    }
                    if(oyuncu.getSkor()<=0)
                    {
                        Puan puan1 = new Puan();
                        Label label1 = new Label("Skorunuz="+puan1.PuaniGoster());
                        label1.setLayoutX(170);
                        label1.setLayoutY(200);
                        label1.setFont(new Font("Arial", 30));
                        group1.getChildren().add(label1);
                        stage.setScene(scene1);
                        stage.show();
                    }
                    if(image.getX()==650&&image.getY()==400)
                    {
                        Puan puan1 = new Puan();
                        Label label1 = new Label("Skorunuz="+puan1.PuaniGoster());
                        label1.setLayoutX(170);
                        label1.setLayoutY(200);
                        label1.setFont(new Font("Arial", 30));
                        group1.getChildren().add(label1);
                        stage.setScene(scene1);
                        stage.show();
                    }

                });
                Timer mytimer= new Timer();

                TimerTask timerTask =new TimerTask() {


                    @Override
                    public void run() {
                        setAltın1(random.nextInt(73));
                        setAltın2(random.nextInt(73));
                        setAltın3(random.nextInt(73));
                        setAltın4(random.nextInt(73));
                        setAltın5(random.nextInt(73));

                        if(ti%2==1)
                        {
                            altinn1.setVisible(false);
                            altinn2.setVisible(false);
                            altinn3.setVisible(false);
                            altinn4.setVisible(false);
                            altinn5.setVisible(false);
                        }
                        else
                        {
                            altinn1.setVisible(true);
                            altinn1.setX(obje1.getMatris()[altın1][0]);
                            altinn1.setY(obje1.getMatris()[altın1][1]);
                            if(image.getX()==altinn1.getX()&&image.getY()==altinn1.getY())
                            {
                                altinn1.setVisible(false);


                            }
                            altinn2.setVisible(true);
                            altinn2.setX(obje1.getMatris()[altın2][0]);
                            altinn2.setY(obje1.getMatris()[altın2][1]);
                            if(image.getX()==altinn2.getX()&&image.getY()==altinn2.getY())
                            {
                                altinn2.setVisible(false);

                            }
                            altinn3.setVisible(true);
                            altinn3.setX(obje1.getMatris()[altın3][0]);
                            altinn3.setY(obje1.getMatris()[altın3][1]);
                            if(image.getX()==altinn3.getX()&&image.getY()==altinn3.getY())
                            {
                                altinn3.setVisible(false);


                            }
                            altinn4.setVisible(true);
                            altinn4.setX(obje1.getMatris()[altın4][0]);
                            altinn4.setY(obje1.getMatris()[altın4][1]);
                            if(image.getX()==altinn4.getX()&&image.getY()==altinn4.getY())
                            {
                                altinn4.setVisible(false);


                            }
                            altinn5.setVisible(true);
                            altinn5.setX(obje1.getMatris()[altın5][0]);
                            altinn5.setY(obje1.getMatris()[altın5][1]);
                            if(image.getX()==altinn5.getX()&&image.getY()==altinn5.getY())
                            {
                                altinn5.setVisible(false);


                            }

                        }
                        ti++;
                        if(image.getX()==650&&image.getY()==400)
                        {
                            mytimer.cancel();
                        }
                    }
                };
                mytimer.schedule(timerTask,0,6000);

                TimerTask timerTask1 = new TimerTask() {
                    @Override
                    public void run() {
                        setMantar1(random.nextInt(73));
                        if(t%2==1)
                        {
                            mantar.setVisible(false);
                        }
                        else
                        {

                            mantar.setVisible(true);
                            mantar.setX(obje1.getMatris()[mantar1][0]);
                            mantar.setY(obje1.getMatris()[mantar1][1]);
                            if(image.getX()==mantar.getX()&&image.getY()==mantar.getY())
                            {
                                mantar.setVisible(false);


                            }

                        }
                        t++;
                        if(image.getX()==650&&image.getY()==400)
                        {
                            mytimer.cancel();
                        }
                    }
                };
                mytimer.schedule(timerTask1,0,8000);

            }
        });


        akilli1.setOnAction(e ->{
            setBasildimi(true);
            murat1.setVisible(false);
            akilli1.setVisible(false);
            murat.setVisible(false);
            akilli.setVisible(false);
            ImageView altinn1= new ImageView("altin.jpg");
            group.getChildren().add(altinn1);
            ImageView altinn2= new ImageView("altin.jpg");
            group.getChildren().add(altinn2);
            ImageView altinn3= new ImageView("altin.jpg");
            group.getChildren().add(altinn3);
            ImageView altinn4= new ImageView("altin.jpg");
            group.getChildren().add(altinn4);
            ImageView altinn5= new ImageView("altin.jpg");
            group.getChildren().add(altinn5);
            ImageView mantar=new ImageView("mantar1.jpg");
            group.getChildren().add(mantar);
            ImageView gargamel= new ImageView("gargamel1.jpg");
            ImageView azman= new ImageView("azman1.png");

            Label dumana_uzaklik= new Label();
            dumana_uzaklik.setLayoutX(50);
            dumana_uzaklik.setLayoutY(650);
            dumana_uzaklik.setFont(new Font("Blue",35));
            Label dumana_uzaklik1= new Label();
            dumana_uzaklik1.setLayoutX(50);
            dumana_uzaklik1.setLayoutY(700);
            dumana_uzaklik1.setFont(new Font("Blue",35));


            if(dusman1.getDusmanAdi().equals("Gargamel")&&finalDizi[3].equals("A"))
            {

                gargamel.setX(200);
                gargamel.setY(50);
                gargamell.setBaslangicX(200);
                gargamell.setBaslangicY(50);
                group.getChildren().add(gargamel);
                karakter.En_Kisa_Yol(35,73);
                dumana_uzaklik.setText("Gargamelin Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));


            }
            else if(dusman1.getDusmanAdi().equals("Gargamel")&&finalDizi[3].equals("B"))
            {

                gargamel.setX(550);
                gargamel.setY(50);
                gargamell.setBaslangicX(550);
                gargamell.setBaslangicY(50);
                group.getChildren().add(gargamel);
                karakter.En_Kisa_Yol(35,74);
                dumana_uzaklik.setText("Gargamelin Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

            }
            else if(dusman1.getDusmanAdi().equals("Gargamel")&&finalDizi[3].equals("C"))
            {

                gargamel.setX(50);
                gargamel.setY(300);
                gargamell.setBaslangicX(50);
                gargamell.setBaslangicY(300);
                group.getChildren().add(gargamel);
                karakter.En_Kisa_Yol(35,75);
                dumana_uzaklik.setText("Gargamelin Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

            }
            else if(dusman1.getDusmanAdi().equals("Gargamel")&&finalDizi[3].equals("D"))
            {

                gargamel.setX(200);
                gargamel.setY(550);
                gargamell.setBaslangicX(200);
                gargamell.setBaslangicY(550);
                group.getChildren().add(gargamel);
                karakter.En_Kisa_Yol(35,76);
                dumana_uzaklik.setText("Gargamelin Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

            }
            else if(dusman1.getDusmanAdi().equals("Azman")&&finalDizi[3].equals("A"))
            {

                azman.setX(200);
                azman.setY(50);
                azmann.setBaslangicX(200);
                azmann.setBaslangicY(50);
                group.getChildren().add(azman);
                karakter.En_Kisa_Yol(35,73);
                dumana_uzaklik.setText("Azmanın Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

            }
            else if(dusman1.getDusmanAdi().equals("Azman")&&finalDizi[3].equals("B"))
            {

                azman.setX(550);
                azman.setY(50);
                azmann.setBaslangicX(550);
                azmann.setBaslangicY(50);
                group.getChildren().add(azman);
                karakter.En_Kisa_Yol(35,74);
                dumana_uzaklik.setText("Azmanın Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

            }
            else if(dusman1.getDusmanAdi().equals("Azman")&&finalDizi[3].equals("C"))
            {

                azman.setX(50);
                azman.setY(300);
                azmann.setBaslangicX(50);
                azmann.setBaslangicY(300);
                group.getChildren().add(azman);
                karakter.En_Kisa_Yol(35,75);
                dumana_uzaklik.setText("Azmanın Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

            }
            else if(dusman1.getDusmanAdi().equals("Azman")&&finalDizi[3].equals("D"))
            {

                azman.setX(200);
                azman.setY(550);
                azmann.setBaslangicX(200);
                azmann.setBaslangicY(550);
                group.getChildren().add(azman);
                karakter.En_Kisa_Yol(35,76);
                dumana_uzaklik.setText("Azmanın Şirine Uzaklığı ="+(karakter.getGidiş_yolu().size()-1));

            }
            if(dusman2.getDusmanAdi().equals("Gargamel")&&finalDizi1[3].equals("A"))
            {

                gargamel.setX(200);
                gargamel.setY(50);
                gargamell.setBaslangicX(200);
                gargamell.setBaslangicY(50);
                group.getChildren().add(gargamel);
                karakter1.En_Kisa_Yol(35,73);
                dumana_uzaklik1.setText("Gargamel Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Gargamel")&&finalDizi1[3].equals("B"))
            {

                gargamel.setX(550);
                gargamel.setY(50);
                gargamell.setBaslangicX(550);
                gargamell.setBaslangicY(50);
                group.getChildren().add(gargamel);
                karakter1.En_Kisa_Yol(35,74);
                dumana_uzaklik1.setText("Gargamel Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Gargamel")&&finalDizi1[3].equals("C"))
            {

                gargamel.setX(50);
                gargamel.setY(300);
                gargamell.setBaslangicX(50);
                gargamell.setBaslangicY(300);
                group.getChildren().add(gargamel);
                karakter1.En_Kisa_Yol(35,75);
                dumana_uzaklik1.setText("Gargamel Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Gargamel")&&finalDizi1[3].equals("D"))
            {

                gargamel.setX(200 );
                gargamel.setY(550);
                gargamell.setBaslangicX(200);
                gargamell.setBaslangicY(550);
                group.getChildren().add(gargamel);
                karakter1.En_Kisa_Yol(35,76);
                dumana_uzaklik1.setText("Gargamel Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Azman")&&finalDizi1[3].equals("A"))
            {

                azman.setX(200 );
                azman.setY(50);
                azmann.setBaslangicX(200);
                azmann.setBaslangicY(50);
                group.getChildren().add(azman);
                karakter1.En_Kisa_Yol(35,73);
                dumana_uzaklik1.setText("Azman Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Azman")&&finalDizi1[3].equals("B"))
            {

                azman.setX(550 );
                azman.setY(50);
                azmann.setBaslangicX(550);
                azmann.setBaslangicY(50);
                group.getChildren().add(azman);
                karakter1.En_Kisa_Yol(35,74);
                dumana_uzaklik1.setText("Azman Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Azman")&&finalDizi1[3].equals("C"))
            {

                azman.setX(50 );
                azman.setY(300);
                azmann.setBaslangicX(50);
                azmann.setBaslangicY(300);
                group.getChildren().add(azman);
                karakter1.En_Kisa_Yol(35,75);
                dumana_uzaklik1.setText("Azman Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }
            else if(dusman2.getDusmanAdi().equals("Azman")&&finalDizi1[3].equals("D"))
            {

                azman.setX(200 );
                azman.setY(550);
                azmann.setBaslangicX(200);
                azmann.setBaslangicY(550);
                group.getChildren().add(azman);
                karakter1.En_Kisa_Yol(35,76);
                dumana_uzaklik1.setText("Azman Şirine Uzaklığı ="+(karakter1.getGidiş_yolu().size()-1));


            }


            if(isBasildimi())
            {
                Label SkorLabeli=new Label();
                SkorLabeli.setLayoutX(750);
                SkorLabeli.setLayoutY(50);
                Label SkorLabeli2= new Label();
                SkorLabeli2.setLayoutX(750);
                SkorLabeli2.setLayoutY(100);
                SkorLabeli2.setFont(new Font("Blue",35));
                oyuncu.setSkor(20);
                SkorLabeli2.setText(""+oyuncu.getSkor());



                SkorLabeli.setFont(new Font("Blue",45));
                SkorLabeli.setText("Puan Durumu");
                group.getChildren().add(SkorLabeli);

                group.getChildren().add(SkorLabeli2);


                String add="images (2).jpg";
                ImageView image=new ImageView(add);
                image.setX(350);
                image.setY(300);
                group.getChildren().add(image);

                group.getChildren().addAll(dumana_uzaklik,dumana_uzaklik1);

                for (int i = 1; i < karakter.getGidiş_yolu().size()-1; i++) {
                    Rectangle kare1=new Rectangle();
                    kare1.setHeight(50);
                    kare1.setWidth(50);
                    kare1.setFill(Color.rgb(0,0,255,0.3));
                    kare1.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][0]);
                    kare1.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][1]);
                    group.getChildren().add(kare1);
                    kareler.add(kare1);
                }
                for (int i = 1; i < karakter1.getGidiş_yolu().size()-1; i++) {
                    Rectangle kare1=new Rectangle();
                    kare1.setHeight(50);
                    kare1.setWidth(50);
                    kare1.setFill(Color.rgb(0,0,255,0.3));
                    kare1.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][0]);
                    kare1.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][1]);
                    group.getChildren().add(kare1);
                    kareler.add(kare1);
                }
                karakter.setGidiş_yolu();
                karakter1.setGidiş_yolu();

                scene.setOnKeyPressed(a -> {


                    if (a.getCode() == KeyCode.UP) {

                            if (matris[tuty - 1][tutx] != 0) {

                                setSıra(getSıra()+1);
                                setTuty(getTuty() - 1);
                                image.setY(image.getY() - 50);
                                durum = bul(image);


                                    if (image.getX() == azman.getX() && image.getY() == azman.getY()) {
                                        azman.setX(azmann.getBaslangicX());
                                        azman.setY(azmann.getBaslangicY());
                                        oyuncu.setSkor(oyuncu.getSkor() - 5);
                                        SkorLabeli2.setText("" + oyuncu.getSkor());
                                    }
                                    if (image.getX() == gargamel.getX() && image.getY() == gargamel.getY()) {
                                        gargamel.setX(gargamell.getBaslangicX());
                                        gargamel.setY(gargamell.getBaslangicY());
                                        oyuncu.setSkor(oyuncu.getSkor() - 15);
                                        SkorLabeli2.setText("" + oyuncu.getSkor());
                                    }


                                ArrayList<Integer> tut = new ArrayList<Integer>();

                                karakter.setGidiş_yolu();
                                karakter1.setGidiş_yolu();


                                if (finalList.size() == 1 && dusman1.getDusmanAdi().equals("Gargamel")) {
                                    int konumu = bul(gargamel);
                                    karakter.En_Kisa_Yol(durum, konumu);

                                } else if (finalList.size() == 1 && dusman1.getDusmanAdi().equals("Azman")) {
                                    int konumu = bul(azman);
                                    karakter1.En_Kisa_Yol(durum, konumu);
                                }
                                if (finalList.size() == 2) {
                                    int konumu = bul(gargamel);
                                    int konumu1 = bul(azman);
                                    karakter.En_Kisa_Yol(durum, konumu);
                                    karakter1.En_Kisa_Yol(durum, konumu1);
                                }
                                System.out.println(karakter.getGidiş_yolu());
                                System.out.println(karakter1.getGidiş_yolu());
                                for (int i = 0; i < kareler.size(); i++) {
                                    group.getChildren().remove(kareler.get(i));
                                }
                                if(getSıra()>=2) {
                                    for (int i = 3; i < karakter.getGidiş_yolu().size() - 1; i++) {
                                        Rectangle kare1 = new Rectangle();
                                        kare1.setHeight(50);
                                        kare1.setWidth(50);
                                        kare1.setFill(Color.rgb(0, 0, 255, 0.3));
                                        kare1.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][0]);
                                        kare1.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][1]);
                                        group.getChildren().add(kare1);
                                        kareler.add(kare1);
                                    }
                                    for (int i = 2; i < karakter1.getGidiş_yolu().size() - 1; i++) {
                                        Rectangle kare1 = new Rectangle();
                                        kare1.setHeight(50);
                                        kare1.setWidth(50);
                                        kare1.setFill(Color.rgb(0, 0, 255, 0.3));
                                        kare1.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][0]);
                                        kare1.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][1]);
                                        group.getChildren().add(kare1);
                                        kareler.add(kare1);
                                    }
                                }
                                if(getSıra()>=2)
                                {
                                    if (karakter.getGidiş_yolu().size() >= 2) {

                                        for (int i = 0; i < 2; i++) {
                                            gargamel.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i + 1)][0]);
                                            gargamel.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i + 1)][1]);
                                            if (image.getX() == gargamel.getX() && image.getY() == gargamel.getY()) {
                                                gargamel.setX(gargamell.getBaslangicX());
                                                gargamel.setY(gargamell.getBaslangicY());
                                                oyuncu.setSkor(oyuncu.getSkor() - 15);
                                                SkorLabeli2.setText("" + oyuncu.getSkor());
                                                break;
                                            }
                                            dumana_uzaklik.setText("Gargamelin Şirine uzaklıgı="+(karakter.getGidiş_yolu().size()-3));
                                        }
                                    }

                                    if (karakter1.getGidiş_yolu().size() != 0) {
                                        azman.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][0]);
                                        azman.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][1]);
                                        if (image.getX() == azman.getX() && image.getY() == azman.getY()) {
                                            azman.setX(azmann.getBaslangicX());
                                            azman.setY(azmann.getBaslangicY());
                                            oyuncu.setSkor(oyuncu.getSkor() - 5);
                                            SkorLabeli2.setText("" + oyuncu.getSkor());
                                        }
                                        dumana_uzaklik1.setText("Azman Şirine uzaklıgı="+(karakter1.getGidiş_yolu().size()-2));
                                    }
                                    setSıra(0);
                                }



                            }
                            if (image.getX() == mantar.getX() && image.getY() == mantar.getY() && mantar.isVisible()) {
                                mantar.setVisible(false);
                                oyuncu.setSkor(oyuncu.getSkor() + 50);
                                SkorLabeli2.setText("" + oyuncu.getSkor());

                            }
                            if (image.getX() == altinn1.getX() && image.getY() == altinn1.getY() && altinn1.isVisible()) {
                                altinn1.setVisible(false);
                                oyuncu.setSkor(oyuncu.getSkor() + 5);
                                SkorLabeli2.setText("" + oyuncu.getSkor());
                            }
                            if (image.getX() == altinn2.getX() && image.getY() == altinn2.getY() && altinn2.isVisible()) {
                                altinn2.setVisible(false);
                                oyuncu.setSkor(oyuncu.getSkor() + 5);
                                SkorLabeli2.setText("" + oyuncu.getSkor());
                            }
                            if (image.getX() == altinn3.getX() && image.getY() == altinn3.getY() && altinn3.isVisible()) {
                                altinn3.setVisible(false);
                                oyuncu.setSkor(oyuncu.getSkor() + 5);
                                SkorLabeli2.setText("" + oyuncu.getSkor());
                            }
                            if (image.getX() == altinn4.getX() && image.getY() == altinn4.getY() && altinn4.isVisible()) {
                                altinn4.setVisible(false);
                                oyuncu.setSkor(oyuncu.getSkor() + 5);
                                SkorLabeli2.setText("" + oyuncu.getSkor());
                            }
                            if (image.getX() == altinn5.getX() && image.getY() == altinn5.getY() && altinn5.isVisible()) {
                                altinn5.setVisible(false);
                                oyuncu.setSkor(oyuncu.getSkor() + 5);
                                SkorLabeli2.setText("" + oyuncu.getSkor());
                            }



                    }
                    if(a.getCode()==KeyCode.DOWN)
                    {



                        if(matris[tuty+1][tutx]!=0)
                        {
                            setSıra(getSıra()+1);
                            setTuty(getTuty()+1);
                            image.setY(image.getY()+50);
                            durum=bul(image);


                                if(image.getX()==azman.getX()&&image.getY()==azman.getY())
                                {
                                    azman.setX(azmann.getBaslangicX());
                                    azman.setY(azmann.getBaslangicY());
                                    oyuncu.setSkor(oyuncu.getSkor()-5);
                                    SkorLabeli2.setText(""+oyuncu.getSkor());
                                }
                                if(image.getX()==gargamel.getX()&&image.getY()==gargamel.getY())
                                {
                                    gargamel.setX(gargamell.getBaslangicX());
                                    gargamel.setY(gargamell.getBaslangicY());
                                    oyuncu.setSkor(oyuncu.getSkor()-15);
                                    SkorLabeli2.setText(""+oyuncu.getSkor());
                                }



                            ArrayList<Integer> tut=new ArrayList<Integer>();
                            karakter.setGidiş_yolu();
                            karakter1.setGidiş_yolu();

                            if(finalList.size()==1 && dusman1.getDusmanAdi().equals("Gargamel"))
                            {
                                int konumu=bul(gargamel);
                                karakter.En_Kisa_Yol(durum,konumu);

                            }
                            else if(finalList.size()==1 && dusman1.getDusmanAdi().equals("Azman"))
                            {
                                int konumu=bul(azman);
                                karakter1.En_Kisa_Yol(durum,konumu);
                            }
                            if(finalList.size()==2)
                            {
                                int konumu=bul(gargamel);
                                int konumu1=bul(azman);
                                karakter.En_Kisa_Yol(durum,konumu);
                                karakter1.En_Kisa_Yol(durum,konumu1);
                            }
                            System.out.println(karakter.getGidiş_yolu());
                            System.out.println(karakter1.getGidiş_yolu());
                            for (int i = 0; i < kareler.size(); i++) {
                                group.getChildren().remove(kareler.get(i));
                            }
                            if(getSıra()>=2) {


                                for (int i = 3; i < karakter.getGidiş_yolu().size() - 1; i++) {
                                    Rectangle kare1 = new Rectangle();
                                    kare1.setHeight(50);
                                    kare1.setWidth(50);
                                    kare1.setFill(Color.rgb(0, 0, 255, 0.3));
                                    kare1.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][0]);
                                    kare1.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][1]);
                                    group.getChildren().add(kare1);
                                    kareler.add(kare1);
                                }
                                for (int i = 2; i < karakter1.getGidiş_yolu().size() - 1; i++) {
                                    Rectangle kare1 = new Rectangle();
                                    kare1.setHeight(50);
                                    kare1.setWidth(50);
                                    kare1.setFill(Color.rgb(0, 0, 255, 0.3));
                                    kare1.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][0]);
                                    kare1.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][1]);
                                    group.getChildren().add(kare1);
                                    kareler.add(kare1);
                                }
                            }
                            if (getSıra()>=2) {

                                if(karakter.getGidiş_yolu().size()>=2)
                                {
                                    for (int i = 0; i < 2; i++) {
                                        gargamel.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i+1)][0]);
                                        gargamel.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i+1)][1]);
                                        if (image.getX()==gargamel.getX()&&image.getY()==gargamel.getY())
                                        {
                                            gargamel.setX(gargamell.getBaslangicX());
                                            gargamel.setY(gargamell.getBaslangicY());
                                            oyuncu.setSkor(oyuncu.getSkor()-15);
                                            SkorLabeli2.setText(""+oyuncu.getSkor());
                                            break;
                                        }
                                        dumana_uzaklik.setText("Gargamelin Şirine uzaklıgı="+(karakter.getGidiş_yolu().size()-3));
                                    }
                                }

                                if(karakter1.getGidiş_yolu().size()!=0)
                                {
                                    azman.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][0]);
                                    azman.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][1]);
                                    if (image.getX()==azman.getX()&&image.getY()==azman.getY())
                                    {
                                        azman.setX(azmann.getBaslangicX());
                                        azman.setY(azmann.getBaslangicY());
                                        oyuncu.setSkor(oyuncu.getSkor()-5);
                                        SkorLabeli2.setText(""+oyuncu.getSkor());
                                    }
                                    dumana_uzaklik1.setText("Azman Şirine uzaklıgı="+(karakter1.getGidiş_yolu().size()-2));
                                }
                                setSıra(0);
                            }


                        }
                        if(image.getX()==mantar.getX()&&image.getY()==mantar.getY()&&mantar.isVisible())
                        {
                            mantar.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+50);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn1.getX()&&image.getY()==altinn1.getY()&&altinn1.isVisible())
                        {
                            altinn1.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn2.getX()&&image.getY()==altinn2.getY()&&altinn2.isVisible())
                        {
                            altinn2.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn3.getX()&&image.getY()==altinn3.getY()&&altinn3.isVisible())
                        {
                            altinn3.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn4.getX()&&image.getY()==altinn4.getY()&&altinn4.isVisible())
                        {
                            altinn4.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }
                        if(image.getX()==altinn5.getX()&&image.getY()==altinn5.getY()&&altinn5.isVisible())
                        {
                            altinn5.setVisible(false);
                            oyuncu.setSkor(oyuncu.getSkor()+5);
                            SkorLabeli2.setText(""+oyuncu.getSkor());
                        }

                    }
                    if(a.getCode()==KeyCode.RIGHT)
                    {



                                if (matris[tuty][tutx + 1] != 0) {
                                    setSıra(getSıra()+1);
                                    setTutx(getTutx() + 1);
                                    image.setX(image.getX() + 50);
                                    durum = bul(image);


                                        if (image.getX() == azman.getX() && image.getY() == azman.getY()) {
                                            azman.setX(azmann.getBaslangicX());
                                            azman.setY(azmann.getBaslangicY());
                                            oyuncu.setSkor(oyuncu.getSkor() - 5);
                                            SkorLabeli2.setText("" + oyuncu.getSkor());
                                        }
                                        if (image.getX() == gargamel.getX() && image.getY() == gargamel.getY()) {
                                            gargamel.setX(gargamell.getBaslangicX());
                                            gargamel.setY(gargamell.getBaslangicY());
                                            oyuncu.setSkor(oyuncu.getSkor() - 15);
                                            SkorLabeli2.setText("" + oyuncu.getSkor());
                                        }


                                    ArrayList<Integer> tut = new ArrayList<Integer>();
                                    karakter.setGidiş_yolu();
                                    karakter1.setGidiş_yolu();

                                    if (finalList.size() == 1 && dusman1.getDusmanAdi().equals("Gargamel")) {
                                        int konumu = bul(gargamel);
                                        karakter.En_Kisa_Yol(durum, konumu);

                                    } else if (finalList.size() == 1 && dusman1.getDusmanAdi().equals("Azman")) {
                                        int konumu = bul(azman);
                                        karakter1.En_Kisa_Yol(durum, konumu);
                                    }
                                    if (finalList.size() == 2) {
                                        int konumu = bul(gargamel);
                                        int konumu1 = bul(azman);
                                        karakter.En_Kisa_Yol(durum, konumu);
                                        karakter1.En_Kisa_Yol(durum, konumu1);
                                    }
                                    System.out.println(karakter.getGidiş_yolu());
                                    System.out.println(karakter1.getGidiş_yolu());
                                    for (int i = 0; i < kareler.size(); i++) {
                                        group.getChildren().remove(kareler.get(i));
                                    }
                                    if(getSıra()>=2) {
                                        for (int i = 3; i < karakter.getGidiş_yolu().size() - 1; i++) {
                                            Rectangle kare1 = new Rectangle();
                                            kare1.setHeight(50);
                                            kare1.setWidth(50);
                                            kare1.setFill(Color.rgb(0, 0, 255, 0.3));
                                            kare1.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][0]);
                                            kare1.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][1]);
                                            group.getChildren().add(kare1);
                                            kareler.add(kare1);
                                        }
                                        for (int i = 2; i < karakter1.getGidiş_yolu().size() - 1; i++) {
                                            Rectangle kare1 = new Rectangle();
                                            kare1.setHeight(50);
                                            kare1.setWidth(50);
                                            kare1.setFill(Color.rgb(0, 0, 255, 0.3));
                                            kare1.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][0]);
                                            kare1.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][1]);
                                            group.getChildren().add(kare1);
                                            kareler.add(kare1);
                                        }
                                    }
                                    if(getSıra()>=2) {
                                        if (karakter.getGidiş_yolu().size() >= 2) {
                                            for (int i = 0; i < 2; i++) {
                                                gargamel.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i + 1)][0]);
                                                gargamel.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i + 1)][1]);
                                                if (image.getX() == gargamel.getX() && image.getY() == gargamel.getY()) {
                                                    gargamel.setX(gargamell.getBaslangicX());
                                                    gargamel.setY(gargamell.getBaslangicY());
                                                    oyuncu.setSkor(oyuncu.getSkor() - 15);
                                                    SkorLabeli2.setText("" + oyuncu.getSkor());
                                                    break;
                                                }
                                                dumana_uzaklik.setText("Gargamelin Şirine uzaklıgı="+(karakter.getGidiş_yolu().size()-3));
                                            }
                                        }

                                        if (karakter1.getGidiş_yolu().size() != 0) {
                                            azman.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][0]);
                                            azman.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][1]);
                                            if (image.getX() == azman.getX() && image.getY() == azman.getY()) {
                                                azman.setX(azmann.getBaslangicX());
                                                azman.setY(azmann.getBaslangicY());
                                                oyuncu.setSkor(oyuncu.getSkor() - 5);
                                                SkorLabeli2.setText("" + oyuncu.getSkor());
                                            }
                                            dumana_uzaklik1.setText("Azman Şirine uzaklıgı="+(karakter1.getGidiş_yolu().size()-2));
                                        }
                                        setSıra(0);
                                    }
                                }
                                if (image.getX() == mantar.getX() && image.getY() == mantar.getY() && mantar.isVisible()) {

                                    mantar.setVisible(false);
                                    oyuncu.setSkor(oyuncu.getSkor() + 50);
                                    SkorLabeli2.setText("" + oyuncu.getSkor());
                                }
                                if (image.getX() == altinn1.getX() && image.getY() == altinn1.getY() && altinn1.isVisible()) {
                                    altinn1.setVisible(false);
                                    oyuncu.setSkor(oyuncu.getSkor() + 5);
                                    SkorLabeli2.setText("" + oyuncu.getSkor());
                                }
                                if (image.getX() == altinn2.getX() && image.getY() == altinn2.getY() && altinn2.isVisible()) {
                                    altinn2.setVisible(false);
                                    oyuncu.setSkor(oyuncu.getSkor() + 5);
                                    SkorLabeli2.setText("" + oyuncu.getSkor());
                                }
                                if (image.getX() == altinn3.getX() && image.getY() == altinn3.getY() && altinn3.isVisible()) {
                                    altinn3.setVisible(false);
                                    oyuncu.setSkor(oyuncu.getSkor() + 5);
                                    SkorLabeli2.setText("" + oyuncu.getSkor());
                                }
                                if (image.getX() == altinn4.getX() && image.getY() == altinn4.getY() && altinn4.isVisible()) {
                                    altinn4.setVisible(false);
                                    oyuncu.setSkor(oyuncu.getSkor() + 5);
                                    SkorLabeli2.setText("" + oyuncu.getSkor());
                                }
                                if (image.getX() == altinn5.getX() && image.getY() == altinn5.getY() && altinn5.isVisible()) {
                                    altinn5.setVisible(false);
                                    oyuncu.setSkor(oyuncu.getSkor() + 5);
                                    SkorLabeli2.setText("" + oyuncu.getSkor());
                                }

                    }
                    if(a.getCode()==KeyCode.LEFT)
                    {



                            if (matris[tuty][tutx - 1] != 0) {
                                setSıra(getSıra()+1);
                                setTutx(getTutx() - 1);
                                image.setX(image.getX() - 50);
                                durum = bul(image);


                                    if (image.getX() == azman.getX() && image.getY() == azman.getY()) {
                                        azman.setX(azmann.getBaslangicX());
                                        azman.setY(azmann.getBaslangicY());
                                        oyuncu.setSkor(oyuncu.getSkor() - 5);
                                        SkorLabeli2.setText("" + oyuncu.getSkor());
                                    }
                                    if (image.getX() == gargamel.getX() && image.getY() == gargamel.getY()) {
                                        gargamel.setX(gargamell.getBaslangicX());
                                        gargamel.setY(gargamell.getBaslangicY());
                                        oyuncu.setSkor(oyuncu.getSkor() - 15);
                                        SkorLabeli2.setText("" + oyuncu.getSkor());
                                    }


                                ArrayList<Integer> tut = new ArrayList<Integer>();
                                karakter.setGidiş_yolu();
                                karakter1.setGidiş_yolu();

                                if (finalList.size() == 1 && dusman1.getDusmanAdi().equals("Gargamel")) {
                                    int konumu = bul(gargamel);
                                    karakter.En_Kisa_Yol(durum, konumu);

                                } else if (finalList.size() == 1 && dusman1.getDusmanAdi().equals("Azman")) {
                                    int konumu = bul(azman);
                                    karakter1.En_Kisa_Yol(durum, konumu);
                                }
                                if (finalList.size() == 2) {
                                    int konumu = bul(gargamel);
                                    int konumu1 = bul(azman);
                                    karakter.En_Kisa_Yol(durum, konumu);
                                    karakter1.En_Kisa_Yol(durum, konumu1);
                                }
                                System.out.println(karakter.getGidiş_yolu());
                                System.out.println(karakter1.getGidiş_yolu());
                                for (int i = 0; i < kareler.size(); i++) {
                                    group.getChildren().remove(kareler.get(i));
                                }
                                if(getSıra()>=2) {
                                    for (int i = 3; i < karakter.getGidiş_yolu().size() - 1; i++) {
                                        Rectangle kare1 = new Rectangle();
                                        kare1.setHeight(50);
                                        kare1.setWidth(50);
                                        kare1.setFill(Color.rgb(0, 0, 255, 0.3));
                                        kare1.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][0]);
                                        kare1.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i)][1]);
                                        group.getChildren().add(kare1);
                                        kareler.add(kare1);
                                    }
                                    for (int i = 2; i < karakter1.getGidiş_yolu().size() - 1; i++) {
                                        Rectangle kare1 = new Rectangle();
                                        kare1.setHeight(50);
                                        kare1.setWidth(50);
                                        kare1.setFill(Color.rgb(0, 0, 255, 0.3));
                                        kare1.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][0]);
                                        kare1.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(i)][1]);
                                        group.getChildren().add(kare1);
                                        kareler.add(kare1);
                                    }
                                }
                                if(getSıra()>=2) {
                                    if (karakter.getGidiş_yolu().size() >= 2) {
                                        for (int i = 0; i < 2; i++) {
                                            gargamel.setX(obje1.getMatris()[karakter.getGidiş_yolu().get(i + 1)][0]);
                                            gargamel.setY(obje1.getMatris()[karakter.getGidiş_yolu().get(i + 1)][1]);
                                            if (image.getX() == gargamel.getX() && image.getY() == gargamel.getY()) {
                                                gargamel.setX(gargamell.getBaslangicX());
                                                gargamel.setY(gargamell.getBaslangicY());
                                                oyuncu.setSkor(oyuncu.getSkor() - 15);
                                                SkorLabeli2.setText("" + oyuncu.getSkor());
                                                break;
                                            }
                                            dumana_uzaklik.setText("Gargamelin Şirine uzaklıgı="+(karakter.getGidiş_yolu().size()-3));
                                        }
                                    }

                                    if (karakter1.getGidiş_yolu().size() != 0) {
                                        azman.setX(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][0]);
                                        azman.setY(obje1.getMatris()[karakter1.getGidiş_yolu().get(1)][1]);
                                        if (image.getX() == azman.getX() && image.getY() == azman.getY()) {
                                            azman.setX(azmann.getBaslangicX());
                                            azman.setY(azmann.getBaslangicY());
                                            oyuncu.setSkor(oyuncu.getSkor() - 5);
                                            SkorLabeli2.setText("" + oyuncu.getSkor());
                                        }
                                        dumana_uzaklik1.setText("Azman Şirine uzaklıgı="+(karakter1.getGidiş_yolu().size()-2));
                                    }
                                    setSıra(0);
                                }

                            }
                            if (image.getX() == mantar.getX() && image.getY() == mantar.getY() && mantar.isVisible()) {

                                mantar.setVisible(false);
                                oyuncu.setSkor(oyuncu.getSkor() + 50);
                                SkorLabeli2.setText("" + oyuncu.getSkor());

                            }
                            if (image.getX() == altinn1.getX() && image.getY() == altinn1.getY() && altinn1.isVisible()) {
                                altinn1.setVisible(false);
                                oyuncu.setSkor(oyuncu.getSkor() + 5);
                                SkorLabeli2.setText("" + oyuncu.getSkor());
                            }
                            if (image.getX() == altinn2.getX() && image.getY() == altinn2.getY() && altinn2.isVisible()) {
                                altinn2.setVisible(false);
                                oyuncu.setSkor(oyuncu.getSkor() + 5);
                                SkorLabeli2.setText("" + oyuncu.getSkor());
                            }
                            if (image.getX() == altinn3.getX() && image.getY() == altinn3.getY() && altinn3.isVisible()) {
                                altinn3.setVisible(false);
                                oyuncu.setSkor(oyuncu.getSkor() + 5);
                                SkorLabeli2.setText("" + oyuncu.getSkor());
                            }
                            if (image.getX() == altinn4.getX() && image.getY() == altinn4.getY() && altinn4.isVisible()) {
                                altinn4.setVisible(false);
                                oyuncu.setSkor(oyuncu.getSkor() + 5);
                                SkorLabeli2.setText("" + oyuncu.getSkor());
                            }
                            if (image.getX() == altinn5.getX() && image.getY() == altinn5.getY() && altinn5.isVisible()) {
                                altinn5.setVisible(false);
                                oyuncu.setSkor(oyuncu.getSkor() + 5);
                                SkorLabeli2.setText("" + oyuncu.getSkor());
                            }

                    }
                    if(oyuncu.getSkor()<=0)
                    {
                        Puan puan1 = new Puan();
                        Label label1 = new Label("Skorunuz="+puan1.PuaniGoster());
                        label1.setLayoutX(170);
                        label1.setLayoutY(200);
                        label1.setFont(new Font("Arial", 30));
                        group1.getChildren().add(label1);
                        stage.setScene(scene1);
                        stage.show();
                    }
                    if(image.getX()==650&&image.getY()==400)
                    {
                        Puan puan1 = new Puan();
                        Label label1 = new Label("Skorunuz="+puan1.PuaniGoster());
                        label1.setLayoutX(170);
                        label1.setLayoutY(200);
                        label1.setFont(new Font("Arial", 30));
                        group1.getChildren().add(label1);
                        stage.setScene(scene1);
                        stage.show();
                    }

                });



                Timer mytimer= new Timer();

                TimerTask timerTask =new TimerTask() {


                    @Override
                    public void run() {
                        setAltın1(random.nextInt(73));
                        setAltın2(random.nextInt(73));
                        setAltın3(random.nextInt(73));
                        setAltın4(random.nextInt(73));
                        setAltın5(random.nextInt(73));

                        if(ti%2==1)
                        {
                            altinn1.setVisible(false);
                            altinn2.setVisible(false);
                            altinn3.setVisible(false);
                            altinn4.setVisible(false);
                            altinn5.setVisible(false);
                        }
                        else
                        {
                            altinn1.setVisible(true);
                            altinn1.setX(obje1.getMatris()[altın1][0]);
                            altinn1.setY(obje1.getMatris()[altın1][1]);
                            if(image.getX()==altinn1.getX()&&image.getY()==altinn1.getY())
                            {
                                altinn1.setVisible(false);


                            }
                            altinn2.setVisible(true);
                            altinn2.setX(obje1.getMatris()[altın2][0]);
                            altinn2.setY(obje1.getMatris()[altın2][1]);
                            if(image.getX()==altinn2.getX()&&image.getY()==altinn2.getY())
                            {
                                altinn2.setVisible(false);

                            }
                            altinn3.setVisible(true);
                            altinn3.setX(obje1.getMatris()[altın3][0]);
                            altinn3.setY(obje1.getMatris()[altın3][1]);
                            if(image.getX()==altinn3.getX()&&image.getY()==altinn3.getY())
                            {
                                altinn3.setVisible(false);


                            }
                            altinn4.setVisible(true);
                            altinn4.setX(obje1.getMatris()[altın4][0]);
                            altinn4.setY(obje1.getMatris()[altın4][1]);
                            if(image.getX()==altinn4.getX()&&image.getY()==altinn4.getY())
                            {
                                altinn4.setVisible(false);


                            }
                            altinn5.setVisible(true);
                            altinn5.setX(obje1.getMatris()[altın5][0]);
                            altinn5.setY(obje1.getMatris()[altın5][1]);
                            if(image.getX()==altinn5.getX()&&image.getY()==altinn5.getY())
                            {
                                altinn5.setVisible(false);


                            }

                        }
                        ti++;
                        if(image.getX()==650&&image.getY()==400)
                        {
                            mytimer.cancel();
                        }
                    }
                };
                mytimer.schedule(timerTask,0,6000);

                TimerTask timerTask1 = new TimerTask() {
                    @Override
                    public void run() {
                        setMantar1(random.nextInt(73));
                        if(t%2==1)
                        {
                            mantar.setVisible(false);
                        }
                        else
                        {

                            mantar.setVisible(true);
                            mantar.setX(obje1.getMatris()[mantar1][0]);
                            mantar.setY(obje1.getMatris()[mantar1][1]);
                            if(image.getX()==mantar.getX()&&image.getY()==mantar.getY())
                            {
                                mantar.setVisible(false);


                            }

                        }
                        t++;
                        if(image.getX()==650&&image.getY()==400)
                        {
                            mytimer.cancel();
                        }
                    }
                };
                mytimer.schedule(timerTask1,0,8000);

            }

        });

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String args[])
    {
        launch(args);
    }
}
