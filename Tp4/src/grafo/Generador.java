package grafo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Generador {
	protected boolean[][] matrizAdyacencia=null;
	protected int cantNodos;
	protected int cantAristas;
	protected int gradoMaxima;
	protected int gradoMinima;
	protected double porcAdyacencia;		
		
	public Generador(int nodos){
			this.cantNodos=nodos;
			this.matrizAdyacencia= new boolean[nodos][nodos];
			for(int i=0;i<nodos;i++){
				for (int j = 0; j < nodos; j++) {
					matrizAdyacencia[i][j]=false;
				}
			}
		}
		
		public void esccribirArchivo(String path){
			FileWriter archivo = null;
			PrintWriter pw = null;
			try {
				archivo = new FileWriter(path);
				pw = new PrintWriter(archivo);
				calcularGrado();
				pw.write(this.cantNodos+" "+this.cantAristas+" "+this.porcAdyacencia+" "+this.gradoMaxima+" "+this.gradoMinima);
				pw.write("\n");
				for(int i=0;i<this.cantNodos;i++){
					for(int j=0;j<this.cantNodos;j++){
						if(matrizAdyacencia[i][j]==true)
						pw.write(i+" "+j+"\n");
					}
				}
			} catch (Exception e) {
				System.out.println("Error de Escritura Archivo de Salida - "+e.getMessage());
			} finally {
				if (null != archivo) {
					try {
						archivo.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		public void calcularGrado(){
		int max=0;
		int min=Integer.MAX_VALUE;
		int cont=0;
		
		for(int i=0;i<cantNodos;i++){
			for (int j = 0; j < cantNodos; j++) {
				if(matrizAdyacencia[i][j]){
					cont++;
				}
			}
			if(cont>max)
				max=cont;
			if(cont<min)
				min=cont;
			cont=0;
		}
		gradoMaxima=max;
		gradoMinima=min;
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
