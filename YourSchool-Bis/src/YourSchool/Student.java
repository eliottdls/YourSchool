package YourSchool;
import java.util.*;

public class Student {

  //Attributs d'un étudiant
  private String nom; //Nom de l'étudiant
  private ArrayList<String> preference; //Liste des écoles par ordre de préférence
  private String actuelPreference; //L'école à qui demander
  private School accepte; //Ecole actuelle qui l'a accepté
  private int nbVoeux; //Nombre de voeux d' l'étudiants
  private Boolean fini; //Si l'étudiant a fini


	// Constructeur d'un étudiant
	public Student(String nom, String vows) {
	assert nom != null;
	this.nom = nom;
    preference = new ArrayList<String>();
    String[] voeux = vows.split(",");
    this.nbVoeux = voeux.length;
    for (int i = 0; i < voeux.length; i++) {
        preference.add(voeux[i]);
    }
    this.actuelPreference = preference.get(0);
    this.accepte = null;
    this.fini = false;
	}

	public String getNom() {
		String n = this.nom;
		return n;
	}

	public ArrayList<String> getPreference() {
		ArrayList<String> p = preference;
		return p;
	}
	
	public String getPreferenceIndex(int index) {
		String school = preference.get(index);
		return school;
	}
	
	public int getPreferencePlace(School school) {
		for (int i = 0; i < preference.size(); i++) {
			if (preference.get(i).equals(school.getNom())) {
				return i;
			}
		}
		System.out.println("ERREUR DANS STUDENT");
		return 1000;
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
}
