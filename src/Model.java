import java.util.ArrayList;
import java.util.*;

/**
 * Class Modèle du MVC.
 */
public class Model implements Sujet{

    /** La liste des cartes du jeu */
    private ArrayList<Carte> cartes;

    private ArrayList<Observateur> observateurs;
    
    /** Le nombre de paires trouvées */
    private int NbPaires;
    
    /** Le nombre de coups joués */
    private int NbCoups;
    
    /** Le répéertoire, permet de passer du mode smiley à fruit */
    private String rep;

    private Carte cartePrecedante;
    
    /** La carte suivant la carte précédente #jesuisdruide */
    private Carte secondeCarte;
    
    /** Vaut true quand le joueur à trouvé les 10 paires */
    private boolean finis;

    /**
     * Constructeur, créer la liste de carte avec un doublon pour chaque numéro
     */
    public Model() {
        this.observateurs = new ArrayList<Observateur>();
        this.cartes = new ArrayList<Carte>();
        this.rep = "smiley";
        this.finis = false;
        for (int i = 0; i < 20; i++) {
            Carte carte = new Carte((int) i / 2);
            cartes.add(carte);}
    }

    /**
     * Mélange les cartes
     */
    public void melanger() {
        Collections.shuffle(cartes);
        this.notifierObservateurs();
    }

    /**
     * Cache les cartes
     */
    public void cacher() {
        for (int i = 0; i < 20; i++) {
            cartes.get(i).setVisible(false);
        }
        this.notifierObservateurs();
    }

    /**
     * Retourne le carte correspondant au numéro donné en paramètres dans le liste
     * Gère les cas ou aucune carte n'a encore été retournée, une seule carte est retournée sur le plateau ou deux
     */
    public void retourner(int i) {
        if (this.secondeCarte == null) {
            if (this.cartePrecedante != null) {
                this.cartes.get(i).setVisible(true);
                if (this.cartePrecedante.getNum() == this.cartes.get(i).getNum()) {
                    this.cartePrecedante = null;
                    this.secondeCarte = null;
                    this.NbPaires++;
                    if (this.NbPaires == 10) {
                        this.finis = true;
                    }
                }
                else {
                    this.secondeCarte = this.cartes.get(i);
                }
            } else {
                this.cartes.get(i).setVisible(true);
                this.cartePrecedante = this.cartes.get(i);
            }
        } else {
            this.cartes.get(i).setVisible(true);
            this.cartePrecedante.setVisible(false);
            this.secondeCarte.setVisible(false);
            this.cartePrecedante = this.cartes.get(i);
            this.secondeCarte = null;
        }
        this.NbCoups++;
        this.notifierObservateurs();
    }

    public ArrayList<Carte> getCartes(){
        return this.cartes;
    }

    public String getRep() {
        return this.rep;
    }

    /**
     * Change la valeur associée au répértoire, méthode appellée par le bouton correspondant dans ControleurBoutons
     */
    public void setRep(int i){
        if (i == 1) {
            this.rep = "smiley";
        }
        if (i ==2) {
            this.rep = "fruits";
        }
        this.notifierObservateurs();
    }

    public int getNbCoups() {return this.NbCoups;}

    public int getNbPaires() {return this.NbPaires;}

    public boolean getFinis() {return this.finis;}

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
