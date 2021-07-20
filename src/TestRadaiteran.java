
import org.junit.*;

public class TestRadaiteran {

	Radaiteran radaiteran = new Radaiteran();
	Enemigo enemigo = new Enemigo();

	@SuppressWarnings("unused")
	@Test
	public void prueba001() { // crea un Radaiteran
		Radaiteran radaiteran = new Radaiteran();
	}

	@Test
	public void prueba002() { // salud
		Assert.assertEquals(36, (int)radaiteran.getSalud());
	}

	@Test
	public void prueba003() { // ataque
		Assert.assertEquals(56, radaiteran.atacar());
	}

	@Test
	public void prueba004() { // ataca una vez y el siguiente ataque hace 3 mas de daño.
		radaiteran.atacar();
		Assert.assertEquals(59, radaiteran.atacar());
	}

	@Test
	public void prueba005() { // ataca dos veces y su tercer ataque hace 62 de daño.
		radaiteran.atacar();
		radaiteran.atacar();
		Assert.assertEquals(62, radaiteran.atacar());
	}

	@Test
	public void prueba006() { // ataca y aumenta su daño, recibe un ataque y se reinicia su daño al inicial.
		radaiteran.atacar();
		radaiteran.recibeDanio(enemigo.atacar());
		Assert.assertEquals(56, radaiteran.atacar());
	}

	@Test
	public void prueba007() { // recibe daño
		radaiteran.recibeDanio(enemigo.atacar());
		Assert.assertEquals(26, (int)radaiteran.getSalud());
	}

	@Test
	public void prueba008() { // descansa y no le sucede nada
		radaiteran.descansar();
		Assert.assertEquals(56, radaiteran.atacar());
		Assert.assertEquals(36, (int)radaiteran.getSalud());
	}

	@Test
	public void prueba009() { // ataca al enemigo y le reduce la salud
		enemigo.recibirDanio(radaiteran.atacar());
		Assert.assertEquals(444, (int)enemigo.getSalud());
	}
}