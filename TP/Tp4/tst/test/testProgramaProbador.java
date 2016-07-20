package test;

import org.junit.Assert;
import org.junit.Test;

public class testProgramaProbador {

	@Test
	public void programaProbadorGrafoOK() {
		String pathEntrada = "RegularAl50Porciento";
		ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
		Assert.assertTrue(probarColoreo.probador("Lote de Prueba PP\\"+pathEntrada+".in",
				"Lote de Prueba PP\\RegularAl50PorcientoColoreado.out"));
	}
	
	@Test
	public void programaProbadorGrafoNOKFaltaNodo() {
		String pathEntrada = "RegularAl50Porciento";
		ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
		Assert.assertFalse((probarColoreo.probador("Lote de Prueba PP\\"+pathEntrada+".in", 
				"Lote de Prueba PP\\RegularAl50PorcientoColoreadoFaltaNodo.out") ));
	}
	@Test
	public void programaProbadorGrafoNOKNodoDosColores() {
		String pathEntrada = "RegularAl50Porciento";
		ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
		Assert.assertFalse(probarColoreo.probador("Lote de Prueba PP\\"+pathEntrada+".in", 
				"Lote de Prueba PP\\RegularAl50PorcientoColoreadoNodoDosColores.out") );
	}
	@Test
	public void programaProbadorGrafoNOKGrafosAdyIguales() {
		String pathEntrada = "RegularAl50Porciento";
		ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
		Assert.assertFalse(probarColoreo.probador("Lote de Prueba PP\\"+pathEntrada+".in",
				"Lote de Prueba PP\\RegularAl50PorcientoColoreadoNodosAdyacentesIguales.out") );
	}
}
