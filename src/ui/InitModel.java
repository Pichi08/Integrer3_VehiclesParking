package ui;

import java.util.ArrayList;

import model.*;

public class InitModel {
    
    public InitModel() {}

    public ArrayList<Vehicle> createVehicles(){

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        TecnoMecanica tecnoMecanica = new TecnoMecanica("",-1, 2022, -1);
        Soat soat = new Soat("",-1, 2022, -1);
        PropertyCard propertyCard = new PropertyCard("",-1, -1);
        vehicles.add(new Gasoline("Ferrari","A00",100000, -1, 2001, 300, "0", false, "000000", tecnoMecanica, soat, propertyCard, true, 2, true, 80, "extra", 8));
        

        TecnoMecanica a = new TecnoMecanica("",-1, 2022, -1);
        Soat b = new Soat("",-1, 2022, -1);
        PropertyCard c = new PropertyCard("",-1, -1);
        vehicles.add(new Gasoline("Ferrari","A01",100000, -1, 2014, 300, "0", false, "000000", a, b, c, true, 2, true, 80, "extra", 8));

        TecnoMecanica aa = new TecnoMecanica("",-1, 2022, -1);
        Soat bb= new Soat("",-1, 2022, -1);
        PropertyCard cc = new PropertyCard("",-1, -1);
        vehicles.add(new Gasoline("Ferrari","A02",100000, -1, 2009, 300, "0", false, "000000", aa, bb, cc, true, 2, true, 80, "extra", 8));

        TecnoMecanica aaa = new TecnoMecanica("",-1, 2022, -1);
        Soat bbb = new Soat("",-1, 2022, -1);
        PropertyCard ccc = new PropertyCard("",-1, -1);
        vehicles.add(new Gasoline("Ferrari","A03",100000, -1, 2011, 300, "0", false, "000000", aaa, bbb, ccc, true, 2, true, 80, "extra", 8));

        TecnoMecanica aaaa = new TecnoMecanica("",-1, 2022, -1);
        Soat bbbb = new Soat("",-1, 2022, -1);
        PropertyCard cccc = new PropertyCard("",-1, -1);
        vehicles.add(new Gasoline("Ferrari","A04",100000, -1, 2000, 300, "0", false, "000000", aaaa, bbbb, cccc, true, 2, true, 80, "extra", 8));

        return vehicles;

    }
}
