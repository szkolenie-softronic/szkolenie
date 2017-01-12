package pl.softronic.szkolenie.klasy.pojemniki;

public class Main {

	public static void main(String[] args) {
		System.out.println("Start");

		String s = "Wonsz";
		
		Pojemny pojemnik = new Magazyn();
		
		pojemnik.wloz("Ala");
		pojemnik.wloz(s);
		pojemnik.wloz("Beczka");
		pojemnik.wloz("Jajo");
		pojemnik.wloz("Polewka");
		pojemnik.wloz("Heheheszki");
		pojemnik.wloz("Kamil");
		pojemnik.wloz("Janusz");
		pojemnik.wloz("Palec");
		pojemnik.wloz("Pa³ac kultury");
		pojemnik.wloz("Olej rzepakowy");
		pojemnik.wloz("Olej ten przyk³ad");
		
		wypiszStanPojemnika(pojemnik);
		
		wyjmowanie(s, pojemnik);
		
		oproznianie(pojemnik);
		
		System.out.println("End.");
	}

	private static void wypiszStanPojemnika(Pojemny pojemnik) {
		System.out.println("W pojemniku jest "+ pojemnik.zlicz() +" elementów.");
		System.out.println("Zawartoœæ pojemnika: ");
		pojemnik.wypisz();
	}

	private static void wyjmowanie(Object s, Pojemny pojemnik) {
		System.out.println("Wyjmowanie z pojemnika...");
		Object obj = pojemnik.wyjmij(s);
		if(obj == null){
			System.out.println("Nic nie wyjêto z pojemnika");
		} else {
			System.out.println("Wyjêto z pojemnika: " + obj);
		}
		System.out.println("Po wyjmowaniu jest "+ pojemnik.zlicz() +" elementów w pojemniku.");
	}

	private static void oproznianie(Pojemny pojemnik) {
		System.out.println("Opró¿nianie pojemnika...");
		pojemnik.oproznij();
		System.out.println("Opró¿nianie pojemnika zakoñczono.");
		if(pojemnik.zlicz() == 0){
			System.out.println("Pojemnik opró¿niono do zera.");
		} else {
			System.out.println("B³¹d: Pojemnik nie jest pusty po opró¿nianiu.");
		}
	}

}
