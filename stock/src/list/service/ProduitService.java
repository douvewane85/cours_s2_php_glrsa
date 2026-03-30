package service;

import java.util.ArrayList;

import entity.Produit;

public final class ProduitService {
    private static ArrayList<Produit> produits=new ArrayList<Produit>();
  
    private ProduitService() {
    }
    public static ArrayList<Produit> getProduits() {
        return produits;
    }

    public static void addProduit(Produit produit){
             produits.add(produit);
     
    }
    
}
