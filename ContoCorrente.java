/**
 * Lezione 6 - ContoCorrente
 * 
 * Si progetti la classe ContoCorrente che rappresenta il conto corrente di un cliente
 * Un oggetto della classe è costruito a partire dall'identificativo del cliente e, opzionalmente,
 * dal valore iniziale del conto corrente (altrimenti pari a 0)
 * 
 * @author forefice
 */
public class ContoCorrente {
	private String identificativoCliente;
	private double importo;

	/**
	 * Costruttore della classe
	 * @param identificativo del cliente
	 */
	public ContoCorrente(String identificativoCliente) {
		this.identificativoCliente = identificativoCliente;
	}

	/**
	 * Costruttore della classe con valore iniziale del conto corrente 
	 * @param identificativo del cliente
	 * @param importo iniziale del conto corrente 
	 */
	public ContoCorrente(String identificativoCliente, double importo) {
		this.identificativoCliente = identificativoCliente;
		this.importo = importo;
	}

	/**
	 * Il valore del conto viene azzerato e il quantitativo di denaro presente viene restituito in output all'utente
	 */
	public void svuota() {
		System.out.println("L'attuale valore del conto corrente di " + getImporto() + " € sta per essere azzerato");
		importo = 0;
	}

	/**
	 * Importo attualmente presente sul conto
	 * @return il valore in euro dell'importo del conto
	 */
	public double getImporto() {
		return importo;
	}

	/**
	 * Identificativo del cliente
	 * @return l'identificativo univoco del cliente
	 */
	public String getIdUtente() {
		return identificativoCliente;
	}

	/**
	 * Sottrae all'attuale importo del conto una somma prelevata dall'utente
	 * @param valore dell'importo da prelevare
	 */
	public void preleva(double valore) {
		importo -= valore;
	}

	/**
	 * Somma all'attuale importo del conto una somma versata dall'utente
	 * @param valore dell'importo versato
	 */
	public void versa(double valore) {
		importo += valore;
	}

	public static void main(String[] args) {
		ContoCorrente conto = new ContoCorrente("Fra Ore", 50000);
		System.out.println("Conto corrente dell'utente \"" + conto.getIdUtente() + "\" inizializzato a " + conto.getImporto() + " €");

		conto.versa(7000);
		System.out.println("Hai versato sul conto 5.000 €, importo attuale: " + conto.getImporto());

		conto.preleva(2000);
		System.out.println("Hai prelevato dal conto 2.000 €, importo attuale: " + conto.getImporto());

		conto.svuota();
		System.out.println("Ora hai " + conto.getImporto() + " € sul tuo conto");
	}
}