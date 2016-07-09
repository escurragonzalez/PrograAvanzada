package matriz;

public class MatrizSimetrica {

	private boolean[]vector;
	private int n;//Orden de la Matriz
	private int t;//tamaño del vector
	
	public MatrizSimetrica(int cantNodos){
		this.n = cantNodos;
		t=Math.round((int)(Math.pow(n, 2)-n)/2);
		vector = new boolean[t];
		int k=0;//indice en el vector
		for (int i = 0; i < n; i++) {
			for(int j=i+1;j<n;j++){
				vector[k]=false;
				k++;
			}
		}
	}
	
	public MatrizSimetrica(MatrizMath matriz,int cantNodo,int canAristas){
		this.n = matriz.getOrden();
		t=Math.round((int)(Math.pow(n, 2)-n)/2);
		vector = new boolean[t];
		int k=0;//indice en el vector
		for (int i = 0; i < n; i++) {
			for(int j=i+1;j<n;j++){
				vector[k]=matriz.getElemento(i, j);
				k++;
			}
		}
	}
	
	public int getOrden(){
		return n;
	}
	
	public boolean getValor(int i,int j){
		int k;
		if (i<j){
			k=(int)(i * this.n + j - ( (i*i) + 3 * i + 2) / 2);
		}else{
			k=(int)(j * this.n + i - ( (j*j) + 3 * j + 2) / 2);
		}
		return this.vector[k];
	}
	
	public void setValor(int i,int j,boolean valor){
		int k;
		if (i<j){
			k=(int)(i * this.n + j - ( (i*i) + 3 * i + 2) / 2);
		}else{
			k=(int)(j * this.n + i - ( (j*j) + 3 * j + 2) / 2);
		}
		vector[k]=valor;
	}
}
