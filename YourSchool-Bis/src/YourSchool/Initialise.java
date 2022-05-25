package YourSchool;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Initialise {

	/** Initialise les étudiants et écoles et choisit le type de sérénade.
	 * @throws IOException
	 * @throws FileNotFoundException
  *
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

    //Initialisation des listes
    ArrayList<School> schools = new ArrayList<School>();
    ArrayList<Student> students = new ArrayList<Student>();
    String choix; //Qui fait les demande

    //Réception des fichiers, + découpe
		int id = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("src/YourSchool/student_file.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] studentsStrings = line.split(":");
				//Student test2 = new Student(studentsStrings[0], id, studentsStrings[1]);
				students.add(new Student(studentsStrings[0], id, studentsStrings[1])); //Liste des étudiants à envoyer à l'algorithme
			}
		}

		try (BufferedReader br = new BufferedReader(new FileReader("src/YourSchool/school_file.txt"))) {
		    String line;
		    id = 0;
		    while ((line = br.readLine()) != null) {
				String[] schoolsStrings = line.split(":");
				//School test = new School(schoolsStrings[0], id, (integer)schoolsStrings[1], schoolsStrings[2]);
				ArrayList<Student> schoolpreference = new ArrayList<Student>();
				String[] schoolpref = schoolsStrings[2].split(",");

				Iterator<Student> itr=students.iterator();//getting the Iterator
			    while(itr.hasNext()){//check if iterator has the elements
			    	for (int x = 0; x<5; x++) {
			    		if (itr.next().getNom() == schoolpref[x]) {
			    			schoolpreference.add(itr.next());
					    }
			    	}
			    }
				schools.add(new School(schoolsStrings[0], id, Integer.parseInt(schoolsStrings[1]), schoolpreference)); //Liste des écoles à envoyer à l'algorithme
				id += 1;
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
    System.out.println("Liste students : " + students);
    System.out.println("Liste ecoles : " + schools);
    Algorithm algo = new Algorithm(students, schools, choix);
    System.out.println("YOUHOU");
	algo.sorting();
	}

  public static String serenades(){
    Scanner clavier = new Scanner(System.in);
    System.out.println("Qui doit faire les sérénades ? 1 : Students ou 2 : Schools");
    int choix = clavier.nextInt();
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
