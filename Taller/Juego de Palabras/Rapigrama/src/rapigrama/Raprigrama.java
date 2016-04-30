package rapigrama;

import java.io.*;

public class Raprigrama {
	
	private char[][] tablero;
	private int dimension;
	private String[] palabras;
	private char[] resultado;
	private char [][] tableroInvertido;
	
	public Raprigrama(){
		
		File archivo=null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea = "";
		String[] splitlinea= null;
		try {
			archivo = new File("rapigrama.in");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			linea = br.readLine();
			splitlinea= linea.split(" ");
			this.dimension= Integer.parseInt(splitlinea[0]);
			int cant= Integer.parseInt(splitlinea[1]);
			this.tablero = new char[this.dimension][this.dimension];
			for (int i = 0; i < this.dimension; i++) {
				linea=br.readLine();
				char[] letras =linea.toCharArray();
				for (int j = 0; j < this.dimension; j++) {
					this.tablero[i][j]=letras[j];
				}
			}
			invertirTablero();
			
			this.palabras = new String[cant];
			this.resultado = new char[cant];
			for (int i = 0; i < cant; i++) {
				linea=br.readLine();
				palabras[i]=linea;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public void resolver(){
		int res= 0;
		int resColumna=0;
		String fila = "";
		String filaInvertida="";
		String columna = "";
		String columnaInvertida="";
		
		int i=0;
		for(int j=0;j<this.palabras.length;j++){
			i=0;
			this.resultado[j]='x';
			while(this.resultado[j]=='x' && i<this.dimension){
				fila= String.valueOf(this.tablero[i]);
				columna= String.valueOf(this.tableroInvertido[i]);
				res= fila.indexOf(this.palabras[j]);
				if(res!=-1){
					 this.resultado[j]='E';
				 }
				else{
					 filaInvertida = new StringBuilder(fila).reverse().toString();
					 res= filaInvertida.indexOf(this.palabras[j]);
					 if(res!=-1){
						 this.resultado[j]='O';
					 }
				}
				
				resColumna = columna.indexOf(this.palabras[j]);
				if(resColumna!=-1){
					 this.resultado[j]='S';
				 }
				else{
					 columnaInvertida = new StringBuilder(columna).reverse().toString();
					 resColumna= columnaInvertida.indexOf(this.palabras[j]);
					 if(resColumna!=-1){
						 this.resultado[j]='N';
					 }
				}
				i++;
			}
		}
		
				
	}

	public void escribirArchivoSalida(String archOut){
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			fichero = new FileWriter(archOut);
			pw = new PrintWriter(fichero);
			for (int i = 0; i < this.palabras.length; i++) {
				if (this.resultado[i]!='x') {
					pw.println(i+1 + " " + this.resultado[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("Error de Escritura Archivo de Salida - "+e.getMessage());
		} finally {
			if (null != fichero) {
				try {
					fichero.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	private void invertirTablero() {
		
		this.tableroInvertido=new char[this.dimension][this.dimension];
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension ; j++) {
				this.tableroInvertido[i][j]=this.tablero[j][i];
			}
		}
		
	}
}