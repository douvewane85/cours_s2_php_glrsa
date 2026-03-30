package entity;

public class Produit {
    private static int compteur;
    private int id;
    private String libelle;
    /*
    Reels
        float (6 chiffres signitifs)
            => mantice i.e nbre chiffre significatif apres la virgule
              1.2 ==>  1.200000
              1.25 ==> 1.250000
              1.1234567 ==>  1.123456
         float prix=1.2f;
         double (>6 chiffres signitifs)
         1.2 ==>double
         double prix=1.2;

    Entiers
        short int: (2 octets) ==> Domaine de Valeurs[-2 puiss 15,2 puiss 15 -1]
        int :  (4 octets) ==> Domaine de Valeurs[-2 puiss 31,2 puiss 31 -1] 
        long int (8 octets) ==> Domaine de Valeurs[-2 puiss 63,2 puiss 63 -1] 
        unsigned short int: (2 octets) ==> Domaine de Valeurs[0,2 puiss 16 -1]
        unsigned int :  (4 octets) ==> Domaine de Valeurs[0,2 puiss 32 -1] 
        unsigned long int (8 octets) ==> Domaine de Valeurs[0,2 puiss 64 -1] 

    */
    private float prix;
    private int qteStock;

    //ManyToOne (+sieurs Produits associes a une categorie)
     private Categorie categorie;


    public Produit(String libelle, float prix, int qteStock) {
        this.libelle = libelle;
        this.prix = prix;
        this.qteStock = qteStock;
        this.id=compteur++;
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
    }
    public Produit() {
        this.id=compteur++;

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
        return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", qteStock=" + qteStock + ", Categorie=" + categorie.getNom() + "]";
    }
}
