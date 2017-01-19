package pl.softronic.szkolenie.przyklady.wyjatki;

public class Main {

	public static void main(String[] args)  {
		System.out.println("Start");
		
		zwykla();
		
		System.out.println("End.");
	}
	
	public static void zwykla() {
		System.out.println("Metoda zwyk�a");
		try{
			wyjatkowa();
		} catch (NullPointerException e) {
			System.err.println("Przechwycono wyj�tek Null-Pointer: "+e);
		} catch (RuntimeException e) {
			System.err.println("Przechwycono wyj�tek czasu wykonania: "+e);
		} catch (WyjatekZawily e) {
			System.out.println("Przechwycono wyj�tek Zawi�y o przyczynie: "+e.getPrzyczyna());
			e.setPrzyczyna("Przekazanie wyj�tku");
			RuntimeException exc = new RuntimeException("Wyj�tek z przyczyn�", e);
			throw exc;
		} finally {
			System.out.println("Blok \"finally\"");
		}
	}
	
	public static void wyjatkowa() throws WyjatekZawily{
		System.out.println("Metoda wyj�tkowa");
		
		WyjatekZawily wyjatek = new WyjatekZawily();
		//wyjatek.setPrzyczyna("Bo tak!");		
		throw wyjatek;
	}
	
}
