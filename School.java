package YourSchool;

public class School {

    /** Attribut d'un joueur à visibilité privée.
     * Nom du joueur
     */
	private String nom;

    /** Attribut d'un joueur à visibilité privée.
     * Strategie du joueur
     */
	private List<Student> preference;

	/** Construire un joueur à partir de son nom et de sa strategie.
	 * @param nom nom du joueur
	 * @param strategie strategie du joueur
	 */
	public Joueur(String nom, String preference) {
		assert nom != null;
		this.nom = nom;
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
	public List<Student> getPreference() {
		null;
	}

    /** Afficher le jeu.  Le jeu est affiché sous la forme :
     *
	 */
    public String toString() {
    	return "School " + this.nom;
    }
}
