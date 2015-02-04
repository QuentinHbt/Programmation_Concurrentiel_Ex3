package Ex2;

import java.util.Arrays;

public class basNiveau extends AbstractFileBloquanteBornee<Object> {

	public basNiveau(int n) throws IllegalArgumentException {
		super(n);
	}

	@Override
	public synchronized void deposer(Object e) throws InterruptedException {
		
		if (this.estPleine) {
			wait();
		}
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
		notify();
		
	}

	/**
	 * Prendre une référence dans la file.
	 * 
	 * La prise est faite en tête de file. L'objet référencé n'est pas copié au
	 * moment du dépôt. La prise est bloquante lorsque la file est vide.
	 * 
	 * returns la référence de tête de la file
	 */
	@Override
	public synchronized Object prendre() throws InterruptedException {
		Object retour = null;
		
		if (this.estVide) {
			wait();
		}
		retour =this.tableau[this.tete];
		this.estPleine = false;
		this.tete++;
			
		System.out.println("Pris");
		if (this.tete == this.tableau.length) {
			this.tete = 0;
		}
		if (this.tete == this.queue) {
			this.estVide = true;
		}
			
		notify();
		return retour;
	}

	@Override
	public String toString() {
		return "basNiveau [tableau=" + Arrays.toString(tableau) + ", tete="
				+ tete + ", queue=" + queue + ", estVide=" + estVide
				+ ", estPleine=" + estPleine + "]";
	}

}
