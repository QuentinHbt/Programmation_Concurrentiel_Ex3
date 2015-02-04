package Ex2;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
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
		Object retourner = "Non !";
		try{
			if(estVide){
				prendre.await();
				
			}
			else{
				retourner = tableau[tete];
				tableau[tete] =null;
				if(tete < tableau.length-1)
				tete += 1;
				if(estPleine){
					estPleine = false;
				}
				if(tete == queue){
					estVide = true;
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
				
				if(tete == 0){
					tableau[queue] = e;
					if(queue < tableau.length)
						queue ++;
				}
				else{
					if(queue < tableau.length-1)
						tableau[queue++] = e;
					else{
						if(queue ==  tableau.length-1 && tableau[queue] == null)
							tableau[queue] =e;
						else
						    deposer.await();
					}
				}
				estVide = false;
				if(queue == tableau.length-1 && tete != tableau.length-1){
					estPleine = true;
				}
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
	
