package IHM;

import metier.Gestion;

import javax.swing.*;

import java.awt.event.WindowEvent;

public class Fenetre extends JFrame{

    public static final int TAILLE_CELLULE = 10;

    private int[][] tabCellules;
    private Gestion g;

    public Fenetre(int tailleX, int tailleY, int time) {
        super("Forêt en feu");
        super.frameInit();
        g = new Gestion(tailleX,tailleY);
        g.GameTimer(time);
        setLayout(null);
        setContentPane(new Tableau(tailleX, tailleY,g.getTabCellules()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(true);
        setDefaultLookAndFeelDecorated(false);
        setSize(tailleY+20,tailleX+50);
        setLocationRelativeTo(null);

    }

    public void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            this.dispose();
            System.out.print("\n\nQuitting the application!\n");
            System.exit(0);
        }
    }

}
