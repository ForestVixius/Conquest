package IHM;

import javax.swing.*;
import java.awt.*;

public class Tableau extends JPanel {

    private int[][] tabCellules;
    private int x;
    private int y;

    public Tableau(int x, int y, int[][] tabCellules) {
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
                if (tabCellules[i][j] == 1) { g.setColor(Color.red);              }
                if (tabCellules[i][j] == 2) { g.setColor(Color.gray);             }
                if (tabCellules[i][j] == 3) { g.setColor(Color.white);            }
                if (tabCellules[i][j] == 4) { g.setColor(Color.green);            }
                if (tabCellules[i][j] == 5) { g.setColor((Color.green).darker()); }

                g.fill3DRect(j*Fenetre.TAILLE_CELLULE, i*Fenetre.TAILLE_CELLULE, Fenetre.TAILLE_CELLULE,Fenetre.TAILLE_CELLULE, true);
            }
        }

        repaint();
    }
}