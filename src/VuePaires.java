import javax.swing.*;

/**
 * Class vue du MVC, affiche le nombre de paires trouvées
 */
public class VuePaires extends JLabel implements Observateur {

    public VuePaires() {
        super(" Nombre de paires trouvées : 0 ",JLabel.CENTER);
    }

    /**
     * Méthode Actualiser
     * Récupère le nombre de paires dans l'attribut correspondant dans le modèle, et mets à jour le JLabel
     */
    @Override
    public void actualiser(Sujet s) {

        Model m = (Model) s;
        Boolean finis = m.getFinis();
        if (!finis) {
            this.setText(" Nombre de paires trouvées : " + m.getNbPaires());
        }
        else {
            this.setText(" Ohh putain, QI de 143 ");
        }
    }
}