/**
 * Lezione 4 - Variabili
 * 
 * Scrivere una classe Variabili che, all'interno del metodo main, dichiari una variabile intera i, una variabile di tipo stringa s e una variabile double d.
 * Quindi vengono svolte le seguenti tre operazioni:
 * - La stringa viene inizializzata al valore del primo argomento fornito in input al main
 * - All'intero viene assegnato il valore intero della stringa
 * - Al double viene assegnata la metà del valore di i (ad es. se i è pari a 3, d sarà pari a 1.5)
 * - I valori di s, i e d vengono stampati a video
 * 
 * @author forefice
 */
public class Variabili {
	public static void main(String[] args) {
		int i;
		String s;
		double d;

		s = args[0];
		i = Integer.parseInt(s);
		d = i / 2;

		System.out.println("s: " + s + ", i: " + i + ", d: " + d);
	}
}