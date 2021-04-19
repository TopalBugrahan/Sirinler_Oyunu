package sample;


public class Dusman extends Karakter{
    private int dusmanID;
    private String dusmanAdi;
    private String dusmanTur;

    public Dusman() {

    }

    public Dusman(int ID, String ad, String tur, int[] koordinatlar, int dusmanID, String dusmanAdi, String dusmanTur) {
        super(ID, ad, tur, koordinatlar);
        this.dusmanID = dusmanID;
        this.dusmanAdi = dusmanAdi;
        this.dusmanTur = dusmanTur;

    }

    public int getDusmanID() {
        return dusmanID;
    }

    public void setDusmanID(int dusmanID) {
        this.dusmanID = dusmanID;
    }

    public String getDusmanAdi() {
        return dusmanAdi;
    }

    public void setDusmanAdi(String dusmanAdi) {
        this.dusmanAdi = dusmanAdi;
    }

    public String getDusmanTur() {
        return dusmanTur;
    }

    public void setDusmanTur(String dusmanTur) {
        this.dusmanTur = dusmanTur;
    }
}
