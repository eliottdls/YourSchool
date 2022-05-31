package YourSchool;
import java.util.*;

public class School {

    /** Attribut d'une école à visibilité privée.
     * Nom de l'école
		 * (on considère que chaque école à un nom unique -> le nom est un id)
     */
	private String nom;

    /** Attribut d'une école
     * Tous les étudiants qui demandent l'école sont classés dans l'ordre de choix de l'école
     */
	private ArrayList<Student> preference; //List<Student>
	
	private ArrayList<Student> actuel_preference;
	private ArrayList<Student> actuel_preference_apres_refus;


	private ArrayList<Student> liste;
	
	private int dernierRefus; //La place du dernier élève qui a refusé

	/*
	* Nombre de places dans l'école
	*/
	private Integer places;
	
	private Boolean fini;

	/** Construire un joueur à partir de son nom et de sa strategie.
	 * @param nom nom du joueur
	 * @param strategie strategie du joueur
	 */
	public School(String nom, int places, ArrayList<Student> schoolsStrings2) {
		assert nom != null;
		this.nom = nom;
		this.places = places;
		this.preference = schoolsStrings2;
		liste = new ArrayList<Student>();
	    this.fini = false;
	    actuel_preference = new ArrayList<Student>();
	    //On crée les préférences actuelles d'une école avec les premiers étudiants de sa liste, dans la limite des places disponibles
	    for (int i = 0; i < places; i++) {
	    	actuel_preference.add(preference.get(i));
	    }
	    actuel_preference_apres_refus = actuel_preference;
	    this.dernierRefus = -1;
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
	
	public Student getPreferenceIndex(int index) {
		Student s = preference.get(index);
		return s;
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
	
	public int getPreferencePlace(Student student) {
		for (int i = 0; i < preference.size(); i++) {
			if( preference.get(i) == student) {
				return i;
			}
		}
		System.out.println(" ERREUR SCHOOL ");
		return 1000;
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
    	return this.nom;
    }

	public ArrayList<Student> getactuelPreference() {
		ArrayList<Student> p = actuel_preference;
		return p;
	}
	
	public Student getactuelPreferenceIndex(int index) {
		Student s = actuel_preference.get(index);
		return s;
	}
	
	
	public void setactuelPreference(Student student) {
		actuel_preference.add(student);
	}
	
	/*public void setactuelPreference(Student student) {
		actuel_preference.add(student);
	}*/
	
	public ArrayList<Student> getactuel_preference_apres_refus() {
		ArrayList<Student> p = actuel_preference_apres_refus;
		return p;
	}
	
	public void resetactuel_preference_apres_refus() {
		actuel_preference_apres_refus = actuel_preference;
	}
	
	public void resetactuel_preference() {
		actuel_preference = actuel_preference_apres_refus;
	}
	
	public void removeactuel_preference_apres_refus(Student student) {
		actuel_preference_apres_refus.remove(student);
	}

	
	public void removeactuelPreference(int index) {
		actuel_preference.add(index, null);
	}
	
	/*public void removeactuelPreference(Student student) {
		for (int i = 0; i < actuel_preference.size(); i++) {
			if (actuel_preference.get(i) == student ) {
				actuel_preference.add(i, null);
			}
		}
	}*/
	
	/*public void removeactuelPreferenceNull(int index) {
		actuel_preference.remove(index);
	}*/
	
	public int getDernierRefus() {
		int p = dernierRefus;
		return p;
	}
	
	public void setDernierRefus(int place) {
		dernierRefus = place;
	}
}
