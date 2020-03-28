import java.util.Random;

/**
 * Lezione 11 - ScacchieraTris
 * 
 * Progettare una classe ScacchieraTris che implementi la scacchiera del gioco del tris
 * La classe deve memorizzare la scacchiera i cui elementi possono essere:
 * " " (se non è stata ancora occupata la casella)
 * "X" oppure "O" (secondo il giocatore che ha occupato la casella)
 * La classe deve stampare in qualsiasi momento
 * La classe deve stampare in qualsiasi momento la situazione della scacchiera
 * Deve permettere di occupare una casella con un simbolo "X" o "O"
 * 
 * @author forefice
 */
public class ScacchieraTris {
	Random random;

	private char[][] scacchiera;

	public static final char X = 'X';
	public static final char O = 'O';
	public static final char NESSUNO = '\0';

	private int mosse;
	private char giocatore;
	
	public ScacchieraTris()	{
		scacchiera = new char[3][3];

		// Assegno casualmente il primo giocatore
		giocatore = Math.random() < 0.5 ? X : O;
	}

	public String toString() {
		String output = "";

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				output += " " + scacchiera[i][k] + (k < 2 ? " |" : "\n");
			}

			output += i < 2 ? "---+---+---\n" : " ";
		}

		return output;
	}

	public int getMosse() {
		return mosse;
	}

	public char getGiocatore() {
		return giocatore;
	}

	public boolean occupa(int x, int y) {
		if (scacchiera[x][y] == NESSUNO) {
			// Occupa la posizione
			scacchiera[x][y] = giocatore;

			// Inverte il giocatore
			giocatore = giocatore == X ? O : X;

			// Incrementa il numero di mosse fatte 
			mosse++;

			return true;
		}

		return false;
	}

	public char vincitore() {
		for (int i = 0; i < 3; i++) {
			if (scacchiera[i][0] == scacchiera[i][1] && scacchiera[i][1] == scacchiera[i][2]) {
				return scacchiera[i][0];
			}

			if (scacchiera[0][i] == scacchiera[1][i] && scacchiera[1][i] == scacchiera[2][i]) {
				return scacchiera[0][i];
			}
		}

		if (scacchiera[0][0] == scacchiera[1][1] && scacchiera[1][1] == scacchiera[2][2]) {
			return scacchiera[0][0];
		}

		if (scacchiera[0][2] == scacchiera[1][1] && scacchiera[1][1] == scacchiera[2][0]) {
			return scacchiera[0][2];
		}

		return NESSUNO;
	}
}