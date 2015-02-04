package Ex2;

public class TestBNDepot implements Runnable{

	basNiveau bNiveau;
	static TestBNDepot testbnd;
	
	public TestBNDepot(basNiveau bNiveau) {
		super();
		this.bNiveau = bNiveau;
	}

	
	@Override
	public void run() {
		int i =0;
		// TODO Auto-generated method stub
		while(true){
			try {
				bNiveau.deposer(new String("Tour "+i));
				i++;
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
