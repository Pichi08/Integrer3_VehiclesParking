package model;

public class Soat extends Document {

    private double coberture;

    public Soat(double price, int year, double coberture) {
        super(price, year);
        this.coberture = coberture;
    }
    
}
