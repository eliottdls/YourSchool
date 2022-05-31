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
	
	private ArrayList<Student> actuel_preference;

	private ArrayList<Student> liste;

	/*
	* Nombre de places dans l'école
	*/
	private Integer places;
	
	private Boolean fini;

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
		liste = new ArrayList<Student>();
	    this.fini = false;
	    actuel_preference = new ArrayList<Student>();
	    //On crée les préférences actuelles d'une école avec les premiers étudiants de sa liste, dans la limite des places disponibles
	    for (int i = 0; i < schoolsStrings; i++) {
	    	actuel_preference.add(preference.get(i));
	    }
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
	
	/*public int getNbPreference(Student stud) {
		
	}*/

	public Integer getPlaces(){
		Integer n = this.places;
		return n;
	}
	
	public ArrayList<Student> getListe(){
		ArrayList<Student> l = liste;
		return l;
	}
	
	public int getIndexStudent(Student stud) {
		for (int i = 0; i < preference.size(); i++) {
			if( preference.get(i) == stud) {
				return i;
			}
		}
		System.out.println("ERREUR");
		return 1000;
	}
	
	/*public int getIndexStudent(Student stud) {
		for (int i = 0; i < liste.size(); i++) {
			if( preference.get(i) == stud) {
				return i;
			}
		}
		System.out.println("ERREUR");
		return 1000;
	}*/
	
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
	
	public boolean getFini() {
		  return fini;
	  }
	  
	  public void setFiniTrue() {
		  this.fini = true;
	  }
	  
	  public void setFiniFalse() {
		  this.fini = false;
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

	public ArrayList<Student> getactuelPreference() {
		ArrayList<Student> p = actuel_preference;
		return p;
	}
	
	public Student getactuelPreferenceIndex(int index) {
		Student s = actuel_preference.get(index);
		return s;
	}
}
