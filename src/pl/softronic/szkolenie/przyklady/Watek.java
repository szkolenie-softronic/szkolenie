package pl.softronic.szkolenie.przyklady;

public class Watek extends Thread {

	@Override
	public void run(){
		for(int j=0; j<10; j++){
			String s = "Napis z w¹tku, który wyœwietla siê w pêtli: znak po znaku.";
			for(int i=0; i<s.length(); i++){
				System.out.print(s.charAt(i));
			}
			System.out.println();
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				System.out.println("Przechwycono przerwanie");
//				return;
//			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Watek w = new Watek();
		//Watek v = new Watek();
		System.out.println("Przed startem w¹tku pobocznego.");
		w.start();
		//v.start();
		
		System.out.println("Po starcie w¹tku pobocznego.");
		
		w.join(1);
		
		//System.out.println("Po join...");
		
		w.stop();
		System.out.println("Po interrupt...");
		
		
	}

}
