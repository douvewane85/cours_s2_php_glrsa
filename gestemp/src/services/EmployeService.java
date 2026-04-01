package services;

import java.util.ArrayList;

import entity.Employe;

public class EmployeService {
     private  static ArrayList<Employe> employes = new ArrayList<>();
      private EmployeService() {
    }
    public static ArrayList<Employe> getEmployes() {
        return employes;
    }
    public static void  initialize() {
        employes.add(new Employe("Doe", "John", "E001", java.time.LocalDate.of(2020, 1, 15), java.time.LocalDate.of(1990, 5, 20), 3000000.0));
        employes.add(new Employe("Smith", "Jane", "E002", java.time.LocalDate.of(2019, 3, 10), java.time.LocalDate.of(1985, 8, 30), 3500000.0));
        employes.add(new Employe("Brown", "Charlie", "E003", java.time.LocalDate.of(2021, 6, 5), java.time.LocalDate.of(1992, 12, 10), 2800000.0));
    }

   public  static boolean addEmploye(Employe employe) {
        employes.add(employe);
        return true;
    }
}