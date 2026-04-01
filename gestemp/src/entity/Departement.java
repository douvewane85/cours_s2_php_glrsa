package entity;

import java.util.ArrayList;

public class Departement {
    private String code;
    private String nom;

    private ArrayList<Employe> employes=new ArrayList<>();
    public ArrayList<Employe> getEmployes() {
        return employes;
    }
    public void addEmploye(Employe employe) {
        this.employes.add(employe);
    }

    public Departement(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }
    private Departement() {
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public String toString() {
        return "Departement [code=" + code + ", nom=" + nom + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
        Departement other = (Departement) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        return true;
    }
    
}
