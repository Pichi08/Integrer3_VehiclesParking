package model;

public class Hybrid extends Automobile{
    
    private double tankCapacity;
    //Enum
    private String typeGasoline; 
    private double consumeGasoline;
    private boolean typeCharger;
    private double durationBattery;
    private double consumeBattery;

    public Hybrid(String brand, String id, double basePrice, double sellPrice, int model, int displacement, String km,
            boolean state, String plate, TecnoMecanica tecnoMecanica, Soat soat, Boolean typeCar, int numberDoors,
            Boolean polorizeWindows, double tankCapacity, String typeGasoline, double consumeGasoline, boolean typeCharger, double durationBattery, double consumeBattery) {
        super(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat, typeCar, numberDoors,
                polorizeWindows);
        this.tankCapacity = tankCapacity;
        this.typeGasoline = typeGasoline;
        this.consumeGasoline = consumeGasoline;
        this.typeCharger = typeCharger;
        this.durationBattery = durationBattery;
        this.consumeBattery = consumeBattery;
    }

    @Override
    public double fuelConsuption() {
        double out = -1;

        if(typeCharger=true){
            out = (durationBattery)*(super.getDisplacement()/200);
        } else{
            out = (durationBattery+7)*(super.getDisplacement()/200);
        }

        return out;
    }

    public String getTypeGasoline(){
        return typeGasoline;
    }

    public String getTypeCharger(){
        String out = "";
        if(typeCharger==true){
            out = "Fast";
        }else{
            out = "Normal";
        }
        return out;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public double getConsumeGasoline() {
        return consumeGasoline;
    }

    public double getDurationBattery() {
        return durationBattery;
    }

    public double getConsumeBattery() {
        return consumeBattery;
    }


    public String toString(){

        String out = "";

        if(super.getPlate().equals("000000")){
            //Es nuevo
            out = "Hybrid "+super.getTypeCar()+"\nType of charger: "+getTypeCharger()+" and type gasoline: "+getTypeGasoline()+"\n"+super.getBrand()+"\nModel: "+super.getModel()+"\nBase price: "+super.getBasePrice()+"\nSell price: "+super.getSellPrice()+"\nState: New\n\n";
        } else {
            out = "Hybrid "+super.getTypeCar()+"\nType of charger: "+getTypeCharger()+" and type gasoline: "+getTypeGasoline()+"\n"+super.getBrand()+"\nModel: "+super.getModel()+"\nBase price: "+super.getBasePrice()+"\nSell price: "+super.getSellPrice()+"\nState: Used\n\n";
        }

        return out;
    }

}
