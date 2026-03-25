package entity;

//Toute classe herite par defaut de la classe Object
public class Categorie  {
    /*
         Les attributs d'une classe sont initialises en Java
             attributs est un number(float  ou double,int,short int , long int) ==>0
             attributs est un boolean ==>false
             attributs est un Objet ==>null
    */
    private  static final int N=100;
    private int code ;
    private String nom;

    //OneToMany (1 Categorie ==> plusieurs Produits)
     private Produit[] produits=new Produit[N];
     private int nbreProduit;
    
    public int getNbreProduit() {
        return nbreProduit;
    }

    public Produit[] getProduits() {
        return produits;
    }

    public boolean addProduit(Produit produit){
       if (nbreProduit<N) {
          produits[nbreProduit++]=produit;
          return true;
       }
       return false;
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

    
}
