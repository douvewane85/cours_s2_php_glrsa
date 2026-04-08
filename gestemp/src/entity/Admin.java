package entity;

public class Admin extends User {

     private String fonction;
    public Admin() {
        super(TypeUser.ADMIN);
    }

   

    public Admin(String nom, String prenom, String login, String password,String fonction) {
        super(nom, prenom, login, password, TypeUser.ADMIN);
        this.fonction = fonction;
    }

    public String getFonction() {
        return fonction;
    }



    @Override
    public String toString() {
        return "Admin [fonction=" + fonction + ", nom=" + nom + ", prenom=" + prenom + "]";
    }

   
    
}
