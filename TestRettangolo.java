/**
 * Lezione 6 - TestRettangolo
 * 
 * Implementare una classe di test TestRettangolo che verifichi il funzionamento della classe
 * Rettangolo sul rettangolo in posizione (0, 0) e di lunghezza 20 e altezza 10, traslandolo di (10, 5)
 * (ovvero 10 verso destra e 5 in basso)
 * 
 * @author forefice
 */
public class TestRettangolo {
	public static void main(String[] args) {
		Rettangolo rettangolo = new Rettangolo(0, 0, 20, 10);
		rettangolo.trasla(10, 5);
		System.out.print(rettangolo.toString());
	}
}