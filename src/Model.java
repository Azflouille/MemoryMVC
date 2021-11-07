import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class Model implements Sujet{

    private ArrayList<Carte> cartes;
    private ArrayList<Observateur> observateurs;
    private Carte cartePrecedente;
    private int NbPaires;
    private int NbCoups;

    public Model() {
        observateurs = new ArrayList<Observateur>();
        cartes = new ArrayList<Carte>();
        for (int i = 0; i < 20; i++) {
            Carte carte = new Carte((int) i / 2);
            cartes.add(carte);}
    }

    public void melanger() {
        Collections.shuffle(cartes);
        this.notifierObservateurs();
        for (int i = 0; i < 20; i++) {
            System.out.println(cartes.get(i).getNum());
        }
    }

    public ArrayList<Carte> getCartes(){
        return this.cartes;
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
