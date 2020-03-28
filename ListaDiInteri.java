/**
 * Lezione 11 - ListaDiInteri
 * 
 * Che cos'è una lista? E' una sequenza di oggetti!
 * Implementare una classe ListaDiInteri
 * 
 * @author forefice
 */
public class ListaDiInteri {
	private int[] lista;

	public ListaDiInteri(int[] lista) {
		this.lista = lista;
	}

	/**
	 * Restituisce l'elemento i-esimo della lista
	 * @param posizione dell'elemento da ritornare
	 * @return i-esimo elemento della lista
	 */
	public int getValue(int i) {
		if (i >= lista.length) {
			return -1;
		}

		return lista[i];
	}

	/**
	 * Restituisce l'indice della posizione dell'intero passato in input
	 * @param intero di cui si vuole tornare l'indice
	 * @return indice della posizione dell'intero
	 */
	public int indexOf(int n) {
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == n) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Restituisce la lista di interi formattata a mo' di stringa senza alterarne l'ordine
	 * Ad esempio, dato l'array { 8, 6, 5, 7, 1, 3 }
	 * ritorna: [ 8, 6, 5, 7, 1, 3 ]
	 * @return rappresentazione dell'array di interi sotto forma di stringa
	 */
	public String toString() {
		String output = "[ ";

		for (int i = 0; i < lista.length; i++) {
			output += lista[i];
			if (i < lista.length - 1) {
				output += ", ";
			}
		}

		return output + " ]";
	}

	/**
	 * Aggiunge un intero nella posizione specificata
	 * @param indice della lista in cui inserire il nuovo valore
	 * @param valore da inserire all'i-esima posizione della lista
	 */
	public void add(int i, int v) {
		int[] nuovaLista = new int[lista.length + 1];

		for (int k = 0, j = 0; k < nuovaLista.length; k++, j++) {
			if (k == i) {
				nuovaLista[k] = v;
				j--;
			}
			else {
				nuovaLista[k] = lista[j];
			}
		}

		lista = nuovaLista;
	}

	/**
	 * Aggiunge un intero in coda alla lista
	 * @param intero da aggiungere in coda alla lista
	 */
	public void addTail(int v) {
		add(lista.length, v);
	}

	/**
	 * Elimina l'elemento i-esimo della lista
	 * @param indice dell'elemento da rimuovere dalla lista
	 */
	public void remove(int i) {
		int[] nuovaLista = new int[lista.length - 1];

		for (int k = 0, j = 0; k < nuovaLista.length; k++, j++) {
			if (k == i) {
				j++;
				nuovaLista[k] = lista[j];
			}
			else {
				nuovaLista[k] = lista[j];
			}
		}

		lista = nuovaLista;
	}

	/**
	 * Elimina la prima occorrenza di un intero dalla lista
	 * @param valore da rimuovere dalla lista
	 */
	public void removeValue(int v) {
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == v) {
				remove(i);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		ListaDiInteri lista = new ListaDiInteri(new int[] { 1, 2, 10, 2, 42, 7, 8 });
		System.out.println(lista);
		lista.addTail(0);
		System.out.println(lista);
		lista.add(1, 3);
		System.out.println(lista);
		lista.remove(5);
		System.out.println(lista);
		lista.removeValue(2);
		System.out.println(lista);
	}
}