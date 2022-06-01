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
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

    //Initialisation des listes
    ArrayList<School> schools = new ArrayList<School>();
    ArrayList<Student> students = new ArrayList<Student>();
    String choix; //Qui fait les demande
    int nbScho = 0;
    int nbStud = 0;
    //String etudiants = "src/YourSchool/student_file.txt";
    //String ecoles = "src/YourSchool/school_file.txt";
    
    //On demande à l'utilisateur s'il veut utiliser d'autres fichiers
    //fichiers();

    //Réception des fichiers, + découpe
		try (BufferedReader br = new BufferedReader(new FileReader("src/YourSchool/student_file.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				nbStud += 1;
				String[] studentsStrings = line.split(":");
				students.add(new Student(studentsStrings[0], studentsStrings[1])); //Liste des étudiants à envoyer à l'algorithme
			}
		}

		try (BufferedReader br = new BufferedReader(new FileReader("src/YourSchool/school_file.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	nbScho += 1;
				String[] schoolsStrings = line.split(":");
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
    Algorithm algo = new Algorithm(students, schools, choix, nbScho, nbStud);
	algo.sorting();
	recommencer(args);
	}

  public static String serenades(){
    Scanner clavier = new Scanner(System.in);
	System.out.println("----------------------------------------------");
	System.out.println("		Bienvenue dans cet algorithme de répartition d'élèves");
	System.out.println("----------------------------------------------");
	System.out.println("----------------------------------------------");
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
  
  public static void recommencer(String[] args) throws FileNotFoundException, IOException {
	  Scanner clavier = new Scanner(System.in);
	  System.out.println("----------------------------------------------");
	  System.out.println("Répartition des étudiants fini, voulez vous recommencer ?");
	  System.out.println("1 : Oui");
	  System.out.println("2 : Non");
	    try {
	    	int choix = clavier.nextInt();
	        switch(choix) {
	          case 1:
	            main(args);
	          case 2:
		            System.out.println("Au revoir");
		            break;
	          default:
	            System.out.println("Choix incorrect, veuillez choisir '1' ou '2'");
	            recommencer(args);
	        }
	    }catch (InputMismatchException e) {
	    	System.out.println("Veuillez rentrer un nombre");
	        recommencer(args);
	    }
	  clavier.close();
  }
  
  /*public static void fichiers() {
	  Scanner clavier = new Scanner(System.in);
	  System.out.println();
	  System.out.println("----------------------------------------------");
	  System.out.println("		Bienvenue dans cet algorithme de répartition d'élèves");
	  System.out.println("----------------------------------------------");
	  System.out.println();
	  System.out.println("Les fichiers par défaut sont 'school_file' et 'student_file'");
	  System.out.println("Voulez-vous changer de fichiers ?");
	  System.out.println("1 : Oui (ne fonctionne pas pour le moment)");
	  System.out.println("2 : Non");
	  try {
	    	int choix = clavier.nextInt();
	        switch(choix) {
	          case 1:
	        	  System.out.println("Implémentation de changement de fichier incorrect, on garde les mêmes");
	        	  System.out.println("Rentrez le nom du fichier d'écoles : ");
	        	  String scho = clavier.nextLine();
	        	  setEcoles(scho);
	        	  System.out.println("Rentrez le nom du fichier d'étudiants : ");
	        	  String stud = clavier.nextLine();
	        	  setEtudiants(stud);
	          case 2:
		            System.out.println("On garde donc les mêmes fichiers");
		            break;
	          default:
	            System.out.println("Choix incorrect, veuillez choisir '1' ou '2'");
	            fichiers();
	        }
	    }catch (InputMismatchException e) {
	    	System.out.println("Veuillez rentrer un nombre");
	        fichiers();
	    }
  }*/
  
  /*public static void setEcoles(String ecole) {
	  ecoles = "src/YourSchool/" + ecole;
  }
  
  public static void setEtudiants(String etudiant) {
	  etudiants = "src/YourSchool/" + etudiant;
  }
  
  public static String getEcoles() {
	  return ecoles;
  }
  
  public static String getEtudiants() {
	  return etudiants;
  }*/

}
