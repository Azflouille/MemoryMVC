import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class Model implements Sujet{

    private ArrayList<Carte> cartes;
    private ArrayList<Observateur> observateurs;
    private int NbPaires;
    private int NbCoups;
    private String rep;
    private Carte cartePrecedante;
    private Carte secondeCarte;

    public Model() {
        observateurs = new ArrayList<Observateur>();
        cartes = new ArrayList<Carte>();
        rep = "smiley";
        for (int i = 0; i < 20; i++) {
            Carte carte = new Carte((int) i / 2);
            cartes.add(carte);}
        this.notifierObservateurs();
    }

    public void melanger() {
        Collections.shuffle(cartes);
        this.notifierObservateurs();
    }

    public void cacher() {
        for (int i = 0; i < 20; i++) {
            cartes.get(i).setVisible(false);
        }
        this.notifierObservateurs();
    }

    public void retourner(int i) {
        if(this.secondeCarte == null) {
            if (this.cartePrecedante != null) {
                this.cartes.get(i).setVisible(true);
                if (this.cartePrecedante.getNum() == this.cartes.get(i).getNum()) {
                    this.cartePrecedante = null;
                    this.secondeCarte = null;
                    this.NbPaires++;
                    //arreter la partie si 10 paires trouvées
                    // if(this.nbCartesDecouvertes == 10){
                    //}
                }
                else {
                    this.secondeCarte = this.cartes.get(i);
                }
            }
            else {
                this.cartes.get(i).setVisible(true);
                this.cartePrecedante = this.cartes.get(i);
            }
        }
        else {
            this.cartes.get(i).setVisible(true);
            this.cartePrecedante.setVisible(false);
            this.secondeCarte.setVisible(false);
            this.cartePrecedante = this.cartes.get(i);
            this.secondeCarte = null;
        }
        this.NbCoups++;
        this.notifierObservateurs();
    }

    public void setRep(int i) {
        if (i == 1) {
            this.rep = "smiley";
        }
        if (i ==2) {
            this.rep = "fruits";
        }
        this.notifierObservateurs();
    }

    public ArrayList<Carte> getCartes(){
        return this.cartes;
    }

    public String getRep() {
        return this.rep;
    }

    public int getNbCoups() {return this.NbCoups;}

    public int getNbPaires() {return this.NbPaires;}

    @Override
    public void enregistrerObservateur(Observateur o) {
        this.observateurs.add(o);
        this.notifierObservateurs();
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
