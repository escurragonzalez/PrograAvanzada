package grafo;

import java.util.Random;

public class GeneradorGrafosAleatoriosDadosNPorcentaje extends GeneradorGrafosAleatorios {
	private double porcentaje;
	private Arista[] aristas;

	public GeneradorGrafosAleatoriosDadosNPorcentaje(int n, double porcentaje) {
		super(n);
		
		this.aristas = new Arista[(n) * (n + 1) / 2];//Formula Amiga (c) Leonardo
		int cantidadAristas = 0;
		Random  rnd = new Random();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				Arista arista = new Arista(i + 1, j + 1,rnd.nextDouble());
				this.aristas[cantidadAristas++]=arista;
			}
		}
		
		new Ordenadora(this.aristas).quickSort(0, cantidadAristas-1);;
		
		this.setCantAristas((int)(cantidadAristas*porcentaje/100));
		this.setCantNodos(n);
		this.setPorcentaje(porcentaje);
		
		for (int i = 0; i < this.getCantAristas(); i++) {
			this.getMatrizAdyacencia()[this.aristas[i].origen-1][this.aristas[i].destino-1]=true;
			this.getMatrizAdyacencia()[this.aristas[i].destino-1][this.aristas[i].origen-1]=true;
		}
		
		
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Arista[] getAristas() {
		return aristas;
	}

	public void setAristas(Arista[] aristas) {
		this.aristas = aristas;
	}
}
