package Ex2;

public class TestHautNiveauDepos implements Runnable{
	private hautNiveau hNiveau;

	public TestHautNiveauDepos(hautNiveau hNiveau) {
		super();
		this.hNiveau = hNiveau;
	}
	@Override
	public void run() {
		int i = 0;
		while(true){
			try {
				hNiveau.deposer(new String("Tour "+i));
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(hNiveau.toString());
			try {
				Thread.currentThread();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


}
