import java.util.Random;
import java.util.Scanner;

public class GiocoDelQuindici {
	private Random random;
	private int[][] tabellina;

	public static final int TESSERE_PER_RIGA = 4;
	public static final int TOTALE_TESSERE = 16;
	public static final int TESSERA_VUOTA = 0;

	public GiocoDelQuindici() {
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

	public boolean scorri(int x, int y, DirezioniTessera direzione) {
		// Esegue una serie di controlli per evitare errori di tipo ArrayIndexOutOfBoundsException
		if (x > TESSERE_PER_RIGA - 1 || y > TESSERE_PER_RIGA - 1) {
			System.out.println("ATTENZIONE! Hai inserito un valore non valido. X ed Y devono essere <= 3");
			return true;
		}

		// Esegue una serie di controlli per evitare errori di tipo ArrayIndexOutOfBoundsException in base alla direzione richiesta
		if (x == 0 && direzione == DirezioniTessera.SINISTRA) {
			System.out.println("ATTENZIONE! Stai cercando di spostare la tessera oltre il bordo sinistro");
			return true;
		}

		if (x == TESSERE_PER_RIGA - 1 && direzione == DirezioniTessera.DESTRA) {
			System.out.println("ATTENZIONE! Stai cercando di spostare la tessera oltre il bordo destro");
			return true;
		}

		if (y == 0 && direzione == DirezioniTessera.SU) {
			System.out.println("ATTENZIONE! Stai cercando di spostare la tessera oltre il bordo superiore");
			return true;
		}

		if (y == TESSERE_PER_RIGA - 1 && direzione == DirezioniTessera.GIU) {
			System.out.println("ATTENZIONE! Stai cercando di spostare la tessera oltre il bordo inferiore");
			return true;
		}

		int xTarget = x, yTarget = y;

		switch (direzione) {
			case SU:
				yTarget = y - 1;
			break;
			case GIU:
				yTarget = y + 1;
			break;
			case SINISTRA:
				xTarget = x - 1;
			break;
			case DESTRA:
				xTarget = x + 1;
			break;
		}

		if (tabellina[yTarget][xTarget] != TESSERA_VUOTA) {
			System.out.println("ATTENZIONE! Stai cercando di spostare la tessera in uno spazio occupato");
			return true;
		}

		tabellina[yTarget][xTarget] = tabellina[y][x];
		tabellina[y][x] = TESSERA_VUOTA;

		if (vinto()) {
			System.out.println("Complimenti!!! Hai vinto!");
			return false;
		}

		return true;
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
		return true;
	}

	public void gioca() {
		stampa();

		System.out.print("\nInserisci tre parametri \"X Y direzione\" (separati da uno spazio)\nEsempio: 3 2 SU\n> ");

		Scanner input = new Scanner(System.in);
		String[] comandi = input.nextLine().split(" ");

		if (comandi.length != 3) {
			System.out.println("ATTENZIONE! Hai inserito un numero errato di paramentri (" + comandi.length + " inseriti, 3 richiesti)");
			gioca();
		}
		else {
			if (!DirezioniTessera.SU.toString().equals(comandi[2]) && !DirezioniTessera.GIU.toString().equals(comandi[2]) && !DirezioniTessera.SINISTRA.toString().equals(comandi[2]) && !DirezioniTessera.DESTRA.toString().equals(comandi[2])) {
				System.out.println("ATTENZIONE! Hai inserito una direzione non valida");
				gioca();
			}

			int x = Integer.parseInt(comandi[0]);
			int y = Integer.parseInt(comandi[1]);
			DirezioniTessera direzione = DirezioniTessera.valueOf(comandi[2]);

			if (scorri(x, y, direzione)) {
				gioca();
			}
		}
	}

	public static void main(String[] args) {
		GiocoDelQuindici gioco = new GiocoDelQuindici();
		gioco.gioca();
	}
}