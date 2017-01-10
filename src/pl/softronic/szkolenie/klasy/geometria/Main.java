package pl.softronic.szkolenie.klasy.geometria;

public class Main {

	public static void main(String[] args) {
		
		Punkt gora  = new Punkt(10, 0);
		Punkt lewy  = new Punkt( 0, 0);
		Punkt prawy = new Punkt( 0,10);
		
		Trojkat trojkat = new Trojkat(gora, lewy,  prawy);
		System.out.println("Obwód = " + trojkat.getObwod());
		System.out.println("Pole  = " + trojkat.getPole());
		

	}
	


}
