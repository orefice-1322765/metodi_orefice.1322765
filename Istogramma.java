/**
 * Lezione 11 - Istogramma
 * 
 * Progettare una classe Istogramma che rappresenta la distribuzione di dati (es. voti degli studenti)
 * in un intervallo da i a j fornito in input (es. da 0 a 31 (trenta e lode))
 * La classe permette di incrementare il conteggio in corrispondenza di ciascun elemento dell'intervallo
 * (es. memorizzando così un nuovo voto di uno studente)
 * La classe può stampare a video l'istogramma corrispondente
 * 
 * @author forefice
 */
public class Istogramma {
	private int i;
	private int j;
	private int[] voti;

	/**
	 * Costruttore della classe
	 * @param i
	 * @param j
	 */
	public Istogramma(int i, int j) {
		this.i = i;
		this.j = j;
		this.voti = new int[j - i + 1];
	}

	/**
	 * Incrementa di uno la k-esima posizione dell'array
	 * @param posizione dell'array da incrementare
	 */
	public void incrementa(int k) {
		if (k >= i && k <= j) {
			voti[k - i]++;
		}
		else {
			System.out.println("Valore \"" + k + "\" non valido. Devi inserire un intero compreso tra " + i + " e " + j);
		}
	}

	/**
	 * Stampa l'istogramma in orizzontale
	 */
	public void stampaOrizzontale() {
		int spazi = String.valueOf(voti[voti.length - 1]).length();

		for (int k = 0; k < voti.length; k++) {

			String riga = String.valueOf(k + i);
			for (int i = 0; i < spazi - String.valueOf(riga).length(); i++) {
				riga = " " + riga;
			}

			riga += " ";

			for (int i = 0; i < voti[k]; i++) {
				riga += ("_");
			}

			if (voti[k] > 0) {
				riga += "(" + voti[k] + ")";
			}
			System.out.println(riga);
		}
	}

	/**
	 * Stampa l'istogramma in verticale
	 */
	public void stampaVerticale() {
		int spazi = String.valueOf(voti[voti.length - 1]).length(), massimo = 0;

		for (int k = 0; k < voti.length; k++) {
			if (voti[k] > massimo) {
				massimo = voti[k];
			}
		}

		for (int y = massimo; y > 0; y--) {
			String riga = "";

			for (int k = 0; k < voti.length; k++) {
				if (voti[k] < y) {
					riga += " ";
				}
				else {
					riga += "|";
				}

				for (int s = 0; s < spazi; s++) {
					riga += " ";
				}
			}
			System.out.println(riga);
		}

		for (int k = 0; k < voti.length; k++) {
			System.out.print(k + i);

			for (int s = 0; s <= spazi - String.valueOf(k + i).length(); s++) {
				System.out.print(" ");
			}
		}
	}
}