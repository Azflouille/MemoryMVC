import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class vue du MVC, affiche les cartes
 */
public class VueGraphique extends JPanel implements Observateur{

    /**
     * Méthode Actualiser
     * Récupère la liste de cartes du modèle et les affiche
     */
    @Override
    public void actualiser(Sujet s) {
        if (this.countComponents() != 0) {
                this.removeAll();
                this.revalidate();
                this.repaint();
        }
        Model m = (Model) s;
        String doss = m.getRep();
        ArrayList<Carte> cartes = m.getCartes();
        String chemin;
        String repertoire= doss;
        for (int i = 0; i < 20; i++) {
            if(cartes.get(i).isVisible())
                chemin = "img/" + repertoire + "/im" + cartes.get(i).getNum()+".png";
            else
                chemin= "img/" + repertoire + "/fond.png";
            this.add(new JLabel(new ImageIcon(chemin)));
        }
    }
}
