package Ex2;

public class main {

	public static void main(String[] args) throws InterruptedException {
//		hautNiveau hNiveau = new hautNiveau(5);
//		Thread thread = new Thread((Runnable) hNiveau);
//		thread.start();
//		Thread thread1 = new Thread((Runnable) hNiveau);
//		thread1.start();
//		String cocoi = new String("Tu");
//		String cocoii = new String("est");
//		String cocoiii = new String("un");
//		String cocoiiii = new String("petit");
//		String cocoiiiii = new String("joueur !");
//		String cocoiiiiii = new String("OSEF !");
//		hNiveau.deposer(cocoi);
//		hNiveau.deposer(cocoii);
//		hNiveau.deposer(cocoiii);
//		hNiveau.deposer(cocoiiii);
//		hNiveau.deposer(cocoiiiii);
//		hNiveau.deposer(cocoiiiiii);
		//System.out.println(hNiveau.toString());
//		System.out.println( (String)hNiveau.prendre());
//		
//		System.out.println( (String)hNiveau.prendre());
//		System.out.println( (String)hNiveau.prendre());
//
//		System.out.println( (String)hNiveau.prendre());
//		System.out.println( (String)hNiveau.prendre());
//		System.out.println( (String)hNiveau.prendre());
		//Crée classe haut niveau
		hautNiveau hNiveau = new hautNiveau(5);
		//Classe Thread Deposer
		TestHautNiveauDepos testHN = new TestHautNiveauDepos(hNiveau);
		//Classe Thread prendre
		TestHautNiveauRetrait testRT = new TestHautNiveauRetrait(hNiveau);
		//Initialise thread avec classe thread
		Thread th1 = new Thread((Runnable) testHN);
		Thread th2 = new Thread((Runnable) testRT);
		//Lance
		th1.start();
		th2.start();

	}

}
