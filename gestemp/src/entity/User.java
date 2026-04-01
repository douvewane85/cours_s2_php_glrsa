package entity;

public abstract class User {
    private String login;
    private String password;
    private  TypeUser typeUser;
    public void setTypeUser(TypeUser typeUser) {
        if (this.typeUser == TypeUser.EMPLOYESIMPLE && typeUser == TypeUser.CHEF) {
            this.typeUser = typeUser;
        }
 
    }
    public TypeUser getTypeUser() {
        return typeUser;
    }
    public User(String login, String password, TypeUser typeUser) {
        this.login = login;
        this.password = password;
        this.typeUser = typeUser;
    
        this.password = password;
    }
    public User(TypeUser typeUser) {
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
        return "login=" + login + ", password=" + password + " " + "Type=" + typeUser;
    } 
}
