package model;

public class Electric extends Automobile{

    
    //Enum
    private boolean typeCharger;
    private double durationBattery;
    private double consumeBattery;

    public Electric(String brand, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, TecnoMecanica tecnoMecanica, Soat soat, Boolean typeCar, int numberDoors, Boolean polorizeWindows, boolean typeCharger, double durationBattery, double consumeBattery) {
        super(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat, typeCar, numberDoors, polorizeWindows);
        this.typeCharger = typeCharger;
        this.durationBattery = durationBattery;
        this.consumeBattery = fuelConsuption();
    }

    @Override
    public double fuelConsuption() {
        double out = -1;

        if(typeCharger=true){
            out = (durationBattery+13)*(super.getDisplacement()/100);
        } else{
            out = (durationBattery+18)*(super.getDisplacement()/100);
        }

        return out;
        
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

    public double getConsumeBattery() {
        return consumeBattery;
    }

    public String toString(){

        String out = "";

        if(super.getPlate().equals("000000")){
            //Es nuevo
            out = "Elcetric "+super.getTypeCar()+"\nType of charger: "+getTypeCharger()+"\n"+super.getBrand()+"\nModel: "+super.getModel()+"\nBase price: "+super.getBasePrice()+"\nSell price: "+super.getSellPrice()+"\nState: New\n\n";
        } else {
            out = "Elcetric "+super.getTypeCar()+"\nType of charger: "+getTypeCharger()+"\n"+super.getBrand()+"\nModel: "+super.getModel()+"\nBase price: "+super.getBasePrice()+"\nSell price: "+super.getSellPrice()+"\nState: Used\n\n";
        }

        return out;
    }


}
