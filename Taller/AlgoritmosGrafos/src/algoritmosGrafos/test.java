package algoritmosGrafos;

import java.io.*;

public class test {

	public static void main(String[] args) {
		long max = 999999999;
		long matrizA[][] = {{0,10,max,30,100},
							{max,0,50,max,max},
							{max,max,0,max,10},
							{max,max,20,0,60},
							{max,max,max,max,0}};
		int matrizW[][] = {{0,1,0},{0,0,0},{0,0,0}};
		
		
		DijkstraPrecedencia caminos = new DijkstraPrecedencia();
		System.out.println(caminos.algoritmoDijkstra(matrizA));
//		Dijkstra caminos = new Dijkstra();
//		System.out.println(caminos.algoritmoDijkstra(matrizA));
//		Warshall existencias = new Warshall();
//		Prim camino = new Prim();
//		CaminosMinimos ruta = new CaminosMinimos();
//		System.out.println(ruta.algoritmoFloyd(matrizA));
//		System.out.println(camino.algoritmoPrim(matrizA));
	}
}
