package model;

public class TecnoMecanica extends Document{

    private double levelOfGases;

    public TecnoMecanica(double price, int year, double levelOfGases) {
        super(price, year);
        this.levelOfGases = levelOfGases;
    }

    
    
}
