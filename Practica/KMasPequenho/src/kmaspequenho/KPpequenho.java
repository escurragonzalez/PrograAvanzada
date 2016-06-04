package kmaspequenho;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class KPpequenho {
	
	private int[] numeros;
	private int[] resultado;
	private int cantidad;
	
	public KPpequenho(String path) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try{
			String[] splitLine=null;
			String linea="";
			archivo = new File(path);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			linea= br.readLine();
			splitLine=linea.split(" ");
			int num= Integer.parseInt(splitLine[0]);
			cantidad= Integer.parseInt(splitLine[1]);
			numeros = new int[num];
			resultado = new int[cantidad+1];
			for(int i=0;i<num;i++){
				linea= br.readLine();
				numeros[i]= Integer.parseInt(linea);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void resolver(){
		ordenarVector();
		resultado[0]=cantidad;
		int c = cantidad-1;
		int j=2;
		if(c>0 && numeros.length>0){
			resultado[1]=numeros[0];
			for(int i=1;i<numeros.length-1;i++){
				if(numeros[i]>resultado[j-1]&& c>0){
					resultado[j]=numeros[i];
					j++;
					c--;
				}
			}
		}
		escribirArchivo();
	}

	private void ordenarVector() {
		int aux=0;
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros.length-1; j++) {
					if(numeros[j]>numeros[j+1]){
					aux=numeros[j];
					numeros[j]=numeros[j+1];
					numeros[j+1]=aux;
				}
			}
		}
	}

	private void escribirArchivo() {
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			fw = new FileWriter("salida.out");
			pw = new PrintWriter(fw);
			for(int i=0;i<this.resultado.length;i++){
				pw.println(resultado[i]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fw!=null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
