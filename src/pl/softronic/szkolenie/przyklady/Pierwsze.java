package pl.softronic.szkolenie.przyklady;

import java.util.LinkedList;
import java.util.List;

public class Pierwsze extends Thread {

	static final String NAPIS_PRZECINEK = ", ";
	int szukana;
	boolean czyPierwsza = true;

	@Override
	public void run() {
		for (int liczba = szukana - 2; liczba > 2; liczba -= 2) {
			if (szukana % liczba == 0) {
				czyPierwsza = false;
				return;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");
		int liczbaProcesorow = Runtime.getRuntime().availableProcessors();
		System.out.println("Liczba procesorów: " + liczbaProcesorow);
		Pierwsze[] watki = new Pierwsze[liczbaProcesorow];
		System.out.println("2,\n3,");

		int szukana = 5;
		List<Integer> znalezione = new LinkedList<>();
		while (true) {
			int indexWatku = ((szukana + 3) / 2) % liczbaProcesorow;

			if (watki[indexWatku] != null) {
				watki[indexWatku].join();
				if (watki[indexWatku].czyPierwsza) {
					if(watki[indexWatku].szukana > 1000000){
						znalezione.add(watki[indexWatku].szukana);
					}
					//System.out.println(watki[indexWatku].szukana + ",");
				}
			}
			
			if(znalezione.size()>20){
				StringBuilder str = new StringBuilder();
				for(int liczba : znalezione){
					str.append(liczba);
					str.append(NAPIS_PRZECINEK);
				}
				System.out.println(str);
				znalezione.clear();
			}

			watki[indexWatku] = new Pierwsze();
			watki[indexWatku].szukana = szukana;
			watki[indexWatku].start();

			szukana += 2;
		}

		//System.out.println("End.");
	}

}
