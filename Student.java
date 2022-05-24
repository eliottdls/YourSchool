package YourSchool;

public class Student {

    /** Attribut d'un student à visibilité privée.
     * Nom de l'étudiant
     * (on considère que chaque étudiant à un nom unique -> le nom est un id)
     */
	private String nom;

    /** Attribut d'un joueur à visibilité privée.
     * Liste des écoles préférées de l'étudiant (liste ordonnée)
     * Un étudiant demande 5 écoles
     */
	private List<School> preference;

  private School actuelPreference;

	/** Construire un joueur à partir de son nom et de sa strategie.
	 * @param nom nom du joueur
	 * @param strategie strategie du joueur
	 */
	public Student(String nom, String vows) {
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

	/** Obtenir la stratégie du joueur.
	 * @return la stratégie du joueur.
	 */
	public List<School> getPreference() {
		List<School> p = preference;
		return p;
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
    	return "Student " + this.nom;
    }
}
