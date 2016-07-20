package grafo;

import java.util.Random;

public class GeneradorRegularesPorcentaje extends Generador {

	public GeneradorRegularesPorcentaje(int n, double porcentaje) {
		super(n);// Llamo al constructor de la clase base

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j)
					this.matrizAdyacencia[i][j] = true;
			} // Grafo completo (100%) armado.
		}
		this.cantAristas = (n) * (n - 1) / 2;
		double porcentajeProximo = (((this.cantAristas - (n / 2)) * 100) / this.cantAristas);
		int gradoBuscado = n - 2;

		while (porcentajeProximo >= porcentaje && gradoBuscado > 1) {
			for (int j = 0; j < n ; j++) {
				if (calcularGradoNodo(j + 1) != gradoBuscado)
					tratarArista(j + 1, (n / 2) + j + 1, n, gradoBuscado);
			}

			porcentajeProximo = (((this.cantAristas - (n / 2)) * 100) / ((n) * (n - 1) / 2));
			gradoBuscado--;
		}

		this.calcularGrado();
		
		this.porcAdyacencia=(double)cantAristas/(cantNodos*(cantNodos-1)/2)*100;
		porcAdyacencia= (double) Math.round(porcAdyacencia*100)/100;
	}

	private int calcularGradoNodo(int numNodo) {
		int grado = 0;
		for (int i = 0; i < matrizAdyacencia.length; i++) {
			if (this.matrizAdyacencia[numNodo - 1][i] == true) {
				grado++;
			}
		}
		return grado;
	}

	private void tratarArista(int origen, int destino, int tamaño, int gradoBuscado) {

		if (destino > tamaño ) {
			destino = 1;
		}

		if (existeArista(origen, destino, tamaño) && calcularGradoNodo(destino) != gradoBuscado)
			eliminarArista(origen, (destino), tamaño);
		else
			tratarArista(origen, (destino) + 1, tamaño, gradoBuscado);

	}

	private void eliminarArista(int origen, int destino, int tamaño) {
		this.matrizAdyacencia[origen - 1][destino - 1] = false;
		this.matrizAdyacencia[destino - 1][origen - 1] = false;
		this.cantAristas--;
	}

	private boolean existeArista(int origen, int destino, int tamaño) {
		return this.matrizAdyacencia[origen - 1][destino - 1];
	}

	/*public void mostrarAdyacencia() {//Usado en Debug
		for (int i = 0; i < matrizAdyacencia.length; i++) {
			for (int j = 0; j < matrizAdyacencia.length; j++) {
				// System.out.print(this.getMatrizAdyacencia()[i][j]+" ");
				if (this.getMatrizAdyacencia()[i][j] && i < j) {
					System.out.println((i + 1) + " " + (j + 1));
				}
			}
			// System.out.print("\n");
		}
	}*/

}