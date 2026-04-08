

import view.AdminView;
import view.EmployeView;
import view.View;

import java.lang.StackWalker.Option;
import java.util.Optional;
import java.util.Scanner;

import entity.Employe;
import entity.TypeUser;
import entity.User;
import services.DepartementService;
import services.UserService;


public class App {
  
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            View.of(scanner);
            AdminView.of(scanner);
            EmployeView.of(scanner);
        
           UserService.initialize();
           DepartementService.initialize();
            Optional<User> userOpt;
          do {
              String login=View.saisieChaine("Login : ");
              String password=View.saisieChaine("Password : "); 
              //1-Authentification de l'utilisateur
                 // (recupérer l'utilisateur à partir du login et du mot de passe)
               userOpt = UserService.seConnecter(login, password);
            if(userOpt.isEmpty()){
                System.out.println("Login ou mot de passe incorrect.");
            }
            } while (userOpt.isEmpty());

            User user = userOpt.get();
            //Autorisation de l'utilisateur 
            // (en fonction de son type : admin, chef ou employé)
            if (user.getTypeUser()==TypeUser.ADMIN) {
                  AdminView.menu(user);
            } else if (user.getTypeUser()==TypeUser.CHEF) {
                  EmployeView.menu(user);
            }
            else {
                System.out.println("Vous n'avez pas les droits d'accès.");  
            }
             scanner.close();
                
            }
       
}


