package entity;

import java.util.ArrayList;

//Toute classe herite par defaut de la classe Object
public class Categorie  {
    /*
         Les attributs d'une classe sont initialises en Java
             attributs est un number(float  ou double,int,short int , long int) ==>0
             attributs est un boolean ==>false
             attributs est un Objet ==>null
    */
    private int code ;
    private String nom;

    //OneToMany (1 Categorie ==> plusieurs Produits)
     private ArrayList<Produit> produits=new ArrayList<Produit>();
    
  

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void addProduit(Produit produit){
             produits.add(produit);  
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
      
        return nom;
    }

    public void setNom(String nom) {
       this.nom = nom;
    }

    public Categorie(){
      
    }

     public Categorie(int code , String nom){
          this.code=code;
          this.nom=nom;
         
    }

    
    //Redifinit(Heritage + Modification)
     @Override
     public String toString() {
        return "Categorie [code=" + code + ", nom=" + nom + "]";
     }

     @Override
     public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + code;
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
        Categorie other = (Categorie) obj;
        if (code != other.code)
            return false;
        return true;
     }

    
}
