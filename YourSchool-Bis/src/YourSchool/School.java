package YourSchool;
import java.util.*;

public class School {

	// Attributs d'une école
	private String nom;
	private ArrayList<Student> preference; //Liste des étudiants classés
	private ArrayList<Student> actuel_preference; //Demandes actuelles
	private ArrayList<Student> actuel_preference_apres_refus; //Demande actuelles
	private ArrayList<Student> liste; //Liste des étudiants acceptés
	private int dernierRefus; //La place du dernier élève qui a refusé
	private Integer places;	//Nombre de places dans l'école
	private Boolean fini; //Si l'école a fini

	//Constructeur d'une école
	public School(String nom, int places, ArrayList<Student> schoolsStrings2) {
		assert nom != null;
		this.nom = nom;
		this.places = places;
		this.preference = schoolsStrings2;
		liste = new ArrayList<Student>();
	    this.fini = false;
	    actuel_preference = new ArrayList<Student>();
	    actuel_preference_apres_refus = new ArrayList<Student>();
	    //On crée les préférences actuelles d'une école avec les premiers étudiants de sa liste, dans la limite des places disponibles
	    for (int i = 0; i < places; i++) {
	    	actuel_preference.add(preference.get(i));
		    actuel_preference_apres_refus.add(preference.get(i));
	    }
	    this.dernierRefus = -1;
	}

	public String getNom() {
		String j = this.nom;
		return j;
	}

	public ArrayList<Student> getPreference() {
		ArrayList<Student> l = preference;
		return l;
	}
	
	public Student getPreferenceIndex(int index) {
		Student s = preference.get(index);
		return s;
	}

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
	
	public ArrayList<Student> getactuel_preference_apres_refus() {
		ArrayList<Student> p = actuel_preference_apres_refus;
		return p;
	}
	
	public void resetactuel_preference_apres_refus() {
		for (int i = actuel_preference_apres_refus.size() - 1; i >= 0; i--) {
			actuel_preference_apres_refus.remove(i);
		}
		for (int x = 0; x < actuel_preference.size(); x++) {
			actuel_preference_apres_refus.add(actuel_preference.get(x));
		}
	}
	
	public void resetactuel_preference() {
		for (int i = actuel_preference.size() - 1; i >= 0; i--) {
			actuel_preference.remove(i);
		}
		for (int x = 0; x < actuel_preference_apres_refus.size(); x++) {
			actuel_preference.add(actuel_preference_apres_refus.get(x));
		}
	}
	
	public void removeactuel_preference_apres_refus(Student student) {
		actuel_preference_apres_refus.remove(student);
	}

	
	public void removeactuelPreference(int index) {
		actuel_preference.add(index, null);
	}
	
	public int getDernierRefus() {
		int p = dernierRefus;
		return p;
	}
	
	public void setDernierRefus(int place) {
		dernierRefus = place;
	}
}
