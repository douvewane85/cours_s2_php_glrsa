package entity;

import java.time.LocalDate;

import utils.DateUtils;

public class Produit {
     private static int compteur;
     private int id;
     private String libelle;
     private LocalDate dateCreation;
     private LocalDate datePremption;
    
    public LocalDate getDatePremption() {
        return datePremption;
    }
     public void setDatePremption(LocalDate datePremption) {
         this.datePremption = datePremption;
     }

  
    private float prix;
    private int qteStock;

    //ManyToOne (+sieurs Produits associes a une categorie)
     private Categorie categorie;


    public Produit(String libelle, float prix, int qteStock) {
        this.libelle = libelle;
        this.prix = prix;
        this.qteStock = qteStock;
        this.id=compteur++;
        this.dateCreation=LocalDate.now();
    }
    public Categorie getCategorie() {
        return categorie;
    }
     public void setCategorie(Categorie categorie) {
         this.categorie = categorie;
       //Relation de categorie vers Produit
        categorie.addProduit(this);
     }
    public Produit(int id, String libelle, float prix, int qteStock) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.qteStock = qteStock;
        this.dateCreation=LocalDate.now();
    }
    public Produit() {
        this.id=compteur++;
        this.dateCreation=LocalDate.now();

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public int getQteStock() {
        return qteStock;
    }
    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }
    @Override
    public String toString() {
          return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" 
                   + prix + ", qteStock=" + qteStock + ", Categorie="
                   + categorie.getNom()
                   + " Date Creation " +  DateUtils.formatDate(dateCreation, "dd/MM/yyyy") 
                   + " Date Premption " + DateUtils.formatDate(datePremption, "dd/MM/yyyy")
                   + "]";
    }

     public LocalDate getDateCreation() {
        return dateCreation;
    }
}
