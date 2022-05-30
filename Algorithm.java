package YourSchool;
import java.util.*;

public class Algorithm {

    /** Attribut d'un arbitre à visibilité privée.
     * Joueur 1.
     */
	private ArrayList<Student> students;

    /** Attribut d'un arbitre à visibilité privée.
     * Joueur 2.
     */
	private ArrayList<School> schools;

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
    Iterator<School> itr=schools.iterator();//getting the Iterator
    while(itr.hasNext()){//check if iterator has the elements
      System.out.println(itr.next().toString());
      System.out.println("Nombre de tours de l'algorithme : " + Nbtours);
    }
	}

  /*
  * Les écoles proposent des places aux élèves selon leur nombre de places.
  */
  public void Student2School(){
	Nbtours += 1;
    fini = true; //Le tri est considéré fini tant qu'un élève ne dit pas le contraire

    //Chaque étudiant fait une proposition à son école préférée actuelle
    Iterator<Student> itrStud=students.iterator();//getting the Iterator
    while(itrStud.hasNext()){
      Iterator<School> itrScho=schools.iterator();
      while(itrScho.hasNext()){
        if (itrStud.next().getactuelPreference() == itrScho.next().getNom()){
          Student2SchoolProposal(itrStud.next(), itrScho.next());
        }
      }
      //On vérifie si c'est fini (si chaque étudiant à une école qui l'a accepté)
      //Si un seul n'a pas d'école, ce ne sera pas fini tant que tous ses choix ne seront pas refusés (son choix n°5).
      if (itrStud.next().getAccepte() == null && itrStud.next().getactuelPreference() != itrStud.next().getPreferenceIndex(4) ){
        fini = false;
      }
    }

    //Si ce n'est pas fini, on refait un tour de demandes
    if (fini == false){
      Student2School();
    }
  }

  //Un élève se propose à une école
  public void Student2SchoolProposal(Student student, School school){
    int nbMax = school.getPlaces();
    if (school.getListeIndex(nbMax - 1) == null) { //Si il reste des places libres dans l'école
      school.addListe(student); //On ajoute l'étudiant dans la liste de l'école
      student.setAccepte(school); //On ajoute l'école à l'élève comme choix 1 qui l'a accepté
    } else { //Sinon on vérifie si l'élève peut prendre la place d'un autre
      int i = 0;
      Student competition = school.getListeIndex(i);
      while (school.getListeIndex(i) != null){
        if (school.getPreference().indexOf(competition) < school.getPreference().indexOf(school.getListeIndex(i))){
          competition = school.getListeIndex(i);
        }
        i += 1;
      } if (school.getPreference().indexOf(student) < school.getPreference().indexOf(competition)) {
        //On retire l'étudiant le moins bien classé
        school.removeListe(competition);
        Integer indexComp = competition.getPreference().indexOf(school.getNom()); //indice de l'école actuelle dans les préférences de l'élève
        competition.setactuelPreference(competition.getPreference().get(indexComp+1)); //On passe donc à l'école suivante
        competition.setAccepte(null);

        //On ajoute l'étudiant qui vient de faire sa demande
        school.addListe(student); //On ajoute l'étudiant dans la liste de l'école
        student.setAccepte(school); //On ajoute l'école à l'élève comme choix 1 qui l'a accepté
      } else { //Sinon on modifie la préférence actuelle de l'élève par le suivant
        Integer indexStud = student.getPreference().indexOf(school.getNom()); //indice de l'école actuelle dans les préférences de l'élève
        student.setactuelPreference(student.getPreference().get(indexStud+1)); //On passe donc à l'école suivante
      }
    }
  }

  /*
  * Les étudiants demandent une place à leur école favorite encore sur leur liste.
  */
  /*public void School2Student(){
    null;
  }*/

}
