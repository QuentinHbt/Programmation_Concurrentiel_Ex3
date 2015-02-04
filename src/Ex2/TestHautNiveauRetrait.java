package Ex2;

public class TestHautNiveauRetrait implements Runnable{
	private hautNiveau hNiveau;

	public TestHautNiveauRetrait(hautNiveau hNiveau) {
		super();
		this.hNiveau = hNiveau;
	}
	@Override
	public void run() {
		while(true){
			System.out.println("Retrait_______________________________");
			try {
				System.out.println(hNiveau.prendre());
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
