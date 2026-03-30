package service;

import entity.Produit;

public final class ProduitService {
    private  static final int N=100;
    private static Produit[] produits=new Produit[N];
    private static int nbreProduit;

    
    private ProduitService() {
    }

    public static int getNbreProduit() {
        return nbreProduit;
    }

    public static Produit[] getProduits() {
        return produits;
    }

    public static boolean addProduit(Produit produit){
       if (nbreProduit<N) {
          produits[nbreProduit++]=produit;
          return true;
       }
       return false;
    }
    
}
