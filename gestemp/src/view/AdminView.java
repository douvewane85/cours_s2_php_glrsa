package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Admin;
import entity.Departement;
import entity.Employe;
import entity.User;
import services.DepartementService;
import services.UserService;
import utils.DateUtils;

public final class AdminView  {
     private static Scanner scanner;
        public static void of(Scanner sc) {
            scanner = sc;
        }
    public  static Departement selectionnerDepartement(List<Departement> departements) {
        // Afficher la liste des départements disponibles
              for (int i = 0; i < departements.size(); i++) {
                System.out.println((i + 1) + ". " + departements.get(i).getNom());
              }
               int choix;
               do {
                  System.out.println("Sélectionnez un département :");
                   choix = scanner.nextInt();
               } while (choix < 1 || choix > departements.size());
             return departements.get(choix - 1);
    }

     

    public static Employe saisirEmploye() {
        System.out.println("Saisir les détails de l'employé :");
        String nom = View.saisieChaine("Nom : ");
        String prenom = View.saisieChaine("Prénom : ");
        String matricule = View.saisieChaine("Matricule : "); System.out.print("Date d'embauche (dd-MM-yyyy) : ");
        boolean dateEmbaucheValide;
         LocalDate dateNaiss;
        do{
             scanner.nextLine(); 
              String dateNaissString = View.saisieChaine("Date de naissance (dd-MM-yyyy) : ");
              dateNaiss = DateUtils.parseDate(dateNaissString,"dd-MM-yyyy");
        
              dateEmbaucheValide = DateUtils.isDateNaiss(dateNaiss);
            if (!dateEmbaucheValide) {
                System.out.println("Date de naissance invalide ou employé trop jeune. Veuillez réessayer.");
            } else {
                break;
            }
        }while(true);
      
        double salaire = View.saisieDouble("Salaire : ");
        scanner.nextLine(); // Consume newline
        return new Employe(nom, prenom, matricule, dateNaiss, salaire);
    }

    public static void menu(User user) {
        Admin admin = (Admin) user;
         int choice;
       do {
        System.out.println("Menu:");
        System.out.println("1. Afficher les employés");
        System.out.println("2. Ajouter un employé");
        System.out.println("3. Quitter");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
       
            switch (choice) {
                case 1:
                    var employes = UserService.getEmployes();
                    if (employes.isEmpty()) {
                        System.out.println("Aucun employé trouvé.");
                        break; 
                    }
                    View.afficherEmployes(employes);
                    break;
                case 2:
                    var nouvelEmploye = AdminView.saisirEmploye();
                      String reponse;
                      //Affecter un département à l'employé
                    do {
                        System.out.println("Voulez-vous assigner cet employé à un département ? (OUI/NON)");
                        reponse = scanner.next().trim().toUpperCase();
                        if (reponse.compareTo("OUI") == 0) {
                              var departements = DepartementService.getDepartements();
                              var departementSelectionne = AdminView.selectionnerDepartement(departements);
                              nouvelEmploye.setDepartement(departementSelectionne);
                              departementSelectionne.addEmploye(nouvelEmploye);
                            break;
                        } else if (reponse.compareTo("NON") == 0) {
                            break;
                        } else {
                            System.out.println("Réponse invalide. Veuillez répondre par OUI ou NON.");
                        }
                    } while (true);
                        var success = UserService.addEmploye(nouvelEmploye);
                    if (success) {
                        System.out.println("Employe ajouté avec succès.");
                    } else {
                        System.out.println("Erreur lors de l'ajout de l'employé.");
                    }
                    break;
                case 3:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        
        
       } while (choice != 3);
    }
}
