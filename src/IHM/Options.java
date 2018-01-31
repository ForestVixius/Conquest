package IHM;

import metier.Gestion;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

public class Options extends JFrame implements ActionListener {

    public static final int TAILLE_CELLULE = 10;

    private int tailleX;
    private int tailleY;
    private int time;

    private JButton valider;
    private JTextField jTaille;
    private JTextField jArbreFeu;
    private JTextField jSapinFeu;
    private JTextField jChanceFeu;

    public Options() {
        super("Forest destructor - Options");
        super.frameInit();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(325, 600);
        setLocationRelativeTo(null);

        JLabel jLTaille = new JLabel("Taille cellule en pixel : ");
        jLTaille.setBounds(20, 20, 260, 30);
        add(jLTaille);
        jTaille = new JTextField("10");
        jTaille.setBounds(250, 20, 50, 30);
        add(jTaille);

        JLabel jLArbre = new JLabel("Chance de prendre feu pour arbre : ");
        jLArbre.setBounds(20, 60, 260, 30);
        add(jLArbre);
        jArbreFeu = new JTextField("3");
        jArbreFeu.setBounds(250, 60, 50, 30);
        add(jArbreFeu);

        JLabel jLSapin = new JLabel("Chance de prendre feu pour sapin : ");
        jLSapin.setBounds(20, 100, 260, 30);
        add(jLSapin);
        jSapinFeu = new JTextField("3");
        jSapinFeu.setBounds(250, 100, 50, 30);
        add(jSapinFeu);

        JLabel jLFeu = new JLabel("Chance qu'un éclair frappe un arbre : ");
        jLFeu.setBounds(20, 140, 260, 30);
        add(jLFeu);
        jChanceFeu = new JTextField("3");
        jChanceFeu.setBounds(250, 140, 50, 30);
        add(jChanceFeu);

        setVisible(true);
    }

    public void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            this.dispose();
            System.out.print("\n\nQuitting the application!\n");
            System.exit(0);
        }
    }

    public void actionPerformed(ActionEvent e) {
        /*Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x =     Integer.parseInt(jHauteur.getText());
        int y =     Integer.parseInt(jLargeur.getText());
        int timer = Integer.parseInt(jTimer.getText());
        boolean error = false;

        if ( (x > dim.getHeight()-150) || (x < 20)) {
            JOptionPane.showMessageDialog(null, ("Mauvaise hauteur, veuilez choisir entre 20 et "+(dim.getHeight()-150)+"px"));
            error = true;
        }
        else
        if ( (y > dim.getWidth()-150) || (y < 20))  {
            JOptionPane.showMessageDialog(null, ("Mauvaise largeur, veuilez choisir entre 20 et "+(dim.getHeight()-150)+"px"));
            error = true;
        }

        System.out.println("Largeur de base : "+x+"px");
        System.out.println("Hauteur de base : "+y+"px");
        System.out.println("Temps entre chaque itération : "+timer+"ms");

        if (!error) {
            new Fenetre(x,y,timer);
            dispose();
        }
*/

    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}


}



