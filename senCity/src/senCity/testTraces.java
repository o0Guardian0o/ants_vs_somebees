package senCity;

import java.io.IOException;

public class testTraces {
	
	public static void main(String[] args) throws IOException {
		ArrayListTraces a_traces = new ArrayListTraces();
		LinkedListTraces l_traces = new LinkedListTraces();
		a_traces.setDebugMode(false);
		l_traces.setDebugMode(false);
		try {
			System.out.println(Runtime.getRuntime().totalMemory());
			long espace1 = Runtime.getRuntime().freeMemory();
			a_traces.load("capture_wifi.csv");
			System.out.println(Runtime.getRuntime().totalMemory());
			long espace2 = Runtime.getRuntime().freeMemory();
			a_traces.Save("first_capture.txt");
			//calcul de l'espace utilisé
			long method1_used_space = espace1 - espace2;
			System.out.println("Espace utilisé par la méthode avec les arraylist : " + method1_used_space);
			
			System.out.println(Runtime.getRuntime().totalMemory());
			long espace3 = Runtime.getRuntime().freeMemory();
			l_traces.load("capture_wifi.csv");
			System.out.println(Runtime.getRuntime().totalMemory());
			long espace4 = Runtime.getRuntime().freeMemory();
			l_traces.Save("first_capture.txt");
			//calcul de l'espace utilisé
			long method2_used_space = espace3 - espace4;
			System.out.println("Espace utilisé par la méthode avec les linkedlist : " + method2_used_space);
		}
		catch (IOException e) {
			System.out.println("Problème pour trouver le fichier");
		} 
		
	}
}
