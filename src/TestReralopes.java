import org.junit.Assert;
import org.junit.Test;

public class TestReralopes {

	Reralopes rera = new Reralopes();
	Enemigo enemigo = new Enemigo();
	
	@Test
	public void prueba001() { // crea un reralopes
		@SuppressWarnings("unused")
		Reralopes rera = new Reralopes();
	}
	
	@Test
	public void testGetSalud() { // salud
		Assert.assertEquals(53, (int)rera.getSalud());
	}
	
	@Test
	public void testGetDanioBasico() { // atacar
		Assert.assertEquals(27, rera.atacar());
	}
	
	@Test
	public void prueba004() { // ataca 4 veces y erra 2
		Assert.assertEquals(27, rera.atacar());
		Assert.assertEquals(0, rera.atacar());
		Assert.assertEquals(27, rera.atacar());
		Assert.assertEquals(0, rera.atacar());
	}
	
	@Test
	public void prueba005() { // descansa, ataca con el doble de daño
		rera.descansar();
		enemigo.recibirDanio(rera.atacar());
		
		Assert.assertEquals(446,(int)enemigo.getSalud());
	}
	
	@Test
	public void prueba006() { // descansa, recibe ataque, se desconcentra y pierde doble de daño
		rera.descansar();
		rera.recibirDanio(enemigo.atacar());
		enemigo.recibirDanio(rera.atacar());
		
		Assert.assertEquals(473,(int)enemigo.getSalud());
	}
}

