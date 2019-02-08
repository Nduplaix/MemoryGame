package dut.archilog.intro;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;

import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.*;

public class GraphicalMemory extends JFrame implements Memory<GraphicalCell> {

    //Mise en place de la fenetre
    private JPanel pan;

    //Mise en place de base du jeu.
    private Cell[][] cells;
    private Cell firstCard;
    private Cell secondCard;
    private Cell selectedCell;
    private Object mutex = new Object();
    private int height;
    private int width;
    private int nbPairs;
    private int nbPairesTrouvee;

    public GraphicalMemory(int width, int height) {
        if((height*width)%2!=0){
            System.out.println("Les dimentions ne sont pas bonnes, le nombre de carte est impaire.");
            System.exit(1);
        }
        this.height = height;
        this.width = width;
        this.cells = new GraphicalCell[height][width];
        this.nbPairs = (height*width)/2;
        this.firstCard = null;
        this.secondCard = null;
        this.selectedCell = null;
        nbPairesTrouvee = 0;



        this.pan = new JPanel();
        this.setSize(width*55,height*65);

        this.setTitle("Jeu Memory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pan.setLayout(new GridLayout(height,width));
        this.add(BorderLayout.CENTER,pan);

    }

    @Override
    public GraphicalCell createCell(char content) {
        return new GraphicalCell(content);
    }

    @Override
    public int getNbPairs() {
        return nbPairs;
    }

    @Override
    public void prepare(Iterator<GraphicalCell> it) {
        CellJButton button;
        GraphicalCell cell;
        while(it.hasNext()){
            cell= it.next();
            button = cell.getUi();
            pan.add(button);
            button.addActionListener(this::onClick);
        }
        this.pack();
        this.setVisible(true);
    }

    private void onClick(ActionEvent e){
        CellJButton button = (CellJButton) e.getSource();
        Cell aCell = (button).getCell();
        displayMessage("click" + aCell);


        synchronized (mutex){
            button.setEnabled(false);
            aCell.setVisible(true);
            selectedCell = aCell;
            mutex.notify();
        }

    }

    @Override
    public void selectFirstCard() {
        synchronized (mutex){
            try {
                while(selectedCell == null){
                    mutex.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        displayMessage("Selection de la premiere carte");
        firstCard = selectedCell;
        selectedCell = null;
    }

    @Override
    public void selectSecondCard() {
        synchronized (mutex){
            try {
                while(selectedCell == null){
                    mutex.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        displayMessage("Selection de la premiere carte");
        secondCard = selectedCell;
        selectedCell = null;
    }

    @Override
    public boolean areCardEquals() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return firstCard.equals(secondCard);
    }

    @Override
    public void displayTheTwoCards() {
        nbPairesTrouvee++;
        displayMessage("nombre de cartes trouvée : " + nbPairesTrouvee + "\nnombre de cartes a trouver : " + nbPairs);
        this.revalidate();

    }

    @Override
    public void hideTheTwoCards() {
        firstCard.pin();
        secondCard.pin();
        firstCard.setVisible(false);
        secondCard.setVisible(false);
        this.revalidate();
    }

    @Override
    public boolean isStoppingCriterionMet() {
        return isWinner();
    }

    @Override
    public boolean isWinner() {
        return nbPairesTrouvee == nbPairs;
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
