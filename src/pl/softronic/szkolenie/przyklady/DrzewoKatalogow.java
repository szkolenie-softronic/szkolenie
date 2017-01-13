package pl.softronic.szkolenie.przyklady;

import java.io.File;

public class DrzewoKatalogow {

	public static void main(String[] args) {
		String katalog = "D:/eclipse/workspace-softronic/szkolenie";
		File f = new File(katalog);
		wypiszDrzewo(f, "");
	}
	
	static void wypiszDrzewo(File f, String wciecie){
		
		if(f.isDirectory()){
			System.out.printf("K %-50s\n", wciecie + f.getName());
			//System.out.println("K " + wciecie + f.getName());
			File[] dir = f.listFiles();
			for(File d : dir){
				wypiszDrzewo(d, wciecie + "| ");
			}
		} else { // f is not a directory
			System.out.printf("P %-50s %7d\n", wciecie + f.getName(), f.length());
			//System.out.println("P " + wciecie + f.getName() + "\t" + f.length());
		}
		
		
	}

}
