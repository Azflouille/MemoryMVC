import java.util.ArrayList;
import java.util.*;

public class Model implements Sujet{

    private ArrayList<Carte> cartes;
    private ArrayList<Observateur> observateurs;
    private Carte cartePrecedente;
    private int NbPaires;
    private int NbCoups;

    public void melanger() {
        Collections.shuffle(cartes);
    }

    @Override
    public void enregistrerObservateur(Observateur o) {
        this.observateurs.add(o);
    }

    @Override
    public void supprimerObservateur(Observateur o) {
        int i = this.observateurs.indexOf(o);
        if (i >= 0) {
            this.observateurs.remove(i);
        }
    }

    @Override
    public void notifierObservateurs() {
        for (int i = 0; i < this.observateurs.size(); i++) {
            Observateur observer = this.observateurs.get(i);
            observer.actualiser(this);
        }
    }
}
