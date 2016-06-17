package grafo;

public abstract class GeneradorGrafosAleatorios {
	private boolean[][] matrizAdyacencia=null;
	private int cantNodos;
	private int cantAristas;
	private int gradoMaxima;
	private int gradoMinima;
	
	
	
	public GeneradorGrafosAleatorios(int n) {
		this.matrizAdyacencia=new boolean[n][n];
	}
	public boolean[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}
	public void setMatrizAdyacencia(boolean[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}
	public int getCantNodos() {
		return cantNodos;
	}
	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}
	public int getCantAristas() {
		return cantAristas;
	}
	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}
	public int getGradoMaxima() {
		return gradoMaxima;
	}
	public void setGradoMaxima(int gradoMaxima) {
		this.gradoMaxima = gradoMaxima;
	}
	public int getGradoMinima() {
		return gradoMinima;
	}
	public void setGradoMinima(int gradoMinima) {
		this.gradoMinima = gradoMinima;
	}
	
	
	
}
