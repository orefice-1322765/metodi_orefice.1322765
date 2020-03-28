/**
 * Lezione 2 - SecondoProgramma
 * 
 * - Scrivere una classe Java chiamata SecondoProgramma che stampi a video la stringa "Hai digitato: " seguita dal primo parametro in input (args[0]).
 * Si utilizzino i metodi print e println
 * - Svolgere nuovamente l'esercizio utilizzando il metodo printf
 * 
 * @author forefice
 */
public class SecondoProgramma {
	public static void main(String[] args) {
		System.out.print("Hai digitato: " + args[0] + " (stampato con print)");
		System.out.println();

		System.out.printf("Hai digitato: %s (stampato con printf)", args[0]);
		System.out.println();
	}
}