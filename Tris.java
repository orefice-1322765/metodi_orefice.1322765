import java.util.Random;

/**
 * Lezione 11 - Tris
 * 
 * Progettare una classe Tris che implementi il gioco utilizzando la classe ScacchieraTris
 * 
 * @author forefice
 */
public class Tris {
	private Random random;
	private ScacchieraTris scacchiera;

	public Tris() {
		scacchiera = new ScacchieraTris();
		random = new Random();
	}

	public void gioca() {
		char vincitore = scacchiera.NESSUNO;

		// Finchè ho turni a disposizione e non ho un vincitore
		while (vincitore == scacchiera.NESSUNO && scacchiera.getMosse() < 9) {
			int i = 0, j = 0;
			while (!scacchiera.occupa(i, j)) {
				i = random.nextInt(3);
				j = random.nextInt(3);
			}

			vincitore = scacchiera.vincitore();
			System.out.println(scacchiera);
		}

		if (vincitore == scacchiera.NESSUNO) {
			System.out.println("Nessun vincitore");
		}
		else {
			System.out.println("Il vincitore è " + vincitore);
		}
	}

	public static void main(String[] args) {
		Tris tris = new Tris();
		tris.gioca();
	}
}