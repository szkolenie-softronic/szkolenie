package pl.softronic.szkolenie.klasy.pojemniki;

public class Skrzynia extends Przechowalnia {

	public static final int MAX_POJEMNOSC = 10;
	
	@Override
	public void wloz(Object o) {
		if(getLista().size()>=MAX_POJEMNOSC){
			System.out.println("Skrzynia jest pe³na. Jest w niej ju¿ "+MAX_POJEMNOSC+" elementów.");
			System.out.println("Nie uda³o siê w³o¿yæ " + o);
		} else {
			super.wloz(o);
		}
	}

	@Override
	public String getNazwaTypuPrzechowalni() {
		return "Skrzynia";
	}

}
