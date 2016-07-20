package tp3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaArchivo {

	private String expresion;
	private Integer cantidadVariables;
	private Integer cantidadPuntos;
	private Double puntos[][];

	public LecturaArchivo(String path) {
			
		File file=null;
		FileReader fileReader=null;
		try {
			file=new File (path);
			fileReader=new FileReader(file);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String linea = bufferedReader.readLine();
			if(linea == null)
				throw new Exception ("Archivo Vacio");
			this.expresion=linea;
			
			linea = bufferedReader.readLine();
			this.cantidadVariables=Integer.parseInt(linea.split(" ")[0]);
			this.cantidadPuntos=Integer.parseInt(linea.split(" ")[1]);
			
			this.puntos= new Double [this.cantidadPuntos][this.cantidadVariables];
			
			for (int i = 0; i < this.cantidadPuntos; i++) {
				linea = bufferedReader.readLine();
				for (int j = 0; j < this.cantidadVariables; j++) {
					this.puntos[i][j]=Double.parseDouble(linea.split(" ")[j]);				
				}
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null!=fileReader)
				try{
					fileReader.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
		}
		
				
	}

	public String getExpresion() {
		return expresion;
	}

	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}

	public Integer getCantidadVariables() {
		return cantidadVariables;
	}

	public void setCantidadVariables(Integer cantidadVariables) {
		this.cantidadVariables = cantidadVariables;
	}

	public Integer getCantidadPuntos() {
		return cantidadPuntos;
	}

	public void setCantidadPuntos(Integer cantidadPuntos) {
		this.cantidadPuntos = cantidadPuntos;
	}

	public Double[][] getPuntos() {
		return puntos;
	}

	public void setPuntos(Double[][] puntos) {
		this.puntos = puntos;
	}
	
}
