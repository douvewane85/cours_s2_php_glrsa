package view;

import java.util.List;
import java.util.Scanner;

import entity.Departement;

public final class DepartementView {
        private static Scanner scanner = new Scanner(System.in);
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
}
