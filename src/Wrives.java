
public class Wrives extends Raza{
	
	private int numeroDeAtaques;
	private boolean fueAtacado;
	
	/*
	 * pre: crear el guerrero con los valores por defecto.
	 * post: crea el guerrero con los valores por defecto.
	 */
	public Wrives() {
		super(108,113);
		numeroDeAtaques = 0;
		fueAtacado = true;
	}
	
	/*
	 * pre: crear el guerrero con los valores por defecto y si es aliado o no.
	 * post: crea el guerrero con los valores por defecto e inidica si es aliado o no.
	 */
	public Wrives(boolean b) {
		super(108,113,b);
		numeroDeAtaques = 0;
		fueAtacado = true;
	}
	
	/*
	 * pre: se debe atacar al enemigo.
	 * post: se ataca al enemigo con su ataque especial en caso de que corresponda.
	 */
	public int atacar() {
		
		if(!fueAtacado) {
			return 0;
		}
		
		if(numeroDeAtaques == 2) {
			numeroDeAtaques = 0;
			return super.atacar()*2;
		}
		
		numeroDeAtaques++;
		return super.atacar();
	}
	
	/*
	 * pre: se debe restar de la salud el danio recibido.
	 * post: se resta de la salud el danio recibido por el enemigo.
	 */
	public void recibirDanio(int danio) {
		super.recibirDanio(danio*2);
		fueAtacado = true;
	}
	
	/*
	 * pre: debe descansar.
	 * post: descansa y pone descansado en true.
	 */
	public void descansar() {
		fueAtacado = false;
		salud+= 50;
		descansado = true;
	}
	
	public String toString() {
		
		return "[Wrives:" + super.toString();
	}
}
