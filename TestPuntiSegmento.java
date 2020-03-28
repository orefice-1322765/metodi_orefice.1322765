/**
 * Lezione 8 - TestPuntiSegmento
 * 
 * Testa le classi Punto e Segmento
 * 
 * @author forefice
 */
public class TestPuntiSegmento {

	public static void main(String[] args) {
		// Creo due oggetti della classe Punto con coordinate (1, 3, 8) e (4, 4, 7)
		Punto a = new Punto(1, 3, 8);
		Punto b = new Punto(4, 4, 7);

		// Creo un oggetto della classe segmento che ha per estremi i due punti precedentemente creati
		Segmento segmento = new Segmento(a, b);
	}
}