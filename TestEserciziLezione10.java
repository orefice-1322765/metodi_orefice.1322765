/**
 * Lezione 10 - TestEserciziLezione10
 * 
 * Testa la classe EserciziLezione10
 * 
 * @author forefice
 */
public class TestEserciziLezione10 {
	public static void main(String[] args) {
		EserciziLezione10 esercizi = new EserciziLezione10();

		System.out.println("Test metodo printMatrix()");
		System.out.println("*************************");
		esercizi.printMatrix(10);
		System.out.println();

		System.out.println("Test metodo contaParole()");
		System.out.println("*************************");
		System.out.println("Totale occorrenze della parola \"aa\" nel testo \"aa a kr kdd aa d aa\": " + esercizi.contaParole("aa a kr kdd aa d aa", "aa"));
		System.out.println();

		System.out.println("Test metodo stringheVerticali()");
		System.out.println("*******************************");
		esercizi.stringheVerticali("Casa", "Coronavirus", "Albero");
		System.out.println();

		System.out.println("Test metodo contaVocali()");
		System.out.println("*************************");
		esercizi.contaVocali("Le aiuole sono pulite");
		System.out.println();

		System.out.println("Test metodo getDivisori()");
		System.out.println("*************************");
		esercizi.getDivisori(20);
		System.out.println();
		System.out.println();

		System.out.println("Test metodo sommaNumeriPrecedenti()");
		System.out.println("***********************************");
		esercizi.sommaNumeriPrecedenti(2, 3, 6);
		System.out.println();
		System.out.println();

		System.out.println("Test metodo ternePitagoriche()");
		System.out.println("******************************");
		esercizi.ternePitagoriche(15);
		System.out.println();

		System.out.println("Test metodo daCifreALettere()");
		System.out.println("*****************************");
		System.out.println(esercizi.daCifreALettere("8452"));
		System.out.println();

		System.out.println("Test metodo daLettereACifre()");
		System.out.println("*****************************");
		System.out.println(esercizi.daLettereACifre("otto quattro cinque due"));
		System.out.println();

		System.out.println("Test metodo triangoloIsoscele()");
		System.out.println("*****************************");
		System.out.println(esercizi.triangoloIsoscele(9));
		System.out.println();

		System.out.println("Test metodo stringaVerticale()");
		System.out.println("******************************");
		esercizi.stringaVerticale();
		System.out.println();
	}
}