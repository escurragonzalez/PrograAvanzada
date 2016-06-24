package grafos;

public class Grafo {

	protected Integer [][] matrizAdyacencia;
	protected Integer cantNodos;
	
	public Grafo(){
		
	}
	
	public Grafo(Integer cant){
		this.cantNodos=cant;
		this.matrizAdyacencia = new Integer[cant][cant];
		for (int i = 0; i < cant; i++) {
			for (int j = 0; j < cant; j++) {
				matrizAdyacencia[i][j]=Integer.MAX_VALUE;
			}
			
		}
	}

	public Integer[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizAdyacencia(Integer[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	public Integer getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(Integer cantNodos) {
		this.cantNodos = cantNodos;
	}
}
