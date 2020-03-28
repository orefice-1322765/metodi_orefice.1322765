/**
 * Lezione 10 - Cornice
 * 
 * Progettare una classe Cornice che rappresenti una cornice NxN, con eventuale stringa contenuta al suo interno
 * La cornice deve disporre del metodo toString() che ne restituisce la rappresentazione in formato stringa
 * Ad esempio: new Cornice(6, "Cornici in Java").toString() restituisce la seguente stringa
 * ******
 * *Corn*
 * *ici *
 * *in J*
 * *ava *
 * ******
 * 
 * @author forefice
 */
public class Cornice {
	private int n;
	private String stringa;

	/**
	 * Costruttore della classe senza stringa contenuta al suo interno
	 */
	public Cornice(int n) {
		this.n = n;
		this.stringa = "";
	}

	/**
	 * Costruttore della classe con stringa
	 */
	public Cornice(int n, String stringa) {
		this.n = n;
		this.stringa = stringa;
	}

	public String toString() {
		String output = "";
		int lunghezza = stringa.length();

		for (int i = 0, k = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
					output += "*";
				}
				else {
					output += k < lunghezza ? stringa.charAt(k++) : " ";
				}
			}
			output += "\n";
		}

		return output;
	}

	public static void main(String[] args) {
		System.out.print(new Cornice(6));
		System.out.print(new Cornice(6, "Cornici in Java"));
		System.out.print(new Cornice(8, "Dovrebbe funzionare anche così?"));
	}
}