/**
 * Lezione 6 - Rettangolo
 * 
 * Progettare una classe Rettangolo i cui oggetti rappresentano un rettangolo
 * e sono costruiti a partire dalle coordinate x, y e dalla lunghezza e altezza del rettangolo
 * 
 * @author forefice
 */
public class Rettangolo {
	private double x;
	private double y;
	private double lunghezza;
	private double altezza;

	/**
	 * Costruttore della classe
	 * @param x coordinata x da sinistra
	 * @param y coordinata y dall'alto
	 * @param lunghezza dimensione della base del rettangolo
	 * @param altezza dimensione dell'altezza del rettangolo
	 */
	public Rettangolo(double x, double y, double lunghezza, double altezza) {
		this.x = x;
		this.y = y;
		this.lunghezza = lunghezza;
		this.altezza = altezza;
	}

	/**
	 * Trasla le coordinate del rettangolo dei valori orizzontali e verticali corrispondenti
	 */
	public void trasla(double destra, double basso) {
		x += destra;
		y += basso;
	}

	/**
	 *  Restituisce una stringa del tipo "(x1, y1)->(x2, y2)" con i punti
	 *  degli angoli in alto a sinistra  e in basso a destra del rettangolo
	 */
	public String toString() {
		double xx = x + lunghezza;
		double yy = y + altezza;
		return "(" + x + ", " + y + ") -> (" + xx + ", " + yy + ")";
	}
}