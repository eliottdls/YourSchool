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
    int nbScho = 0;
    int nbStud = 0;;

    //Réception des fichiers, + découpe
		int id = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("src/YourSchool/student_file1.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				nbStud += 1;
				String[] studentsStrings = line.split(":");
				//Student test2 = new Student(studentsStrings[0], id, studentsStrings[1]);
				students.add(new Student(studentsStrings[0], id, studentsStrings[1])); //Liste des étudiants à envoyer à l'algorithme
			}
		}

		try (BufferedReader br = new BufferedReader(new FileReader("src/YourSchool/school_file1.txt"))) {
		    String line;
		    id = 0;
		    while ((line = br.readLine()) != null) {
		    	nbScho += 1;
				String[] schoolsStrings = line.split(":");
				//School test = new School(schoolsStrings[0], id, (integer)schoolsStrings[1], schoolsStrings[2]);
				ArrayList<Student> schoolpreference = new ArrayList<Student>();
				String[] schoolpref = schoolsStrings[2].split(",");
				int taille = schoolpref.length;
				
				for (int x = 0; x < taille; x++) {
					//System.out.println("X " + schoolpref[x]);
					for (int s = 0; s < nbStud; s ++) {
						if (students.get(s).getNom().equals(schoolpref[x])) {
			    			schoolpreference.add(students.get(s));
					    }
					}
					
				}
				
				schools.add(new School(schoolsStrings[0], id, Integer.parseInt(schoolsStrings[1]), schoolpreference)); //Liste des écoles à envoyer à l'algorithme
				id += 1;
		    }
		}

    //On demande à l'utilisateur qui doit faire les sérénades
    choix = serenades();

    //Fin de l'initialisation, on envoie les données à l'algorithme
    System.out.println("Liste students (" + nbStud + ") : " + students);
    System.out.println("Liste ecoles (" + nbScho + ") : " + schools);
    Algorithm algo = new Algorithm(students, schools, choix, nbScho, nbStud);
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
