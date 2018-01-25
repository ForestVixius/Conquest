package IHM;

import metier.Gestion;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

public class Menu extends JFrame implements ActionListener {

    public static final int TAILLE_CELLULE = 10;

    private int tailleX;
    private int tailleY;
    private int time;

    private JButton forest;
    private JTextField jLargeur;
    private JTextField jHauteur;
    private JTextField jTimer;

    public Menu() {
        super("Forêt en feu");
        super.frameInit();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(700, 500);
        setLocationRelativeTo(null);
        Insets insets = this.getInsets();

        JLabel textLarg = new JLabel("Largeur");
        textLarg.setBounds(400,5,50,20);
        add(textLarg);
        jLargeur = new JTextField("500");
        jLargeur.addActionListener(this);
        jLargeur.setBounds(400, 25, 200, 50);
        add(jLargeur);

        JLabel textHaut = new JLabel("Hauteur");
        textHaut.setBounds(25,5,50,20);
        add(textHaut);
        jHauteur = new JTextField("500");
        jHauteur.addActionListener(this);
        jHauteur.setBounds(25, 25, 200, 50);
        add(jHauteur);

        JLabel textTimer = new JLabel("Timer");
        textTimer.setBounds(250,80,50,20);
        add(textTimer);
        jTimer = new JTextField("10");
        jTimer.addActionListener(this);
        jTimer.setBounds(250, 100, 200, 50);
        add(jTimer);

        forest = new JButton("Lancer : \"Forêt en feu\"");

        forest.addActionListener(this);
        forest.setVerticalTextPosition(AbstractButton.BOTTOM);
        forest.setHorizontalTextPosition(AbstractButton.CENTER);
        forest.setBounds(200, 300, 300, 100);
        add(forest);


        setVisible(true);
    }

    public Menu(int tailleX, int tailleY, int time) {
        this();
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.time = time;
    }

    public void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            this.dispose();
            System.out.print("\n\nQuitting the application!\n");
            System.exit(0);
        }
    }

    public void actionPerformed(ActionEvent e) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
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


    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}


}



