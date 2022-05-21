package model;
import java.util.ArrayList;


public class DealerShip {
    
    private Vehicle [][] parkVehicles;
    private ArrayList<Vehicle> vehicles;

    /**
     * Constructor
     */
    public DealerShip(){
        this.vehicles = new ArrayList<Vehicle>();
        this.parkVehicles = new Vehicle[10][5];
    }
    /**
     * 
     * @param vehicles ArrayList, of the vehicles register in the system
     */
    public DealerShip(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
        this.parkVehicles = new Vehicle[10][5];
    }
    /**
     * 
     * @param brand String, brand of the vehicle
     * @param documents boolean, true if vehicle has documents
     * @param id String, id of the vehicle
     * @param basePrice double, base price of the vehicle
     * @param sellPrice double, sell price of the vehicle
     * @param model int, year of the vehicle
     * @param displacement int, displacement of the vehicle (Cilindraje)
     * @param km String, total km that the vehicle has
     * @param state boolean, true if new
     * @param plate String, plate of the vehicle
     * @param priceTecno double, price of the tecnico-mecanica
     * @param yearTecno int, year of the tecnico-mecanica
     * @param levelOfGases double, level of gases of the vehicle
     * @param priceSoat double, price of the soat
     * @param yearSoat int, year of the SOAT
     * @param coberture double, coberture in case of accident SOAT
     * @param priceProperty double, price of the property card
     * @param yearProperty int, year of the property card
     * @param typeCar boolean, if true sedan if false truk
     * @param numberDoors int, number of doors that the vehicle has
     * @param polorizeWindows boolean, if true the vehicle has polorize windows
     * @param tankCapacity double, tank capacity
     * @param typeGasoline String, type gasoline
     * @param consumeGasoline int, consume gasoline
     * @return addGasolineVehicle String, message
     */
    public String addGasolineVehicle(String brand, boolean documents, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, double priceTecno, int yearTecno, double levelOfGases, double priceSoat, int yearSoat, double coberture, double priceProperty, int yearProperty, Boolean typeCar, int numberDoors, Boolean polorizeWindows, double tankCapacity, String typeGasoline, double consumeGasoline){

        String out = "";
        String numberDocument = "empty";
        TecnoMecanica tecnoMecanica = new TecnoMecanica(numberDocument, priceTecno, yearTecno, levelOfGases);
        Soat soat = new Soat(numberDocument, priceSoat, yearSoat, coberture);
        PropertyCard propertyCard = new PropertyCard(numberDocument, priceProperty, yearProperty);
        vehicles.add(new Gasoline(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat, propertyCard, typeCar, numberDoors, polorizeWindows, tankCapacity, typeGasoline, consumeGasoline));

        out = "New gasoline vehicle added";

        calculateSellPrice(id);

        return out;
    }
    /**
     * 
     * @param brand String, brand of the vehicle
     * @param documents boolean, true if vehicle has documents
     * @param id String, id of the vehicle
     * @param basePrice double, base price of the vehicle
     * @param sellPrice double, sell price of the vehicle
     * @param model int, year of the vehicle
     * @param displacement int, displacement of the vehicle (Cilindraje)
     * @param km String, total km that the vehicle has
     * @param state boolean, true if new
     * @param plate String, plate of the vehicle
     * @param priceTecno double, price of the tecnico-mecanica
     * @param yearTecno int, year of the tecnico-mecanica
     * @param levelOfGases double, level of gases of the vehicle
     * @param priceSoat double, price of the soat
     * @param yearSoat int, year of the SOAT
     * @param coberture double, coberture in case of accident SOAT
     * @param priceProperty double, price of the property card
     * @param yearProperty int, year of the property card
     * @param typeCar boolean, if true sedan if false truk
     * @param numberDoors int, number of doors that the vehicle has
     * @param polorizeWindows boolean, if true the vehicle has polorize windows
     * @param typeCharger boolean, if true fast if false normal charger
     * @param durationBattery double, duration of the battery in hours
     * @param consumeBattery double, consumption of the battery
     * @return addElectricVehicle, message
     */
    public String addElectricVehicle(String brand, boolean documents, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, double priceTecno, int yearTecno, double levelOfGases, double priceSoat, int yearSoat, double coberture, double priceProperty, int yearProperty, Boolean typeCar, int numberDoors, Boolean polorizeWindows, boolean typeCharger, double durationBattery, double consumeBattery){
        
        String out = "";
        String numberDocument = "empty";
        TecnoMecanica tecnoMecanica = new TecnoMecanica(numberDocument, priceTecno, yearTecno, levelOfGases);
        Soat soat = new Soat(numberDocument, priceSoat, yearSoat, coberture);
        PropertyCard propertyCard = new PropertyCard(numberDocument, priceProperty, yearProperty);
        vehicles.add(new Electric(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat, propertyCard, typeCar, numberDoors, polorizeWindows, typeCharger, durationBattery, consumeBattery));

        out = "New electric vehicle has been added";

        calculateSellPrice(id);

        return out;
    }
    /**
     * 
     * @param brand String, brand of the vehicle
     * @param documents boolean, true if vehicle has documents
     * @param id String, id of the vehicle
     * @param basePrice double, base price of the vehicle
     * @param sellPrice double, sell price of the vehicle
     * @param model int, year of the vehicle
     * @param displacement int, displacement of the vehicle (Cilindraje)
     * @param km String, total km that the vehicle has
     * @param state boolean, true if new
     * @param plate String, plate of the vehicle
     * @param priceTecno double, price of the tecnico-mecanica
     * @param yearTecno int, year of the tecnico-mecanica
     * @param levelOfGases double, level of gases of the vehicle
     * @param priceSoat double, price of the soat
     * @param yearSoat int, year of the SOAT
     * @param coberture double, coberture in case of accident SOAT
     * @param priceProperty double, price of the property card
     * @param yearProperty int, year of the property card
     * @param typeCar boolean, if true sedan if false truk
     * @param numberDoors int, number of doors that the vehicle has
     * @param polorizeWindows boolean, if true the vehicle has polorize windows
     * @param typeCar boolean, if true sedan if false truk
     * @param numberDoors int, number of doors that the vehicle has
     * @param polorizeWindows boolean, if true the vehicle has polorize windows
     * @param typeCharger boolean, if true fast if false normal charger
     * @param durationBattery double, duration of the battery in hours
     * @param consumeBattery double, consumption of the battery
     * @return addHybridVehicle String, message
     */
    public String addHybridVehicle(String brand, boolean documents, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, double priceTecno, int yearTecno, double levelOfGases, double priceSoat, int yearSoat, double coberture, double priceProperty, int yearProperty,  Boolean typeCar, int numberDoors, Boolean polorizeWindows, double tankCapacity, String typeGasoline, double consumeGasoline, boolean typeCharger, double durationBattery, double consumeBattery){

        String out = "";
        String numberDocument = "empty";
        TecnoMecanica tecnoMecanica = new TecnoMecanica(numberDocument, priceTecno, yearTecno, levelOfGases);
        Soat soat = new Soat(numberDocument, priceSoat, yearSoat, coberture);
        PropertyCard propertyCard = new PropertyCard(numberDocument, priceProperty, yearProperty);
        vehicles.add(new Hybrid(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat, propertyCard, typeCar, numberDoors, polorizeWindows, tankCapacity, typeGasoline, consumeGasoline, typeCharger, durationBattery, consumeBattery));

        out = "New hybrid vehicle has been added";


        calculateSellPrice(id);

        return out;
    }
    /**
     * 
     * @param brand String, brand of the vehicle
     * @param documents boolean, true if vehicle has documents
     * @param id String, id of the vehicle
     * @param basePrice double, base price of the vehicle
     * @param sellPrice double, sell price of the vehicle
     * @param model int, year of the vehicle
     * @param displacement int, displacement of the vehicle (Cilindraje)
     * @param km String, total km that the vehicle has
     * @param state boolean, true if new
     * @param plate String, plate of the vehicle
     * @param priceTecno double, price of the tecnico-mecanica
     * @param yearTecno int, year of the tecnico-mecanica
     * @param levelOfGases double, level of gases of the vehicle
     * @param priceSoat double, price of the soat
     * @param yearSoat int, year of the SOAT
     * @param coberture double, coberture in case of accident SOAT
     * @param priceProperty double, price of the property card
     * @param yearProperty int, year of the property card
     * @param typeMotorcicle String, type of motorcycle
     * @param typeGasoline String, type of gasoline the motorcycle
     * @param consumeGasoline double, consume gasoline by the motorcycle
     * @return addMotorCycle, message
     */
    public String addMotorCicle(String brand, boolean documents, String id, double basePrice, double sellPrice, int model, int displacement, String km, boolean state, String plate, double priceTecno, int yearTecno, double levelOfGases, double priceSoat, int yearSoat, double coberture, double priceProperty, int yearProperty, String typeMotorcicle, String typeGasoline, double consumeGasoline){

        String out = "";
        String numberDocument = "empty";
        TecnoMecanica tecnoMecanica = new TecnoMecanica(numberDocument, priceTecno, yearTecno, levelOfGases);
        Soat soat = new Soat(numberDocument, priceSoat, yearSoat, coberture);
        PropertyCard propertyCard = new PropertyCard(numberDocument, priceProperty, yearProperty);
        vehicles.add(new Motorcicle(brand, id, basePrice, sellPrice, model, displacement, km, state, plate, tecnoMecanica, soat, propertyCard, typeMotorcicle, typeGasoline, consumeGasoline));

        out = "New Motorcicle has been added";

        calculateSellPrice(id);

        return out;
    }
    /**
     * 
     * @param id String, id of the vehicle that the user gave to the vehicle
     */
    public void calculateSellPrice(String id){

        int documentation = 0;
        double total = 0;
        double base = 0;
        

        for(int i = 0; i<vehicles.size(); i++){
            if(vehicles.get(i).getId().equals(id)){

                base = vehicles.get(i).getBasePrice();

                if(vehicles.get(i).getState()==true || vehicles.get(i).activeSoat()==false || vehicles.get(i).activeTecno()==false){
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
    /**
     * 
     * @param id String, id of the vehicle the user wants to know its total price
     * @param discount double, discount that the user wants to give to the final price
     * @return String, message with the total price of the vehciel
     */

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
                        
                            if(vehicles.get(e).getState()==true || vehicles.get(e).activeSoat()==false || vehicles.get(e).activeTecno()==false){
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
    /**
     * 
     * @param var int, option the user choosed
     * @param varVehicle int, option the user choosed
     * @param varFuel int, option the user choosed
     * @param varState int, option the user choosed
     * @return String, returns toString of the specific type of vehicle that the user wants
     */
    public String reportDataVehicles(int var, int varVehicle, int varFuel, int varState){
        
        String out = "";

        for(int i = 0; i<vehicles.size(); i++){

            if(var==1){

                if(varVehicle==1){
                    out += ((Gasoline)vehicles.get(i)).toString();
                }else if(varVehicle==2){
                    out += ((Electric)vehicles.get(i)).toString();
                }else if (varVehicle==3){
                    out += ((Hybrid)vehicles.get(i)).toString();
                }else if (varVehicle==4){
                    out += ((Motorcicle)vehicles.get(i)).toString();
                }

            } else if(var==2){

                if(vehicles.get(i) instanceof Gasoline || vehicles.get(i) instanceof Hybrid || vehicles.get(i) instanceof Motorcicle){
                    if(varFuel==1){
                        if(((Gasoline)vehicles.get(i)).getTypeGasoline().equals("corriente")){
                            out+=vehicles.get(i).toString();
                        } else if (((Hybrid)vehicles.get(i)).getTypeGasoline().equals("corriente")){
                            out+=vehicles.get(i).toString();
                        } else if (((Motorcicle)vehicles.get(i)).getTypeGasoline().equals("corriente")){
                            out+=vehicles.get(i).toString();
                        }
                    } else if (varFuel==2){
                        if(((Gasoline)vehicles.get(i)).getTypeGasoline().equals("extra")){
                            out+=vehicles.get(i).toString();
                        } else if (((Hybrid)vehicles.get(i)).getTypeGasoline().equals("extra")){
                            out+=vehicles.get(i).toString();
                        } else if (((Motorcicle)vehicles.get(i)).getTypeGasoline().equals("extra")){
                            out+=vehicles.get(i).toString();
                        }
                    } else if (varFuel==3){
                        if(((Gasoline)vehicles.get(i)).getTypeGasoline().equals("diesel")){
                            out+=vehicles.get(i).toString();
                        } else if (((Hybrid)vehicles.get(i)).getTypeGasoline().equals("diesel")){
                            out+=vehicles.get(i).toString();
                        } else if (((Motorcicle)vehicles.get(i)).getTypeGasoline().equals("diesel")){
                            out+=vehicles.get(i).toString();
                        }
                    }
                }

            } else if(var==3){

                if(varState==1){
                    if(vehicles.get(i).getState()==true){
                        out += vehicles.get(i).toString();
                    }
                }else if (varState==2){
                    if(vehicles.get(i).getState()==false){
                        out += vehicles.get(i).toString();
                    }
                }

            }

        }

        return out;
    }
    /**
     * 
     * @param id String, id of the vehicle the user wants to know the satate of the vehicle
     * @return String, message with the state of the documents of the vehicle with the id
     */
    public String stateVehiculeDocument(String id){

        String out = "";

        for(int i =0; i<vehicles.size(); i++){
            if(vehicles.get(i).getId().equals(id)){
                if(vehicles.get(i).activeSoat()==false){
                    out += "The vehicle has no SOAT\n";
                }else{
                    Soat soat = vehicles.get(i).getSoat();
                    out += "The number of the SOAT is: "+soat.getNumberDocument()+"\n";   
                }
                if(vehicles.get(i).activeTecno()==false){
                    out += "The vehicle has no Tecno-Mecanica"+"\n";
                }else{
                    TecnoMecanica tecnoMecanica = vehicles.get(i).getTecnoMecanica();
                    out += "The number of the Tecno-Mecanica is: "+tecnoMecanica.getNumberDocument()+"\n";   
                }
                if(vehicles.get(i).getState()==false){
                    out += "The vehicle has no Property Card"+"\n";
                }else{
                    PropertyCard propertyCard = vehicles.get(i).getPropertyCard();
                    out += "The number of the Property Card is: "+propertyCard.getNumberDocument()+"\n";   
                }
            }
        }

        return out;
    }

    /**
     * Metod for showing the map of parking lot
     */
    public void mapMatrix(){

        boolean flag = true;
        int column = 0;

        for (int i =0; i<vehicles.size(); i++){

            flag=true;
            Vehicle obj = vehicles.get(i);

            if(obj.getState()==false && obj.getModel()<2015){

                if(obj.getModel()==2014){
                    column=0;
                }else if (obj.getModel()==2013){
                    column=1;
                }else if (obj.getModel()==2012){
                    column=2;
                }else if (obj.getModel()==2011){
                    column=3;
                }else if (obj.getModel()<2011){
                    column=4;
                }

                for(int j=0; j<parkVehicles[0].length && flag==true; j++){
                    if(parkVehicles[j][column]==null){
                        parkVehicles[j][column]=obj;
                        flag=false;
                    }
                }

            }
        }
    }

    /**
     * 
     * @return String, print of the parking lot in the consol
     */
    public String showParkinLot(){
        
        mapMatrix();
        String out = "";

        out+="|   2014    |";
        out+="|   2013    |";
        out+="|   2012    |";
        out+="|   2011    |";
        out+="| 2010 or < |\n";
        out+="=================================================================\n";

        for(int i = 0; i<parkVehicles.length; i++){
            for(int j = 0; j<parkVehicles[0].length; j++){

                if(j+1<parkVehicles[0].length){

                    if(parkVehicles[i][j]!=null){
                        out+="| Occupied  |";
                    }else{
                        out+="|   Empty   |";
                    }

                }else{

                    if(parkVehicles[i][j]!=null){
                        out+="| Occupied  |\n";
                    }else{
                        out+="|   Empty   |\n";
                    }

                }
            }
        }

        return out;
    }

    /**
     * 
     * @return String, with message with the ocupation of the parking lot
     */
    public String occupationParking(){

        mapMatrix();
        String out = "";
        int num = 0;
        double finalNum = 500;

        for(int i = 0; i<parkVehicles.length; i++){
            for(int j = 0; j<parkVehicles[0].length; j++){
                if(parkVehicles[i][j]!=null){
                    num++;
                }
            }
        }

        finalNum= (num)/finalNum;
        finalNum = finalNum*100;
        out = "The occupation of the parking lot is: "+finalNum+"%";

        return out;

    }
    /**
     * 
     * @return String, message with the newest vehicle and the oldest
     */
    public String oldNewestVehicleData(){

        String out = "";
        boolean flag = true;
        Vehicle obj = null;
        int numDef=0;

        for(int i =0; i<vehicles.size() && flag==true; i++){
            if(vehicles.get(i).getState()==false && vehicles.get(i).getModel()<2015){
                obj = vehicles.get(i);
                flag=false;
                numDef=i;
            }
        }

        int numNew = numDef;
        for(int i =0; i<vehicles.size(); i++){
            if(vehicles.get(i).getState()==false && vehicles.get(i).getModel()<2015){
                if(obj.getModel()<vehicles.get(i).getModel()){
                    obj=vehicles.get(i);
                    numNew=i;
                }
            }
        }

        int numOld = numDef;
        for(int i =0; i<vehicles.size(); i++){
            if(vehicles.get(i).getState()==false && vehicles.get(i).getModel()<2015){
                if(obj.getModel()>vehicles.get(i).getModel()){
                    obj=vehicles.get(i);
                    numOld=i;
                }
            }
        }


        out = "Info newest vehicle: \n"+vehicles.get(numNew).toString()+
            "\nInfo oldes vehicle: \n"+vehicles.get(numOld).toString();
        

        return out;
    }
    /**
     * 
     * @param year1 int, first year the user wrote
     * @param year2 int, second year the user wrote
     * @return String, message with the toString of vehicles between the two years
     */
    public String listVehiclesRange(int year1, int year2){

        String out = "";
        int diference = 0;
        int yearOne = year1;
        int yearTwo = year2;

        if(year1>year2){
            
            diference=year1-year2;

            for(int i = 0; i<diference+1; i++){
                yearOne = year1-i;
                for(int j =0; j<vehicles.size(); j++){
                    if(vehicles.get(j).getState()==false && vehicles.get(j).getModel()==yearOne){
                        out+=vehicles.get(j).toString();
                    }
                }
            }
            
        }else{

            diference=year2-year1;

            for(int i = 0; i<diference+1; i++){
                yearTwo = year2-i;
                for(int j =0; j<vehicles.size(); j++){
                    if(vehicles.get(j).getState()==false && vehicles.get(j).getModel()==yearTwo){
                        out+=vehicles.get(j).toString();
                    }
                }
            }

        }

        return out;
    }

}
