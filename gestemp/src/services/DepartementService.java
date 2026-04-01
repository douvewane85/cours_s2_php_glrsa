package services;

import java.util.ArrayList;
import entity.Departement;
public final class DepartementService {
        private DepartementService() {
        }

        private static ArrayList<Departement> departements = new ArrayList<>();
        public static ArrayList<Departement> getDepartements() {
            return departements;
        }
        public static void initialize() {
            departements.add(new Departement("D001", "Informatique"));
            departements.add(new Departement("D002", "Ressources Humaines"));
            departements.add(new Departement("D003", "Finance"));
        }
}
