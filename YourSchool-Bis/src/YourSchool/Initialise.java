package YourSchool;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
		try (BufferedReader br = new BufferedReader(new FileReader("src/YourSchool/student_file.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				nbStud += 1;
				String[] studentsStrings = line.split(":");
				//Student test2 = new Student(studentsStrings[0], id, studentsStrings[1]);
				students.add(new Student(studentsStrings[0], studentsStrings[1])); //Liste des étudiants à envoyer à l'algorithme
			}
		}

		try (BufferedReader br = new BufferedReader(new FileReader("src/YourSchool/school_file.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	nbScho += 1;
				String[] schoolsStrings = line.split(":");
				//School test = new School(schoolsStrings[0], id, (integer)schoolsStrings[1], schoolsStrings[2]);
				ArrayList<Student> schoolpreference = new ArrayList<Student>();
				String[] schoolpref = schoolsStrings[2].split(",");
				int taille = schoolpref.length;
				
				for (int x = 0; x < taille; x++) {
					for (int s = 0; s < nbStud; s ++) {
						if (students.get(s).getNom().equals(schoolpref[x])) {
			    			schoolpreference.add(students.get(s));
					    }
					}
					
				}
				
				schools.add(new School(schoolsStrings[0], Integer.parseInt(schoolsStrings[1]), schoolpreference)); //Liste des écoles à envoyer à l'algorithme
		    }
		}

    //On demande à l'utilisateur qui doit faire les sérénades
    choix = serenades();

    //Fin de l'initialisation, on envoie les données à l'algorithme
    //System.out.println("Liste students (" + nbStud + ") : " + students);
    //System.out.println("Liste ecoles (" + nbScho + ") : " + schools);
    Algorithm algo = new Algorithm(students, schools, choix, nbScho, nbStud);
	algo.sorting();
	}

  public static String serenades(){
    Scanner clavier = new Scanner(System.in);
    System.out.println("Qui doit faire les sérénades ?");
    System.out.println("1 : Les étudiants");
    System.out.println("2 : Les écoles");
    try {
    	int choix = clavier.nextInt();
        switch(choix) {
          case 1:
            return "students";
          case 2:
            return "schools";
          default:
            System.out.println("Choix incorrect, veuillez choisir '1' ou '2'");
            return serenades();
        }
    }catch (InputMismatchException e) {
    	System.out.println("Veuillez rentrer un nombre");
        return serenades();
    }
    
    }

    
  }
