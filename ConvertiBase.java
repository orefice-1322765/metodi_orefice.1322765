/**
 * Lezione 10 - ConvertiBase
 * 
 * Progettare una classe per la conversione di base dei numeri interi
 * Ogni oggetto della classe viene costruito con un intero o con una stringa che contiene l'intero
 * La classe è in grado di convertire l'intero nella base desiderata (restituito sotto forma di stringa)
 * 
 * @author forefice
 */
public class ConvertiBase {
	private int numero, base;

	/**
	 * Costruttore della classe
	 * @param numero da convertire
	 * @param base in cui convertire il numero
	 */
	public ConvertiBase(int numero, int base) {
		this.numero = numero;
		this.base = base;
	}

	/**
	 * Costruttore della classe
	 * @param numero da convertire sotto forma di stringa
	 * @param base in cui convertire il numero sotto forma di stringa
	 */
	public ConvertiBase(String numero, String base) {
		this.numero = Integer.parseInt(numero);
		this.base = Integer.parseInt(base);
	}

	/**
	 * Converte il numero nella base desiderata attraverso il meccanismo delle divisioni iterate
	 */
	public String toString() {
		int risultato = numero / base, resto = numero % base;
		String output = Integer.toString(resto);

		while (risultato > 0) {
			output = risultato % base + output;
			risultato /= base;
		}

		return output;
	}

	public static void main(String[] args) {
		System.out.println("791 in base 6: " + new ConvertiBase(791, 6));
		System.out.println("17 in base 2: " + new ConvertiBase("17", "2"));
	}
}