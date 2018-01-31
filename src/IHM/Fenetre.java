package IHM;

import metier.Gestion;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

    public static final int TAILLE_CELLULE = 10;
    public boolean enPause = true;

    private Tableau tableauGraphique;

    private JButton jPausePlay;
    private JButton jSuivant;
    private JButton jSuivantDix;

    private int clickY = -1;
    private int clickX  = -1;

    private int[][] tabCellules;
    int time;
    private Gestion g;

    public Fenetre(int tailleX, int tailleY, int time) {
        super("Forest destructor");
        super.frameInit();
        g = new Gestion(tailleX,tailleY);
        this.tableauGraphique = new Tableau(tailleX, tailleY,g.getTabCellules());
        add(tableauGraphique);
        this.time = time;

        tableauGraphique.addMouseListener(this);
        tableauGraphique.addMouseMotionListener(this);

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
                this.enPause = true;
                g.pauseTimer();
            } else {
                jPausePlay.setText("Pause");
                this.enPause = false;
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


    public void mousePressed(MouseEvent e) {
        //if (!this.enPause) {} else {
            if (e.getButton() == MouseEvent.BUTTON1) {

                clickX = (int) Math.ceil((double)e.getX() / TAILLE_CELLULE)-1;
                clickY =(int) Math.ceil((double)e.getY() / TAILLE_CELLULE )-1;
                //System.out.println("click  "+clickX+":"+clickY+" = "+e.getX()+":"+e.getY());
                g.setCellule(clickX,clickY, tableauGraphique);
            }
        //}
    }

    public void mouseDragged(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {}
}
