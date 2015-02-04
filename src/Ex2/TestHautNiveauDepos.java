package Ex2;

public class TestHautNiveauDepos implements Runnable{
	private hautNiveau hNiveau;

	public TestHautNiveauDepos(hautNiveau hNiveau) {
		super();
		this.hNiveau = hNiveau;
	}
	@Override
	public void run() {
		while(true){
			System.out.println("Deposer_______________________________");
			try {
				hNiveau.deposer(new String("OK"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(hNiveau.toString());
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


}
