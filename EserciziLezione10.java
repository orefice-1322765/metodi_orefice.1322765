import java.util.Scanner;

/**
 * Lezione 10 - EserciziLezione10
 * 
 * Tutti gli esercizi definiti come "Scrivere un metodo che..." della lezione 10
 * 
 * @author forefice
 */
public class EserciziLezione10 {

	/**
	 *  Scrivere un metodo che, dato un intero N, stampi una matrice NxN il cui elemento (i, j) vale:
	 *  - 1 se i è un divisore di j (o viceversa);
	 *  - 0 altrimenti.
	 * @param dimensione della matrice
	 */
	public void printMatrix(int N) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print((i % j == 0 || j % i == 0) ? 1 + " " : 0 + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Scrivere un metodo che, presi in ingresso un testo sotto forma di stringa e una parola,
	 * trasformi il testo in parole (token) e conti le occorrenze della parola nel testo
	 * @param testo in cui cercare la parola
	 * @param parola da cercare nel testo
	 * @return numero di occorrenze di una specifica parola in un testo
	 */
	public int contaParole(String testo, String parola) {
		int occorrenze = 0;
		String[] parole = testo.split(" ");

		for (int i = 0; i < parole.length; i++) {
			if (parole[i].equals(parola)) {
				occorrenze++;
			}
		}

		return occorrenze;
	}

	/**
	 * Scrivere un metodo che legge una stringa da console e la stampa in verticale un carattere per linea
	 * Ad esempio, dato in input “ciao”, viene stampato:
	 * c
	 * i
	 * a
	 * o
	 */
	public void stringaVerticale() {
		Scanner input = new Scanner(System.in);
		System.out.print("Inserisci una parola: ");

		String parola = input.nextLine();

		for (int i = 0; i < parola.length(); i++) {
			System.out.println(parola.charAt(i));
		}
	}

	/**
	 * Scrivere un metodo che riceve tre stringhe e le stampa in verticale una accanto all'altra
	 * Ad esempio: date "ciao", "buondì", "hello", stampa:
	 * cbh
	 * iue
	 * aol
	 * onl
	 *  do
	 *  ì
	 * @param prima stringa da verticalizzare
	 * @param seconda stringa da verticalizzare
	 * @param terza stringa da verticalizzare
	 */
	public void stringheVerticali(String prima, String seconda, String terza) {
		int primaLunghezza = prima.length(), secondaLunghezza = seconda.length(), terzaLunghezza = terza.length();
		int massimo = Math.max(Math.max(primaLunghezza, secondaLunghezza), terzaLunghezza);

		for (int i = 0; i < massimo; i++) {
			String riga = "";

			riga += primaLunghezza > i ? prima.charAt(i) : " ";
			riga += secondaLunghezza > i ? seconda.charAt(i) : " ";
			riga += terzaLunghezza > i ? terza.charAt(i) : " ";

			System.out.println(riga);
		}
	}

	/**
	 * Scrivere un metodo che riceve una stringa e stampa a video il conteggio delle vocali in essa contenute
	 * Ad esempio: data la stringa “le aiuole sono pulite”, il metodo stampa: a=1 e=3 i=2 o=3 u=2
	 * @param stringa la stringa in cui contare le vocali
	 */
	public void contaVocali(String stringa) {
		String[] lettere = stringa.split("");
		int a = 0, e = 0, i = 0, o = 0, u = 0;

		for (int k = 0; k < lettere.length; k++) {
			switch (lettere[k]) {
				case "a": a++; break;
				case "e": e++; break;
				case "i": i++; break;
				case "o": o++; break;
				case "u": u++; break;
			}
		}

		System.out.println("a=" + a + " e=" + e + " i=" + i + " o=" + o + " u=" + u);
	}

	/**
	 * Scrivere un metodo che, dato un intero positivo n in ingresso, stampi i divisori propri di n (ovvero i divisori < n)
	 * Ad esempio, dato l'intero 20, il metodo stampa: 1, 2, 4, 5, 10
	 * @param numero del quale individuare i divisori
	 */
	public void getDivisori(int n) {
		if (n < 0) {
			System.out.println("Sono ammessi solo valori positivi!");
		}

		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				System.out.print(i + (i < n / 2 ? ", " : ""));
			}
		}
	}

	/**
	 * Scrivere un metodo che, dati in ingresso due interi a e b e un terzo intero N,
	 * stampi a e b e gli N numeri della sequenza in cui ogni numero è la somma dei due precedenti
	 * Ad esempio, dati gli interi 2, 3 e 6, il metodo stampa: 2, 3, 5, 8, 13, 21, 34, 55
	 * @param primo intero
	 * @param secondo intero
	 * @param terzo intero
	 */
	public void sommaNumeriPrecedenti(int a, int b, int n) {
		System.out.print(a + ", " + b);

		for (int i = 0; i < n; i++) {
			int somma = a + b;
			a = b;
			b = somma;
			System.out.print(", " + somma);
		}
	}

	/**
	 * Una terna pitagorica è una tripla di numeri interi a, b, c tali che 1 <= a <= b <= c e a2 + b2 = c2
	 * Ovvero a e b sono i lati di un triangolo rettangolo e c l'ipotenusa
	 * Scrivere un metodo che legge un intero N e stampa tutte le triple pitagoriche con c <= N
	 * Ad esempio: dato N=15 il metodo stampa:
	 * a=3 b=4 c=5
	 * a=6 b=8 c=10
	 * a=5 b=12 c=13
	 * a=9 b=12 c=15
	 * @param n
	 */
	public void ternePitagoriche(int n) {
		for (int c = 1; c <= n; c++) {
			for (int b = 1; b <= c; b++) {
				for (int a = 1; a <= b; a++) {
					if (a * a + b * b == c * c) {
						System.out.println("a=" + a + " b=" + b + " c=" + c);
					}
				}
			}
		}
	}

	/**
	 * Scrivere un metodo che prenda in ingresso una stringa contenente cifre e restituisca
	 * una stringa in cui ciascuna cifra è stata trasformata nella parola corrispondente
	 * Ad esempio, data in input la stringa "8452", il metodo restituisce "otto quattro cinque due"
	 * @param cifra da trasformare in parole
	 * @return una stringa composta delle cifre passate in input sotto forma di parole
	 */
	public String daCifreALettere(String cifre) {
		String output = "";
		String[] numeri = cifre.split("");

		for (int i = 0; i < numeri.length; i++) {
			if (i > 0) {
				output += " ";
			}

			switch (numeri[i]) {
				case "0":
					output += "zero";
					break;
				case "1":
					output += "uno";
					break;
				case "2":
					output += "due";
					break;
				case "3":
					output += "tre";
					break;
				case "4":
					output += "quattro";
					break;
				case "5":
					output += "cinque";
					break;
				case "6":
					output += "sei";
					break;
				case "7":
					output += "sette";
					break;
				case "8":
					output += "otto";
					break;
				case "9":
					output += "nove";
					break;
			}
		}

		return output;
	}

	/**
	 * Scrivere un metodo che prenda in ingresso una stringa contenente cifre scritte a lettere
	 * e restituisca una stringa contenente le cifre corrispondenti
	 * Ad esempio, data in input la stringa "otto quattro cinque due", il metodo restituisce "8452"
	 * @param cifre scritte in lettere
	 * @return una stringa composta delle cifre passate in input sotto forma di numeri
	 */
	public String daLettereACifre(String cifre) {
		String output = "";
		String[] numeri = cifre.split(" ");

		for (int i = 0; i < numeri.length; i++) {
			switch (numeri[i]) {
				case "zero":
					output += "0";
					break;
				case "uno":
					output += "1";
					break;
				case "due":
					output += "2";
					break;
				case "tre":
					output += "3";
					break;
				case "quattro":
					output += "4";
					break;
				case "cinque":
					output += "5";
					break;
				case "sei":
					output += "6";
					break;
				case "sette":
					output += "7";
					break;
				case "otto":
					output += "8";
					break;
				case "nove":
					output += "9";
					break;
			}
		}

		return output;
	}

	/**
	 * Scrivere un metodo che, dato un intero positivo dispari N,
	 * stampi un triangolo isoscele la cui base è costituita da N caratteri
	 * Ad esempio, dato l'intero 5, il metodo stampa:
	 *   *
	 *  ***
	 * *****
	 * @param n intero positivo dispari
	 * @return una stringa rappresentante il triangolo isoscele di base n
	 */
	public String triangoloIsoscele(int n) {		
		if (n % 2 == 0) {
			return "Sono ammessi solo interi dispari";
		}

		String output = "";
		int meta = n / 2;

		for (int i = 0; i < meta + 1; i++) {
			int spazi = meta - i;

			for (int j = 0; j < spazi; j++) {
				output += " ";
			}

			for (int k = i * 2; k >= 0; k--) {
				output += "*";
			}

			output += "\n";
		}

		return output;
	}
}