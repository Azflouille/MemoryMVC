import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurBoutons implements ActionListener {

    private Model model;

    public ControleurBoutons(Model m) {
        this.model = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Melanger")) {
            this.model.melanger();
        }
    }
}
