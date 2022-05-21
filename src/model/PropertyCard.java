package model;

public class PropertyCard extends Document{

    public PropertyCard(String numberDocument, double price, int year) {
        super(numberDocument, price, year);
        generateNumber();
    }

    /**
     * Desencriptado number of the property card
     */
    @Override
    public void generateNumber() {
        String out = "";
        int definitMatrix[][] = new int[4][4];
        definitMatrix = super.createMatrix();

        for(int i = definitMatrix.length-1; i>=0; i--){
            for(int j = 0; j<definitMatrix.length; j++){
                if(i%2==0 && j%2==1){
                    out += ""+definitMatrix[i][j];
                }
                if(i%2==1 && j%2==0){
                    out += ""+definitMatrix[i][j];
                }
            }

        }

        setNumberDocument(out);
    }
    
}
