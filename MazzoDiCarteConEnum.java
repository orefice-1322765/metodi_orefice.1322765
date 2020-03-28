import java.util.Random;

/**
 * Lezione 12 - MazzoDiCarte
 * 
 * Reimplementate le classi Carta e MazzoDiCarte utilizzando le enumerazioni
 * invece degli interi per rappresentare semi e valori delle carte
 * 
 * @author forefice
 */
public class MazzoDiCarteConEnum {
	private CartaConEnum[] carte;
	private int posizione;
	public static final int TOTALE_CARTE = 52;

	public MazzoDiCarteConEnum() {
		carte = new CartaConEnum[TOTALE_CARTE];
		ValoreCarta[] valori = ValoreCarta.values();

		for (int i = 0, valore = 0; i < TOTALE_CARTE; valore++) {
			carte[i++] = new CartaConEnum(SemeCarta.PICCHE, valori[valore % 13]);
			carte[i++] = new CartaConEnum(SemeCarta.FIORI, valori[valore % 13]);
			carte[i++] = new CartaConEnum(SemeCarta.QUADRI, valori[valore % 13]);
			carte[i++] = new CartaConEnum(SemeCarta.CUORI, valori[valore % 13]);
		}
	}

	/**
	 * Mescola il mazzo di carte randomizzando gli indici
	 */
	public void mescola() {
		Random random = new Random();

		for (int i = 0; i < TOTALE_CARTE; i++) {
			int indiceCasuale = random.nextInt(carte.length);
			CartaConEnum nuovaCarta = carte[indiceCasuale];
			carte[indiceCasuale] = carte[i];
			carte[i] = nuovaCarta;
		}
	}

	/**
	 * Distribuisce la prossima carta
	 * @return una carta del mazzo
	 */
	public CartaConEnum distribuisci() {
		return carte[posizione++];
	}
}