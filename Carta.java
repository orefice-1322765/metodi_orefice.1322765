/**
 * Lezione 11 - Carta
 * 
 * Progettare una classe Carta che rappresenti una singola carta da gioco (con seme e valore)
 * La classe deve restituire su richiesta la propria rappresentazione sotto forma di stringa
 * 
 * @author forefice
 */
public class Carta {
	private String seme;
	private int valore;

	public Carta(String seme, int valore) {
		this.seme = seme;
		this.valore = valore;
	}

	public String toString() {
		return valore + " di " + seme;
	}
}