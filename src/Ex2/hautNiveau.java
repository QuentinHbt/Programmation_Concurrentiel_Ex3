package Ex2;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class hautNiveau extends AbstractFileBloquanteBornee<Object> {
	Lock lock = new ReentrantLock();
	Condition prendre = lock.newCondition();
	Condition deposer = lock.newCondition();
	int increm;
	public hautNiveau(int n) throws IllegalArgumentException {
		super(n);

	}
	/**
	 * Prendre une référence dans la file.
	 *
	 * La prise est faite en tête de file.
	 * L'objet référencé n'est pas copié au moment du dépôt.
	 * La prise est bloquante lorsque la file est vide.
	 *
	 * returns la référence de tête de la file
	 */
	@Override
	public Object prendre() throws InterruptedException {
		lock.lock();
		Object retourner = null;
		try{
			if(estVide){
				prendre.await();
				
			}
			else{
				retourner =this.tableau[this.tete];
				this.estPleine = false;
				this.tete++;
					
				System.out.println("Pris");
				if (this.tete == this.tableau.length) {
					this.tete = 0;
				}
				if (this.tete == this.queue) {
					this.estVide = true;
				}
				deposer.signal();
			}
		}catch(Exception e){}finally{lock.unlock();}
		return retourner;
	}


	/**
	 * Déposer une référence dans la file.
	 *
	 * Le dépôt est fait en fin de file.
	 * L'objet référencé n'est pas copié au moment du dépôt.
	 * Le dépôt est bloquant lorsque la file est pleine
	 *
	 * param e - l'élément à ajouter à la file
	 */
	@Override
	public  void deposer(Object e) throws InterruptedException {
		lock.lock();
		try{
			if(estPleine){
				deposer.await();
			}
			else{
				this.tableau[this.queue] = e;
				this.queue ++;
				this.estVide = false;
				
			if(this.queue == this.tableau.length){
				this.queue = 0;
			}
			if(this.queue == this.tete){
				this.estPleine = true;
			}
			System.out.println("D�pos�");
				prendre.signal();
			}
		}catch(Exception exception){System.out.println(exception.getMessage());}finally{lock.unlock();}

	}
	@Override
	public synchronized String toString() {
		
		return  "hautNiveau [tableau=" + Arrays.toString(tableau) + ", tete="
				+ tete + ", queue=" + queue + ", estVide=" + estVide
				+ ", estPleine=" + estPleine + "]";
	}
}
	
