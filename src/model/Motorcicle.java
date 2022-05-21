package model;
import java.util.Calendar;

public class Motorcicle extends Vehicle{
    
    //Enum
    private String typeMotorcicle;
    private String typeGasoline; 
    private double consumeGasoline;

    public Motorcicle(String brand, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, TecnoMecanica tecnoMecanica, Soat soat, PropertyCard propertyCard,String typeMotorcicle, String typeGasoline, double consumeGasoline) {
        super(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat, propertyCard);
        this.typeMotorcicle = typeMotorcicle;
        this.typeGasoline = typeGasoline;
        this.consumeGasoline = fuelConsuption();
    }

    /**
     * Fuel consumption of the vehicle
     */
    @Override
    public double fuelConsuption() {
        double out = -1;
        out = (super.getDisplacement()/75);

        return out;
    }

    
    @Override
    public boolean activeTecno() {
        boolean out = false;
        int year = Calendar.getInstance().get(Calendar.YEAR);

        if(super.getTecnoMecanica().getYear()==year){
            out = true;
        }

        return out;
    }

    @Override
    public boolean activeSoat() {
        boolean out = false;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        
        if(super.getSoat().getYear()==year){
            out = true;
        }

        return out;
    }

    public String getTypeGasoline(){
        return typeGasoline;
    }

    public String getTypeMotorCicle(){
        return typeMotorcicle;
    }

    public double getConsumeGasoline(){
        return consumeGasoline;
    }

    public String toString(){

        String out = "";

        if(super.getPlate().equals("000000")){
            //Es nuevo
            out = "Gasoline: "+getTypeGasoline()+"\n"+getTypeMotorCicle()+"\n"+super.getBrand()+"\nModel: "+super.getModel()+"\nBase price: "+super.getBasePrice()+"\nSell price: "+super.getSellPrice()+"\nState: New\n\n";
        } else {
            out = "Gasoline: "+getTypeGasoline()+"\n"+getTypeMotorCicle()+"\n"+super.getBrand()+"\nModel: "+super.getModel()+"\nBase price: "+super.getBasePrice()+"\nSell price: "+super.getSellPrice()+"\nState: Used\n\n";
        }

        return out;
    }
}
