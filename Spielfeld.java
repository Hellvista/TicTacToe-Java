package Fourth;

public class Spielfeld {
	
	// Klassenattribute
	String[][] feld = { 
			{"1", " | ", "2", " | ", "3"}, 
			{"_", "_" , "|", "_", "_", "_", "|", "_", "_"}, 
			{"4", " | ", "5", " | ", "6"}, 
			{"_", "_" , "|", "_", "_", "_", "|", "_", "_"},
			{"7", " | ", "8", " | ", "9"},
			{" ", " | ", " ", " | ", " "}};	
	String[] SpielerSymbol = {"X", "O"};
	short zug = 0;
	byte dreiGewinnt = 0;
	boolean sieg = false;
	
	// Methoden Abschnitt
	//
	// Generiere aktuellen Spielstand
	public void feldGenerieren() {
		
		for (byte i = 0; i < this.feld.length; i++) {
			for (byte j = 0;  j < this.feld[i].length; j++) {
				System.out.print(this.feld[i][j]);
			}
			System.out.println();
		}
	}	// Methoden ende
	
	// manipuliere Spielfeld mit eingebenem Parameter
	public void feldManipulieren(String zahlEingabe, byte spieler) {
		
		boolean fertig = false;
		
		for (byte i = 0; i < this.feld.length; i +=2) {	
			for (byte j = 0;  j < this.feld[i].length; j += 2) {
				if (this.feld[i][j].equals(zahlEingabe)){
					this.feld[i][j] = SpielerSymbol[spieler];
					fertig = true;
					break;
				} else
					fertig = false;
			}
			if (fertig)
				break;
		} 
		
	}	// Methoden ende
	 
	// prüfen, ob es einen Gewinner gibt
	public void feldAnalyse(byte spieler) {
		
		
		
		do{
			// prüfe Waagerecht
			for (byte i = 0; i < this.feld.length; i +=2) {
				for (byte j = 0;  j < this.feld[i].length; j += 2) {
					if (feld[i][j].contains(SpielerSymbol[spieler]))
						++dreiGewinnt;
				}
				if (dreiGewinnt == 3) {
					sieg = true;
					break;
					}
				else
					dreiGewinnt = 0;
			}
			if (sieg)
				continue;
			
			// prüfe Senkrecht
			for (byte reihe = 0; reihe < this.feld.length; reihe +=2) {
				for (byte i = 0; i < this.feld.length; i +=2) {
					if (feld[i][reihe].contains(SpielerSymbol[spieler]))
						++dreiGewinnt;
				}
				if (dreiGewinnt == 3) {
					sieg = true;
					break;
					}
				else
					dreiGewinnt = 0;
			}
			if (sieg)
				continue;
			
			// prüfe Diagonal ffff
			for (byte i = 0; i < 2; i++) {
				for (byte j = 0; j < 5; j += 2) {
					if (feld[j][j].contains(SpielerSymbol[spieler]))
						++dreiGewinnt;
					else if (feld[4-j][j].contains(SpielerSymbol[spieler]))
						++dreiGewinnt;
				}
				if (dreiGewinnt == 3) {
					sieg = true;
					break;
					}
				else
					dreiGewinnt = 0;
			}
		} while (false);
		if (sieg)
			System.out.println("Spieler " + SpielerSymbol[spieler] + " hat gewonnen");
	}	// Analyse-Methoden ende
	
}	// Class ende
