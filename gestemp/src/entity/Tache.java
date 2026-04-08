package entity;

public class Tache {
    private static int compteur = 1;
    private int id;
    private String nom;
    private boolean estComplete;

    private Employe employe; 
    
    


    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache(String nom) {
        this.id = compteur++;
        this.nom = nom  ;
        this.estComplete = false;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom  ;
    }

    public boolean isEstComplete() {
        return estComplete;
    }

    public void setEstComplete(boolean estComplete) {
        this.estComplete = estComplete;
    }

    @Override
    public String toString() {
        return "Tache [id=" + id + ", nom=" + nom + ", estComplete=" + estComplete + "]";
    }
}
