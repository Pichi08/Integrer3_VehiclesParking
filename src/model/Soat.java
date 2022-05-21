package model;

public class Soat extends Document {

    private double coberture;

    public Soat(String numberDocument,double price, int year, double coberture) {
        super(numberDocument, price, year);
        this.coberture = coberture;
        generateNumber();
    }

    /**
     * Desencriptado number of the SOAT
     */
    @Override
    public void generateNumber() {

        String out = "";
        String out2 = "";
        int definitMatrix[][] = new int[4][4];
        definitMatrix = super.createMatrix();

        for(int i = 0; i<definitMatrix.length; i++){
            out += ""+definitMatrix[i][0];
            if(i!=0){
            out2 += ""+definitMatrix[definitMatrix.length-1][i];
            }
        }
        /* 
        for(int i = 1; i<definitMatrix.length-1; i++){
            flag = false;
            for(int j = definitMatrix.length-1 ; j>0 && flag==false ; j--){
                out += ""+definitMatrix[i][j];
                flag = true;
            }
        }

        for(int i = 0; i<definitMatrix.length; i++){
            out += ""+definitMatrix[definitMatrix.length-1][i];
        }
 */
        setNumberDocument(out+out2);

    }

    public double getCoberture(){
        return coberture;
    }
    
}
