package view;

import java.lang.StackWalker.Option;
import java.util.Optional;
import java.util.Scanner;

import entity.Employe;
import entity.Tache;
import entity.User;
import services.UserService;

public final class EmployeView {
   private static Scanner scanner;
        public static void of(Scanner sc) {
            scanner = sc;
        }
     

          public static void menu(User user) {
            Employe chef = (Employe) user;
           int choice;
            do {
                System.out.println("Menu:");
                System.out.println("1. Voir ses Employés");
                System.out.println("2. Affecter une Tache a un Employé");
                System.out.println("3. Lister les Taches d'un Employé");
                System.out.println("4. Quitter");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        // Code pour voir les employés
                    var employes = chef.getSubordonnes();
                     if (employes.isEmpty()) {
                          System.out.println("Aucun employé trouvé.");
                          break; 
                    }
                      View.afficherEmployes(employes);

                        break;
                    case 2:
                           // Code pour affecter une tâche à un employé
                                var employe = rechercherEmployeParMatricule(chef);
                                var tache = EmployeView.saisirTache();
                                employe.addTache(tache);
                                System.out.println("Tâche affectée avec succès.");
                        break;
                    case 3:
                        // Code pour lister les tâches d'un employé
                        
                                 employe = rechercherEmployeParMatricule(chef);
                                 var taches = employe.getTaches();
                                if (taches.isEmpty()) {
                                    System.out.println("Aucune tâche trouvée pour cet employé.");
                                } else {
                                    System.out.println("Tâches de l'employé " + employe.getMatricule() + " :");
                                    for (Tache t : taches) {
                                        System.out.println("- " + t.getNom());
                                    }
                                }
                        break;
                    case 4:
                        System.out.println("Au revoir!");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } while (choice != 4);

          }

          public static Tache saisirTache() {
            String nom = View.saisieChaine("Nom de la tâche : ");
            return new Tache(nom);   
          }

          private static Employe rechercherEmployeParMatricule(Employe chef) {
            Optional<Employe> employeOpt;
            do {
                 var matricule=View.saisieChaine("Matricule: ");
                  employeOpt = chef.getEmployeByMatricule(matricule);
                  if (employeOpt.isEmpty()) {
                    System.out.println("Matricule incorrect. Veuillez réessayer.");
                 }
            } while (employeOpt.isEmpty());
            return employeOpt.get();
          }
    }

