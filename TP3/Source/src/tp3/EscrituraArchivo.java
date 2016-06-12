package tp3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscrituraArchivo {
	private Integer cantidadValoresSalida;
	private Double[] valoresSalida;
	
	public Integer getCantidadValoresSalida() {
		return cantidadValoresSalida;
	}
	public void setCantidadValoresSalida(Integer cantidadValoresSalida) {
		this.cantidadValoresSalida = cantidadValoresSalida;
		this.valoresSalida=new Double[this.cantidadValoresSalida];
	}
	public Double[] getValoresSalida() {
		return valoresSalida;
	}
	
	public void escribirArchivoSalida(String path){
		FileWriter archivo=null;
		PrintWriter pw=null;
		
		try {
			archivo=new FileWriter(path);
			pw=new PrintWriter(archivo);
			
			pw.println(this.cantidadValoresSalida);
			for (int i = 0; i < valoresSalida.length; i++) {
				pw.println(this.valoresSalida[i]);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			if(null!=archivo)
				try{
					archivo.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
		}
	}
	
}
