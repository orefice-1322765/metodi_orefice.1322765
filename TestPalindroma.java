/**
 * Lezione 10 - TestPalindroma
 * 
 * Testa la classe Palindroma
 * 
 * @author forefice
 */
public class TestPalindroma {
	public static void main (String[] args) {
		System.out.println("Primo metodo su \"itopinonavevanonipoti\". E' palindroma: " + new Palindroma().isPalindroma1("itopinonavevanonipoti"));
		System.out.println("Primo metodo su \"angelalavalalegna\". E' palindroma: " + new Palindroma().isPalindroma1("angelalavalalegna"));
		System.out.println("Primo metodo su \"iononsonopalindroma\". E' palindroma: " + new Palindroma().isPalindroma1("iononsonopalindroma"));

		System.out.println();

		System.out.println("Secondo metodo su \"itopinonavevanonipoti\". E' palindroma: " + new Palindroma().isPalindroma2("itopinonavevanonipoti"));
		System.out.println("Secondo metodo su \"angelalavalalegna\". E' palindroma: " + new Palindroma().isPalindroma2("angelalavalalegna"));
		System.out.println("Secondo metodo su \"iononsonopalindroma\". E' palindroma: " + new Palindroma().isPalindroma2("iononsonopalindroma"));

		System.out.println();

		System.out.println("Terzo metodo su \"itopinonavevanonipoti\". E' palindroma: " + new Palindroma().isPalindroma3("itopinonavevanonipoti"));
		System.out.println("Terzo metodo su \"angelalavalalegna\". E' palindroma: " + new Palindroma().isPalindroma3("angelalavalalegna"));
		System.out.println("Terzo metodo su \"iononsonopalindroma\". E' palindroma: " + new Palindroma().isPalindroma3("iononsonopalindroma"));
	}
}