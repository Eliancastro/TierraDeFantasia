
public class Radaiteran extends Raza {

	private final static int Danio_EXTRA = 3;
	private int cantidadDeAtaques = -1;
    
	/*
	 * pre: crear el guerrero con los valores por defecto.
	 * post: crea el guerrero con los valores por defecto.
	 */
	public Radaiteran() {
		super(36,56);
	}
	
	/*
	 * pre: crear el guerrero con los valores por defecto y si es aliado o no.
	 * post: crea el guerrero con los valores por defecto e inidica si es aliado o no.
	 */
	public Radaiteran(boolean b) {
		super(36,56,b);
	}
    
	/*
	 * pre: se debe atacar al enemigo.
	 * post: se ataca al enemigo con su ataque especial.
	 */
	@Override
	public int atacar() {
		cantidadDeAtaques++;

		return super.atacar() + (Danio_EXTRA * cantidadDeAtaques);
	}
    
	/*
	 * pre: se debe restar de la salud el danio recibido.
	 * post: se resta de la salud el danio recibido por el enemigo.
	 */
	public void recibeDanio(int danio) {
		cantidadDeAtaques = -1;    // Esto se debería quitar(Leer TP)
		super.recibirDanio(danio);
	}
    
	/*
	 * pre: debe descansar.
	 * post: descansa y pone descansado en true.
	 */
	public void descansar() {
		descansado = true;
	}
	
	public String toString() {
		
		return "[Radaiteran:" + super.toString();
	}

}
