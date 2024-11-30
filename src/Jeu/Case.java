package Jeu;

public class Case {
	private boolean utiliser; //si la case contient une lettre ou non 
	private boolean croix; //indique si la case est l'une des 3 croix 
	private String lettre; //ou se trouve la lettre 
	private String predic; //valeur de prediction pour le mouvement que le joueur pourra faire  
	private boolean dispo;  //indique si il est possible de se placer dessus ou non

	
	/**
	 * Constructeur par défaut de la case
	 */
	public Case() {
		this.lettre = "";
		this.predic = "";
		this.croix = false;
		this.utiliser = false;
		this.dispo = false;
	}
	
	
	
	/**
	 * getter prediction
	 * @return prediction 
	 */
	public String getPredic() {
		return this.predic;
	}
	
	
	/**
	 * Initialise une case avec une croix
	 * càd les cases permettant de marqué des points 
	 */
	public void initCroix() {
		this.croix = true;
		this.utiliser = false;
	}
	
	/**
	 * Indique la disponibilité d'une case
	 * @return boolean pour savoir 
	 * si la case est utilisée
	 */ 
	public boolean estUtiliser() {
		return this.utiliser;
	}
	
	/**
	 * getter lettre
	 * @return lettre par qui la case est utilisée
	 */
	public String getLettre() {
		return lettre;
	}

	/**
	 * Indique si la case possède une croix 
	 * @return boolean pour savoir si 
	 * c'est le cas 
	 */
	
	public boolean estUneCroix() {
		return this.croix;
	}
	
	/**
	 * sert à remplir la case et 
	 * indiqué qu'elle utilisé  
	 * @param la lettre à mettre dans la case , 
	 * un boolean pour indiqué si elle est utilisé ou non 
	 */
	public void setUtiliser(String lettre , boolean b) {
		this.utiliser = b;
		this.lettre = lettre;
	}
	
	/**
	 * permet de donner une valeur de prediction si 
	 * la case le permet 
	 * @param numPredic, b 
	 */
	public void setPredic(String numPredic , boolean b) {
		this.dispo = b;
		this.predic = numPredic; 
	}
	

	/**
	 * pour savoir si la case possède une valeur de prédiction 
	 * @return un boolean pour le savoir
	 */
	//pour savoir si la case possède une valeur de prédiction 
	public boolean estPredic() {
		return this.dispo;
	}
}

