import java.util.Scanner;

public class App{
    //Classe System
       // System.in ==>Clavier
       // System.out ==>Ecran
    //Ecrire sur l'ecran 
       //System.out.print("Chaine"+nomVar) ==>Pas de retour a la ligne
       //System.out.println("Chaine"+nomVar) ==>retour a la ligne
   //Lecture au Clavier ==> Scanner
       //Scanner clavier =new Scanner(System.in)
        //clavier.nextType()
          //Type (int,double,float,...)
   public static void main(String[] args) {
        Scanner clavier =new Scanner(System.in);
         System.out.println("Entrer un entier");
         int x=clavier.nextInt();
         System.out.print("La valeur de x est : \n");
         // System.out.print(x+"\n");
          System.out.println(x);

       clavier.close();
       
   }
    
}