/**
 * Lezione 7 - RegistratoreDiCassa
 * 
 * Progettare una classe che costituisca un modello di registratore di cassa
 *  La classe deve consentire a un cassiere di inserire i prezzi di articoli
 *  e la quantità di denaro pagata dal cliente, calcolando il resto dovuto
 * 
 * @author forefice
 */
public class RegistratoreDiCassa {
	private double totale;
	private double pagato;

	/**
	 * Incrementa il totale con il prezzo di ogni prodotto aggiunto
	 * @param prezzo del prodotto da aggiungere
	 */
	public void aggiungiProdotto(double prezzo) {
		totale += prezzo;
	}

	/**
	 * Incrementa la somma pagata dal cliente
	 * @param somma pagata dal cliente
	 */
	public void paga(double somma) {
		pagato += somma;
	}

	/**
	 * Termina la transazione e calcola il resto dovuto al cliente 
	 * @return resto dovuto al cliente
	 */
	public double resto() {
		return pagato - totale; 
	}

	public static void main(String[] args) {
		RegistratoreDiCassa cassa = new RegistratoreDiCassa();
		System.out.println("Hai avviato una nuova transazione. Aggiungi i tuoi prodotto");

		cassa.aggiungiProdotto(4.5);
		System.out.println("Prezzo del prodotto 4.50 €");

		cassa.aggiungiProdotto(1.5);
		System.out.println("Prezzo del prodotto 1.50 €");

		cassa.aggiungiProdotto(3);
		System.out.println("Prezzo del prodotto 3 €");

		cassa.paga(10);
		System.out.println("Hai dato 10 € alla cassa. Il resto dovuto è di " + cassa.resto() + " €");
	}
}