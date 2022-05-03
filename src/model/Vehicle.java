package model;

public abstract class Vehicle {
    
    private String brand;
    private String id;
    private double basePrice;
    private double sellPrice;
    //Enum
    private int model;
    private int displacement;
    private String km;
    //Enum
    private boolean state;
    private String plate;
    
    private TecnoMecanica tecnoMecanica;
    private Soat soat;


    public Vehicle(String brand, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, TecnoMecanica tecnoMecanica, Soat soat) {
        this.brand = brand;
        this.id = id;
        this.basePrice = basePrice;
        this.sellPrice = sellPrice;
        this.model = model;
        this.displacement = displacement;
        this.km = km;
        this.state = state;
        this.plate = plate;
        this.tecnoMecanica = tecnoMecanica;
        this.soat = soat;
    }

    public abstract double fuelConsuption();

    public String getId(){
        return id;
    }

    public double getSellPrice(){
        return sellPrice;
    }

    public double getBasePrice(){
        return basePrice;
    }

    public int getDisplacement(){
        return displacement;
    }

    public boolean getState(){
        return state;
    }

    public void setSellPrice(double sellPrice){
        this.sellPrice = sellPrice;
    }

    public int getModel() {
        return model;
    }

    public String getKm() {
        return km;
    }

    public boolean isState() {
        return state;
    }

    public String getPlate() {
        return plate;
    }

    public TecnoMecanica getTecnoMecanica() {
        return tecnoMecanica;
    }

    public Soat getSoat() {
        return soat;
    }

    public String getBrand(){
        return brand;
    }

}
