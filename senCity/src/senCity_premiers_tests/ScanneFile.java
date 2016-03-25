package senCity_premiers_tests;

import java.io.*;
import java.util.*;


public class ScanneFile {
	
	private String chemin_file;
	private String type;
	private String value;
	private ArrayList<String> lines;
	
	
	public ScanneFile(String chemin,String type, String value) {
		this.chemin_file = chemin;
		this.type = type;
		this.value = value;
		this.lines = new ArrayList<String>();
	}
	public String getWifiCapt(boolean Debug) throws FileNotFoundException {
		//initialisation des paramètres locaux utils
		int compteur = 0;
		int pos_col = 0;
		String current_word = "";
		String current_line = "";
		
		
		//initialisation du scanner ligne
		Scanner Sligne = null;
		try { 
			Sligne = new Scanner(new FileReader(new File(chemin_file)));
		}
		catch (FileNotFoundException e) {
			System.out.println("Le fichier est introuvable");
		}
		String First_Line = Sligne.nextLine();
		if (Debug) {
			System.out.println(First_Line);
		}
		
		//initialisation du scanner de mots
		Scanner Smot = new Scanner(First_Line);
		Smot.useDelimiter(",");
		
		//trouvons la position de la colonne de ce qu'on cherche
		while (!(current_word.equals(this.type)) && Smot.hasNext()) {
			current_word = Smot.next();
			compteur ++;
			if (Debug) {
				System.out.println("Au compteur " + compteur + " on a le mot : " + current_word);
			}
		}
		pos_col = compteur;
		if (Debug) {
			System.out.println("L'indice de la colonne choisi en partant de 1 est : " + pos_col);
		}
		
		//trouvons la ligne d'intérêt
		while (!(current_word.equals(this.value)) && Sligne.hasNextLine()) {
			current_line = Sligne.nextLine();
			
			//réinitilisation du Scanner de mots
			Smot = new Scanner(current_line);
			Smot.useDelimiter(",");
			
			for (int i = 1; i < pos_col ; i++) {
				Smot.next();
			}
			current_word = Smot.next();
			if (Debug) {
				System.out.println("La ligne courrante est : " + current_line
						+ "\nLe mot de la colonne choisi est : " + current_word);
			}
		}
		return current_line;
	}
}
