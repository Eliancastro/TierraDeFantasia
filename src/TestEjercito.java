
import org.junit.Assert;
import org.junit.Test;

public class TestEjercito {
	
	Ejercito ejercito = new Ejercito();
	
	@Test
	public void crearUnEjercito() {
		@SuppressWarnings("unused")
		Ejercito ejercito = new Ejercito();
	}
	
	@Test
	public void agregarUnGuerreroDeCadaRaza() {

		ejercito.agregar(new Wrives());
		ejercito.agregar(new Reralopes());
		ejercito.agregar(new Radaiteran());
		ejercito.agregar(new Nortaichian());
		
		Assert.assertEquals(4, ejercito.getCantidadDeGuerreros());
	}
	
	@Test
	public void agregarUnEjercitoConGuerrerosAOtroEjercito() {
		Ejercito ejercitoAliado = new Ejercito();
		
		ejercitoAliado.agregar(new Wrives());
		ejercitoAliado.agregar(new Reralopes());
		ejercitoAliado.agregar(new Radaiteran());
		ejercitoAliado.agregar(new Nortaichian());
		
		ejercito.agregar(ejercitoAliado);
		
		Assert.assertEquals(1, ejercito.getCantidadDeGuerreros());
	}
	
	@Test
	public void descansarUnEjercito() {
		
		ejercito.agregar(new Wrives());
		ejercito.agregar(new Reralopes());
		ejercito.agregar(new Radaiteran());
		ejercito.agregar(new Nortaichian());
		
		ejercito.descansar();
	}
	
	
	
//	@Test
//	public void test() {
//		Ejercito ejercitoWrive = new Ejercito();
//		Wrives guerrero = new Wrives();
//		ejercitoWrive.agregar(guerrero);
//		Assert.assertEquals(108	,(int) ejercitoWrive.listarSiguiente().getSalud());
//	}
//	@Test
//	public void testListarSuiguiente() {
//		Ejercito ejercitoWrive = new Ejercito();
//		Wrives guerrero = new Wrives();
//		ejercitoWrive.agregar(guerrero);
//		Assert.assertEquals(108	,(int) ejercitoWrive.getSalud());  // .obtenerSiguiente()
//	}

}