import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class Model implements Sujet{

    private ArrayList<Carte> cartes;
    private ArrayList<Observateur> observateurs;
    private int NbPaires;
    private int NbCoups;
    private String rep;
    private ArrayList<Carte> CarteRetournee;

    public Model() {
        observateurs = new ArrayList<Observateur>();
        cartes = new ArrayList<Carte>();
        rep = "smiley";
        this.CarteRetournee = new ArrayList<Carte>();
        for (int i = 0; i < 20; i++) {
            Carte carte = new Carte((int) i / 2);
            cartes.add(carte);}
        this.notifierObservateurs();
    }

    public void melanger() {
        Collections.shuffle(cartes);
        this.notifierObservateurs();
    }

    public void cacher(int nb) {
        if (nb == -1) {
        for (int i = 0; i < 20; i++) {
            cartes.get(i).setVisible(false);
            }
        }
        else {
            for (int i = 0; i < 20; i++) {
                if (cartes.get(i).getNum() == nb) {
                    cartes.get(i).setVisible(false);
                }
            }
        }
        this.notifierObservateurs();
    }

    public void retourner(int i) {
        if (cartes.get(i).isVisible() == false) {
            cartes.get(i).setVisible(true);
            this.CarteRetournee.add(this.cartes.get(i));
        }
        //Je suis panomarix le druide
        if ((CarteRetournee.toArray().length % 2) == 0 && CarteRetournee.toArray().length != 1) {
            if (CarteRetournee.get(CarteRetournee.toArray().length -1).getNum() == CarteRetournee.get(CarteRetournee.toArray().length -2).getNum()) {
                System.out.println("bien joué batar");
            }
            else if (CarteRetournee.toArray().length != 1){
                this.cacher(CarteRetournee.get(CarteRetournee.toArray().length -1).getNum());
                this.cacher(CarteRetournee.get(CarteRetournee.toArray().length -2).getNum());
            }
        }

        if ((CarteRetournee.toArray().length % 2) == 0) {
            this.NbCoups++;
        }
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
