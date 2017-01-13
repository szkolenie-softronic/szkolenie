package pl.softronic.szkolenie.przyklady.serializacja;

import pl.softronic.szkolenie.util.Files;

public class Pisarz {

	public static void main(String[] args) throws Exception {
		Dane d = new Dane.Builder()
				.withImie("Ala")
				.withNazwisko("Makota")
				.withWiek(22)
				.withPlec(Dane.Plec.KOBIETA)
				.get();
		
		Files.writeObject(
				"C:/Users/wojt3/Desktop/dane.dat", d);

	}

}
