package pl.softronic.szkolenie.przyklady.kolekcje;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.out;

public class Main {

	static String[] tab = "Ala ma kota, a kot ma Alê. Ala go kocha, a kot j¹ wcale.".split(" ");
	static List<String> slowa = Arrays.asList(tab);
	
	public static void main(String[] args) {
		System.out.println("Start");

		Map<String, Integer> mapa = new TreeMap<>();
		
		for(String slowo: slowa){
			if(mapa.containsKey(slowo)){
				Integer i = mapa.get(slowo);
				i++;
				mapa.put(slowo, i);
			} else {
				mapa.put(slowo, 1);
			}
		}
		
//		for(Map.Entry<String, Integer> e : mapa.entrySet()){
//			
//			System.out.println(e.getKey() + " : " + e.getValue());
//		}
		
		mapa.forEach( (k,v)-> out.println(k + " : " + v) );
		
		out.println("End.");
	}

}
