/**
 * Lezione 11 - Filtro
 * 
 * Progettare una classe Filtro costruita con un array di interi
 * La classe implementa operazioni che permettono di ottenere nuovi sotto-array dell'array iniziale
 * 
 * @author forefice
 */
public class Filtro {
	private int[] elementi;

	public Filtro(int[] elementi) {
		this.elementi = elementi;
	}

	/**
	 * Metodo di utilità che, dato un array di interi, ne stampi i valori in sequenza
	 * Ad esempio, dato l’array { 3, 6, 3, 8, 5, 7, 1, 0 }
	 * stampa: [ 3, 6, 3, 8, 5, 7, 1, 0 ]
	 * @param array di interi da stampare
	 */
	private static void print(int[] a) {
		System.out.print("[ ");

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + (i == a.length - 1 ? " ]" : ", "));
		}
	}

	/**
	 * Metodo di utilità che riduce l'array ad una dimensione stabilita di elementi
	 * Questo metodo sostituisce il metodo copyOf() del package java.util.Arrays
	 * @param array da ridurre
	 * @param dimensione dell'array da restituire
	 * @return una nuova array contenente i primi n elementi dell'array da copiare
	 */
	private static int[] copyOf(int[] a, int n) {
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = a[i];
		}

		return array;
	}

	/**
	 * Metodo di utilità che controlla se un determinato intero è presente in un'array di interi
	 * @param array di interi in cui cercare
	 * @param valore interp da cercare nell'array
	 * @return true se l'array passata in input contiene l'intero, false altrimenti
	 */
	private boolean contains(int[] a, int k) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == k) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Restituisce tutti gli elementi <= k nell’ordine iniziale
	 * @param array di interi
	 * @return array di interi contenente tutti gli elementi <= k
	 */
	public int[] passaBasso(int k) {
		int[] risultato = new int[elementi.length];
		int c = 0;

		for (int i = 0; i < elementi.length; i++) {
			if (elementi[i] <= k) {
				risultato[c++] = elementi[i];
			}
		}

		return copyOf(risultato, c);
	}

	/**
	 * Restituisce tutti gli elementi >= k nell’ordine iniziale
	 * @param array di interi
	 * @return array di interi contenente tutti gli elementi >= k
	 */
	public int[] passaAlto(int k) {
		int[] risultato = new int[elementi.length];
		int c = 0;

		for (int i = 0; i < elementi.length; i++) {
			if (elementi[i] >= k) {
				risultato[c++] = elementi[i];
			}
		}

		return copyOf(risultato, c);
	}

	/**
	 * Restituisce l’array iniziale da cui sono state eliminate tutte
	 * le occorrenze dell’intero passato in input
	 * @param intero da rimuovere
	 * @return array degli interi iniziali meno quello filtrato
	 */
	public int[] filtra(int n) {
		return filtra(new int[] { n });
	}

	/**
	 * Restituisce l’array iniziale da cui vengono eliminate tutte
	 * le occorrenze di interi presenti nell’array passato in input
	 * @param array contenente gli interi da rimuovere
	 * @return array degli interi iniziali al netto di quelli da filtrare
	 */
	public int[] filtra(int[] rimuovere) {
		int[] risultato = new int[elementi.length];
		int c = 0;

		for (int i = 0; i < elementi.length; i++) {
			if (!contains(rimuovere, elementi[i])) {
				risultato[c++] = elementi[i];
			}
		}

		return copyOf(risultato, c);
	}

	public static void main(String[] args) {
		Filtro filtro = new Filtro(new int[] { 1, 2, 10, 2, 42, 7, 8 });
		print(filtro.passaBasso(3));
		print(filtro.passaAlto(3));
		print(filtro.filtra(new int[] { 2, 7, 42 }));
		print(filtro.filtra(2));
	}
}