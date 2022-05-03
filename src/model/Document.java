package model;

public abstract class Document {

    private double price;
    private int year;
    //anadir la imgagen que eso es todo raro y aun no se como se hace

    public Document(double price, int year) {
        this.price = price;
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

}
