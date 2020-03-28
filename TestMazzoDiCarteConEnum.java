/**
 * Lezione 12 - TestMazzoDiCarte
 * 
 * Testa la classe MazzoDiCarte
 * 
 * @author forefice
 */
public class TestMazzoDiCarteConEnum {
	public static void main(String[] args) {
		MazzoDiCarteConEnum mazzo = new MazzoDiCarteConEnum();
		mazzo.mescola();

		for (int i = 0; i < MazzoDiCarteConEnum.TOTALE_CARTE; i++) {
			System.out.println(mazzo.distribuisci());
		}
	}
}