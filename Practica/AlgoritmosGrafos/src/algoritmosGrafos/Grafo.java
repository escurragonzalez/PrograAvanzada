package algoritmosGrafos;

public class Grafo {

	protected Integer [][] matrizAdyacencia;
	protected Integer cantNodos;
	protected Integer posPrimero=1; // Indica el valor de la primera posicion del grafo
									// para luego corregir defasajes en mat. adyacencia, etc.
	
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

	public Integer getPosPrimero() {
		return posPrimero;
	}

	public void setPosPrimero(Integer posPrimero) {
		this.posPrimero = posPrimero;
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

}
