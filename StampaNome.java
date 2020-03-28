/**
 * Lezione 4 - StampaNome
 * 
 * Scrivere una classe StampaNome che, dato in input un nome, lo stampi tra due righe di trattini
 * +---------+
 * Roberto
 * +---------+
 * 
 * @author forefice
 */
public class StampaNome {
	public static void main(String[] args) {
		System.out.println("+---------+");
		System.out.println(args[0]);
		System.out.println("+---------+");
	}
}