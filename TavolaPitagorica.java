/**
 * Lezione 11 - TavolaPitagorica
 * 
 * Scrivere una classe che rappresenti la tavola pitagorica NxN
 * (dove l'intero N è un parametro di costruzione della classe)
 * 
 * @author forefice
 */
public class TavolaPitagorica {
	private int n;
	private int[][] tavola;

	/**
	 * Costruttore della classe
	 * @param dimensione della tavola
	 */
	public TavolaPitagorica(int n) {
		this.n = n;
	}

	/**
	 * Costruisco la tavola attraverso un'iterazione di righe * colonne
	 * @return una matrice (formata da un array bidimensionale di interi) contenente i valore della tavola
	 */
	public int[][] build() {
		tavola = new int[n + 1][n + 1];

		for (int y = 0; y < tavola.length; y++) {
			for (int x = 0; x < tavola.length; x++) {
				tavola[y][x] = y * x;
			}
		}

		return tavola;
	}

	/**
	 * Ritorna il valore della tabella in corrispondenza della posizione (i, j)
	 * @param i
	 * @param j
	 * @return valore della tabella in corrispondenza della posizione (i, j)
	 */
	public int get(int i, int j) {
		return tavola[i][j];
	}

	/**
	 * Stampa la Tavola Pitagorica nel formato:
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * | X |0  |1  |2  |3  |4  |5  |6  |7  |8  |9  |10 |
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * |0  |0  |0  |0  |0  |0  |0  |0  |0  |0  |0  |0  |
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * |1  |0  |1  |2  |3  |4  |5  |6  |7  |8  |9  |10 |
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * |2  |0  |2  |4  |6  |8  |10 |12 |14 |16 |18 |20 |
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * |3  |0  |3  |6  |9  |12 |15 |18 |21 |24 |27 |30 |
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * |4  |0  |4  |8  |12 |16 |20 |24 |28 |32 |36 |40 |
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * |5  |0  |5  |10 |15 |20 |25 |30 |35 |40 |45 |50 |
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * |6  |0  |6  |12 |18 |24 |30 |36 |42 |48 |54 |60 |
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * |7  |0  |7  |14 |21 |28 |35 |42 |49 |56 |63 |70 |
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * |8  |0  |8  |16 |24 |32 |40 |48 |56 |64 |72 |80 |
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * |9  |0  |9  |18 |27 |36 |45 |54 |63 |72 |81 |90 |
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * |10 |0  |10 |20 |30 |40 |50 |60 |70 |80 |90 |100|
	 * +---+---+---+---+---+---+---+---+---+---+---+---+
	 * 
	 * Probabilmente avrei potuto farlo con molti meno for annidati...
	 */
	public void print() {
		int size = String.valueOf(n * n).length();
		String line = "+", header = "| X";

		for (int i = 0; i < size - 2; i++) {
			header += " ";
		}
		header += "|";

		for (int y = 0; y < 1; y++) {
			for (int x = 0; x <= tavola.length; x++) {
				for (int s = 0; s < size; s++) {
					line += "-";				
				}
				line += "+";				
			}
		}

		for (int y = 0; y <= tavola.length; y++) {
			if (y == 0) {
				for (int z = 0; z < tavola.length; z++) {
					header += z;

					for (int i = 0; i < size - String.valueOf(z).length(); i++) {
						header += " ";
					}

					header += "|";
				}
				System.out.println(line + "\n" + header + "\n" + line);
			}
			else {
				String row = "|";
				for (int x = 0; x <= tavola.length; x++) {
					if (x == 0) {
						row += y - 1;

						for (int i = 0; i < size - String.valueOf(y - 1).length(); i++) {
							row += " ";
						}

						row += "|";
					}
					else {
						int value = tavola[y - 1][x - 1];
						int spaces = size - String.valueOf(value).length();
		
						row += value;
		
						for (int i = 0; i < spaces; i++) {
							row += " ";
						}
		
						row += "|";
					}
				}
				System.out.print(row + "\n" + line + "\n");
			}
		}
	}

	public static void main(String[] args) {
		TavolaPitagorica tavola = new TavolaPitagorica(10);
		tavola.build();
		tavola.print();
	}
}