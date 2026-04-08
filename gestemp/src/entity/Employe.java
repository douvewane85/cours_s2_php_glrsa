package entity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;


public class Employe extends User {
       private static int compteur = 1;
       private static    int ageRetraite = 60;
    
        private String matricule;
        private LocalDate dateEmbauche;
        private LocalDate dateNaissance;
        private double salaire;
        private ArrayList<Employe> subordonnes = new ArrayList<>();
        private Employe chef=null;

        private ArrayList<Tache> taches = new ArrayList<>();
        public ArrayList<Tache> getTaches() {
            return taches;
        }
        public void addTache(Tache tache) {
            //Tache --> Employe
              this.taches.add(tache);
              //Employe --> Tache
              tache.setEmploye(this);
        }


        public ArrayList<Employe> getSubordonnes() {
            return subordonnes;
        }
        public void addSubordonne(Employe subordonne) {
            if (subordonnes.isEmpty()) {
                 super.setTypeUser(TypeUser.CHEF);
            }
             //Chef --> ES 
             this.subordonnes.add(subordonne);
             //ES -->Chef  
             subordonne.setChef(this);
        }

  
        public Employe getChef() {
            return chef;
        }
        public void setChef(Employe chef) {
            this.chef = chef;
        }

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
         super(TypeUser.EMPLOYESIMPLE);
         
      }

     /*
         * Constructeur surchargé 
         * Données Passees
     */
    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, LocalDate dateNaissance, double salaire, String login, String password) {
        super(nom, prenom, login, password, TypeUser.EMPLOYESIMPLE);
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
        super(TypeUser.EMPLOYESIMPLE);

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
        return "Employe [ "+super.toString()+", matricule=" + matricule + ", dateEmbauche="
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

      public  Optional<Employe>  getEmployeByMatricule(String    matricule){
       for (Employe employe : subordonnes) {
                if (employe.getMatricule().equals(matricule)) {
                    return Optional.of(employe);
                }
        }
        return Optional.empty();
    }

}
