package TEST;



/**
 *
 * @author MOHAMMED.MOURADI
 */
import java.util.Scanner;

import ArbreDEDecision.ArbreDEDecision;
import KMeans.K_Means;

public class presentationTEST {
	private static Scanner e;
	public static void main(String[] args) {
		e = new Scanner(System.in);
		String choix;
		do{
			System.out.println();
			System.out.println();
                        System.out.println("**     **  *******  **   **  *******  *******  ********    **********      MOHAMMED MOURADI ");
                        System.out.println("***   ***  **   **  **   **  **   **  **   **  **     **       **          MASTER SID1 ");
                        System.out.println("**** ****  **   **  **   **  *******  **   **  **     ***      **          ENSET MOHAMMEDIA");
                        System.out.println("**  *  **  **   **  **   **  **       *******  **     ***      **          PROJET : DATA MAINING");
                        System.out.println("**     **  **   **  **   **  **  *    **   **  **     **       **          ENCADRE PAR: Abdelwahab NAJI");
                        System.out.println("**     **  *******  *******  **    *  **   **  ********    **********              ");
			System.out.println("DATA MINING");
			System.out.println();
			System.out.println("*** Les differentes methodes : *************");
			System.out.println("L'arbre de decision .................... 1");
			System.out.println("K-Means ................................ 2");
			System.out.println("Quitter ................................ 3");
			System.out.println("********************************************************");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = e.nextLine();
			switch(choix){
			case "1" :  ArbreDEDecision.lancer();break;
			case "2" :  K_Means.lancer();break;
			}		
		}while(choix.equals("3")==false);
	}
}
