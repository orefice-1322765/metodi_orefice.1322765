import java.util.Arrays;

/**
 * Lezione 11 - SequenzaDiCifre
 * 
 * Progettare una classe SequenzaDiCifre che espone un metodo che, data in input una stringa e un intero N,
 * aggiunga alla sequenza inizialmente vuota (rappresentata mediate un array) le prime N cifre contenute nella stringa
 * (si assuma che ne contenga comunque almeno N).
 * La classe espone anche un metodo toString che fornisce una rappresentazione sotto forma di stringa della sequenza.
 * Ad esempio:
 * SequenzaDiCifre s = new SequenzaDiCifre();
 * s.aggiungiCifre("abc1--23", 2);
 * s.aggiungiCifre("xx0a8b76543100", 4);
 * System.out.println(s.toString());
 * stampa: [1,2,0,8,7,6]
 * 
 * @author forefice
 */
public class SequenzaDiCifre {
	private int[] sequenza = new int[0];

	public void aggiungiCifre(String stringa, int n) {
		int[] nuova = Arrays.copyOf(sequenza, sequenza.length + n);
		int c = 0;

		for (int i = 0; i < stringa.length(); i++) {
			if (Character.isDigit(stringa.charAt(i))) {
				nuova[sequenza.length + c++] = Character.getNumericValue(stringa.charAt(i));
			}
			if (c == n) {
				break;
			}
		}

		sequenza = nuova;
	}

	public String toString() {
		return Arrays.toString(sequenza);
	}

	public static void main(String[] args) {
		SequenzaDiCifre s = new SequenzaDiCifre();
		s.aggiungiCifre("abc1--23", 2);
		s.aggiungiCifre("xx0a8b76543100", 4);
		System.out.println(s.toString());
	}
}