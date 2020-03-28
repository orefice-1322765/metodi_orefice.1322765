/**
 * Lezione 4 - Moltiplica
 * 
 * Scrivere una classe Moltiplica che, dati in input 2 numeri interi, ne restituisca a video il prodotto
 * 
 * @author forefice
 */
public class Moltiplica {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.println("Il prodotto tra " + a + " e " + b + " vale: " + a * b);
	}
}
