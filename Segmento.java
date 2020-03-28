/**
 * Lezione 8 - Segmento
 * 
 * Progettare una classe Segmento per rappresentare un segmento nello spazio tridimensionale
 * 
 * @author forefice
 */
public class Segmento {
	private Punto a, b;

	/**
	 * Costruttore della classe
	 * Utilizzo due oggetti di tipo Punto per rappresentare i due estremi del segmento
	 * @param primo estremo del segmento
	 * @param secondo estremo del segmento
	 */
	public Segmento(Punto a, Punto b) {
		this.a = a;
		this.b = b;
	}
}