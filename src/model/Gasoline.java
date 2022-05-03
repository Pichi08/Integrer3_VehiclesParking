package model;

public class Gasoline extends Automobile{
    
    private double tankCapacity;
    //Enum
    private String typeGasoline; 
    private double consumeGasoline;

    public Gasoline(String brand, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, TecnoMecanica tecnoMecanica, Soat soat, Boolean typeCar, int numberDoors, Boolean polorizeWindows, double tankCapacity, String typeGasoline, double consumeGasoline) {
        super(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat, typeCar, numberDoors, polorizeWindows);
        this.tankCapacity = tankCapacity;
        this.typeGasoline = typeGasoline;
        this.consumeGasoline = fuelConsuption();
    }

    @Override
    public double fuelConsuption() {
        double out = -1;
        out = (super.getDisplacement()/150);

        return out;
        
    }

    public double getTankCapacity(){
        return tankCapacity;
    }

    public double getConsumeGasoline(){
        return consumeGasoline;
    }

    public String getTypeGasoline(){
        return typeGasoline;
    }

    public String toString(){

        String out = "";

        if(super.getPlate().equals("000000")){
            //Es nuevo
            out = "Gasoline: "+getTypeGasoline()+"\n"+super.getTypeCar()+"\n"+super.getBrand()+"\nModel: "+super.getModel()+"\nBase price: "+super.getBasePrice()+"\nSell price: "+super.getSellPrice()+"\nState: New\n\n";
        } else {
            out = "Gasoline: "+getTypeGasoline()+"\n"+super.getTypeCar()+"\n"+super.getBrand()+"\nModel: "+super.getModel()+"\nBase price: "+super.getBasePrice()+"\nSell price: "+super.getSellPrice()+"\nState: Used\n\n";
        }

        return out;
    }

}
