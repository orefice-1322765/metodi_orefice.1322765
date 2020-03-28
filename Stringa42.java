/**
 * Lezione 8 - Stringa42
 * 
 * Progettare una classe Stringa42, costruita a partire da 3 stringhe in input, che concateni le
 * stringhe inframezzate da spazi e conservi solo i primi 42 caratteri della stringa risultante
 * 
 * @author forefice
 */
public class Stringa42 {
	String stringa;

	/**
	 * Costruttore della classe
	 * @param prima stringa da concatenare
	 * @param seconda stringa da concatenare
	 * @param terza stringa da concatenare
	 */
	public Stringa42(String prima, String seconda, String terza) {
		stringa = prima + " " + seconda + " " + terza;

		// Taglio la stringa se superiore a 42 caratteri
		if (stringa.length() > 42) {
			stringa = stringa.substring(0, 42);
		}
	}

	/**
	 * Restituire la stringa di lunghezza massima 42
	 * @return la stringa concatenata
	 */
	public String getStringa() {
		return stringa;
	}

	/**
	 * Restituisce il primo carattere della stringa
	 * @return il primo carattere della stringa
	 */
	public char getIniziale() {
		return stringa.charAt(0);
	}

	/**
	 * Restituire un booleano che indichi se la stringa è pari al numero "magico" 42
	 * @return true se la stringa è uguale a 42, altrimenti false
	 */
	public boolean isMagic() {
		return stringa.equals("42");
	}

	/**
	 * Restituire un booleano che indichi se la stringa contiene il numero "magico" 42
	 * @return true se la stringa contiene il numero 42, altrimenti false
	 */
	public boolean containsMagic() {
		return stringa.indexOf("42") != -1;
	}

	public static void main(String[] args) {
		Stringa42 s1 = new Stringa42("Ciao", "Ca42sa", "Mia");
		System.out.println("Stringa: " + s1.getStringa());
		System.out.println("Carattere iniziale: " + s1.getIniziale());
		System.out.println("La stringa è uguale a 42? " + s1.isMagic());
		System.out.println("La stringa contieneil numero 42? " + s1.containsMagic());

		Stringa42 s2 = new Stringa42("Non", "contengo", "quarantadue");
		System.out.println("Stringa: " + s2.getStringa());
		System.out.println("Carattere iniziale: " + s2.getIniziale());
		System.out.println("La stringa è uguale a 42? " + s2.isMagic());
		System.out.println("La stringa contieneil numero 42? " + s2.containsMagic());
	}
}