package YourSchool;


public class School {

    /** Attribut d'une école à visibilité privée.
     * Nom du joueur
     */
	private String nom;

  private List<String> preference;


	/** Construire un joueur à partir de son nom et de sa strategie.
	 * @param nom nom du joueur
	 * @param strategie strategie du joueur
	 */
	public School(String nom; List<String> preference) {
		assert nom != null;
		this.nom = nom;
	}

	/** Obtenir le nom d'un joueur.
	 * @return le nom du joueur
	 */
	public String getNom() {
		String n = this.nom;
		return n;
	}

    /** Afficher le jeu.  Le jeu est affiché sous la forme :
     *
	 */
    public String toString() {
    	return "Ecole " + this.nom;
    }

	/** Changer le nom du joueur.
	 * @param nom nouveau nom du joueur
	 */
	public void setNom(String nom) {
		assert nom != null;
		this.nom = nom;
	}

	/** Changer la strategie du joueur.
	 * @param strategie nouvelle strategie du joueur
	 */
	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}
}
