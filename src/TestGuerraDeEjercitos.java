
import org.junit.Assert;
import org.junit.Test;

public class TestGuerraDeEjercitos {
	
	
	
	Pueblo pueblo = new Pueblo(true);
	Ejercito ejercitoPropio = new Ejercito();
	Ejercito ejercitoRival = new Ejercito();
	
	@Test
	public void ejercitoDe10WrivesVsEjercitoDe12Enemigos() {
		ejercitoPropio.agregar(new Wrives()); ejercitoPropio.agregar(new Wrives()); ejercitoPropio.agregar(new Wrives());
		ejercitoPropio.agregar(new Wrives()); ejercitoPropio.agregar(new Wrives()); ejercitoPropio.agregar(new Wrives());
		ejercitoPropio.agregar(new Wrives()); ejercitoPropio.agregar(new Wrives()); ejercitoPropio.agregar(new Wrives());
		ejercitoPropio.agregar(new Wrives());
		
		ejercitoRival.agregar(new Enemigo()); ejercitoRival.agregar(new Enemigo()); ejercitoRival.agregar(new Enemigo()); 
		ejercitoRival.agregar(new Enemigo()); ejercitoRival.agregar(new Enemigo()); ejercitoRival.agregar(new Enemigo());
		ejercitoRival.agregar(new Enemigo()); ejercitoRival.agregar(new Enemigo()); ejercitoRival.agregar(new Enemigo());
		ejercitoRival.agregar(new Enemigo()); ejercitoRival.agregar(new Enemigo()); ejercitoRival.agregar(new Enemigo()); 
				
		combate(ejercitoPropio, ejercitoRival);
		
		Assert.assertEquals(8, ejercitoPropio.getCantidadDeGuerreros());
		Assert.assertEquals(0, ejercitoRival.getCantidadDeGuerreros());
	}
	
	@Test
	public void ejercitoDe14RadaiteranVsEjercitoDe6Enemigos() {
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		
		ejercitoRival.agregar(new Enemigo());
		ejercitoRival.agregar(new Enemigo());
		ejercitoRival.agregar(new Enemigo());
		ejercitoRival.agregar(new Enemigo());
		ejercitoRival.agregar(new Enemigo());
		ejercitoRival.agregar(new Enemigo());
		
		combate(ejercitoPropio, ejercitoRival);
		
		Assert.assertEquals(0, ejercitoRival.getCantidadDeGuerreros());
		Assert.assertEquals(2, ejercitoPropio.getCantidadDeGuerreros());
	}
	
	@Test
	public void ejercitoDe4RadaiteranConEjercitoDe10RadaiteranAliadosVsEjercitoDe6Enemigos() {
		
		ejercitoRival.agregar(new Enemigo());
		ejercitoRival.agregar(new Enemigo());
		
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		
		Ejercito aliados = new Ejercito();
		
		aliados.agregar(new Radaiteran());
		aliados.agregar(new Radaiteran());
		aliados.agregar(new Radaiteran());
		aliados.agregar(new Radaiteran());
		aliados.agregar(new Radaiteran());
		aliados.agregar(new Radaiteran());
		aliados.agregar(new Radaiteran());
		aliados.agregar(new Radaiteran());
		aliados.agregar(new Radaiteran());
		aliados.agregar(new Radaiteran());
		ejercitoPropio.agregar(aliados);
		
		ejercitoRival.agregar(new Enemigo());
		ejercitoRival.agregar(new Enemigo());
		ejercitoRival.agregar(new Enemigo());
		ejercitoRival.agregar(new Enemigo());
		
		combate(ejercitoPropio, ejercitoRival);
		
		Assert.assertEquals(0, ejercitoRival.getCantidadDeGuerreros());
		Assert.assertEquals(2, ejercitoPropio.getCantidadDeGuerreros());
	}
	
	@Test
	public void Combate13vs5SinEjercitoAliado() {
		
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		
		ejercitoPropio.agregar(new Nortaichian());
		ejercitoPropio.agregar(new Nortaichian());
		ejercitoPropio.agregar(new Nortaichian());
		
		ejercitoRival.agregar(new Enemigo(400));
		ejercitoRival.agregar(new Enemigo(600));
		ejercitoRival.agregar(new Enemigo(300));
		ejercitoRival.agregar(new Enemigo(200));
		ejercitoRival.agregar(new Enemigo(700));
		
		combate(ejercitoPropio, ejercitoRival);
		
		Assert.assertEquals(7, ejercitoPropio.getCantidadDeGuerreros());
		Assert.assertEquals(0, ejercitoRival.getCantidadDeGuerreros());
		
	}
	
	@Test
	public void Combate13vs5ConEjercitoAliado() {
		
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Radaiteran());
		
		ejercitoRival.agregar(new Enemigo(400));
		ejercitoRival.agregar(new Enemigo(600));
		ejercitoRival.agregar(new Enemigo(300));
		ejercitoRival.agregar(new Enemigo(200));
		ejercitoRival.agregar(new Enemigo(700));
		
		Ejercito ejercitoAliado = new Ejercito();
		ejercitoAliado.agregar(new Nortaichian(true));
		ejercitoAliado.agregar(new Nortaichian(true));
		ejercitoAliado.agregar(new Nortaichian(true));
		
		ejercitoPropio.agregar(ejercitoAliado);
		
		combate(ejercitoPropio, ejercitoRival);
		
		Assert.assertEquals(7, ejercitoPropio.getCantidadDeGuerreros());
		Assert.assertEquals(0, ejercitoRival.getCantidadDeGuerreros());
	}
	
	@Test
	public void ejercitoConGuerrerosQueDescansaronVsEjercitoEnemigo() {
		
		ejercitoPropio.agregar(new Wrives());
		ejercitoPropio.agregar(new Reralopes());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Nortaichian());
		ejercitoPropio.agregar(new Wrives());
		ejercitoPropio.agregar(new Reralopes());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Nortaichian());
		
		ejercitoPropio.descansar();
		
		ejercitoRival.agregar(new Enemigo(400));
		ejercitoRival.agregar(new Enemigo(600));
		ejercitoRival.agregar(new Enemigo(300));
		ejercitoRival.agregar(new Enemigo(200));
		ejercitoRival.agregar(new Enemigo(700));
		
		combate(ejercitoPropio, ejercitoRival);
		
		Assert.assertEquals(4, ejercitoPropio.getCantidadDeGuerreros());
		Assert.assertEquals(0, ejercitoRival.getCantidadDeGuerreros());
		
		
	}
	
	@Test
	public void ejercitoConGuerrerosSinDescansarVsEjercitoEnemigo() {
		
		ejercitoPropio.agregar(new Wrives());
		ejercitoPropio.agregar(new Reralopes());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Nortaichian());
		ejercitoPropio.agregar(new Wrives());
		ejercitoPropio.agregar(new Reralopes());
		ejercitoPropio.agregar(new Radaiteran());
		ejercitoPropio.agregar(new Nortaichian());
		
		ejercitoRival.agregar(new Enemigo(400));
		ejercitoRival.agregar(new Enemigo(600));
		ejercitoRival.agregar(new Enemigo(300));
		ejercitoRival.agregar(new Enemigo(200));
		ejercitoRival.agregar(new Enemigo(700));
		
		combate(ejercitoPropio, ejercitoRival);
		
		Assert.assertEquals(4, ejercitoPropio.getCantidadDeGuerreros());
		Assert.assertEquals(0, ejercitoRival.getCantidadDeGuerreros());
		
		
	}
	
	public static void combate(Ejercito e1, Ejercito e2) {

		while(e1.hayGuerreros() && e2.hayGuerreros()) {
			Guerrero g1 = e1.getGuerrero();
			Guerrero g2 = e2.getGuerrero();
			
			while(g1.getSalud() > 0 && g2.getSalud() > 0) {
	
				if(g1.getSalud() > 0)
					g2.recibirDanio(g1.atacar());
	
				if(g2.getSalud() > 0)
					g1.recibirDanio(g2.atacar());
			}
	
			if(g1.getSalud() > 0) {
				e1.agregarColaDeHeridos(g1);
				e2.getGuerrero();
			} else {
				e2.agregarColaDeHeridos(g2);
 				e1.getGuerrero();
			}
		}
	}
}