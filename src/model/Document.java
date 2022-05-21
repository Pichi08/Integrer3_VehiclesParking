package model;
import java.util.Random;

public abstract class Document {

    private double price;
    private int year;
    private String numberDocument;
    //anadir la imgagen que eso es todo raro y aun no se como se hace

    public Document(String numberDocument, double price, int year) {
        this.price = price;
        this.year = year;
        this.numberDocument = numberDocument;
    }

    /**
     * 
     * @return int[][], returns matrix 4x4 with random number between 0 and 99
     */
    public int[][] createMatrix(){
        Random random = new Random();
        int [][] matrix = new int[4][4];

        for(int i =0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                int randomNumber = random.nextInt(10);
                matrix[i][j] = randomNumber;
            }
        }

        return matrix;
    }

    public abstract void generateNumber();

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

}
