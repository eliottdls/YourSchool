package YourSchool;
import java.util.*;

public class Algorithm {

    //Attributs de l'algorithme
	private ArrayList<Student> students; //Liste de tous les étudiants
	private ArrayList<School> schools; //Liste de toutes les écoles
	private ArrayList<Student> studentsWhithoutSchool; //Liste des étudiants qui finissent sans école
	private String WhoIsAsking; //Définit si l'algorithme fait (écoles proposent aux élèves) ou (élèves proposent aux écoles)
	private int Nbtours; //Nombre de tours que prend l'algorithme pour faire la répartition
	private Boolean fini; //Définit si l'algorithme a fini la répartition
	private int nbSchools, nbStudents; //Le nombre d'écoles et le nombre d'étudiants
	
	// Constructeur de l'algorithme
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
      School2Student();
    }
    
    //Une fois le tri fini, on affiche le résultat
    System.out.println();
    System.out.println("----------------------------------------------");
    System.out.println("		RESULTAT FINAL");
    System.out.println("----------------------------------------------");
    System.out.println("Liste des étudiants (" + nbStudents + ") : " + students);
    System.out.println("Liste  des écoles (" + nbSchools + ") : " + schools);
    System.out.println("----------------------------------------------");
    System.out.println("Nom école	Nombre de places  Places restantes			Etudiants acceptés");
    for (int i = 0; i < nbSchools; i ++) {
    	System.out.println(schools.get(i) + "		 " + schools.get(i).getPlaces() + "		" + (schools.get(i).getPlaces() - schools.get(i).getListe().size())  + "		" + schools.get(i).getListe());
    }

    System.out.println("----------------------------------------------");
    System.out.println("Etudiants sans école : " + studentsWhithoutSchool );
    System.out.println("Nombre de tours de l'algorithme : " + Nbtours);
    System.out.println("----------------------------------------------");
	}
    


  /*
  * Les écoles proposent des places aux élèves selon leur nombre de places.
  */
  public void Student2School(){
    fini = true; //Le tri est considéré fini tant qu'un élève ne dit pas le contraire

    //Chaque étudiant fait une proposition à son école préférée actuelle    
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

    /*Affichage des tours temporaires*/
    /*for (int i = 0; i < nbSchools; i ++) {
    	System.out.println(schools.get(i) + " (" + schools.get(i).getPlaces() + ")" + " chose " + schools.get(i).getListe());
    }*/
    System.out.println("----------------------------------------------");
    System.out.println();
    System.out.println("----------------------------------------------");
    System.out.println("		RESULTAT TOUR " + Nbtours);
    System.out.println("----------------------------------------------");
    System.out.println("Liste des étudiants (" + nbStudents + ") : " + students);
    System.out.println("Liste  des écoles (" + nbSchools + ") : " + schools);
    System.out.println("----------------------------------------------");
    System.out.println("Nom école	Nombre de places  Places restantes			Etudiants acceptés");
    for (int i = 0; i < nbSchools; i ++) {
    	System.out.println(schools.get(i) + "		 " + schools.get(i).getPlaces() + "		" + (schools.get(i).getPlaces() - schools.get(i).getListe().size())  + "		" + schools.get(i).getListe());
    }
    /* Fin Affichage des tours temporaires */
    
    
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
        		  if (school.getPreferencePlace(school.getListeIndex(z)) > school.getPreferencePlace(competition)) {
        			  competition = school.getListeIndex(z);
        		  }
        	  }
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
  public void School2Student(){
	  fini = true; //Le tri est considéré fini tant qu'une école ne dit pas le contraire

	    //Chaque école fait une proposition à ses étudiants préférés actuels
	    
	    for (int s = 0; s < nbSchools; s++) {
	        if (schools.get(s).getFini() == false) {
	            School2StudentProposal(schools.get(s), schools.get(s).getactuelPreference());
	        }
	    }
	    
	    //On met à jour les listes de préférence de toutes les écoles
    	//On obtient la place du dernier de la liste de préférences actuelle
	    for (int sc = 0; sc < nbSchools; sc++) {
	    	School school = schools.get(sc);
	    	//school.resetactuel_preference();

	    	int placeDernier = 0;
	    	for (int u = 0; u < school.getactuelPreference().size(); u++) {
	    		if (school.getPreferencePlace(school.getactuelPreferenceIndex(u)) > placeDernier) {
	    			placeDernier = school.getPreferencePlace(school.getactuelPreferenceIndex(u));
	    		}
	    	}
	    	 		
		   	//On met à jour la liste de préférences en remplaçant les parties nulles
	    	int i = 1;
		   	while (school.getactuelPreference().size() < school.getPlaces()) {
		   		if (school.getDernierRefus() > placeDernier) {
			   		school.setactuelPreference(school.getPreferenceIndex(school.getDernierRefus() + i));
			   		i += 1;
		   		} else {
		   			school.setactuelPreference(school.getPreferenceIndex(placeDernier + 1));
		   			placeDernier += 1;
		   		}		   		
	   		}
		   	//System.out.println("ATTENTION : " + (school.getPreference().size() - 1) + " et " + school.getDernierRefus());
		   	if (school.getPreference().size() - 1 == school.getDernierRefus()) {
		   		//Alors l'école fini avec de la place libre
		   		school.setFiniTrue();
		   	}
	   		school.resetactuel_preference_apres_refus();
	   	}
    	//------------------------------------------
	    
	    
	    //On vérifie si c'est fini (si chaque école a rempli sa liste d'acceptance ou si elles ont proposé à tous les élèves de leur liste)
	    for (int s = 0; s < nbSchools; s++) {
	    	if (schools.get(s).getFini() == false) {
	    		fini = false;
	    	}
	    }

	    /*Affichage des tours temporaires*/
	    System.out.println("----------------------------------------------");
	    System.out.println();
	    System.out.println("----------------------------------------------");
	    System.out.println("		RESULTAT TOUR " + Nbtours);
	    System.out.println("----------------------------------------------");
	    System.out.println("Liste des étudiants (" + nbStudents + ") : " + students);
	    System.out.println("Liste  des écoles (" + nbSchools + ") : " + schools);
	    System.out.println("----------------------------------------------");
	    System.out.println("Nom école	Nombre de places  Places restantes			Etudiants acceptés");
	    for (int i = 0; i < nbSchools; i ++) {
	    	System.out.println(schools.get(i) + "		 " + schools.get(i).getPlaces() + "		" + (schools.get(i).getPlaces() - schools.get(i).getListe().size())  + "		" + schools.get(i).getListe() + "		" + schools.get(i).getFini());
	    }
	    /* Affichage des tours temporaires */
	    
	    //Si ce n'est pas fini, on refait un tour de demandes
	    if (fini == false){
	      Nbtours += 1;
	      School2Student();
	    }
	  
  }
  
  public void School2StudentProposal(School school, ArrayList<Student> actuel_preference) {
	  	school.resetactuel_preference_apres_refus();
	    	int nbMax = school.getPlaces();
	        //Sinon on demande aux élèves de la liste actuelle de préférences
	        if (school.getListe().size() < nbMax) {
	        	//Pour chaque élève de la liste de souhaits
	        	for (int i = 0; i < school.getactuelPreference().size(); i++) {
	        		Student etudiant = school.getactuelPreferenceIndex(i);
	        		School accepteParEleve = etudiant.getAccepte();
	        		//Si l'élève n'a pas déjà accepté la demande de l'école (sinon on fait rien)
        			//System.out.println(etudiant + " : (" + school.getPlaces() + ") " + school + " et " + accepteParEleve);

	        		if (accepteParEleve != school) {
	        			if (accepteParEleve == null || etudiant.getPreferencePlace(school) < etudiant.getPreferencePlace(accepteParEleve)) {
	        				//Alors l'élève accepte cette école
	        				etudiant.setAccepte(school);
	        				school.addListe(etudiant);
	        				//On retire l'étudiant de la liste de l'autre école
	        				if (accepteParEleve != null) {
	        					//Il le retirera lui-même
	        					accepteParEleve.removeactuel_preference_apres_refus(etudiant);
	        					accepteParEleve.resetactuel_preference();
	        					//accepteParEleve.removeactuelPreference(accepteParEleve.getactuelPreferencePlace(etudiant));
		        				accepteParEleve.removeListe(etudiant);
		        				accepteParEleve.setFiniFalse();
	        				}
	        			} else { //Si l'élève refuse l'école
		        			if (school.getPreferencePlace(etudiant) > school.getDernierRefus()){
		        				school.setDernierRefus(school.getPreferencePlace(etudiant));
		        			}
	        				school.removeactuel_preference_apres_refus(etudiant);
	        			}
	        		}
	        	}
	        	school.resetactuel_preference();
	        }
	        
	        //Si l'école a rempli sa liste d'acceptance
	        if (school.getListe().size() == school.getPlaces()) {
	        	school.setFiniTrue();
	        }
  }
}
