import javax.swing.*;

public class VuePaires extends JLabel implements Observateur {

    public VuePaires() {
        super(" Nombre de paires trouvées : 0 ",JLabel.CENTER);
    }

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