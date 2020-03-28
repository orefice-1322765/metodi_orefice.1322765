/**
 * Lezione 12 - Carta
 * 
 * Reimplementate le classi Carta e MazzoDiCarte utilizzando le enumerazioni
 * invece degli interi per rappresentare semi e valori delle carte
 * 
 * @author forefice
 */
public class CartaConEnum {
	private SemeCarta seme;
	private ValoreCarta valore;

	public CartaConEnum(SemeCarta seme, ValoreCarta valore) {
		this.seme = seme;
		this.valore = valore;
	}

	public String toString() {
		return valore + " di " + seme;
	}
//	public static void main(String[] args) {
//		System.out.print(SemeCarta.PICCHE);
//
//		ValoreCarta[] valori = ValoreCarta.values();
//		System.out.print(valori[4]);
//
//	}
}