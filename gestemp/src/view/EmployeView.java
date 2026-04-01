package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Employe;
import utils.DateUtils;

public final class EmployeView {
    private static Scanner scanner = new Scanner(System.in);

 
    private EmployeView() {
    }
    public static void afficherEmployes(ArrayList<Employe> employes) {
        System.out.println("Liste des employés :");
       for (Employe emp : employes) {
            System.out.println(emp);
        }
    }

    public static Employe saisirEmploye() {
        System.out.println("Saisir les détails de l'employé :");
        String nom = saisieChaine("Nom : ");
        String prenom = saisieChaine("Prénom : ");
        String matricule = saisieChaine("Matricule : "); System.out.print("Date d'embauche (dd-MM-yyyy) : ");
        boolean dateEmbaucheValide;
         LocalDate dateNaiss;
        do{
              String dateNaissString = saisieChaine("Date de naissance (dd-MM-yyyy) : ");
              dateNaiss = DateUtils.parseDate(dateNaissString,"dd-MM-yyyy");
              dateEmbaucheValide = DateUtils.isDateNaiss(dateNaiss);
            if (!dateEmbaucheValide) {
                System.out.println("Date de naissance invalide ou employé trop jeune. Veuillez réessayer.");
            } else {
                break;
            }
        }while(true);
      
        double salaire = saisieDouble("Salaire : ");
        scanner.nextLine(); // Consume newline
        return new Employe(nom, prenom, matricule, dateNaiss, salaire);
    }

    private static String  saisieChaine(String message) {
        String input;
        do {
            System.out.print(message);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Ce champ ne peut pas être vide. Veuillez réessayer.");
            } else {
                return input;
            }
        } while (true);
        
    }

    private static double saisieDouble(String message) {
        double input;
        do {
                 System.out.print(message);
                  input = scanner.nextDouble();
                 if(input<0){ 
                    System.out.println("Veuillez entrer un nombre valide.");
                    scanner.nextLine(); // Consume invalid input
                }else {
                    return input;
                }

        } while (true);
    }
    
}
