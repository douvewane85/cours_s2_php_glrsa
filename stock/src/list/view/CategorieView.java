package view;

import java.util.ArrayList;
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


     public static void afficheCategorie(ArrayList<Categorie> categories){
        
           for(Categorie cat:categories){
             if (cat!=null) {
                  System.out.println (cat); 
             }
            
           }
     }
}
