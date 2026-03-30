package service;


import java.util.ArrayList;

import entity.Categorie;


public final class CategorieService {
   
    private  static ArrayList<Categorie> categories=new ArrayList<Categorie>();
    //Nbre de Valeurs
    private static int nbreCat=0;

    private CategorieService(){

    }
    public static void   addCategorie(Categorie categorie){
       CategorieService.categories.add(categorie);
    }

     public static int getNombreCategorie() {
        return CategorieService.nbreCat;
    }

     public static ArrayList<Categorie> getAllCategorie() {
        return categories;
    }





}
