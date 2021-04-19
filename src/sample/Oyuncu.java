package sample;


public class Oyuncu extends Karakter {
    private int oyuncuID;
    private String oyuncuAdi;
    private String oyuncuTur;
    public static int Skor;

    public Oyuncu() {
    }
    public Oyuncu(int Skor)
    {
        this.Skor=Skor;
    }
    public Oyuncu(String oyuncuAdi){
        this.oyuncuAdi=oyuncuAdi;
    }

    public Oyuncu(int ID, String ad, String tur, int[] koordinatlar, int oyuncuID, String oyuncuAdi, String oyuncuTur, int skor) {
        super(ID, ad, tur, koordinatlar);
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuTur = oyuncuTur;
        Skor = skor;
    }

    public int  PuaniGoster()
    {
         return 0;
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public String getOyuncuTur() {
        return oyuncuTur;
    }

    public void setOyuncuTur(String oyuncuTur) {
        this.oyuncuTur = oyuncuTur;
    }

    public int getSkor() {
        return Skor;
    }

    public void setSkor(int skor) {
        Skor = skor;
    }
}



