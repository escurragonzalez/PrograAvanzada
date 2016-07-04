package test;

import org.junit.Test;

import algoritmosGrafos.BFS;
import algoritmosGrafos.DFS;
import algoritmosGrafos.Kruskal;

public class test {

//	@Test
//		public void testDFS(){
//			int nodos =9;
//			Integer max=Integer.MAX_VALUE;
//			//					0	1	2	3	4	5	6	7	8
//			Integer[][] mat= {{max,1  ,max,1  ,max,max,max,max,1  },
//							  {1  ,max,1  ,max,max,max,max,max,max},
//							  {max,1  ,max,  1, 1 ,max,max,max,max},
//							  {1  ,max,1  ,max,1  ,max,max,max,max},
//							  {max,max,1  ,1  ,max,1  ,max,max,max},
//							  {max,max,max,max,1  ,max,1  ,max,max},//5
//							  {max,max,max,max,max,1  ,max,max,max},
//							  {max,max,max,max,1  ,max,max,max,1  },
//							  {1  ,max,max,max,max,max,max,1  ,max}
//							  
//			
//			};
//			//Integer[][] mat= {{max,10,max,30,100},{max,max,50,max,max},{max,max,100,max,10},{max,max,60,max,60},{max,max,max,max,max}};
//			//Integer[][] mat= {{max,1,1},{max,max,max},{max,max,max}};//,{max,max,60},{max,max,max};
//			
//			DFS prueba = new DFS(nodos);
//			
//			prueba.setMatrizAdyacencia(mat);
//			Integer nodoInicial=0;
//			
//			prueba.recorrerTodosNodosAPartirDeRaiz(nodoInicial);
////			BFS prueba = new BFS(nodos);
////			
////			prueba.setMatrizAdyacencia(mat);
////			Integer nodoInicial=0;
////			prueba.setPosPrimero(nodoInicial);		
////			
////			prueba.recorrerTodosNodosAPartirDeRaiz(nodoInicial);
//		}
	
	@Test
	public void testKruskal(){
		int nodos =7;
		Integer max=Integer.MAX_VALUE;
		//				0	1	2	3	4	5	6	7	8
		Integer[][] mat= {{max,2  ,4   ,1  ,max,max,max},//,max,1  },
						  {2  ,max,max,3   ,10 ,max,max},//,,max,max},
						  {  4,max,max,  2, max,5  ,max},//,,max,max},
						  {1  ,3  ,2  ,max,7  ,8   ,4  },//,,max,max},
						  {max,10 ,max ,7  ,max,max,6},//,,max,max},
						  {max,max,5  ,8  ,max,max,1  },//,,max,max},//5
						  {max,max,max,4  ,6  ,1  ,max},//,,max,max},
//						  {max,max,max,max,1  ,max,max,max,1  },
//						  {1  ,max,max,max,max,max,max,1  ,max}
						  
		
		};

		Kruskal prueba = new Kruskal(nodos);
		
		prueba.setMatrizAdyacencia(mat);
		Integer nodoInicial=1;
		prueba.setPosPrimero(nodoInicial);
		
		prueba.obtenerArbolAbarcadorYCostoMinimo(nodoInicial);
		
		System.out.println();
	}
}
