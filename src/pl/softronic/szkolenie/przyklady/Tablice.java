package pl.softronic.szkolenie.przyklady;

import java.util.Random;

public class Tablice {

	public static void main(String[] args) {
		System.out.println("Start");
		Random rand = new Random();

		int[] tab = new int[1000];

		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int) (rand.nextDouble() * 1000 + 1);
		}

		szukaj(tab, 200);
		szukajMax(tab);

		System.out.println("End.");
	}

	private static void szukajMax(int[] tablica) {
		System.out.println("Szukam max");
		int max = 0;
		for (int i = 0; i < tablica.length; i++) {
			if (tablica[i] > max) {
				max = tablica[i];
				System.out.println(i + " : " + tablica[i]);
			}
		}
	}

	private static void szukaj(int[] tablica, int x) {
		System.out.println("Szukam: " + x);
		int i = 0;
		for (int y : tablica) {
			if (y == x) {
				System.out.println(i + " : " + y);
			}
			i++;
		}
	}

}
