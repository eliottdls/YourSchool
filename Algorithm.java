package YourSchool;

public class Algorithm {

    /** Attribut d'un arbitre à visibilité privée.
     * Joueur 1.
     */
	private List<Student> students;

    /** Attribut d'un arbitre à visibilité privée.
     * Joueur 2.
     */
	private List<School> schools;

	/** Attribut d'un arbitre à visibilité privée.
     * Joueur 2.
     */
	private String WhoIsAsking;

	/** Construire un arbitre à partir de deux joueurs.
	 * @param j1 joueur
     * @param j2 joueur
	 */
	public Algorithm(List<Student> students, List<School> schools, String ask) {
		this.students = students;
		this.schools = schools;
		this.WhoIsAsking = ask;
	}

   /** Mise en oeuvre de l'algorithme de tri.
	*/
	public void sorting() {
    if (WhoIsAsking == "students") {
      Student2School();
    } else if (WhoIsAsking == "schools") {
      School2Student();
    }
	}

  /*
  * Les écoles proposent des places aux élèves selon leur nombre de places.
  */
  public void Student2School(){

  }

  /*
  * Les étudiants demandent une place à leur école favorite encore sur leur liste.
  */
  public void School2Student(){

  }


}
