import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Class Controleur du MVC, gère les click de souris
 */
public class ControleurClick implements MouseListener {

    private Model model;

    public ControleurClick(Model m){
        this.model = m;
    }

    /**
     * Méthode mouse clicked, récupère les coordonnées du click pour retourner la carte correspondante
     *
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int numCaseX = e.getX()/120;
        int numCaseY = e.getY()/120;
        int num = numCaseY *5 + numCaseX;
        if (num <= 20) {
            this.model.retourner(num);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
