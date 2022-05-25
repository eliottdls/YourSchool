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
	public School(String nom, int id, int schoolsStrings, ArrayList<Student> schoolsStrings2) {
		assert nom != null;
		this.nom = nom;
		this.id = id;
		this.places = schoolsStrings;
		this.preference = schoolsStrings2;
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
	
	public ArrayList<Student> getListe(){
		ArrayList<Student> l = liste;
		return l;
	}
	
	public Student getListeIndex(int index){
		Student s = liste.get(index);
		return s;
	}
	
	public void addListe(Student stud){
		liste.add(stud);
	}
	
	public void removeListe(Student stud){
		liste.remove(stud);
	}

    /** Afficher le jeu.  Le jeu est affiché sous la forme :
     *
	 */
    /*public String toString() {
    	//return "School " + this.nom + " accepted " + this.liste.toArray();
    }*/
	public String toString() {
    	return "School " + this.nom;
    }
}
