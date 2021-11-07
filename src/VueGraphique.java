import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class VueGraphique extends JPanel implements Observateur{

    @Override
    public void actualiser(Sujet s) {
        Model m = (Model) s;
        ArrayList<Carte> cartes = m.getCartes();
        //Création des JLabel associés aux cartes - affichage dans le JPanel Plateau
        String chemin;
        String repertoire="smiley"; //ou "fruits" selon la série choisie
        for (int i = 0; i < 20; i++) {
            if(cartes.get(i).isVisible())  //si l'attribut visible de la carte est a true alors l'image de la carte apparaitra
                chemin = "img/" + repertoire + "/im" + cartes.get(i).getNum()+".png";
            else
                chemin= "img/" + repertoire + "/fond.png";//sinon l'image de la carte retournée apparaitra
            this.add(new JLabel(new ImageIcon(chemin))); //association du fichier image avec le JLabel avec la classe ImageIcon
        }
    }
}
