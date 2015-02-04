package Ex2;

public class main {

	public static void main(String[] args) {
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
		/*
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
*/
		
		
		
	 // TODO Auto-generated method stub
		basNiveau bNiveau = new basNiveau(5);
		
		TestBNDepot bnDepot = new TestBNDepot(bNiveau);
		TestBNRetrait bnRetrait = new TestBNRetrait(bNiveau);
		
		Thread t1 = new Thread((Runnable) bnDepot);
        Thread t2 = new Thread((Runnable) bnRetrait);
        
        t1.start();
        t2.start();
		 
	}

}
