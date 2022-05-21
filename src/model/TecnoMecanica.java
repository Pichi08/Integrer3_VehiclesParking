package model;

public class TecnoMecanica extends Document{

    private double levelOfGases;

    public TecnoMecanica(String numberDocument,double price, int year, double levelOfGases) {
        super(numberDocument, price, year);
        this.levelOfGases = levelOfGases;
        generateNumber();
    }

    /**
     * Desencriptado number of the tecno mecanica
     */
    @Override
    public void generateNumber() {
        
        String out = "";
        String out2 = "";
        String out3 = "";
        int j = 0;
        int definitMatrix[][] = new int[4][4];
        definitMatrix = super.createMatrix();

        for(int i = 0; i<definitMatrix.length; i++){
            out+=""+definitMatrix[0][i];
            out2+=""+definitMatrix[definitMatrix.length-1][i];
            j = definitMatrix.length-i;
            if(i==0 || i==definitMatrix.length-1){
            } else {
                out3+=""+definitMatrix[i][j];
            }
        }

        setNumberDocument(out+out3+out2);
    }

    public double getLevelOfGases(){
        return levelOfGases;
    }
}
