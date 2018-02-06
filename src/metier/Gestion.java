package metier;

import IHM.*;
import javafx.scene.control.Tab;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Gestion {

    private TimerTask task;

    private Tableau t;

    private int[][] tabCellules;
    private int nouvX;
    private int nouvY;
    private int[] temp = new int[9];
    private int[] nouvCellule = new int[9];

    public Gestion(int tailleX, int tailleY) {
        creerCellules(tailleX,tailleY);
        nouvX = tailleX/Fenetre.TAILLE_CELLULE;
        nouvY = tailleY/Fenetre.TAILLE_CELLULE;
    }

    public void dessinerCellules() {
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

    public int[][] tabMonde () {
        try {
            BufferedImage img = ImageIO.read(new File("res/world-map.png"));
            System.out.println("Image chargée");


            System.out.println("Taille px : " + (img.getWidth()) +":" +(img.getHeight()));
            System.out.println("Taille px : " + (img.getWidth()/5) +":" +(img.getHeight()/5));

            int[][] tabImg = new int[img.getWidth()/5][img.getHeight()/5];
            for (int x = 0; x < (img.getWidth()/5); x++) {
                for (int y = 0; y < 208; y++) {
                    //System.out.println("pos : " + x+":"+y+ " --- "+ 5*x+":"+y*5 );
                    if (img.getRGB((x*5),(y*5)) == -1) {
                        tabImg[x][y] = 0;
                    } else {
                        tabImg[x][y] = 1;
                    }

                }
                System.out.println("yo");
            }
            return tabImg;
        } catch (Exception e){System.out.println(e);}
        return null;
    }

    public void lancerTimer(int temps) {
        task = new TimerTask() {
            public void run() {
                dessinerCellules();
            }
        };
        java.util.Timer timer = new Timer();
        timer.schedule(task,0,temps);
    }

    public void pauseTimer() {
        task.cancel();
    }

    public void avancer10Fois(int time) {
        for (int i = 0; i < 10; i++) {
            dessinerCellules();
        }
    }

    public void creerCellules(int arrayX, int arrayY) {

        Random rand = new Random();

        int tempX = arrayX/ Fenetre.TAILLE_CELLULE;
        int tempY = arrayY/Fenetre.TAILLE_CELLULE;

        tabCellules = new int[tempX][tempY];

        for (int i = 0; i < tempX; i++) {
            for (int j = 0; j < tempY; j++) {
                tabCellules[i][j] = rand.nextInt(2)+4;
            }
        }
    }

    public void setCellule(int x, int y, int type) {
        tabCellules[y][x] = type;
    }

    public int[][] getTabCellules() {
        return tabCellules;
    }
}
