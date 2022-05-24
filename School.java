package YourSchool;


public class School {

    /** Attribut d'une école à visibilité privée.
     * Nom du joueur
     */
	private String nom;

    /** Attribut d'un joueur à visibilité privée.
     * Strategie du joueur
     */
	private Strategie strategie;

	/** Construire un joueur à partir de son nom et de sa strategie.
	 * @param nom nom du joueur
	 * @param strategie strategie du joueur
	 */
	public Joueur(String nom, Strategie strategie) {
		assert nom != null;
		this.nom = nom;
		this.strategie = strategie;
	}

	/** Obtenir le nom d'un joueur.
	 * @return le nom du joueur
	 */
	public String getNom() {
		String j = this.nom;
		return j;
	}

	/** Obtenir la stratégie du joueur.
	 * @return la stratégie du joueur.
	 */
	public Strategie getStrategie() {
		Strategie s = strategie;
		return s;
	}

	/** Obtenir la prise au prochain coup d'un joueur.
	 * @return la prise au prochain coup d'un joueur
	 */
	public int getPrise(Jeu jeu) {
		return strategie.getPrise(jeu);
	}

    /** Afficher le jeu.  Le jeu est affiché sous la forme :
     *
	 */
    public String toString() {
    	return "Joueur " + this.nom;
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
