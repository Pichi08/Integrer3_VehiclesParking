package model;

public abstract class Automobile extends Vehicle{

    //Enum
    private Boolean typeCar;
    private int numberDoors;
    //Enum
    private Boolean polorizeWindows;

    public Automobile(String brand, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, TecnoMecanica tecnoMecanica, Soat soat, Boolean typeCar, int numberDoors, Boolean polorizeWindows) {
        super(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat);
        this.typeCar = typeCar;
        this.numberDoors = numberDoors;
        this.polorizeWindows = polorizeWindows;
    }

    public String getTypeCar(){
        String out = "";
        if (typeCar==true){
            out = "Sedan";
        } else {
            out = "Truk";
        }
        return out;
    }

    public int getNumberDoors() {
        return numberDoors;
    }

    public Boolean isPolorizeWindows() {
        return polorizeWindows;
    }

}
