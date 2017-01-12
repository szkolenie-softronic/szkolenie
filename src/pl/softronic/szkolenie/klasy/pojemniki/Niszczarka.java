package pl.softronic.szkolenie.klasy.pojemniki;

public class Niszczarka implements Pojemny {

	@Override
	public void wloz(Object o) {
		System.out.println("Wpad³o do niszczarki: "+ o);
	}

	@Override
	public void oproznij() {
		System.out.println("Nic siê nie sta³o. <<Twoja narodowoœæ tutaj>>. Nic siê nie sta³o.");
	}

	@Override
	public long zlicz() {
		return 0;
	}

	@Override
	public void wypisz() {
		System.out.println("Niszczarka jest pusta!");
	}

	@Override
	public Object wyjmij(Object o) {
		System.out.println("Nie powiod³a siê próba wyjêcia z niszczarki elementu: " + o);
		return null;
	}

}
