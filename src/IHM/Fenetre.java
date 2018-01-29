package IHM;

import metier.Gestion;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Fenetre extends JFrame implements ActionListener{

    public static final int TAILLE_CELLULE = 10;

    private JButton jPausePlay;
    private JButton jSuivant;
    private JButton jSuivantDix;

    private int[][] tabCellules;
    int time;
    private Gestion g;

    public Fenetre(int tailleX, int tailleY, int time) {
        super("Forest destructor");
        super.frameInit();
        g = new Gestion(tailleX,tailleY);
        this.time = time;

        add(new Tableau(tailleX, tailleY,g.getTabCellules()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelBas = new JPanel(new GridLayout(1,3));

        jPausePlay = new JButton("Mise en route");
        jPausePlay.addActionListener(this);
        jSuivant   = new JButton("Avancer de 1 étape");
        jSuivant.addActionListener(this);
        jSuivantDix= new JButton("Avancer de 10 étapes");
        jSuivantDix.addActionListener(this);

        panelBas.add(jPausePlay);
        panelBas.add(jSuivant);
        panelBas.add(jSuivantDix);



        add(panelBas, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setResizable(true);
        setDefaultLookAndFeelDecorated(false);
        setSize(tailleY+20,tailleX+75);
        setLocationRelativeTo(null);

    }

    public void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            this.dispose();
            System.out.print("\n\nQuitting the application!\n");
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object command = e.getSource();

        if (command == jPausePlay) {
            if (jPausePlay.getText().equals("Pause")) {
                jPausePlay.setText("Mise en route");
                g.pauseTimer();
            } else {
                jPausePlay.setText("Pause");
                g.lancerTimer(this.time);
            }

        }

        if (command == jSuivant) {
            g.dessinerCellules();
        }

        if (command == jSuivantDix) {
            g.avancer10Fois(time);
            try {
                setEnabled(false);
                Thread.sleep(time);
                setEnabled(true);
            } catch (Exception ex){}
        }
    }
}
