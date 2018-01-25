import IHM.Fenetre;
import metier.Gestion;

public class Controleur {
    private static int x;
    private static int y;
    private static int time;

    public static void main(String[] args) {
        y = 1200;
        System.out.println("Largeur de base : "+x+"px");
        x = 950;
        System.out.println("Hauteur de base : "+y+"px");
        time = 10;
        System.out.println("Temps entre chaque itération : "+time+"ms");

        Fenetre gui = new Fenetre(x,y,time);


    }
}