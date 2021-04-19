package sample;

import javafx.scene.control.Label;

public class Puan extends Oyuncu{


    public Puan(int Skor) {
        super(Skor);
    }

    public Puan() {
    }

    @Override
    public int  PuaniGoster() {

        return getSkor();

    }
}
