package sample;

public class Gozluklu_Sirin extends Oyuncu{
    private String isim;

    public Gozluklu_Sirin(String isim) {
        this.isim = isim;
    }

    public Gozluklu_Sirin(String oyuncuAdi, String isim) {
        super(oyuncuAdi);
        this.isim = isim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }


}
