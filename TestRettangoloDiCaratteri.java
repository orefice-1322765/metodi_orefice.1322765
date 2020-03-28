/**
 * Lezione 10 - TestRettangoloDiCaratteri
 * 
 * Testa la classe RettangoloDiCaratteri
 * 
 * @author forefice
 */
public class TestRettangoloDiCaratteri {
	public static void main(String[] args) {
		RettangoloDiCaratteri rettangolo1 = new RettangoloDiCaratteri(0,0, 7, 4);
		rettangolo1.setCarattere('$');
		rettangolo1.draw();

		RettangoloDiCaratteri rettangolo2 = new RettangoloDiCaratteri(3, 1, 9, 5);
		rettangolo2.setCarattere('$');
		rettangolo2.drawVerticalStripes();

		RettangoloDiCaratteri rettangolo3 = new RettangoloDiCaratteri(3, 4, 7, 8);
		rettangolo3.setCarattere('$');
		rettangolo3.drawHorizontalStripes();

		RettangoloDiCaratteri rettangolo4 = new RettangoloDiCaratteri(0, 0, 7, 8);
		rettangolo4.setCarattere('/', '-');
		rettangolo4.drawChessboard();

		RettangoloDiCaratteri rettangolo5 = new RettangoloDiCaratteri(0, 0, 4, 4);
		rettangolo5.draw();
		rettangolo5.modificaPosizione(9, 8);
	}
}