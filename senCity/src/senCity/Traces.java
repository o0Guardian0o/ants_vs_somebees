package senCity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public abstract class Traces {

	private boolean Debug = false;
	protected Collection<Trace> traces;
	private Scanner smot;
	
	
	public void addTrace(Trace trace) {
		this.traces.add(trace);
	}
	
	public int tailleTraces() {
		return this.traces.size();
	}
	
	public String toString() {
		String Straces = "";
		if (this.traces != null) {
			for (Trace trace : traces) {
				Straces += "La trace est : \n" + trace.toString();
			}
		}
		return Straces;
	}
	
	public void load(String nomDuFichier) throws IOException {
		//initialisation de la collection
		this.initialiser();
		
		//initialisation des paramètres locaux utils
		int compteur = 0;
		int[] pos_col = {0,0,0};
		String current_word = "";
		String current_line = "";
		String[] types = {"Ros Timestamp","SSID","Signal"};
		
		
		//initialisation du scanner ligne
		Scanner Sligne = null;
		try { 
			Sligne = new Scanner(new FileReader(new File(nomDuFichier)));
		}
		catch (IOException e) {
			System.out.println("Le fichier est introuvable");
		}
		String First_Line = Sligne.nextLine();
		if (Debug) {
			System.out.println(First_Line);
		}
		
		smot = new Scanner(First_Line);
		smot.useDelimiter(",");
		
		//trouvons les position des colonnes de ce qu'on cherche
		while (smot.hasNext()) {
			current_word = smot.next();
			compteur ++;
			for (int i=0; i < 3 ; i++) {
				if (current_word.equals(types[i])) {
					pos_col[i] = compteur;
				}
			}
			if (Debug) {
				System.out.println("Au compteur " + compteur + " on a le mot : " + current_word);
			}
		}
		if (Debug) {
			for (int i=0; i < 3; i++) {
				System.out.println("L'indice de la colonne choisi pour "  + types[i] + " en partant de 1 est : " + pos_col[i]);
			}
		}

		//trouvons la ligne d'intérêt
		while (Sligne.hasNextLine()) {
			String ts = "";
			String ssid = "";
			int signal = 0;
			int cpt = 0;
			
			current_line = Sligne.nextLine();
			
			//réinitilisation du Scanner de mots
			smot = new Scanner(current_line);
			smot.useDelimiter(",");
			
			while (smot.hasNext()) {
				current_word = smot.next();
				cpt++;
				if (cpt == pos_col[0]) {
					ts = current_word;
				}
				if (cpt == pos_col[1]) {
					ssid = current_word;
				}
				if (cpt == pos_col[2]) {
					signal = Integer.parseInt(current_word);
				}
			}
			if (Debug) {
				System.out.println("La ligne courrante est : " + current_line
						+ "\nLe Timestamp correspondant est : " + ts +
						"\nLe SSID corresponant est : " + ssid+
						"\nLe signal correspondant est : " + signal);
			}
			Trace current_trace = new Trace(ts,ssid,signal);
			if (Debug) {
				System.out.println(current_trace);
			}
			this.traces.add(current_trace);
		}
	}
	
	public void Save(String nomDuFichier) throws IOException {
		//initilisation du fichier de sauvegarde
		BufferedWriter writting = null;
		try {
			writting = new BufferedWriter(new FileWriter(new File(nomDuFichier)));
		}
		catch (IOException e) {
			System.out.println("Le fichier est introuvable");
		}
		String first_line = "Timestamp, SSID, Signal";
		writting.write(first_line);
		writting.newLine();
		
		for (Trace trace : this.traces) {
			String current_line = trace.toString();
			writting.write(current_line);
			writting.newLine();
			if (Debug) {
				System.out.println(current_line);
			}
		}
		writting.close();
	}
	
	public void setDebugMode (boolean bool) {
		this.Debug = bool;
	}
	
	public abstract void initialiser();
		//
}
