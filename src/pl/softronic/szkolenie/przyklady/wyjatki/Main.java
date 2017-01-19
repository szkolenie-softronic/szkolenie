package pl.softronic.szkolenie.przyklady.wyjatki;

public class Main {

	public static void main(String[] args)  {
		System.out.println("Start");
		
		zwykla();
		
		System.out.println("End.");
	}
	
	public static void zwykla() {
		System.out.println("Metoda zwyk³a");
		try{
			wyjatkowa();
		} catch (NullPointerException e) {
			System.err.println("Przechwycono wyj¹tek Null-Pointer: "+e);
		} catch (RuntimeException e) {
			System.err.println("Przechwycono wyj¹tek czasu wykonania: "+e);
		} catch (WyjatekZawily e) {
			System.out.println("Przechwycono wyj¹tek Zawi³y o przyczynie: "+e.getPrzyczyna());
			e.setPrzyczyna("Przekazanie wyj¹tku");
			RuntimeException exc = new RuntimeException("Wyj¹tek z przyczyn¹", e);
			throw exc;
		} finally {
			System.out.println("Blok \"finally\"");
		}
	}
	
	public static void wyjatkowa() throws WyjatekZawily{
		System.out.println("Metoda wyj¹tkowa");
		
		WyjatekZawily wyjatek = new WyjatekZawily();
		//wyjatek.setPrzyczyna("Bo tak!");		
		throw wyjatek;
	}
	
}
