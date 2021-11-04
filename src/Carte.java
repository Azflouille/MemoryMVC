public class Carte {
	private boolean visible; // false=cachee true=visible
	private int num; 		 // numero du fichier image

	public Carte(int num) {
		this.num = num;
		this.visible = true;    //--> A METTRE A false POUR LE JEU
	}

	public boolean isVisible() {
		return this.visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getNum() {
		return (this.visible)? this.num : -1; //Si visible == true alors l'attribut num est retourne 
											 // sinon -1 est retourne
	}

	public void setNum(int num) {
		this.num = num;
	}
}
