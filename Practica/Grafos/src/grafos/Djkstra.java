package grafos;

public class Djkstra extends Grafo{
	
	private Integer raiz;
	private Integer[] s;
	private Integer[] vs;
	private Integer[] costoMinimo;
	
	public Djkstra(){
		super();
	}
	
	public Djkstra(Integer cant){
		super (cant);
		this.s= new Integer[cant];
		this.vs= new Integer[cant];
		this.costoMinimo= new Integer[cant];
	}
	
	public void procesar(Integer raiz,Integer matriz[][]){
		this.raiz=raiz;
		this.setMatrizAdyacencia(matriz);
		this.s[raiz-1]=1;
		for (int i = 0; i < costoMinimo.length; i++) {
			costoMinimo[i]=matrizAdyacencia[raiz-1][i];
			vs[i]=1;
		}
		this.vs[raiz-1]=0;
		
		for(int i=0;i<cantNodos;i++){
			int pos=buscarPosMinimo();
			s[pos]=1;
			vs[pos]=0;
			tratarMinimo(pos);
		}
		System.out.println();
	}

	private void tratarMinimo(int pos) {
			for(int i=0;i<cantNodos;i++){
				if(costoMinimo[pos]>matrizAdyacencia[raiz-1][i]+matrizAdyacencia[i][pos]){
					costoMinimo[pos]=matrizAdyacencia[raiz-1][i]+matrizAdyacencia[i][pos];
					matrizAdyacencia[raiz-1][pos]=costoMinimo[pos];
				}
		}
	}

	private int buscarPosMinimo() {
		int nodoMin = Integer.MAX_VALUE;
		int pos = 0;
		for(int i =0;i<cantNodos;i++){
			if(costoMinimo[i]<nodoMin){
				nodoMin=costoMinimo[i];	
				pos=i;
			}
		}
		return pos;
	}
}
	