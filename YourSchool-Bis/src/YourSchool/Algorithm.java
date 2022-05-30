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
	//private ArrayList<School> schoolsclone;

	/** Attribut d'un arbitre à visibilité privée.
     * Joueur 2.
     */
	private String WhoIsAsking;
	
	private int Nbtours;

  private Boolean fini;

	/** Construire un arbitre à partir de deux joueurs.
	 * @param j1 joueur
     * @param j2 joueur
	 */
	public Algorithm(ArrayList<Student> students, ArrayList<School> schools, String ask) {
		this.students = students;
		this.schools = schools;
		this.WhoIsAsking = ask;
		this.Nbtours = 0;
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
    
    //Une fois le tri fini, on affiche le résultat
    for (int i = 0; i < 7; i ++) {
    	System.out.println(schools.get(i) + " (" + schools.get(i).getPlaces() + ")" + " chose " + schools.get(i).getListe());
    }
    
    System.out.println("Nombre de tours de l'algorithme : " + Nbtours);
	}

  /*
  * Les écoles proposent des places aux élèves selon leur nombre de places.
  */
  public void Student2School(){
    fini = true; //Le tri est considéré fini tant qu'un élève ne dit pas le contraire

    //Chaque étudiant fait une proposition à son école préférée actuelle
    //Iterator<Student> itrStud=students.iterator();//getting the Iterator
    
    for (int s = 0; s < 25; s++) {
    	//System.out.println(students.get(s));

        //On vérifie si c'est fini (si chaque étudiant à une école qui l'a accepté)
        //Si un seul n'a pas d'école, ce ne sera pas fini tant que tous ses choix ne seront pas refusés (son choix n°5).
        if (students.get(s).getAccepte() == null && students.get(s).getactuelPreference() != students.get(s).getPreferenceIndex(4) ){
          fini = false;
          Student2SchoolProposal(students.get(s), students.get(s).getactuelPreference());
        }
    }
    
    /*Temporaire*/
    for (int i = 0; i < 7; i ++) {
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
	for (int s = 0; s < 7; s++)  {
		if (sch.equals(schools.get(s).getNom())) {
			school = schools.get(s);
		}
	}
	//System.out.println(school);
	  
    int nbMax = school.getPlaces();
    //System.out.println(nbMax);
    try {
    	if (school.getListeIndex(nbMax - 1) != null) {
    	      int i = 0;
    	      Student competition = school.getListeIndex(i);
      		  for (int z = 0; z < 7; z++) {
      			if (school.getPreference().indexOf(competition) < school.getPreference().indexOf(school.getListeIndex(i))){
      	          competition = school.getListeIndex(i);
      	        }
      		  }
    	      
    	      if (school.getPreference().indexOf(student) < school.getPreference().indexOf(competition)) {
    	        //On retire l'étudiant le moins bien classé
    	        school.removeListe(competition);
    	        Integer indexComp = competition.getPreference().indexOf(school.getNom()); //indice de l'école actuelle dans les préférences de l'élève
    	        competition.setactuelPreference(competition.getPreference().get(indexComp+1)); //On passe donc à l'école suivante
    	        //competition.setactuelPreference(indexComp + 1);
    	        competition.setAccepte(null);

    	        //On ajoute l'étudiant qui vient de faire sa demande
    	        school.addListe(student); //On ajoute l'étudiant dans la liste de l'école
    	        student.setAccepte(school); //On ajoute l'école à l'élève comme choix 1 qui l'a accepté
    	      } else { //Sinon on modifie la préférence actuelle de l'élève par le suivant
    	        Integer indexStud = student.getPreference().indexOf(school.getNom()); //indice de l'école actuelle dans les préférences de l'élève
    	        student.setactuelPreference(student.getPreference().get(indexStud+1)); //On passe donc à l'école suivante
    	      }
    	} else {
    		System.out.println("COUCOU");
    	}
    } catch (IndexOutOfBoundsException e) { //Si entre dans le catch, il reste de la place dans la liste
    	//System.out.println(school);
    	//System.out.println(student);
    	System.out.println("COUCOU2");
    	school.addListe(student); //On ajoute l'étudiant dans la liste de l'école
        student.setAccepte(school); //On ajoute l'école à l'élève comme choix 1 qui l'a accepté
    }
  }

  /*
  * Les étudiants demandent une place à leur école favorite encore sur leur liste.
  */
  /*public void School2Student(){
    null;
  }*/

}
