import java.util.Random;

/**
 * Lezione 11 - MazzoDiCarte
 * 
 * Progettare una classe MazzoDiCarte che rappresenti un intero mazzo da 52 carte
 * 
 * @author forefice
 */
public class MazzoDiCarte {
	private Carta[] carte;
	private int posizione;
	public static final int TOTALE_CARTE = 52;

	public MazzoDiCarte() {
		carte = new Carta[TOTALE_CARTE];

		for (int i = 0, valore = 1; i < TOTALE_CARTE; valore++) {
			carte[i++] = new Carta("Picche", valore);
			carte[i++] = new Carta("Fiori", valore);
			carte[i++] = new Carta("Quadri", valore);
			carte[i++] = new Carta("Cuori", valore);
		}
	}

	/**
	 * Mescola il mazzo di carte randomizzando gli indici
	 */
	public void mescola() {
		Random random = new Random();

		for (int i = 0; i < TOTALE_CARTE; i++) {
			int indiceCasuale = random.nextInt(carte.length);
			Carta nuovaCarta = carte[indiceCasuale];
			carte[indiceCasuale] = carte[i];
			carte[i] = nuovaCarta;
		}
	}

	/**
	 * Distribuisci la prossima carta
	 * @return una carta del mazzo
	 */
	public Carta distribuisci() {
		return carte[posizione++];
	}
}