package entity;

import java.time.LocalDate;

public class Employe {
     private static int compteur = 1;
     private static    int ageRetraite = 60;
     
      private int id;
      private String nom;
      private String prenom;
      private String matricule;
      private LocalDate dateEmbauche;
      private LocalDate dateNaissance;
      private double salaire;

      private Departement departement;
        public Departement getDepartement() {
            return departement; 
        }
        public void setDepartement(Departement departement) {
            this.departement = departement;
        }

      /*
         * Constructeur par défaut  
       */
    public Employe() {
      }

     /*
         * Constructeur surchargé 
         * Données Passees
     */
    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, LocalDate dateNaissance, double salaire) {
        this.id = compteur++;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.dateNaissance = dateNaissance;
        this.salaire = salaire;
    }

        /*
           Donnees Actuelles
           Constructeur surchargé avec date d'embauche par défaut (date actuelle)
        */
        public Employe(String nom, String prenom, String matricule, LocalDate dateNaissance, double salaire) {
        this.id = compteur++;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = LocalDate.now();
        this.dateNaissance = dateNaissance;
        this.salaire = salaire;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        Employe.compteur = compteur;
    }

    public static int getAgeRetraite() {
        return ageRetraite;
    }

    public static void setAgeRetraite(int ageRetraite) {
        Employe.ageRetraite = ageRetraite;
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Employe [nom=" + nom + ", prenom=" + prenom + ", matricule=" + matricule + ", dateEmbauche="
                + dateEmbauche + ", dateNaissance=" + dateNaissance + ", salaire=" + salaire + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
        result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employe other = (Employe) obj;
        if (matricule == null) {
            if (other.matricule != null)
                return false;
        } else if (!matricule.equals(other.matricule))
            return false;
        if (dateNaissance == null) {
            if (other.dateNaissance != null)
                return false;
        } else if (!dateNaissance.equals(other.dateNaissance))
            return false;
        return true;
    }

     public int calculerAge() {
        return LocalDate.now().getYear() - dateNaissance.getYear();
     }

     public int anneeRetraite() {
        return this.ageRetraite - calculerAge();
     }

}
