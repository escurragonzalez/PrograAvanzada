package test;

import org.junit.Assert;
import org.junit.Test;

import grafo.GeneradorAleatoriosPorcentaje;
import grafo.GeneradorAleatoriosProbabilidad;
import grafo.GeneradorRegularesGrado;
import grafo.GeneradorRegularesPorcentaje;
import grafo.GrafoNDNP;

public class testAlgoritmosColoreo {

	@Test
	public void testWPAleatoriaProbabilidad() {
		GeneradorAleatoriosProbabilidad porc= new GeneradorAleatoriosProbabilidad(100, 0.6);
		porc.escribirArchivo("tst\\Lote de entrada\\prueba1.in");
		
		
		try {
			GrafoNDNP prueba=new GrafoNDNP("tst\\Lote de entrada\\prueba1.in");
			prueba.welsh_Powel();
			prueba.calcularCantidadColores();
			prueba.escribirArchivo("tst\\Lote de salida\\prueba1Coloreado.out");
			
			ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
			Assert.assertTrue(probarColoreo.probador("tst\\Lote de entrada\\prueba1.in","tst\\Lote de salida\\prueba1Coloreado.out"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
		
	
	@Test
	public void testWPAleatoriaPorcentaje() {
		GeneradorAleatoriosPorcentaje porc= new GeneradorAleatoriosPorcentaje(100, 60);
		porc.escribirArchivo("tst\\Lote de entrada\\prueba2.in");
		
		
		try {
			GrafoNDNP prueba=new GrafoNDNP("tst\\Lote de entrada\\prueba2.in");
			prueba.welsh_Powel();
			prueba.calcularCantidadColores();
			prueba.escribirArchivo("tst\\Lote de salida\\prueba2Coloreado.out");
			
			ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
			Assert.assertTrue(probarColoreo.probador("tst\\Lote de entrada\\prueba2.in",
					"tst\\Lote de salida\\prueba2Coloreado.out"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
		
	@Test
	public void testWPRegularPorcentaje() {
		GeneradorRegularesPorcentaje porc= new GeneradorRegularesPorcentaje(100, 60);
		porc.escribirArchivo("tst\\Lote de entrada\\prueba3.in");
		
		
		try {
			GrafoNDNP prueba=new GrafoNDNP("tst\\Lote de entrada\\prueba3.in");
			prueba.welsh_Powel();
			prueba.calcularCantidadColores();
			prueba.escribirArchivo("tst\\Lote de salida\\prueba3Coloreado.out");
			
			ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
			Assert.assertTrue(probarColoreo.probador("tst\\Lote de entrada\\prueba3.in",
					"tst\\Lote de salida\\prueba3Coloreado.out"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testWPRegularGrado() {
		GeneradorRegularesGrado porc= new GeneradorRegularesGrado(100, 60);
		porc.escribirArchivo("tst\\Lote de entrada\\prueba4.in");
		
		
		try {
			GrafoNDNP prueba=new GrafoNDNP("tst\\Lote de entrada\\prueba4.in");
			prueba.welsh_Powel();
			prueba.calcularCantidadColores();
			prueba.escribirArchivo("tst\\Lote de salida\\prueba4Coloreado.out");
			
			ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
			Assert.assertTrue(probarColoreo.probador("tst\\Lote de entrada\\prueba4.in",
					"tst\\Lote de salida\\prueba4Coloreado.out"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Test
	public void testMatulaAleatoriaProbabilidad() {
		GeneradorAleatoriosProbabilidad porc= new GeneradorAleatoriosProbabilidad(100, 0.6);
		porc.escribirArchivo("tst\\Lote de entrada\\prueba5.in");
		
		
		try {
			GrafoNDNP prueba=new GrafoNDNP("tst\\Lote de entrada\\prueba5.in");
			prueba.matula();
			prueba.calcularCantidadColores();
			prueba.escribirArchivo("tst\\Lote de salida\\prueba5Coloreado.out");
			
			ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
			Assert.assertTrue(probarColoreo.probador("tst\\Lote de entrada\\prueba5.in","tst\\Lote de salida\\prueba5Coloreado.out"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
		
	
	@Test
	public void testMatulaAleatoriaPorcentaje() {
		GeneradorAleatoriosPorcentaje porc= new GeneradorAleatoriosPorcentaje(100, 60);
		porc.escribirArchivo("tst\\Lote de entrada\\prueba6.in");
		
		
		try {
			GrafoNDNP prueba=new GrafoNDNP("tst\\Lote de entrada\\prueba6.in");
			prueba.matula();
			prueba.calcularCantidadColores();
			prueba.escribirArchivo("tst\\Lote de salida\\prueba6Coloreado.out");
			
			ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
			Assert.assertTrue(probarColoreo.probador("tst\\Lote de entrada\\prueba6.in",
					"tst\\Lote de salida\\prueba6Coloreado.out"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
		
	@Test
	public void testMatulaRegularPorcentaje() {
		GeneradorRegularesPorcentaje porc= new GeneradorRegularesPorcentaje(100, 60);
		porc.escribirArchivo("tst\\Lote de entrada\\prueba7.in");
		
		
		try {
			GrafoNDNP prueba=new GrafoNDNP("tst\\Lote de entrada\\prueba7.in");
			prueba.matula();
			prueba.calcularCantidadColores();
			prueba.escribirArchivo("tst\\Lote de salida\\prueba7Coloreado.out");
			
			ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
			Assert.assertTrue(probarColoreo.probador("tst\\Lote de entrada\\prueba7.in",
					"tst\\Lote de salida\\prueba7Coloreado.out"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMatulaRegularGrado() {
		GeneradorRegularesGrado porc= new GeneradorRegularesGrado(100, 60);
		porc.escribirArchivo("tst\\Lote de entrada\\prueba8.in");
		
		
		try {
			GrafoNDNP prueba=new GrafoNDNP("tst\\Lote de entrada\\prueba8.in");
			prueba.matula();
			prueba.calcularCantidadColores();
			prueba.escribirArchivo("tst\\Lote de salida\\prueba8Coloreado.out");
			
			ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
			Assert.assertTrue(probarColoreo.probador("tst\\Lote de entrada\\prueba8.in",
					"tst\\Lote de salida\\prueba8Coloreado.out"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAleatorioAleatoriaProbabilidad() {
		GeneradorAleatoriosProbabilidad porc= new GeneradorAleatoriosProbabilidad(100, 0.6);
		porc.escribirArchivo("tst\\Lote de entrada\\prueba9.in");
		
		
		try {
			GrafoNDNP prueba=new GrafoNDNP("tst\\Lote de entrada\\prueba9.in");
			prueba.aleatorio();
			prueba.calcularCantidadColores();
			prueba.escribirArchivo("tst\\Lote de salida\\prueba9Coloreado.out");
			
			ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
			Assert.assertTrue(probarColoreo.probador("tst\\Lote de entrada\\prueba9.in","tst\\Lote de salida\\prueba9Coloreado.out"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
		
	
	@Test
	public void testAleatorioAleatoriaPorcentaje() {
		GeneradorAleatoriosPorcentaje porc= new GeneradorAleatoriosPorcentaje(100, 60);
		porc.escribirArchivo("tst\\Lote de entrada\\prueba10.in");
		
		
		try {
			GrafoNDNP prueba=new GrafoNDNP("tst\\Lote de entrada\\prueba10.in");
			prueba.aleatorio();
			prueba.calcularCantidadColores();
			prueba.escribirArchivo("tst\\Lote de salida\\prueba10Coloreado.out");
			
			ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
			Assert.assertTrue(probarColoreo.probador("tst\\Lote de entrada\\prueba10.in",
					"tst\\Lote de salida\\prueba10Coloreado.out"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
		
	@Test
	public void testAleatorioRegularPorcentaje() {
		GeneradorRegularesPorcentaje porc= new GeneradorRegularesPorcentaje(100, 60);
		porc.escribirArchivo("tst\\Lote de entrada\\prueba11.in");
		
		
		try {
			GrafoNDNP prueba=new GrafoNDNP("tst\\Lote de entrada\\prueba11.in");
			prueba.aleatorio();
			prueba.calcularCantidadColores();
			prueba.escribirArchivo("tst\\Lote de salida\\prueba11Coloreado.out");
			
			ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
			Assert.assertTrue(probarColoreo.probador("tst\\Lote de entrada\\prueba11.in",
					"tst\\Lote de salida\\prueba11Coloreado.out"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAleatorioRegularGrado() {
		GeneradorRegularesGrado porc= new GeneradorRegularesGrado(100, 60);
		porc.escribirArchivo("tst\\Lote de entrada\\prueba12.in");
		
		
		try {
			GrafoNDNP prueba=new GrafoNDNP("tst\\Lote de entrada\\prueba12.in");
			prueba.aleatorio();
			prueba.calcularCantidadColores();
			prueba.escribirArchivo("tst\\Lote de salida\\prueba12Coloreado.out");
			
			ProgramaProbadorColoreo probarColoreo = new ProgramaProbadorColoreo();
			Assert.assertTrue(probarColoreo.probador("tst\\Lote de entrada\\prueba12.in",
					"tst\\Lote de salida\\prueba12Coloreado.out"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
