package YourSchool;
import java.util.*;

public class School {

    /** Attribut d'une école à visibilité privée.
     * Nom de l'école
		 * (on considère que chaque école à un nom unique -> le nom est un id)
     */
	private String nom;

	private Integer id;

    /** Attribut d'une école
     * Tous les étudiants qui demandent l'école sont classés dans l'ordre de choix de l'école
     */
	private ArrayList<Student> preference; //List<Student>

	private ArrayList<Student> liste;

	/*
	* Nombre de places dans l'école
	*/
	private Integer places;

	/** Construire un joueur à partir de son nom et de sa strategie.
	 * @param nom nom du joueur
	 * @param strategie strategie du joueur
	 */
	public School(String nom, Integer id, Integer nb, String preference) {
		assert nom != null;
		this.nom = nom;
		this.id = id;
		this.places = nb;
		preference = new ArrayList<String>();
		preference.add(preference.split(","));
		liste = new ArrayList<String>();
		/*for (int i = 0; i < nb: i++){
			liste.add(preference.get(i));
		}*/
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
	public ArrayList<Student> getPreference() {
		ArrayList<Student> l = preference;
		return l;
	}

	public Integer getPlaces(){
		Integer n = this.places;
		return n;
	}

    /** Afficher le jeu.  Le jeu est affiché sous la forme :
     *
	 */
    public String toString() {
    	return "School " + this.nom;
    }
}
