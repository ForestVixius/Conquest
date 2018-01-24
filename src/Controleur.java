import IHM.Fenetre;

public class Controleur {
    private static int x;
    private static int y;
    private static int time;

    public static void main(String[] args) {
        y = 1000;
        System.out.println("Largeur de base : "+x+"px");
        x = 400;
        System.out.println("Hauteur de base : "+y+"px");
        time = 1;
        System.out.println("Temps entre chaque itération : "+time+"ms");


        Fenetre gui = new Fenetre(x,y);
        gui.GameTimer(time);
    }
}