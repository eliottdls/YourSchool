package YourSchool;
import java.util.*;

public class Algorithm {

    /** Attribut d'un arbitre à visibilité privée.
     * Joueur 1.
     */
	private ArrayList<Student> students;
	//private ArrayList<Student> studentsclone;

    /** Attribut d'un arbitre à visibilité privée.
     * Joueur 2.
     */
	private ArrayList<School> schools;
	
	private ArrayList<Student> studentsWhithoutSchool;
	//private ArrayList<School> schoolsclone;

	/** Attribut d'un arbitre à visibilité privée.
     * Joueur 2.
     */
	private String WhoIsAsking;
	
	private int Nbtours;

	private Boolean fini;
	
	private int nbSchools, nbStudents;
	
	/** Construire un arbitre à partir de deux joueurs.
	 * @param j1 joueur
     * @param j2 joueur
	 */
	public Algorithm(ArrayList<Student> students, ArrayList<School> schools, String ask, int nbScho, int nbStud) {
		this.students = students;
		this.schools = schools;
		this.WhoIsAsking = ask;
		this.Nbtours = 1;
		this.nbSchools = nbScho;
		this.nbStudents = nbStud;
		this.studentsWhithoutSchool = new ArrayList<Student>();
	}

   /** Mise en oeuvre de l'algorithme de tri.
	*/
	public void sorting() {
    if (WhoIsAsking == "students") {
      Student2School();
    } else if (WhoIsAsking == "schools") {
      //School2Student();
      System.out.println("A FAIRE");
    }
    
    System.out.println();
    System.out.println("		FINAL RESULT");
    //Une fois le tri fini, on affiche le résultat
    for (int i = 0; i < nbSchools; i ++) {
    	System.out.println(schools.get(i) + " (" + schools.get(i).getPlaces() + ")" + " chose " + schools.get(i).getListe());
    }
    /*for (int v = 0; v < nbSchools; v ++) {
    	if (students.get(v).getAccepte() = NULL) {
    		
    	}
    }*/
    
    System.out.println("Students whithout school : " + studentsWhithoutSchool );
    System.out.println("Nombre de tours de l'algorithme : " + Nbtours);
	}

  /*
  * Les écoles proposent des places aux élèves selon leur nombre de places.
  */
  public void Student2School(){
    fini = true; //Le tri est considéré fini tant qu'un élève ne dit pas le contraire

    //Chaque étudiant fait une proposition à son école préférée actuelle
    //Iterator<Student> itrStud=students.iterator();//getting the Iterator
    
    for (int s = 0; s < nbStudents; s++) {
        if (students.get(s).getFini() == false) {
            Student2SchoolProposal(students.get(s), students.get(s).getactuelPreference());
        }
    }

    //On vérifie si c'est fini (si chaque étudiant à une école qui l'a accepté)
    //Si un seul n'a pas d'école, ce ne sera pas fini tant que tous ses choix ne seront pas refusés (son choix n°5).
    for (int s = 0; s < nbStudents; s++) {
    	if (students.get(s).getFini() == false) {
    		fini = false;
    	}
    }

    /*Temporaire*/
    for (int i = 0; i < nbSchools; i ++) {
    	System.out.println(schools.get(i) + " (" + schools.get(i).getPlaces() + ")" + " chose " + schools.get(i).getListe());
    }
    System.out.println("Nombre de tours de l'algorithme : " + Nbtours);
    System.out.println("----------------------------------------------");
    /* Fin temporaire */
    
    
    //Si ce n'est pas fini, on refait un tour de demandes
    if (fini == false){
      Nbtours += 1;
      Student2School();
    }
  }

  //Un élève se propose à une école
  public void Student2SchoolProposal(Student student, String sch){
	//On récupère l'école
	School school = null;
	for (int s = 0; s < nbSchools; s++)  {
		if (sch.equals(schools.get(s).getNom())) {
			school = schools.get(s);
		}
	}
	  
    int nbMax = school.getPlaces();
        if (school.getListe().size() == nbMax) {
        	
        	Student competition = school.getListeIndex(0);
        	  for (int z = 1; z < school.getListe().size(); z++) {
        		  System.out.println(school.getListeIndex(z) + " est classé " + school.getIndexStudent(school.getListeIndex(z)) + " dans " + school);
        		  if (school.getIndexStudent(school.getListeIndex(z)) < school.getIndexStudent(competition)) {
        			  competition = school.getListeIndex(z);
        		  }
        	  }
        	  
    	      //System.out.println(competition + " est en compet avec " + student);
    	      if (school.getPreference().indexOf(student) < school.getPreference().indexOf(competition)) {
    	        //On retire l'étudiant le moins bien classé
    	        school.removeListe(competition);
    	        Integer indexComp = competition.getPreference().indexOf(school.getNom()); //indice de l'école actuelle dans les préférences de l'élève
    	        competition.setactuelPreference(competition.getPreference().get(indexComp+1)); //On passe donc à l'école suivante
    	        //competition.setactuelPreference(indexComp + 1);
    	        competition.setAccepte(null);
    	        competition.setFiniFalse();
    	        //On ajoute l'étudiant qui vient de faire sa demande
    	        school.addListe(student); //On ajoute l'étudiant dans la liste de l'école
    	        student.setAccepte(school); //On ajoute l'école à l'élève comme choix 1 qui l'a accepté
    	        student.setFiniTrue();
    	      } else { //Sinon on modifie la préférence actuelle de l'élève par le suivant
    	        Integer indexStud = student.getPreference().indexOf(school.getNom()); //indice de l'école actuelle dans les préférences de l'élève
    	        if (student.getactuelPreference().equals(student.getPreferenceIndex(student.getNbVoeux() - 1))){
    	        	System.out.println(student + " fini sans école");
    	        	studentsWhithoutSchool.add(student);
    	        	student.setFiniTrue();
    	        } else {
        	        student.setactuelPreference(student.getPreference().get(indexStud+1)); //On passe donc à l'école suivante
    	        }
    	      }
    	}
        else {
        	school.addListe(student); //On ajoute l'étudiant dans la liste de l'école
        	student.setAccepte(school); //On ajoute l'école à l'élève comme choix 1 qui l'a accepté
        	student.setFiniTrue();
        }
  }

  /*
  * Les étudiants demandent une place à leur école favorite encore sur leur liste.
  */
  /*public void School2Student(){
    null;
  }*/

}
