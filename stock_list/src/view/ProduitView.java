package view;

import java.util.Scanner;

import entity.Categorie;
import entity.Produit;

public final class ProduitView {
    private static Scanner clavier=new Scanner(System.in);
    public static Produit saisieProduit(Categorie[] categories,int nbreCate){
       String libelle;float prix;int qteStock;
       do {
           System.out.println("Entrer le Libelle");
            libelle =clavier.nextLine();
       } while (libelle.isEmpty());
       do {
           System.out.println("Entrer le Prix");
            prix =clavier.nextFloat();
       } while (prix<=0);
       do {
           System.out.println("Entrer le QteStock");
            qteStock =clavier.nextInt();
       } while (qteStock<=0);
       int indexCategorie;
       do {
            for (int index = 0; index < nbreCate; index++) {
              System.out.println(index+" - "+categories[index].getNom());
            }
            System.out.println("Selectionner l'index de la categorie");
            indexCategorie=clavier.nextInt();
       } while (indexCategorie<0 || indexCategorie>=nbreCate);
          var categorie=categories[indexCategorie];
          var produit= new Produit(libelle,prix,qteStock);
           //Relation de produit vers categorie
            produit.setCategorie(categorie);
            return produit;
    }

     public static void afficheProduit(Produit[] produits,int nbreProd){
    
            for(int i=0;i<nbreProd;i++){
                 System.out.println (produits[i]);
            }
     }

     public static void afficheProduit(Produit[] produits){
        /*
          for():parcours de collection(array, list,set,map) <==> foreach en php(array)
            //Elle parcours le nombre cellule
              //N=100 
              //nbreCat=10
                Elle parcours de 1 a 100
             for(Categorie cat:categories){
             }
         */
           for(Produit prod:produits){
             if (prod!=null) {
                  System.out.println (prod); 
             }
            
           }
     }
}
