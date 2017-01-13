package pl.softronic.szkolenie.przyklady;

import pl.softronic.szkolenie.util.Files;

public class PlikZInternetu {

	public static void main(String[] args) throws Exception {
//		String nazwa = "C:/Users/wojt3/Desktop/choinka.htm";
//		nazwa = nazwa.replaceAll("//", File.separator);
		String txt = Files.readURLStream("https://maps.googleapis.com/maps/api/directions/json?origin=Warszawa+Metro+Centrum&destination=Warszawa+Emilii+Plater");
		
		System.out.println(txt);
	}

}
