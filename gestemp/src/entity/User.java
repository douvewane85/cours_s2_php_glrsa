package entity;

public abstract class User {
     private static int compteur = 1;
     private int id;
     protected String nom;
     protected String prenom;
     private String login;
     private String password;
     private  TypeUser typeUser;
    public User(String nom, String prenom, String login, String password, TypeUser typeUser) {
        this.id = compteur++;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.typeUser = typeUser;
    }
    public void setTypeUser(TypeUser typeUser) {
        if (this.typeUser == TypeUser.EMPLOYESIMPLE && typeUser == TypeUser.CHEF) {
            this.typeUser = typeUser;
        }
 
    }
    public TypeUser getTypeUser() {
        return typeUser;
    }
    
    public User(TypeUser typeUser) {
        this.id = compteur++;
         this.typeUser = typeUser;
   
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Nom=" + nom + ", Prenom=" + prenom + ", login=" + login + ", password=" + password + ", typeUser=" + typeUser + "]";
    } 

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
