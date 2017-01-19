package pl.softronic.szkolenie.przyklady.wyjatki;

public class WyjatekZawily extends WyjatekZwykly {

	private String przyczyna;

	public String getPrzyczyna() {
		return przyczyna;
	}

	public void setPrzyczyna(String przyczyna) {
		this.przyczyna = przyczyna;
	}

	@Override
	public String toString() {
		return "WyjatekZawily [przyczyna=" + przyczyna + "]";
	}
	
	
}
