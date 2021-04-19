package sample;

import java.util.ArrayList;

public class Karakter {
    private int ID;
    private String Ad;
    private String Tur;
    private int[] koordinatlar=new int[2];
    static final int V = 77;
    private ArrayList<Integer> gidiş_yolu=new ArrayList<Integer>();


    public ArrayList<Integer> getGidiş_yolu() {
        return gidiş_yolu;
    }

    public void setGidiş_yolu() {
        this.gidiş_yolu.removeAll(gidiş_yolu);
    }

    public Karakter() {
    }

    public Karakter(int ID, String ad, String tur, int[] koordinatlar) {
        this.ID = ID;
        Ad = ad;
        Tur = tur;
        this.koordinatlar = koordinatlar;
    }
    int minimumbrim(int dizi1[], Boolean dorumu[])
    {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (dorumu[v] == false && dizi1[v] <= min) {
                min = dizi1[v];
                min_index = v;
            }

        return min_index;
    }


    void dijkstra(int graf[][], int src,int x)
    {
        int dizi[] = new int[V];

        int list[][]=new int[77][1];
        int list7[]=new int [77];

        int asd=1;

        Boolean dorumu[] = new Boolean[V];


        for (int i = 0; i < V; i++) {
            dizi[i] = Integer.MAX_VALUE;
            dorumu[i] = false;
        }


        dizi[src] = 0;


        for (int count = 0; count < V - 1; count++) {

            int u = minimumbrim(dizi, dorumu);


            dorumu[u] = true;


            for (int v= 0; v < V; v++){

                if (!dorumu[v] && graf[u][v] != 0 && dizi[u] != Integer.MAX_VALUE && dizi[u] + graf[u][v] < dizi[v]){
                    dizi[v] = dizi[u] + graf[u][v];
                    list[v][0]=u;
                }
            }
        }



        int z=x;
        gidiş_yolu.add(z);

        while (true)
        {
            z=list[z][0];
            gidiş_yolu.add(z);
            if(z==src)
            {
                break;
            }

        }


    }

    public void En_Kisa_Yol(int biz,int dusman)
    {
        En_Kisa_Yol en_kisa_yol = new En_Kisa_Yol();

            dijkstra(en_kisa_yol.getKisa_yol(),biz,dusman);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getTur() {
        return Tur;
    }

    public void setTur(String tur) {
        Tur = tur;
    }

    public int[] getKoordinatlar() {
        return koordinatlar;
    }

    public void setKoordinatlar(int[] koordinatlar) {
        this.koordinatlar = koordinatlar;
    }
}
