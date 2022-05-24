package YourSchool;

public class School {

    /** Attribut d'une école à visibilité privée.
     * Nom de l'école
		 * (on considère que chaque école à un nom unique -> le nom est un id)
     */
	private String nom;

    /** Attribut d'une école
     * Tous les étudiants qui demandent l'école sont classés dans l'ordre de choix de l'école
     */
	private List<Student> preference;

	/*
	* Nombre de places dans l'école
	*/
	private Integer places;

	/** Construire un joueur à partir de son nom et de sa strategie.
	 * @param nom nom du joueur
	 * @param strategie strategie du joueur
	 */
	public Joueur(String nom, Integer nb, String preference) {
		assert nom != null;
		this.nom = nom;
		this.places = nb;
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
