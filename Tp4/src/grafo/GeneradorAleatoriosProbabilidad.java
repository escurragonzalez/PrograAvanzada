package grafo;

public class GeneradorAleatoriosProbabilidad extends GeneradorAleatorios{
	
	private double porcentaje;

	public GeneradorAleatoriosProbabilidad(int nodos,double p) {
		super(nodos);
		porcentaje=p;
		generarMatriz();
	}
	
	private void generarMatriz() {
		int cont=0;
		for(int i=0;i<cantNodos;i++){
			for(int j=i+1;j<cantNodos;j++){
				if(porcentaje>Math.random()){
					this.matrizAdyacencia[i][j]=true;
					this.matrizAdyacencia[j][i]=true;
					cont++;
				}
			}
		}
		this.cantAristas=cont;
		this.porcAdyacencia=(double)cantAristas/(cantNodos*(cantNodos-1)/2)*100;
		porcAdyacencia= (double) Math.round(porcAdyacencia*100)/100;
	}
}
