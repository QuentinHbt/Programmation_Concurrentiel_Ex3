package Ex2;

public class main {

	public static void main(String[] args) {
		/* Haut Niveau */
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

		
		
		
	 // TODO Auto-generated method stub
		/* Bas NIveau*/
	/*	basNiveau bNiveau = new basNiveau(5);
		
		TestBNDepot bnDepot = new TestBNDepot(bNiveau);
		TestBNRetrait bnRetrait = new TestBNRetrait(bNiveau);
		
		Thread t1 = new Thread((Runnable) bnDepot);
        Thread t2 = new Thread((Runnable) bnRetrait);
        
        t1.start();
        t2.start();
		 */
	}

}
