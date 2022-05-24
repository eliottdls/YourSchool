package YourSchool;

public class Student {

    /** Attribut d'un student à visibilité privée.
     * Nom de l'étudiant
     * (on considère que chaque étudiant à un nom unique -> le nom est un id)
     */
	private String nom;

  private Integer id;

    /** Attribut d'un joueur à visibilité privée.
     * Liste des écoles préférées de l'étudiant (liste ordonnée)
     * Un étudiant demande 5 écoles
     */
	private List<String> preference; //List<School>

  private String actuelPreference; //School

  private School accepte; //School

	/** Construire un joueur à partir de son nom et de sa strategie.
	 * @param nom nom du joueur
	 * @param strategie strategie du joueur
	 */
	public Student(String nom, Integer id, String vows) {
		assert nom != null;
		this.nom = nom;
    this.id = id;
    preference = new ArrayList<String>();
    preference.add(vows.split(","));
    actuelPreference = preference.get(0);
    accepte = null;
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

  public String getactuelPreference() {
    String a = actuelPreference;
    return a;
  }

  public School getAccepte() {
		School s = this.accepte;
		return s;
	}

  public void setAccepte(School school){
    this.accepte = school;
  }

  public void setactuelPreference(String school){
    this.actuelPreference = school;
  }

    /** Afficher le jeu.  Le jeu est affiché sous la forme :
     *
	 */
    public String toString() {
    	return "Student " + this.nom;
    }
}
