package pl.softronic.szkolenie.klasy.dziedziczenie;

public class Main {

	public static void main(String[] args) {
		
		ObiektFizyczny f = new Pojazd();
		String nazwa = f.getNazwa();
		System.out.println(nazwa);
	}

}
