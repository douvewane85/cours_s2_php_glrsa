

import view.AdminView;
import services.DepartementService;
import services.UserService;


public class App {
  
    public static void main(String[] args) throws Exception {
         UserService.initialize();
         DepartementService.initialize();
         //Connection
          AdminView.menu();
    }

    

    
}
