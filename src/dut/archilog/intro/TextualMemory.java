package dut.archilog.intro;

import java.util.Iterator;
import java.util.Scanner;

public class TextualMemory implements Memory<Cell> {
    private Cell [][] cells;
    private Cell firstCard;
    private Cell secondCard;
    private int height;
    private int width;
    private Scanner scanner;
    protected int nbPairs;
    private boolean abandon;

    public TextualMemory(int heigth, int width) {
        if((heigth*width)%2!=0){
            System.out.println("Les dimentions ne sont pas bonnes, le nombre de carte est impaire.");
            System.exit(1);
        }
        abandon = true;
        this.height=heigth;
        this.width=width;
        cells = new Cell[heigth][width];
        nbPairs= (heigth*width)/2;
        firstCard = null;
        secondCard =  null;
        scanner=new Scanner(System.in);

    }

    @Override
    public Cell createCell(char content) {
        return new Cell(content);
    }

    @Override
    public int getNbPairs() {
        return nbPairs;
    }

    @Override
    public void prepare(Iterator<Cell> it) {
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                cells[i][j] = it.next();
            }
        }
    }

    private  Cell askForCard(){
        Cell selectedCell;
        int ligne, col;
        do{
            System.out.print("Entrez les coordonnées de la carte : ");
            ligne = scanner.nextInt();
            col = scanner.nextInt();
            selectedCell = cells[ligne-1][col-1];
        }while(ligne-1 >= height || col-1 >= width || ligne < 0 || col < 0 || selectedCell.isVisible());


        return selectedCell;
    }

    @Override
    public void selectFirstCard() {
        System.out.println("**************Sélection de la première carte ***************************");
        firstCard = askForCard();
        firstCard.setVisible(true);

    }

    @Override
    public void selectSecondCard() {
        System.out.println("**************Sélection de la deuxième carte ***************************");
        secondCard = askForCard();
        secondCard.setVisible(true);
    }

    @Override
    public boolean areCardEquals() {
        return firstCard.equals(secondCard);
    }

    @Override
    public void displayTheTwoCards() {
        System.out.println("bien joué");
        for (int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                System.out.print(cells[i][j].toString());
            }
            System.out.println();
        }
        System.out.println("\nBien joué une paire trouvée");
    }

    @Override
    public void hideTheTwoCards() {

        firstCard.setVisible(false);
        secondCard.setVisible(false);
        for (int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                System.out.print(cells[i][j].toString());
            }
            System.out.println();
        }
        System.out.println("\nDommage!");
    }

    @Override
    public boolean isStoppingCriterionMet() {
        if (isWinner() || abandon){
            return false;
        }

        return true;
    }

    @Override
    public boolean isWinner() {
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if (!cells[i][j].isVisible()){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }


    public void setAbandon(){abandon=false;}
}
