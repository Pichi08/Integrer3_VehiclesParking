package model;
import java.util.ArrayList;


public class DealerShip {
    
    private ArrayList<Vehicle> vehicles;

    public DealerShip(){
        this.vehicles = new ArrayList<Vehicle>();
    }

    public DealerShip(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    public String addGasolineVehicle(String brand, boolean documents, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, double priceTecno, int yearTecno, double levelOfGases, double priceSoat, int yearSoat, double coberture, Boolean typeCar, int numberDoors, Boolean polorizeWindows, double tankCapacity, String typeGasoline, double consumeGasoline){

        String out = "";
        
        TecnoMecanica tecnoMecanica = new TecnoMecanica(priceTecno, yearTecno, levelOfGases);
        Soat soat = new Soat(priceSoat, yearSoat, coberture);
        vehicles.add(new Gasoline(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat, typeCar, numberDoors, polorizeWindows, tankCapacity, typeGasoline, consumeGasoline));

        out = "New gasoline vehicle added";

        calculateSellPrice(id, documents);

        return out;
    }

    public String addElectricVehicle(String brand, boolean documents, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, double priceTecno, int yearTecno, double levelOfGases, double priceSoat, int yearSoat, double coberture, Boolean typeCar, int numberDoors, Boolean polorizeWindows, boolean typeCharger, double durationBattery, double consumeBattery){
        
        String out = "";
        
        TecnoMecanica tecnoMecanica = new TecnoMecanica(priceTecno, yearTecno, levelOfGases);
        Soat soat = new Soat(priceSoat, yearSoat, coberture);
        vehicles.add(new Electric(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat, typeCar, numberDoors, polorizeWindows, typeCharger, durationBattery, consumeBattery));

        out = "New electric vehicle has been added";

        calculateSellPrice(id, documents);

        return out;
    }

    public String addHybridVehicle(String brand, boolean documents, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, double priceTecno, int yearTecno, double levelOfGases, double priceSoat, int yearSoat, double coberture, Boolean typeCar, int numberDoors, Boolean polorizeWindows, double tankCapacity, String typeGasoline, double consumeGasoline, boolean typeCharger, double durationBattery, double consumeBattery){

        String out = "";

        TecnoMecanica tecnoMecanica = new TecnoMecanica(priceTecno, yearTecno, levelOfGases);
        Soat soat = new Soat(priceSoat, yearSoat, coberture);
        vehicles.add(new Hybrid(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat, typeCar, numberDoors, polorizeWindows, tankCapacity, typeGasoline, consumeGasoline, typeCharger, durationBattery, consumeBattery));

        out = "New hybrid vehicle has been added";


        calculateSellPrice(id, documents);

        return out;
    }

    public String addMotorCicle(String brand, boolean documents, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, double priceTecno, int yearTecno, double levelOfGases, double priceSoat, int yearSoat, double coberture, String typeMotorcicle, String typeGasoline, double consumeGasoline){

        String out = "";

        TecnoMecanica tecnoMecanica = new TecnoMecanica(priceTecno, yearTecno, levelOfGases);
        Soat soat = new Soat(priceSoat, yearSoat, coberture);
        vehicles.add(new Motorcicle(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat, typeMotorcicle, typeGasoline, consumeGasoline));

        out = "New Motorcicle has been added";

        calculateSellPrice(id, documents);

        return out;
    }

    public void calculateSellPrice(String id, boolean documents){

        int documentation = 0;
        double total = 0;
        double base = 0;
        

        for(int i = 0; i<vehicles.size(); i++){
            if(vehicles.get(i).getId().equals(id)){

                base = vehicles.get(i).getBasePrice();

                if(documents==false){
                    documentation=500000;
                }
                if(vehicles.get(i) instanceof Electric){
                    total =0.2;
                }
                if(vehicles.get(i) instanceof Hybrid){
                   total = 0.15;
                }
                if(vehicles.get(i) instanceof Gasoline){
                    total = 0;
                }
                if(vehicles.get(i) instanceof Automobile && vehicles.get(i).getState()==false){
                    total += -0.1;
                }
                if(vehicles.get(i) instanceof Motorcicle && vehicles.get(i).getState()==false){
                    total += -0.02;
                }
                if(vehicles.get(i) instanceof Motorcicle){
                    total += 0.04; 
                }
                System.out.println(documentation);
                base = base+(base*total)+documentation;
                vehicles.get(i).setSellPrice(base);
            }
        }  
    }

    public String showTotalPrice(String id, double discount){

        String out = "Id didn't match any car";
        double newPrice = 0;

        for(int i = 0; i<vehicles.size(); i++){
            if(vehicles.get(i).getId().equals(id)){
                //BORRAR SOLO ES PARA LOS CASOS DE PRUEBA
                if(vehicles.get(i).getSellPrice()==-1){
        
                    int documentation = 0;
                    double total= 0;
                    double base = 0;


                    for(int e = 0; e<vehicles.size(); e++){
                        if(vehicles.get(e).getId().equals(id)){
                        
                            base = vehicles.get(e).getBasePrice();
                        
                            if(vehicles.get(e).getState()==true){
                                documentation=500000;
                            }
                            if(vehicles.get(e) instanceof Electric){
                                total =0.2;
                            }
                            if(vehicles.get(e) instanceof Hybrid){
                               total = 0.15;
                            }
                            if(vehicles.get(e) instanceof Gasoline){
                                total = 0;
                            }
                            if(vehicles.get(e) instanceof Automobile && vehicles.get(e).getState()==false){
                                total += 0.1;
                            }
                            if(vehicles.get(e) instanceof Motorcicle && vehicles.get(e).getState()==false){
                                total += 0.02;
                            }
                            if(vehicles.get(e) instanceof Motorcicle){
                                base = base+(base*0.04); 
                            }
                        
                            base = base+(base*total)+documentation;
                            vehicles.get(e).setSellPrice(base);
                        }
                    } 
                }
                //BORRAR HASTA
                if (discount!=0){
                    newPrice = vehicles.get(i).getSellPrice()-(vehicles.get(i).getSellPrice()*discount);
                    vehicles.get(i).setSellPrice(newPrice);
                    out = "The new price of the vehicle applying the discount is: "+vehicles.get(i).getSellPrice();
                } else {
                    out = "The total price of the vehicle with the id: "+id+", is: "+vehicles.get(i).getSellPrice();
                }
            }
        }

        return out;
    }

    public String reportDataVehicles(){
        
        String out = "";

        for(int i = 0; i<vehicles.size(); i++){
            //BORRAR SOLO ES PARA LOS CASOS DE PRUBE
            if(vehicles.get(i).getSellPrice()==-1){
        
                int documentation = 0;
                double total = 0;
                double base = 0;


                base = vehicles.get(i).getBasePrice();
                
                if(vehicles.get(i).getSoat().getPrice()==-1){
                    documentation=500000;
                }
                if(vehicles.get(i) instanceof Electric){
                    total =0.2;
                }
                if(vehicles.get(i) instanceof Hybrid){
                   total = 0.15;
                }
                if(vehicles.get(i) instanceof Gasoline){
                    total = 0;
                }
                if(vehicles.get(i) instanceof Automobile && vehicles.get(i).getState()==false){
                    total += -0.1;
                }
                if(vehicles.get(i) instanceof Motorcicle && vehicles.get(i).getState()==false){
                    total += -0.02;
                }
                if(vehicles.get(i) instanceof Motorcicle){
                    total += 0.04; 
                }
                System.out.println(documentation);
                base = base+(base*total)+documentation;
                vehicles.get(i).setSellPrice(base);
            } 
            //BORRAR HASTA AQUI

            out+=vehicles.get(i).toString();
        }

        return out;
    }




}
