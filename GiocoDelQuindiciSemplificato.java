import java.util.Random;
import java.util.Scanner;

public class GiocoDelQuindiciSemplificato {
	private Random random;
	private int[][] tabellina;

	public static final int TESSERE_PER_RIGA = 4;
	public static final int TOTALE_TESSERE = 16;
	public static final int TESSERA_VUOTA = 0;

	public GiocoDelQuindiciSemplificato() {
		random = new Random();

		tabellina = new int[][] {
			{ 1, 2, 3, 4 },
			{ 5, 6, 7, 8 },
			{ 9, 10, 11, 12 },
			{ 13, 14, 15, TESSERA_VUOTA }
		};

		mischia();
	}

	public void mischia() {
		for (int i = TOTALE_TESSERE - 1; i > 0; i--) {
			int casuale = random.nextInt(i);
			int riga = i / TESSERE_PER_RIGA;
			int colonna = i - riga * TESSERE_PER_RIGA;

			int rigaCasuale = casuale / TESSERE_PER_RIGA;
			int colonnaCasuale = casuale - rigaCasuale * TESSERE_PER_RIGA;
			int tesseraCasuale = tabellina[riga][colonna];

			tabellina[riga][colonna] = tabellina[rigaCasuale][colonnaCasuale];
			tabellina[rigaCasuale][colonnaCasuale] = tesseraCasuale;
		}
	}

	public void stampa() {
		String linea = "+--+--+--+--+";

		System.out.println("\n" + linea);
		for (int i = 0; i < TESSERE_PER_RIGA; i++) {
			String riga = "";

			for (int k = 0; k < TESSERE_PER_RIGA; k++) {
				int valore = tabellina[i][k];
				riga += "|" + (valore < 10 ? " " : "") + (valore > 0 ? valore : " ");
			}

			System.out.println(riga + "|" + "\n" + linea);
		}
	}

	public void scorri(int tessera) {
		int tessera_x = 0;
		int tessera_y = 0;

		for (int y = 0; y < TESSERE_PER_RIGA; y++) {
			for (int x = 0; x < TESSERE_PER_RIGA; x++) {
				if (tabellina[y][x] == tessera) {
					tessera_x = x;
					tessera_y = y;
				}
			}
		}

		// Provo a spostare la tessera scelta sopra, sotto, a sinistra e a destra
		// Sopra
		if (tessera_y > 0 && tabellina[tessera_y - 1][tessera_x] == TESSERA_VUOTA) {
			tabellina[tessera_y - 1][tessera_x] = tessera;
			tabellina[tessera_y][tessera_x] = TESSERA_VUOTA;
		}
		// Sotto
		else if (tessera_y < 3 && tabellina[tessera_y + 1][tessera_x] == TESSERA_VUOTA) {
			tabellina[tessera_y + 1][tessera_x] = tessera;
			tabellina[tessera_y][tessera_x] = TESSERA_VUOTA;
		}
		// Sinistra
		else if (tessera_x > 0 && tabellina[tessera_y][tessera_x - 1] == TESSERA_VUOTA) {
			tabellina[tessera_y][tessera_x - 1] = tessera;
			tabellina[tessera_y][tessera_x] = TESSERA_VUOTA;
		}
		// Destra
		else if (tessera_x < 3 && tabellina[tessera_y][tessera_x + 1] == TESSERA_VUOTA) {
			tabellina[tessera_y][tessera_x + 1] = tessera;
			tabellina[tessera_y][tessera_x] = TESSERA_VUOTA;
		}
		else {
			System.out.println("ATTENZIONE! Non puoi spostare la tessera con valore " + tessera);
		}

		gioca();
	}

	private boolean vinto() {
		int tessera = 1;

		for (int i = 0; i < TESSERE_PER_RIGA; i++) {
			for (int k = 0; k < TESSERE_PER_RIGA; k++) {
				if (tessera < TOTALE_TESSERE) {
					if (tabellina[i][k] != tessera++) {
						return false;
					}
				}
			}
		}

		stampa();
		System.out.println("Complimenti!!! Hai vinto!");
		return true;
	}

	public void gioca() {
		if (vinto()) {
			return;
		}

		stampa();

		System.out.println("Inserisci il valore della tessera che vuoi spostare\n>");

		Scanner input = new Scanner(System.in);
		int tessera = input.nextInt();

		if (tessera < 1 || tessera > 15) {
			System.out.println("ATTENZIONE! Hai inserito una tessera non valida. Devi inserire un valore compreso tra 1 e 15");
			gioca();
		}

		scorri(tessera);
	}

	public static void main(String[] args) {
		GiocoDelQuindiciSemplificato gioco = new GiocoDelQuindiciSemplificato();
		gioco.gioca();
	}
}