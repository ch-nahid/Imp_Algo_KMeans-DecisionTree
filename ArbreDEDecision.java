package ArbreDEDecision;

import java.util.ArrayList;
import java.util.Scanner;

public class ArbreDEDecision {
	private static Scanner e = new Scanner(System.in);
	private static int colsNumber;
	private static String classe1;
	private static String classe2;
	private static LesColonnes[] cols;
	private static double Is;
	
	public static void lancer(){
		System.out.println();
		System.out.println("Bienvenu dans la méthodes l'arbre de décision :)");
		System.out.println();
		System.out.println("Phase 1 : Saisi de l'ensemble d'apprentissage");
		System.out.print("Veuillez saisir la première classe : ");classe1 = e.next();
		System.out.print("Veuillez saisir la deuxième classe : ");classe2 = e.next();
		System.out.print("Veuillez saisir le nombre de colonnes des variables et de la classe : ");colsNumber = e.nextInt();
		cols = new LesColonnes[colsNumber];
		for(int i=0;i<colsNumber;i++){
			String colName,chaineData,chaineVars;
			ArrayList<String> data = new ArrayList<String>();
			ArrayList<String> vars = new ArrayList<String>();
			if(i==colsNumber-1) colName = "Classe";
			else {System.out.print("   Nom de la colonne "+(i+1)+" : ");colName = e.next();}
			if(i!=colsNumber-1){
				System.out.print("      Variables de la colonne ["+colName+"] ( format -> v1;v2;v3;... ) : ");chaineVars = e.next();
				String s[] = chaineVars.split(";");
				for(String d : s){
					vars.add(d);
				}
			}
			System.out.print("      Données de la colonne ["+colName+"] ( format -> d1;d2;d3;... ) : ");chaineData = e.next();
			String s[] = chaineData.split(";");
			for(String d : s){
				data.add(d);
			}
			cols[i] = new LesColonnes(colName,vars,data);
		}
		System.out.println();
		System.out.println("Phase 3 : Résultat de traitement ");
		traitement();
	}
	
	public static void traitement(){
		System.out.println("Calcule de I(s) : ");
		int nb1=0;
		int nb2=0;
		float p1,p2;
		for (String s : cols [colsNumber-1].getData()){
			if(s.equals(classe1)) nb1++;
			else nb2++;
		}
		p1 = (float)nb1/(nb1+nb2);
		p2 = (float)nb2/(nb1+nb2);
		System.out.println("P("+classe1+") = "+nb1+"/"+(nb1+nb2)+" = "+p1);
		System.out.println("P("+classe2+") = "+nb2+"/"+(nb1+nb2)+" = "+p2);
		Is = (double)(-(p1 * Math.log10(p1)/Math.log10(2)) - p2 * Math.log10(p2)/Math.log10(2));
		System.out.println("I(s) = -"+nb1+"/"+(nb1+nb2)+" * Log2("+nb1+"/"+(nb1+nb2)+") - "+nb2+"/"+(nb1+nb2)+" * Log2("+nb2+"/"+(nb1+nb2)+") = "+Is);
		for(int i=0;i<colsNumber-1;i++){
			System.out.println();
			System.out.println();
			System.out.println("Calcule du gain de la variable ["+cols[i].getNom()+"]");
			calculeGain(cols[i]);
		}
	}
	
	public static void calculeGain(LesColonnes c){
		double Ires=0;
		for(String att : c.getVars()){
			double PI = CalculePIForAttribut(c,att);
			Ires = Ires + PI;
		}
		System.out.println();
		System.out.println("Ires("+c.getNom()+") = "+Ires);
		double gain = (double) Is - Ires;
		System.out.println("Gain("+c.getNom()+") = I(s) - Ires("+c.getNom()+") = "+gain);
		
	}
	
	public static double CalculePIForAttribut(LesColonnes c,String att){
		System.out.println();
		int nbAtt=0,nbAttC1=0,nbAttC2=0;
		for(int i=0;i<c.getData().size();i++){
			if (c.getData().get(i).equals(att)){
				nbAtt++;
				if(cols[colsNumber-1].getData().get(i).equals(classe1)) nbAttC1++;
				if(cols[colsNumber-1].getData().get(i).equals(classe2)) nbAttC2++;
			}
		}
		float p1 = (float) nbAttC1/nbAtt;
		float p2 = (float) nbAttC2/nbAtt;
		double I;
		if(nbAttC1==0 || nbAttC2==0)
			I = (double) 0;
		else
			I = (double)(-(p1 * Math.log10(p1)/Math.log10(2)) - p2 * Math.log10(p2)/Math.log10(2));
		System.out.println("I("+att+") = -"+nbAttC1+"/"+nbAtt+" * Log2("+nbAttC1+"/"+nbAtt+") - "+nbAttC2+"/"+nbAtt+" * Log2("+nbAttC2+"/"+nbAtt+") = "+I);
		double PI = (double)nbAtt/c.getData().size()*I;
		System.out.println("P("+att+")*I("+att+") = "+nbAtt+"/"+c.getData().size()+" * I("+att+") = "+PI);
		return PI;
	}
}
