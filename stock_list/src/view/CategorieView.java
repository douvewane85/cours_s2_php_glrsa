package view;

import java.util.Scanner;

import entity.Categorie;

public final class CategorieView {
    private static Scanner clavier=new Scanner(System.in);
    public static Categorie saisieCategorie(){
        System.out.println("Entrer le Code");
        int code =clavier.nextInt();
      
        System.out.println("Entrer le Nom");
        /*
            clavier.next(): Recuperer une chaine formee par un mot
            clavier.nextLine(): Recuperer une chaine formee par un mot ou plusieurs mots
         */
        String nom =clavier.next();
        return new Categorie(code,nom);
    }

     public static void afficheCategorie(Categorie[] categories,int nbreCat){
        /*
            categories.length : nbre de cellules
            while(..)
            do ..while()
         */
            for(int i=0;i<nbreCat;i++){
                 System.out.println (categories[i]);
            }
     }

     public static void afficheCategorie(Categorie[] categories){
        /*
          for():parcours de collection(array, list,set,map) <==> foreach en php(array)
            //Elle parcours le nombre cellule
              //N=100 
              //nbreCat=10
                Elle parcours de 1 a 100
             for(Categorie cat:categories){
             }
         */
           for(Categorie cat:categories){
             if (cat!=null) {
                  System.out.println (cat); 
             }
            
           }
     }
}
