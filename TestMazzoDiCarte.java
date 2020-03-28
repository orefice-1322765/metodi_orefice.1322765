/**
 * Lezione 11 - TestMazzoDiCarte
 * 
 * Testa la classe MazzoDiCarte
 * 
 * @author forefice
 */
public class TestMazzoDiCarte {
	public static void main(String[] args) {
		MazzoDiCarte mazzo = new MazzoDiCarte();
		mazzo.mescola();

		for (int i = 0; i < MazzoDiCarte.TOTALE_CARTE; i++) {
			System.out.println(mazzo.distribuisci());
		}
	}
}