

import java.util.Scanner;

import entity.Categorie;
import service.CategorieService;
import service.ProduitService;
import view.CategorieView;
import view.ProduitView;


public class App {
    
    public static void main(String[] args) throws Exception {
       Scanner clavier=new Scanner(System.in);
       while (true) {
         System.out.println("1- Ajouter Categorie");
         System.out.println("2- Lister Categorie");
         System.out.println("3- Ajouter Produit");
         System.out.println("4- Lister Produit");
         System.out.println("5- Quitter");
         System.out.println("Entrer le choix");
         int choix=clavier.nextInt();
         switch (choix) {
            case 1:
               Categorie cat=CategorieView.saisieCategorie();
               var result=CategorieService.addCategorie(cat);
               if (result==true) {
                    System.out.println("Categorie ajoutee avec success");
               }else{
                    System.out.println("Le tableau est rempli");
               }
               break;
      case 2:
                var categories=CategorieService.getAllCategorie();
                CategorieView.afficheCategorie(categories);

       case 3:
                categories=CategorieService.getAllCategorie();
                var nbreCat=CategorieService.getNombreCategorie();

               var produit= ProduitView.saisieProduit(categories,nbreCat);

               result=ProduitService.addProduit(produit);
               if (result) {
                    System.out.println("Produit ajoutee avec success");
               }else{
                    System.out.println("Le tableau est rempli");
               }
          break;
           case 4:
                var produits=ProduitService.getProduits();
                 ProduitView.afficheProduit(produits);
             break;
           case 5:
               return;
            default:
               break;
         }
         
       }
    }
}
