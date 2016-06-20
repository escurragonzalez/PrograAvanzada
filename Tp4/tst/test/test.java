package test;

import static org.junit.Assert.*;

import org.junit.Test;

import grafo.*;

//import junit.framework.Assert;
import org.junit.Assert;

public class test {

	
		@Test	
		public void generacionGrafoAleatorioDadoNPorcentajeOrdenamientoSolo() {
			
			int n=10;
			int porcentaje=50;
			GeneradorAleatoriosPorcentaje generadorGrafosAleatoriosDadosNPorcentaje=
					new GeneradorAleatoriosPorcentaje(n, porcentaje);
			for (int i = 0; i < n-1; i++) {
				if(generadorGrafosAleatoriosDadosNPorcentaje.getAristas()[i].getValorRandom()>
					generadorGrafosAleatoriosDadosNPorcentaje.getAristas()[i+1].getValorRandom())
					fail();
			}
			
				
			
		}
		
		@Test	
		public void generacionGrafoAleatorioValidacionCantidad() {
			int n=10;
			int porcentaje=50;
			GeneradorAleatoriosPorcentaje generadorAleatoriosPorcentaje=
					new GeneradorAleatoriosPorcentaje(n, porcentaje);
			Assert.assertEquals(((n*(n-1)/2)*porcentaje/100) , generadorAleatoriosPorcentaje.getCantAristas());
	
		}
		
		@Test
		public void generarMatrizAleatoriaProbabilidad() {
			GeneradorAleatoriosProbabilidad porc= new GeneradorAleatoriosProbabilidad(6, 0.6);
			porc.esccribirArchivo("Salida.out");
		}
		
		@Test
		public void generarMatrizAleatoriaPorcentaje() {
			GeneradorAleatoriosPorcentaje porc= new GeneradorAleatoriosPorcentaje(6, 0.6);
			porc.esccribirArchivo("Salida.out");
		}
		
		@Test
		public void generadorRegularesPorcentajeTestRegularidad() {
			int n=1000;
			int porcentaje=50;
			GeneradorRegularesPorcentaje generadorRegularesPorcentaje= new GeneradorRegularesPorcentaje(n, porcentaje);
			Assert.assertEquals(generadorRegularesPorcentaje.getGradoMaxima(), generadorRegularesPorcentaje.getGradoMinima());
		}
		
		@Test
		public void generadorRegularesPorcentajeTestCantidadAristas() {
			int n=1000;
			int porcentaje=50;
			GeneradorRegularesPorcentaje generadorRegularesPorcentaje= new GeneradorRegularesPorcentaje(n, porcentaje);
			Assert.assertEquals(n*generadorRegularesPorcentaje.getGradoMaxima()/2, generadorRegularesPorcentaje.getCantAristas());
		}
		
		@Test
		public void generadorRegularesPorcentajeTestGradoMinimo() {
			int n=1000;
			double porcentaje=50;
			GeneradorRegularesPorcentaje generadorRegularesPorcentaje= new GeneradorRegularesPorcentaje(n, porcentaje);
			double aristasMax=(n*(n-1)/2);
			double porcentajeUnGradoMenos=(((double)n*(generadorRegularesPorcentaje.getGradoMaxima()-1)/2)/aristasMax);
			
			Assert.assertTrue(porcentajeUnGradoMenos<porcentaje);
		}
		
}
