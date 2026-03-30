package service;

import entity.Categorie;
/*
   class final 
     1-Une Classe qui ne contient que des methodes static
     2-La classe ne puisse pas etre une classe Mere

     //Tableau 
      type[] : array (Type reference)
      type[] nomTab;
      nomTab=new type[Taille];
      int[]: Tableau de valeurs d'entiers
      int[] tabEntiers;
      tabEntiers=new int[10]
      tabEntiers[0]=1
      tabEntiers[1]=10
      Categorie[]: tableau de reference 
      Categorie[] categories;
       //Instancier le Tableau de 5 cellules
         categories=new  Categorie[5];
      //Instancier un Objet Categorie
      categories[0]=new Categorie();
      categories[0].setCode(1)
      categories[0].setNom("Lait");
      categories[1]=new Categorie(2,"COS");
       const 
 */

public final class CategorieService {
    //Taille du Tableau
    private  static final int N=100;
    private  static Categorie[] categories=new Categorie[N];
    //Nbre de Valeurs
    private static int nbreCat=0;

    private CategorieService(){

    }
    public static  boolean addCategorie(Categorie categorie){
        if (nbreCat<N) {
           categories[nbreCat] =categorie;
           nbreCat++;
           return true;
        }
        return false;
    }

     public static int getNombreCategorie() {
        return CategorieService.nbreCat;
    }

     public static Categorie[] getAllCategorie() {
        return categories;
    }





}
