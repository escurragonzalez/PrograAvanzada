package test;

import org.junit.Test;

import algoritmosGrafos.DFS;

public class test {

	@Test
		public void testDFS(){
			int nodos =9;
			Integer max=Integer.MAX_VALUE;
			//					0	1	2	3	4	5	6	7	8
			Integer[][] mat= {{max,1  ,max,1  ,max,max,max,max,1  },
							  {1  ,max,1  ,max,max,max,max,max,max},
							  {max,1  ,max,  1, 1 ,max,max,max,max},
							  {1  ,max,1  ,max,1  ,max,max,max,max},
							  {max,max,1  ,1  ,max,1  ,max,max,max},
							  {max,max,max,max,1  ,max,1  ,max,max},//5
							  {max,max,max,max,max,1  ,max,max,max},
							  {max,max,max,max,1  ,max,max,max,1  },
							  {1  ,max,max,max,max,max,max,1  ,max}
							  
			
			};
			//Integer[][] mat= {{max,10,max,30,100},{max,max,50,max,max},{max,max,100,max,10},{max,max,60,max,60},{max,max,max,max,max}};
			//Integer[][] mat= {{max,1,1},{max,max,max},{max,max,max}};//,{max,max,60},{max,max,max};
			
			DFS prueba = new DFS(nodos);
			
			prueba.setMatrizAdyacencia(mat);
			Integer nodoInicial=0;
			
			prueba.recorrerTodosNodosAPartirDeRaiz(nodoInicial);
			
		}
}
