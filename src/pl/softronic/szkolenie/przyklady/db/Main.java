package pl.softronic.szkolenie.przyklady.db;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import pl.softronic.szkolenie.przyklady.db.model.Dokument;
import pl.softronic.szkolenie.przyklady.db.model.User;
import pl.softronic.szkolenie.przyklady.db.service.UserDAO;
import pl.softronic.szkolenie.przyklady.serializacja.Dane;

public class Main {

	static final Scanner scaner = new Scanner(System.in);
	public static User user = null;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");
		UserDAO.load();
		
		String actUsername = null;
		if(args.length>0){
			actUsername = args[0];
		}
		if(actUsername==null){
			actUsername = pytanieOUsername();
		}
		user = UserDAO.getByUsername(actUsername);
		if(user == null){
			tworzenieNowegoUzytkownika(actUsername);
		}
		powitanie();
		
		int polecenie = -1;
		while(polecenie!=0){
			System.out.println("0: Wyjœcie");
			System.out.println("1: Usuñ siebie z bazy danych");
			System.out.println("2: Listuj dokumenty");
			System.out.println("3: Nowy dokument");
			System.out.println("4: Usuñ dokument");
			System.out.println("5: Odczytaj dokument");
			if(user.isAdmin()){
				System.out.println("6: lista u¿ytkowników");
				System.out.println("7: usuñ u¿ytkownika");
				System.out.println("8: nadaj uprawnienia administratora");
				System.out.println("9: zabierz uprawnienia administratora");
			}
			
			//TODO: menu tutaj bêdzie
			polecenie = odczytNumeruPolecenia();
			if(polecenie == 1){
				UserDAO.remUser(user);
				break;
			}
			if(polecenie == 2){
				listaDokumentow();
			}
			if(polecenie == 3){
				nowyDokument();
			}
			if(polecenie == 4){
				usunDokument();
			}
			if(polecenie == 5){
				czytajDokument();
			}
			if(polecenie == 6 && user.isAdmin()){
				System.out.println("Lista u¿ytkowników");
			}
			if(polecenie == 7 && user.isAdmin()){
				System.out.println("Wybierz u¿ytkownika");
			}
			if(polecenie == 8 && user.isAdmin()){
				System.out.println("Wybierz u¿ytkownika");
			}
			if(polecenie == 9 && user.isAdmin()){
				System.out.println("Wybierz u¿ytkownika");
			}
		}
		
		UserDAO.save();
		System.out.println("End.");
	}

	private static void czytajDokument() {
		if(user.getDokumenty().isEmpty()){
			System.out.println("Brak dokumentów.");
		} else {
			System.out.println("Wybierz dokument do odczytania:");
		}
		Dokument[] tab = user.getDokumenty().toArray(new Dokument[0]);
		for(int i=0; i<tab.length; i++){
			System.out.println((i+1) + ": "+tab[i]);
		}
		System.out.println((tab.length+1)+": wyjdx z odczytywania dokumentów");
		int iDoc = odczytNumeruPolecenia() - 1 ;
		if(iDoc>-1 && iDoc<tab.length){
			Dokument dokument = tab[iDoc];
			System.out.println("------------------------------------");
			System.out.println("Autor: "+user.getUsername());
			System.out.println("Tytu³: "+dokument.getTytul());
			System.out.println("Treœæ: "+dokument.getTresc());
			System.out.println("------------------------------------");
		}
	}

	private static void usunDokument() {
		if(user.getDokumenty().isEmpty()){
			System.out.println("Brak dokumentów.");
		} else {
			System.out.println("Wybierz dokument do usuniêcia:");
		}
		Dokument[] tab = user.getDokumenty().toArray(new Dokument[0]);
		for(int i=0; i<tab.length; i++){
			System.out.println((i+1) + ": "+tab[i]);
		}
		System.out.println((tab.length+1)+": Nie usuwaj");
		int iDoc = odczytNumeruPolecenia() - 1 ;
		if(iDoc>-1 && iDoc<tab.length){
			user.getDokumenty().remove(tab[iDoc]);
			System.out.println("Usuniêto: " + tab[iDoc].getTytul());
		}
	}

	private static void nowyDokument() {
		Dokument doc = new Dokument();
		doc.setAutor(user);
		System.out.println("Wprowadz nowy dokument");
		System.out.print("Tutu³: ");
		doc.setTytul(scaner.nextLine());
		System.out.print("Tresc: ");
		doc.setTresc(scaner.nextLine());
		user.getDokumenty().add(doc);
	}

	private static void listaDokumentow() {
		System.out.println("Lista dokumentów:");
		if(user.getDokumenty().isEmpty()){
			System.out.println("   Jest pusta.");
		}
		for(Dokument d : user.getDokumenty()){
			System.out.println(d);
		}
	}

	private static int odczytNumeruPolecenia() {
		int polecenie;
		System.out.print("> ");
		String numerString = scaner.nextLine();
		try {
			polecenie = Integer.parseInt(numerString);
		} catch (Exception e) {
			System.out.println("Polecenie zosta³o podane b³êdnie.");
			polecenie = -1;
		}
		return polecenie;
	}

	private static String pytanieOUsername() {
		String actUsername;
		System.out.print("WprowadŸ nazwê u¿ytkownika:\n> ");
		actUsername = scaner.nextLine();
		if("".equals(actUsername)){
			System.out.println("Nazwa u¿ytkownika nie mo¿e byæ pusta");
			System.exit(4);
		}
		return actUsername;
	}

	private static void tworzenieNowegoUzytkownika(String actUsername) {
		user = new User();
		user.setUsername(actUsername);
		System.out.println("Witaj "+user.getUsername());
		System.out.println("Wprowadz swoje dane osobowe:");
		Dane dane = new Dane();
		System.out.print("Imiê: ");
		dane.setImie(  scaner.nextLine()  );
		
		System.out.print("Nazwisko: ");
		dane.setNazwisko(  scaner.nextLine()  );
				
		System.out.println("Wybierz plec: ");
		Dane.Plec[] tablicaPlec = Dane.Plec.values();
		for(int i=0; i<tablicaPlec.length; i++){
			System.out.println((i+1)+": "+tablicaPlec[i]);
		}
		System.out.print("> ");
		String numerString = scaner.nextLine();
		try {
			int i = Integer.parseInt(numerString) - 1;
			dane.setPlec(tablicaPlec[i]);
		} catch (Exception e) {
			System.out.println("Plec zosta³a podana b³êdnie.");
			dane.setPlec(Dane.Plec.NIE_WIEM);
		}
		System.out.println("Wybrano plec: "+dane.getPlec());
		
		user.setDaneOsobowe(dane);
		UserDAO.addUser(user);
	}

	private static void powitanie() {
		if(user.getDaneOsobowe() == null
				|| user.getDaneOsobowe().getImie() == null
				|| user.getDaneOsobowe().getImie().equals("")){
			System.out.println("Witaj "+user.getUsername());
		} else {
			System.out.println("Witaj "+user.getDaneOsobowe().getImie());
		}
	}

}
