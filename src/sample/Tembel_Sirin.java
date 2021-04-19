package sample;

public class Tembel_Sirin extends Oyuncu{
    private String isim="Tembel Şirin";

    public Tembel_Sirin(String isim) {
        this.isim = isim;
    }

    public Tembel_Sirin(int ID, String ad, String tur, int[] koordinatlar, int oyuncuID, String oyuncuAdi, String oyuncuTur, int skor, String isim) {
        super(ID, ad, tur, koordinatlar, oyuncuID, oyuncuAdi, oyuncuTur, skor);
        this.isim = isim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}
