package view;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Employe;

public final class View {
        private static Scanner scanner;
        public static void of(Scanner sc) {
            scanner = sc;
        }
    private View() {
    }
     public static String  saisieChaine( String message) {
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

    public static double saisieDouble(String message) {
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

    public static void afficherEmployes(ArrayList<Employe> employes) {
        System.out.println("Liste des employés :");
       for (Employe emp : employes) {
            System.out.println(emp);
        }
    }
}
