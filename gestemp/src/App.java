import java.util.Scanner;

import services.EmployeService;
import view.EmployeView;
import services.DepartementService;
import view.DepartementView;

public class App {
     private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
         int choice;
        // EmployeService.initialize();
         DepartementService.initialize();
  
       do {
            choice = menu();
            switch (choice) {
                case 1:
                    var employes = EmployeService.getEmployes();
                    if (employes.isEmpty()) {
                        System.out.println("Aucun employé trouvé.");
                        break; 
                    }
                    EmployeView.afficherEmployes(employes);
                    break;
                case 2:
                    var nouvelEmploye = EmployeView.saisirEmploye();
                      String reponse;
                      //Affecter un département à l'employé
                    do {
                        System.out.println("Voulez-vous assigner cet employé à un département ? (OUI/NON)");
                        reponse = scanner.next().trim().toUpperCase();
                        if (reponse.compareTo("OUI") == 0) {
                              var departements = DepartementService.getDepartements();
                              var departementSelectionne = DepartementView.selectionnerDepartement(departements);
                              nouvelEmploye.setDepartement(departementSelectionne);
                              departementSelectionne.addEmploye(nouvelEmploye);
                            break;
                        } else if (reponse.compareTo("NON") == 0) {
                            break;
                        } else {
                            System.out.println("Réponse invalide. Veuillez répondre par OUI ou NON.");
                        }
                    } while (true);
                    var success = EmployeService.addEmploye(nouvelEmploye);
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

    public static int menu() {
        System.out.println("Menu:");
        System.out.println("1. Afficher les employés");
        System.out.println("2. Ajouter un employé");
        System.out.println("3. Quitter");
        return scanner.nextInt();
    }

    
}
