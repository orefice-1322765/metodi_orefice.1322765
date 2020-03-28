import java.util.Random;
import java.util.Scanner;

/**
 * Lezione 12 - CampoMinato
 * 
 * Progettare la classe CampoMinato che realizzi il gioco del campo minato
 * (http://it.wikipedia.org/wiki/Campo_minato_(videogioco))
 * Il costruttore deve inizializzare il campo NxM (dove N e M sono interi forniti in ingresso al costruttore
 * insieme al numero m di mine) piazzando casualmente le m mine nel campo
 * 
 * @author forefice
 */
public class CampoMinato {
	Random random;

	private int N;
	private int M;
	private int m;

	private int totaleCaselle;
	private int caselleScoperte;

	public static final int MINA = -1;

	private int[][] campo;

	// Registro tutte le posizioni già scoperte all'interno del campo minato
	private boolean[][] scoperto;

	/**
	 * Costruttore della classe
	 * Inizializza tute le variabili e distribuisce le mine nel campo minato
	 * @param Lunghezza del campo
	 * @param Altezza del campo
	 * @param Numero di mine
	 */
	public CampoMinato(final int N, final int M, final int m) {
		random = new Random();

		this.N = N;
		this.M = M;
		this.m = m;

		totaleCaselle = N * M;

		// Compongo l'array relativa al campo minato e quella delle caselle scoperte
		campo = new int[M][N];
		scoperto = new boolean[M][N];

		// Distribuisco casualmente le mine nel campo
		for (int i = 0; i < m;) {
			int x = random.nextInt(N), y = random.nextInt(M);

			if (campo[y][x] != MINA) {
				campo[y][x] = MINA;
				i++;
			}
		}
	}

	/**
	 * Crea una linea di lunghezza N da riutilizzare nelle stampe
	 * @return linea
	 */
	private String linea() {
		String linea = "";

		for (int i = 0; i < N; i++) {
			linea += "+--";
		}

		return linea;
	}

	/**
	 * Genera l'output del campo minato con le eventuali caselle finora scoperte nel formato:
	 * 
	 *      0  1  2  3  4
	 *    +--+--+--+--+--+
	 *  0 | 0| 1|  |  |  |
	 *    +--+--+--+--+--+
	 *  1 | 0| 2|  |  |  |
	 *    +--+--+--+--+--+
	 *  2 | 1| 3|  |  |  |
	 *    +--+--+--+--+--+
	 *  3 |  |  |  | 1|  |
	 *    +--+--+--+--+--+
	 *  4 |  |  |  |  |  |
	 *    +--+--+--+--+--+
	 * 
	 * @return rappresentazione grafica del campo minato
	 */
	public String toString() {
		String linea = linea(), output = "   ";

		for (int i = 0; i < N; i++) {
			output += i < 10 ? "  " + i : " " + String.valueOf(i);
		}

		output += "\n   " + linea + "+\n";
		for (int i = 0; i < M; i++) {
			String riga = i < 10 ? " " + i + " " : String.valueOf(i) + " ";

			for (int k = 0; k < N; k++) {
				riga += "|" + (scoperto[i][k] ? (campo[i][k] == MINA ? MINA : " " + campo[i][k]) : "  ");
			}

			output += riga + "|" + "\n   " + linea + "+\n";
		}

		return output;
	}

	/**
	 * Genera l'output del campo minato da mostrare quando l'utente perde nel formato:
	 * 
	 *      0  1  2  3  4
	 *    +--+--+--+--+--+
	 *  0 | 0| 1|  |-1| X|
	 *    +--+--+--+--+--+
	 *  1 | 0| 2|-1|-1|  |
	 *    +--+--+--+--+--+
	 *  2 | 1| 3|-1|  |  |
	 *    +--+--+--+--+--+
	 *  3 |  |-1|  | 1|  |
	 *    +--+--+--+--+--+
	 *  4 |-1|-1|  |  |  |
	 *    +--+--+--+--+--+
	 * 
	 * Nella posizione minata scelta inserisco un X invece di -1 per identificarne la posizione
	 * @return campo minato con le caselle finora scoperte e tutte le mine
	 */
	public String perso(int x, int y) {
		String linea = linea(), output = "   ";

		for (int i = 0; i < N; i++) {
			output += i < 10 ? "  " + i : " " + String.valueOf(i);
		}

		output += "\n   " + linea + "+\n";

		for (int i = 0; i < M; i++) {
			String riga = i < 10 ? " " + i + " " : String.valueOf(i) + " ";

			for (int k = 0; k < N; k++) {
				riga += "|" + (campo[i][k] == MINA ? (i == y && k == x ? " X" : MINA) : (scoperto[i][k] ? " " + campo[i][k] : "  "));
			}

			output += riga + "|" + "\n   " + linea + "+\n";
		}

		return output;
	}

	/**
	 * Scopre la casella nella posizione X e Y passate in input dall'utente
	 * Se nella posizione c'è una mina ritorno -1 (e l'utente perde) altrimenti eseguo
	 * una serie di controlli per contare le caselle con una mina adiecanti a quella scelta
	 * Se non ci sono mine adiacenti percorre ricorsivamente le posizioni vicine fino ad
	 * incontrare una cella con un numero di mine adiacenti maggiore di 0
	 * @param coordinata X della cella che si desidera scoprire
	 * @param coordinata Y della cella che si desidera scoprire
	 * @return -1 se è stata selezionato una mina, altrimenti il numero di mine adiacenti alla casella scelta
	 */
	public int scopri(int x, int y) {
		if (campo[y][x] != MINA) {
			int mineAdiacenti = 0;

			// Contro quante mine adiacenti ci sono
			if (y > 0 && campo[y - 1][x] == MINA) { // Sopra
				mineAdiacenti++;
			}
			if (y < M - 1 && campo[y + 1][x] == MINA) { // Sotto
				mineAdiacenti++;
			}
			if (x > 0 && campo[y][x - 1] == MINA) { // Sinistra
				mineAdiacenti++;
			}
			if (x < N - 1 && campo[y][x + 1] == MINA) { // Destra
				mineAdiacenti++;
			}
			if (y > 0 && x > 0 && campo[y - 1][x - 1] == MINA) { // Sopra sinistra
				mineAdiacenti++;
			}
			if (y > 0 && x < N - 1 && campo[y - 1][x + 1] == MINA) { // Sopra destra
				mineAdiacenti++;
			}
			if (y < M - 1 && x > 0 && campo[y + 1][x - 1] == MINA) { // Sotto sinistra
				mineAdiacenti++;
			}
			if (y < M - 1 && x < N - 1 && campo[y + 1][x + 1] == MINA) { // Sotto destra
				mineAdiacenti++;
			}

			campo[y][x] = mineAdiacenti;
			scoperto[y][x] = true;
			caselleScoperte++;

			// Percorre ricorsivamente tutte le posizioni vicine se non ci sono mine adiacenti
			if (mineAdiacenti == 0) {
				if (y > 0 && !scoperto[y - 1][x]) { // Sopra
					scopri(x, y - 1);
				}
				if (y < M - 1 && !scoperto[y + 1][x]) { // Sotto
					scopri(x, y + 1);
				}
				if (x > 0 && !scoperto[y][x - 1]) { // Sinistra
					scopri(x - 1, y);
				}
				if (x < N - 1 && !scoperto[y][x + 1]) { // Destra
					scopri(x + 1, y);
				}
				if (y > 0 && x > 0 && !scoperto[y - 1][x - 1]) { // Sopra sinistra
					scopri(x - 1, y - 1);
				}
				if (y > 0 && x < N - 1 && !scoperto[y - 1][x + 1]) { // Sopra destra
					scopri(x + 1, y - 1);
				}
				if (y < M - 1 && x > 0 && !scoperto[y + 1][x - 1]) { // Sotto sinistra
					scopri(x - 1, y + 1);
				}
				if (y < M - 1 && x < N - 1 && !scoperto[y + 1][x + 1]) { // Sotto destra
					scopri(x + 1, y + 1);
				}
			}

			return mineAdiacenti;
		}

		return MINA;
	}

	/**
	 * Prende in input i due parametri X e Y della casella che si vuole scoprire passati dall'utente in console
	 * Esegue una serie di controlli per evitare eccezioni sulle posizioni del campo e verifica di volta in volta
	 * se l'utente ha vinto, altrimenti permette di continuare a giocare finchè l'utente non perde
	 */
	public void gioca() {
		System.out.print(toString() + "\nInserisci le coordinate X e Y della casella che vuoi scoprire\n> ");

		Scanner input = new Scanner(System.in);
		String[] comandi = input.nextLine().split(" ");

		if (comandi.length != 2) {
			System.out.println("ATTENZIONE! Hai inserito un numero errato di paramentri (" + comandi.length + " inseriti, 2 richiesti)");
			gioca();
		}

		int x = Integer.parseInt(comandi[0]), y = Integer.parseInt(comandi[1]);

		if (x < 0 || x > N - 1 || y < 0 || y > M - 1 || scoperto[y][x]) {
			System.out.println("ATTENZIONE! Hai inserito un parametro non valido o una casella già scoperta");
			gioca();			
		}

		if (scopri(x, y) != MINA) {
			if (vinto()) {
				System.out.println(toString() + "\nComplimenti! Hai vinto");
			}
			else {
				gioca();
			}
		}
		else {
			System.out.println(perso(x, y) + "Hai perso!");
		}
	}

	/**
	 * Controlla quante caselle sono già state scoperte
	 * Se il totale delle caselle ancora da scoprire è uguale al numero di mine ritorno true
	 * @return true se le caselle finora scoperte è uguale al numero di mine, false altrimenti
	 */
	public boolean vinto() {
		if (totaleCaselle - caselleScoperte == m) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		CampoMinato campo = new CampoMinato(5, 5, 8);
		campo.gioca();
	}
}