package pl.softronic.szkolenie.przyklady;

public class Tablice2 {

	public static void main(String[] args){
		System.out.println("Start");
		
		int[][] tablica = new int[10][];
		tablica[3] = new int[20];
		tablica[3][5]=3;
		System.out.println((tablica[3])[5]);
		
		int[] jedenWymiar = tablica[3];
		System.out.println(jedenWymiar[5]);
		
		System.out.println(tablica[6]);
		
		System.out.println("End.");
	}
	
}
