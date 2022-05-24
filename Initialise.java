package YourSchool;


public class Initialise {

	/** Initialise les étudiants et écoles et choisit le type de sérénade.
  *
	 */
	public static void main(String[] args) {

    //Initialisation des listes
    List<Student> schools = new ArrayList<Student>();
    List<School> students = new ArrayList<School>();
    String choix; //Qui fait les demande

    //Réception des fichiers, + découpe
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
	    while ((line = br.readLine()) != null) {
				String[] schoolsStrings = decoupe(line);
				School schoolsStrings[0] = new School(schoolsStrings[0], i, schoolsStrings[1], schoolsStrings[2]);
				schools.add(schoolsStrings[0]); //Liste des écoles à envoyer à l'algorithme
	    }
		}
		//int i = 1;
    //for (CHAQUE LIGNE DE SCHOOLS) {
    //    String[] schoolsStrings = decoupe(FICHIER_ECOLES_LIGNE1);
    //    School schoolsStrings[0] = new School(schoolsStrings[0], i, schoolsStrings[1], schoolsStrings[2]);
    //    i += 1;
    //    schools.add(schoolsStrings[0]); //Liste des écoles à envoyer à l'algorithme
    //}
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
	    while ((line = br.readLine()) != null) {
				String[] studentsStrings = decoupe(line);
				Student studentsStrings[0] = new Student(studentsStrings[0], y, studentsStrings[1]);
		    students.add(studentsStrings[0]); //Liste des étudiants à envoyer à l'algorithme
	    }
		}
    //int y = 1;
    //for (CHAQUE LIGNE DE STUDENTS) {
    //    String[] studentsStrings = decoupe(FICHIER_students_LIGNE1);
    //    Student studentsStrings[0] = new Student(studentsStrings[0], y, studentsStrings[1]);
    //    y += 1;
    //    students.add(studentsStrings[0]); //Liste des étudiants à envoyer à l'algorithme
    //}

    //On demande à l'utilisateur qui doit faire les sérénades
    choix = serenades();

    //Fin de l'initialisation, on envoie les données à l'algorithme
    Algorithm algo = new Algorithm(students, schools, choix);

	}

	/** Sépare un mot donné en paramètre selon les @ qu'il contient.
	 * @param mot mot séléctionné
	 * @return les différents éléments de 'mot' créés
	 */
	public static String[] decoupe(String mot) {
		return mot.split(":");
	}

  public String serenades(){
    Scanner clavier = new Scanner(System.in);
    System.out.println("Qui doit faire les sérénades ? 1 : Students ou 2 : Schools");
    String choix = clavier.nextInt();
    switch(choix) {
      case 1:
        return "students";
      case 2:
        return "schools";
      default:
        System.out.println("Choix incorrect, on recommence :");
        return serenades();
    }

  }

}
