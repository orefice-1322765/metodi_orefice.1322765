/**
 * Lezione 10 - RettangoloDiCaratteri
 * 
 * Progettare una classe RettangoloDiCaratteri che rappresenta un rettangolo riempito con caratteri *
 * Un oggetto della classe viene costruito fornendo la posizione x, y e la lunghezza e altezza del rettangolo
 * Il metodo draw si occupa di stampare il rettangolo a video, partendo dalla posizione (0,0)
 * Ad esempio, dato il rettangolo (2, 2, 4, 3), il metodo draw() stampa ("_" rappresenta una spazio):
 * _
 * _
 * __****
 * __****
 * __****
 * 
 * @author forefice
 */
public class RettangoloDiCaratteri {
	private int x, y, lunghezza, altezza;
	private char carattere1, carattere2;

	/**
	 * Costruttore della classe
	 * @param x distanza del rettangolo da sinistra
	 * @param y distanza del rettangolo dall' alto
	 * @param lunghezza del rettangolo
	 * @param altezza del rettangolo
	 * @param carattere principare da stampare nel rettangolo
	 * @param secondo carattere da stampare nel rettangolo
	 */
	public RettangoloDiCaratteri(int x, int y, int lunghezza, int altezza) {
		this.x = x;
		this.y = y;
		this.lunghezza = lunghezza;
		this.altezza = altezza;
		this.carattere1 = '*';
		this.carattere2 = '*';
	}

	/**
	 * Permette di specificare il carattere principale da utilizzare per stampare i rettangoli
	 * Se non specificato viene usato il carattere asterisco '*'
	 * @param carattere da stampare nel rettangolo
	 */
	public void setCarattere(char carattere) {
		this.carattere1 = carattere;
	}

	/**
	 * Permette di specificare il carattere principale e il carattere secondario da utilizzare per stampare i rettangoli
	 * Se non specificato viene usato l'asterisco '*' per entrambi i caratteri
	 * @param carattere principare da stampare nel rettangolo
	 * @param secondo carattere da stampare nel rettangolo
	 */
	public void setCarattere(char carattere1, char carattere2) {
		this.carattere1 = carattere1;
		this.carattere2 = carattere2;
	}

	/**
	 * Permette di specificare il carattere principale da utilizzare per stampare i rettangoli
	 * Se non specificato viene usato il carattere asterisco '*'
	 * @param carattere da stampare nel rettangolo
	 */
	public String getCarattere() {
		return "('" + this.carattere1 + "', '" + this.carattere2 + "')";
	}

	/**
	 * Stampo il rettangolo di caratteri scorrendo l'altezza + la distanza dall'alto
	 * e creando di volta in volta le righe da stampare
	 */
	public void draw() {
		for (int i = 0; i < y + altezza; i++) {
			String riga = "";
			if (i < y) {
				riga += "_";
			}
			else {
				for (int k = 0; k < x + lunghezza; k++) {
					riga += k < x ? "_" : carattere1;
				}
			}
			System.out.println(riga);
		}
	}

	/**
	 * Stampa il rettangolo a strisce verticali
	 */
	public void drawVerticalStripes() {
		for (int i = 0; i < y + altezza; i++) {
			String riga = "";
			if (i < y) {
				riga += "_";
			}
			else {
				for (int k = 0; k < x + lunghezza; k++) {
					riga += k < x ? "_" : (k % 2 == 0 ? carattere2 : carattere1);
				}
			}
			System.out.println(riga);
		}
	}

	/**
	 * Stampa il rettangolo a strisce orizzontali
	 */
	public void drawHorizontalStripes() {
		for (int i = 0; i < y + altezza; i++) {
			String riga = "";
			if (i < y) {
				riga += "_";
			}
			else {
				for (int k = 0; k < x + lunghezza; k++) {
					if (i % 2 == 0) {
						riga += k < x ? "_" : carattere1;
					}
					else {
						riga += k < x ? "_" : carattere2;	
					}
				}
			}
			System.out.println(riga);
		}
	}

	/**
	 * Stampa il rettangolo a mo' di scacchiera
	 */
	public void drawChessboard() {
		for (int i = 0; i < y + altezza; i++) {
			String riga = "";
			if (i < y) {
				riga += "_";
			}
			else {
				for (int k = 0; k < x + lunghezza; k++) {
					if (i % 2 == 0) {
						riga += k < x ? "_" : (k % 2 == 0 ? carattere1 : carattere2);
					}
					else {
						riga += k < x ? "_" : (k % 2 == 0 ? carattere2 : carattere1);	
					}
				}
			}
			System.out.println(riga);
		}
	}

	/**
	 * Permetta di modificare la posizione del rettangolo
	 * @param x nuova distanza del rettangolo da sinistra
	 * @param y nuova distanza del rettangolo dall' alto
	 */
	public void modificaPosizione(int x, int y) {
		this.x = x;
		this.y = y;
		draw();
	}
}