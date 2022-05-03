package ui;

import java.util.ArrayList;

import model.*;

public class InitModel {
    
    public InitModel() {}

    public ArrayList<Vehicle> createVehicles(){

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        TecnoMecanica tecnoMecanica = new TecnoMecanica(-1, -1, -1);
        Soat soat = new Soat(-1, -1, -1);
        vehicles.add(new Gasoline("Ferrari","A00",100000, -1, 2022, 300, "0", true, "000000", tecnoMecanica, soat, true, 2, true, 80, "extra", 8));



        return vehicles;

    }
}
