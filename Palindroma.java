/**
 * Lezione 10 - Palindroma
 * 
 * Una stringa è palindroma se rimane uguale quando viene letta da sinistra verso destra o da destra verso sinistra
 * Scrivere un metodo che dica che una stringa è palindroma
 * 
 * @author forefice
 */
public class Palindroma {
	/**
	 * Prima versione del metodo
	 * Utilizza un ciclo for che di volta in volta confronta il primo e l'ultimo carattere della stringa
	 * (incrementando ad ogni ciclo di uno la prima posizione e decrementando di uno l'ultima)
	 * @param stringa da valutare
	 * @return true se la stringa è palindroma, altrimenti false
	 */
	public boolean isPalindroma1(String stringa) {
		for (int x = 0, y = stringa.length() - 1; x < y; x++, y--) {
			if (stringa.charAt(x) != stringa.charAt(y)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Seconda versione del metodo
	 * Utilizza un ciclo while che di volta in volta confronta il primo e l'ultimo carattere della stringa
	 * (incrementando ad ogni ciclo di uno la prima posizione e decrementando di uno l'ultima,
	 * per risparmiare codice utilizzo un post incremento e un post decremento)
	 * finchè la posizione di sinistra è minore di quella di destra
	 * @param stringa da valutare
	 * @return true se la stringa è palindroma, altrimenti false
	 */
	public boolean isPalindroma2(String stringa) {
		int x = 0, y = stringa.length() - 1;

		while (x < y) {
			if (stringa.charAt(x++) != stringa.charAt(y--)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Terza versione del metodo
	 * Utilizza un ciclo while che di volta in volta confronta una sottostringa della stringa iniziale
	 * Questo metodo, che è stato il primo a venirmi in mente, credo sia troppo dispendioso rispetto agli altri
	 * @param stringa da valutare
	 * @return true se la stringa è palindroma, altrimenti false
	 */
	public boolean isPalindroma3(String stringa) {
		int lunghezza = stringa.length();

		while (lunghezza > 1) {
			if (stringa.charAt(0) != stringa.charAt(lunghezza - 1)) {
				return false;	
			}
			stringa = stringa.substring(1, lunghezza - 1);
			lunghezza -= 2;
		}

		return true;
	}
}