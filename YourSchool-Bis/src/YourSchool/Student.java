package YourSchool;
import java.util.*;

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
  private ArrayList<String> preference; //List<School>

  private String actuelPreference; //School

  private School accepte; //School
  
  private int nbVoeux;

	/** Construire un joueur à partir de son nom et de sa strategie.
	 * @param nom nom du joueur
	 * @param strategie strategie du joueur
	 */
	public Student(String nom, Integer id, String vows) {
		assert nom != null;
		this.nom = nom;
    this.id = id;
    preference = new ArrayList<String>();
    String[] voeux = vows.split(",");
    this.nbVoeux = voeux.length;
    for (int i = 0; i < voeux.length; i++) {
        preference.add(voeux[i]);
    }
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
	public ArrayList<String> getPreference() {
		ArrayList<String> p = preference;
		return p;
	}
	
	public String getPreferenceIndex(int index) {
		String school = preference.get(index);
		return school;
	}

  public String getactuelPreference() {
    String a = actuelPreference;
    return a;
  }

  public School getAccepte() {
		School s = this.accepte;
		return s;
	}
  
  public int getNbVoeux() {
	  int n = this.nbVoeux;
	  return n;
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
