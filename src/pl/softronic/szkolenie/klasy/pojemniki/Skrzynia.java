package pl.softronic.szkolenie.klasy.pojemniki;

public class Skrzynia extends Przechowalnia {

	public static final int MAX_POJEMNOSC = 10;
	
	@Override
	public void wloz(Object o) {
		if(getLista().size()>=MAX_POJEMNOSC){
			System.out.println("Skrzynia jest pe�na. Jest w niej ju� "+MAX_POJEMNOSC+" element�w.");
			System.out.println("Nie uda�o si� w�o�y� " + o);
		} else {
			super.wloz(o);
		}
	}

	@Override
	public String getNazwaTypuPrzechowalni() {
		return "Skrzynia";
	}

}
