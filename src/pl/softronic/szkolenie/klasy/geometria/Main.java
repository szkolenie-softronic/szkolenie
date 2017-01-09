package pl.softronic.szkolenie.klasy.geometria;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Punkt o = new Punkt(0,0);
		Random rand = new Random();
		
		int x = 0;
		for(int i=0; i<1000000; i++){
			Punkt r = new Punkt(rand.nextDouble(),rand.nextDouble());
			Odcinek odcinek = new Odcinek(o, r);

			double dl = odcinek.dlugosc() ;
			if(dl<1){
				x++;
			}
		}
		
		System.out.println("x = " + 4*x/1000000d);
	}

}
