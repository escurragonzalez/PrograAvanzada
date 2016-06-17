package test;

import static org.junit.Assert.*;

import org.junit.Test;

import grafo.GeneradorGrafosAleatoriosDadosNPorcentaje;

//import junit.framework.Assert;
import org.junit.Assert;

public class test {

	
		@Test	
		public void generacionGrafoAleatorioDadoNPorcentajeOrdenamientoSolo() {
			
			int n=10;
			int porcentaje=50;
			GeneradorGrafosAleatoriosDadosNPorcentaje generadorGrafosAleatoriosDadosNPorcentaje=
					new GeneradorGrafosAleatoriosDadosNPorcentaje(n, porcentaje);
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
			GeneradorGrafosAleatoriosDadosNPorcentaje generadorGrafosAleatoriosDadosNPorcentaje=
					new GeneradorGrafosAleatoriosDadosNPorcentaje(n, porcentaje);
			Assert.assertEquals(((n*(n-1)/2)*porcentaje/100) , generadorGrafosAleatoriosDadosNPorcentaje.getCantAristas());
	
		}
}
