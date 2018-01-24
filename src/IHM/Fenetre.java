package IHM;

import javax.swing.*;
import metier.Cellule;

import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Fenetre extends JFrame{

    public static final int TAILLE_CELLULE = 10;

    private int[][] tabCellules;
    private int nouvX;
    private int nouvY;
    private int[] temp = new int[9];
    private int[] nouvCellule = new int[9];


    public Fenetre(int xSize, int ySize) {
        super("Forêt en feu");
        super.frameInit();
        makeCells(xSize,ySize);
        setLayout(null);
        setContentPane(new Tableau(xSize, ySize,tabCellules));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(true);
        setDefaultLookAndFeelDecorated(true);
        setSize(ySize+20,xSize+50);
        nouvX = xSize/Fenetre.TAILLE_CELLULE;
        nouvY = ySize/Fenetre.TAILLE_CELLULE;
    }

    public void drawCells() {
        for (int i = 0; i < nouvX; i++) {
            for (int j = 0; j < nouvY; j++) {

                int tempNumPlus = 0;

                for (int iX = -1; iX <= 1; iX++) {
                    for (int jX = -1; jX <= 1; jX++) {

                        int xValue = i+iX;
                        int yValue = j+jX;

                        if (xValue == -1) {
                            xValue = nouvX-1;
                        } else if (xValue == nouvX) {
                            xValue = 0;
                        }

                        if (yValue == -1) {
                            yValue = nouvY-1;
                        } else if (yValue == nouvY) {
                            yValue = 0;
                        }

                        temp[tempNumPlus] = tabCellules[xValue][yValue];
                        tempNumPlus++;

                    }
                }

                Cellule myCellule = new Cellule(temp);
                nouvCellule = myCellule.returnCells();

                for (int iY = -1; iY <= 1; iY++) {
                    for (int jY = -1; jY <= 1; jY++) {

                        int xValue = i+iY;
                        int yValue = j+jY;

                        if (xValue == -1) {
                            xValue = nouvX-1;
                        } else if (xValue == nouvX) {
                            xValue = 0;
                        }

                        if (yValue == -1) {
                            yValue = nouvY-1;
                        } else if (yValue == nouvY) {
                            yValue = 0;
                        }

                        tabCellules[xValue][yValue] = nouvCellule[(iY+1)*3+(jY+1)];
                    }
                }
            }
        }
    }

    public void GameTimer(int timeTime) {
        TimerTask task = new TimerTask() {
            public void run() {
                drawCells();
            }
        };
        java.util.Timer timer = new Timer();
        timer.schedule(task,0,timeTime);
    }

    public void makeCells(int arrayX, int arrayY) {

        Random rand = new Random();

        int tempX = arrayX/Fenetre.TAILLE_CELLULE;
        int tempY = arrayY/Fenetre.TAILLE_CELLULE;

        tabCellules = new int[tempX][tempY];

        for (int i = 0; i < tempX; i++) {
            for (int j = 0; j < tempY; j++) {
                tabCellules[i][j] = rand.nextInt(2)+4;
            }
        }
    }

    public void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            this.dispose();
            System.out.print("\n\nQuitting the application!\n");
            System.exit(0);
        }
    }

}
