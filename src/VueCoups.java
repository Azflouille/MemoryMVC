import javax.swing.*;

/**
 * Class vue du MVC, affiche le nombre de coups joués
 */
public class VueCoups extends JLabel implements Observateur {

    public VueCoups() {
    super(" Nombre de coups joués : 0 ",JLabel.CENTER);
    }

    /**
     * Méthode Actualiser
     * Récupère le nombre de coups dans l'attribut correspondant dans le modèle, et mets à jour le JLabel
     */
    @Override
    public void actualiser(Sujet s) {

        Model m = (Model) s;
        int coups = (m.getNbCoups()/2);
        this.setText(" Nombre de coups joués : " + coups);
    }
}
