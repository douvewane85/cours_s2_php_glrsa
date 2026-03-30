package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Categorie;
import entity.Produit;
import utils.DateUtils;

public final class ProduitView {
    private static Scanner clavier=new Scanner(System.in);
    public static Produit saisieProduit(ArrayList<Categorie> categories){
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
            String dateString;
            LocalDate datePremption=LocalDate.now();
          clavier.nextLine();//vider le buffer du clavier
          do{
            System.out.println("Entrer la date de Premption");
            dateString=clavier.nextLine();
           if (!dateString.isEmpty()) {
              datePremption=DateUtils.parseDate(dateString, "dd/MM/yyyy");
              if (DateUtils.isExpired(datePremption)) {
                   System.out.println("Produit est perime");
              }else{
                   System.out.println("Produit n'est pas perime");
              }
            }
          
         }while (DateUtils.isExpired(datePremption) || dateString.isEmpty()); 
         int indexCategorie;
         do {
            for (int index = 0; index < categories.size(); index++) {
              System.out.println(index+" - "+categories.get(index).getNom());
            }
            System.out.println("Selectionner l'index de la categorie");
            indexCategorie=clavier.nextInt();
         } while (indexCategorie<0 || indexCategorie>=categories.size());
           var categorie=categories.get(indexCategorie);
           Produit produit= new Produit(libelle,prix,qteStock);
           produit.setDatePremption(datePremption);
           //Relation de produit vers categorie
            produit.setCategorie(categorie);
            return produit;
    }

     public static void afficheProduit(ArrayList<Produit> produits){
           for(Produit prod:produits){
                  System.out.println (prod); 
            
           }
     }
}
