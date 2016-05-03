package ordenadora;

public class Ordenadora {
	double vector[];
//	Constructor
	Ordenadora(double V[]){
		vector = new double [V.length];
		vector = V;
		
	}
	
	public void Seleccion(){
		double temp;
		int posicion_minimo, i, j;
		
		for (i = 0; i < vector.length-1; i++) {
			
			posicion_minimo = i;
			for (j = i+1; j < vector.length; j++) 
				if(vector[j]<vector[posicion_minimo])
					posicion_minimo = j;
			
			if(posicion_minimo != i){
				temp = vector[i];
				vector[i]=vector[posicion_minimo];
				vector[posicion_minimo]=temp;
			}
				
				
			}
			
		}
		
	public void Insercion(){
		double temp;
		int i, j;
		
		for (i = 1; i < vector.length; i++) {
			temp = vector[i];
			
			for (j = i; (j > 0) && temp<vector[j-1]; j--){
				vector[j]=vector[j-1];
			}
				
			
			vector[j] = temp;
			
		}
		
	}
				
	public void Burbuja(){
		int i, j;
		double temp;
	
		for (i = 0; i < vector.length; i++) {
			for (j = vector.length-1; j > i; j--) {
				if(vector[j]<vector[j-1]){
					temp = vector[j];
					vector[j] = vector[j-1];
					vector[j-1] = temp;
				}
					
			}
		}
		
	}
	
	
	public void QuickSort(Ordenadora vector, int izq, int der){
		
		int pivote;
		
		if(izq<der)
		{
		pivote = Partir(vector,izq,der);
		QuickSort(vector,izq,pivote-1);
		QuickSort(vector,pivote+1,der);
		}
	}
	
	private int Partir(Ordenadora V, int pri, int ult)
	{
		 double pivote = V.vector[pri];
		 double tmp;
		 int izq = pri+1;
		 int der = ult;
		
		do{
			
			while(izq<=der && V.vector[izq]<=pivote)
				izq++;
			while(izq<=der && V.vector[der]>pivote)
				der--;
			
			if(izq<=der)
			{
				tmp = V.vector[izq];
				V.vector[izq] = V.vector[der];
				V.vector[der] = tmp;
			}
			
		}while(izq<=der);
		 
		tmp = V.vector[pri];
		V.vector[pri] = V.vector[der];
		V.vector[der] = tmp;
		
		return der;
	}
	
	
}
