import javax.swing.*;

public class VueCoups extends JLabel implements Observateur {

    public VueCoups() {
    super(" Nombre de coups joués : 0 ",JLabel.CENTER);
    }

    @Override
    public void actualiser(Sujet s) {

        Model m = (Model) s;
        this.setText(" Nombre de coups joués : " + m.getNbCoups());
    }
}
