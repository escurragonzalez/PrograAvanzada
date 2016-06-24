package test;
import grafos.*;
import org.junit.Test;

public class test {
	
		@Test
		public void testDola(){
			int nodos =5;
			Integer max=Integer.MAX_VALUE;
			Integer[][] mat= {{max,10,max,30,100},{max,max,50,max,max},{max,max,100,max,10},{max,max,60,max,60},{max,max,max,max,max}};
			Djkstra prueba = new Djkstra(5);
			prueba.procesar(1, mat);
			
		}
}

