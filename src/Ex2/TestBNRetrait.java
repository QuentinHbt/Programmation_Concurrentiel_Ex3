package Ex2;

public class TestBNRetrait implements Runnable {

	basNiveau bNiveau;
	static TestBNRetrait testbnr;
	
	public TestBNRetrait(basNiveau bNiveau) {
		super();
		this.bNiveau = bNiveau;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				bNiveau.prendre();
				System.out.println(bNiveau.toString());
				Thread.currentThread();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
