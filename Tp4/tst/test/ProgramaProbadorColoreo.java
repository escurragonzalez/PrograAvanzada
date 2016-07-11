package test;

import grafo.GrafoNDNP;

import java.io.*;

public class ProgramaProbadorColoreo {
	
	public ProgramaProbadorColoreo (){
	}

	public boolean probador(String entrada, String salida){
		GrafoNDNP grafo = new GrafoNDNP(entrada);
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		try{
			f = new File(salida);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			String[] datos;
			linea = br.readLine();
			datos = linea.split(" ");
			if(grafo.getCantNodos() != Integer.parseInt(datos[0]))
				return false;
			if(grafo.getCantAristas() != Integer.parseInt(datos[2]))
				return false;
			if(grafo.getPorcentajeAdy() != Double.parseDouble(datos[3]))
				return false;
			if(grafo.getGradMax() != Integer.parseInt(datos[4]))
				return false;
			if(grafo.getGradMin() != Integer.parseInt(datos[5]))
				return false;
			@SuppressWarnings("unused")
			int cantColores = Integer.parseInt(datos[1]);
			for (int i = 0; i < grafo.getCantNodos(); i++) {
				linea = br.readLine();
				datos = linea.split(" ");
				if(grafo.getVectorNodos()[Integer.parseInt(datos[0])-1].getColor() == 0)
					grafo.getVectorNodos()[Integer.parseInt(datos[0])-1].setColor(Integer.parseInt(datos[1]));
				else
					return false;
			}
			for (int i = 0; i < grafo.getCantNodos(); i++) {
				if(grafo.getVectorNodos()[i].getColor() <= 0)
					return false;
				for (int j = 0; j < grafo.getCantNodos(); j++) {
					if(i != j && grafo.getMatriz().getElement(i, j) == 1 && grafo.getVectorNodos()[i].getColor() == grafo.getVectorNodos()[j].getColor())
						return false;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			try{
				if(br != null)
					br.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return true;
	}
}