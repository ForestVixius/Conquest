package IHM;

import metier.Cellule;

import javax.swing.*;
import java.awt.*;

public class Tableau extends JPanel {

    private int[][] tabCellules;
    private int x;
    private int y;

    Tableau(int x, int y, int[][] tabCellules) {
        this.tabCellules = tabCellules;
        this.x = x/Fenetre.TAILLE_CELLULE;
        this.y = y/Fenetre.TAILLE_CELLULE;

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(null);
        boardPanel.setPreferredSize(new Dimension(x,y));
    }

    public void paintComponent(Graphics g) {

        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                if (tabCellules[i][j] == Cellule.EAU)    { g.setColor(Color.blue);              }
                if (tabCellules[i][j] == Cellule.FEU)    { g.setColor(Color.red);              }
                if (tabCellules[i][j] == Cellule.FEUM)   { g.setColor(new Color(255,149,0));           }
                if (tabCellules[i][j] == Cellule.CENDRE) { g.setColor(Color.gray);             }
                if (tabCellules[i][j] == Cellule.SOL)    { g.setColor(Color.white);            }
                if (tabCellules[i][j] == Cellule.ARBRE)  { g.setColor(Color.green);            }
                if (tabCellules[i][j] == Cellule.SAPIN)  { g.setColor((Color.green).darker()); }

                g.fill3DRect(j*Fenetre.TAILLE_CELLULE, i*Fenetre.TAILLE_CELLULE, Fenetre.TAILLE_CELLULE,Fenetre.TAILLE_CELLULE, true);
            }
        }

        repaint();
    }

    public void peindreCellule(int x, int y) {
        this.getGraphics().setColor(Color.blue);
        System.out.println("click  "+x+":"+y+" = "+x*Fenetre.TAILLE_CELLULE+":"+y*Fenetre.TAILLE_CELLULE);
        this.getGraphics().fill3DRect(y*Fenetre.TAILLE_CELLULE, x*Fenetre.TAILLE_CELLULE, Fenetre.TAILLE_CELLULE,Fenetre.TAILLE_CELLULE, true);
        repaint();
    }
}