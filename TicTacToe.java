package Fourth;

import java.util.Scanner;
import java.io.IOException;

public class TicTacToe {
	
	// Eingabe 
	static boolean eingabeExceptions(String testEingabe) {
		
		
		try {
			if (Integer.parseInt(testEingabe) < 1 || Integer.parseInt(testEingabe) > 9) {
				System.out.println("Geben Sie bitte eine gültige Zahl zwischen 1 und 9 ein");
				return true;
			} else
				return false;
		}
		catch (Exception e){
			System.out.println("Geben Sie bitte eine Zahl ein ...");
			return true;
		}
		
			
	}

	public static void main(String[] args) throws IOException, InterruptedException{
		
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		
		// Objekte initialisieren
		Scanner sc = new Scanner (System.in);
		Spielfeld neuesSpiel = new Spielfeld();
		
		// Primitive Datentypen initialisieren
		byte spieler = 0;
		boolean test = true;
		

			System.out.println("The Game - tic-tac-toe \n");
			
			do {
				
				neuesSpiel.feldGenerieren();
				
				for (byte i = 0; i < 3; i++)
					System.out.println();
				
				System.out.print("Geben Sie eine verfügbare Zahl aus dem Spielfeld ein: ");
				String eingabe = sc.next();
				
				if (eingabeExceptions(eingabe))
					continue;
					
				neuesSpiel.feldManipulieren(eingabe,spieler);
				
				neuesSpiel.feldAnalyse(spieler);
				if (neuesSpiel.sieg) {
					test = false;
					neuesSpiel.feldGenerieren();
				}

				if (spieler == 0)
					spieler = 1;
				else
					spieler = 0;
				
			} while(test);
			

		 

		
		
		sc.close();
	}
}
