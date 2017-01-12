package pl.softronic.szkolenie.klasy.pojemniki;

public class Szafka implements Pojemny {

	private final int MAX_ROZMIAR;
	private final Szufladka[] model;
	
	public Szafka(int n) {
		MAX_ROZMIAR = n;
		model = new Szufladka[MAX_ROZMIAR];
		for(int i=0; i<MAX_ROZMIAR; i++){
			model[i] = new Szufladka();
		}
	}
	
	@Override
	public void wloz(Object o) {
		System.out.println("Próba w³o¿enia do szafki elementu: " + o);
		for(int i=0; i<MAX_ROZMIAR; i++){
			if(model[i].zlicz() == 0){
				model[i].wloz(o);
				System.out.println("Próba w³o¿enia do szafki powiod³a siê");
				return;
			}
		}
		System.out.println("Próba w³o¿enia do szafki zakoñczona niepowodzeniem, szafka jest pe³na.");
	}

	@Override
	public void oproznij() {
		System.out.println("Opró¿niam szafkê...");
		for(int i=0; i<MAX_ROZMIAR; i++){
			model[i].oproznij();
		}
		System.out.println("Szafkê opró¿niono.");
	}

	@Override
	public long zlicz() {
		long result = 0;
		for(int i=0; i<MAX_ROZMIAR; i++){
			result += model[i].zlicz();
		}
		return result;
	}

	@Override
	public void wypisz() {
		System.out.println("Zawartoœæ szafki:");
		for(int i=0; i<MAX_ROZMIAR; i++){
			System.out.print((i+1) + ": ");
			model[i].wypisz();
		}
	}

	@Override
	public Object wyjmij(Object o) {
		for(int i=0; i<model.length; i++){
			//if(model[i].zlicz() > 0){
				Object zSzufladki = model[i].wyjmij(o);
				if(zSzufladki != null){
					return zSzufladki;
				}
			//}
		}
		return null;
	}

}
