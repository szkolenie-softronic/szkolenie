package pl.softronic.szkolenie.przyklady.serializacja;

import pl.softronic.szkolenie.util.Files;

public class Czytnik {

	public static void main(String[] args) throws Exception {
		Object o = Files.readObject(
				"C:/Users/wojt3/Desktop/dane.dat");

		if(o instanceof Dane){
			Dane d = (Dane)o;
			System.out.println("Dane: ");
			System.out.println(d);
		} else {
			System.out.println("Z³y obiekt");
		}
		
	}

}
