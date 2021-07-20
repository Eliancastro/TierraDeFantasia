
public class Enemigo extends Raza {
	
	
    /*
     * pre: se debe crear un enemigo para las primeras pruebas de combate.
     * post:se crea el enemigo con su salud y con su danio basico, ambos por defecto.
     */
	public Enemigo() {
		super(500,10);
	}
	
	/*
     * pre: se debe crear un enemigo para las primeras pruebas de combate.
     * post:se crea el enemigo con su salud pasada por parametro y con su danio basico por defecto.
     */
	public Enemigo(int salud) {
		super(salud,10);
	}

	public String toString() {

		return "[Enemigo:" + super.toString();
	}

	@Override
	public void descansar() {
		
	}
}
