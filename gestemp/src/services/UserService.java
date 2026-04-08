package services;


import java.util.ArrayList;
import java.util.Optional;

import entity.Admin;
import entity.Employe;
import entity.TypeUser;
import entity.User;

public class UserService {
     private  static ArrayList<User> users = new ArrayList<>();
      private UserService() {
    }
    public static ArrayList<Employe> getEmployes() {
        ArrayList<Employe> employes = new ArrayList<>();
        for (User user : users) {
            if (user.getTypeUser() == TypeUser.EMPLOYESIMPLE || user.getTypeUser() == TypeUser.CHEF ) {
                Employe employe = (Employe) user;
                employes.add(employe);
            }
        }
        return employes;
    }
    public static void  initialize() {
        
         Admin admin1 = new Admin("Alice", "Smith", "admin", "password", "Directrice Générale");
         Employe chef = new Employe("Johnson", "Emily", "E004", java.time.LocalDate.of(2018, 9, 20), java.time.LocalDate.of(1980, 3, 15), 4000000.0, "chef", "chef");
         var emps1 = new Employe("Doe", "John", "E001", java.time.LocalDate.of(2020, 1, 15), java.time.LocalDate.of(1990, 5, 20), 3000000.0, "john.doe", "password1");
         var emps2 = new Employe("Smith", "Jane", "E002", java.time.LocalDate.of(2019, 3, 10), java.time.LocalDate.of(1985, 8, 30), 3500000.0, "jane.smith", "password2");
         var emps3 = new Employe("Brown", "Charlie", "E003", java.time.LocalDate.of(2021, 6, 5), java.time.LocalDate.of(1992, 12, 10), 2800000.0, "charlie.brown", "password3");
            chef.addSubordonne(emps1);
            chef.addSubordonne(emps2);
            chef.addSubordonne(emps3);
            users.add(chef);
            users.add(emps1);
            users.add(emps2);
            users.add(emps3);
            users.add(admin1);
      

    }

   public  static boolean addEmploye(User user) {
        users.add(user);
        return true;
    }
    /*
          seConnecter(String login, String password):User|null 
          Type de retour : Classe ou null   ==> Optional<Classe>
    */
   public static Optional<User> seConnecter(String login, String password) {
        for (User user : users) {
            if (user.getLogin().compareTo(login) == 0 && user.getPassword().equals(password)) {
                return Optional.of(user); // Authentification réussie, retourner l'utilisateur
            }
        }
        return Optional.empty(); // Authentification échouée
    }

   public static Optional<Employe>  getEmployeByMatricule(String    matricule){
       for (User user : users) {
            if (user.getTypeUser() == TypeUser.EMPLOYESIMPLE ) {
                 Employe employe = (Employe) user;
                if (employe.getMatricule().equals(matricule)) {
                    return Optional.of(employe);
                }
            }
        }
        return Optional.empty();
    }
}