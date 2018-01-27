package ArbreDEDecision;
/**
 *
 * @author MOHAMMED.MOURADI
 */
import java.util.ArrayList;

public class LesColonnes {
	private String nom;
	private ArrayList<String> vars;
	private ArrayList<String> data;
	
	public LesColonnes(String nom,ArrayList<String> vars, ArrayList<String> data) {
		super();
		this.nom = nom;
		this.data = data;
		this.vars = vars;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<String> getData() {
		return data;
	}

	public void setData(ArrayList<String> data) {
		this.data = data;
	}

	public ArrayList<String> getVars() {
		return vars;
	}

	public void setVars(ArrayList<String> vars) {
		this.vars = vars;
	}
	
}
