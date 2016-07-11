package matriz;


public class MatrizSimetrica {

	private int n;
	private int tam;
	private byte[] vector;
	
	public MatrizSimetrica(int n){
		this.n = n;
		this.tam = (int)(Math.pow((double)n,(double)2) - n) / 2; //cálculo de tamaño de vector
		this.vector = new byte[tam];			
	}
	
	@SuppressWarnings("unused")
	private void intercambiarFilaColumna(int fila, int columna) {
		int aux = fila;
		fila = columna;
		columna = aux;
	}

	private int FCToI(int fila, int columna) throws Exception {
		if(fila == columna)
			throw new  Exception("No se puede acceder. Fila " + fila + ", columna " + columna);
		
		if(fila > columna){
			int aux = fila;
			fila = columna;
			columna = aux;
		}
		int in = fila * this.n + columna - ((int)(Math.pow((double)fila,(double)2)) + 3 * fila + 2)/2;
		return in;
	}
	
	public byte getElement(int fila, int columna) throws Exception{
		int indice = FCToI(fila, columna);
		return this.vector[indice];
	}
	//Ver si se puede insertar un elemento en lugar de un 0 o un 1 en la posición enviada
	public void setPosicion(int fila, int columna) throws Exception{		
		int indice = FCToI(fila, columna);
		vector[indice] = 1;
	}
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public static void main(String args[]){
		MatrizSimetrica mat1 = new MatrizSimetrica(5);
		try{
			for(int i = 0; i < 5; i ++)
				for(int j = i+1; j < 5; j ++)
					mat1.setPosicion(i,j);
		}
		catch(Exception E){
			E.printStackTrace();
		}
			
	}
}