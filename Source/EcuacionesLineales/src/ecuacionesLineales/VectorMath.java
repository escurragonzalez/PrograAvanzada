package ecuacionesLineales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.IIOException;

public class VectorMath {
	
	private int dimension;
	private double[] componentes;
	
	public VectorMath(int dimension){
		this.dimension = dimension;
		this.componentes = new double[dimension];
	}
	
	@SuppressWarnings("unused")
	public VectorMath(String path) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea = "";
		String[] arraySplit;
		try {
			archivo = new File(path);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			if (null == (linea = br.readLine())) {
				throw new IIOException ("Error - Primera Linea Vacia");
			}
			this.dimension = Integer.parseInt(linea);
			this.componentes = new double[this.dimension];
			
			for (int i = 0; i < this.dimension; i++) {
				linea = br.readLine();
				arraySplit = linea.split(" ");
				this.componentes[i]=Double.parseDouble(linea);
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getDimension() {
		return this.dimension;
	}

	public double[] getComponentes() {
		return this.componentes;
	}

	public void setComponentes(double[] componentes) {
		this.dimension=componentes.length;
		this.componentes = new double[this.dimension];
		for(int i=0;i<componentes.length;i++){
			this.componentes[i]=componentes[i];
		}
	}
	
	public VectorMath sumar(VectorMath vector){
		
		VectorMath resultado = new VectorMath(this.dimension);
		try {
			
			if (this.dimension != vector.dimension)
				throw new DistDimException(" Distinta Dimension ");
			
			for(int i=0; i<dimension; i++)
				resultado.componentes[i] = this.componentes[i]+vector.componentes[i];

		    } catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public VectorMath restar(VectorMath vector){
		
		VectorMath resultado = new VectorMath(this.dimension);
		try {
			
			if (this.dimension != vector.dimension)
				throw new DistDimException(" Distinta Dimension ");
			
			for(int i=0; i<dimension; i++)
				resultado.componentes[i] = this.componentes[i]-vector.componentes[i];

		    } catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public double producto(VectorMath vector){
		
		double resultado=0;
		try {
			
			if (this.dimension != vector.dimension)
				throw new DistDimException(" Distinta Dimension ");
			
			for(int i=0; i<dimension; i++)
				resultado += this.componentes[i]*vector.componentes[i];

		    } catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public VectorMath producto(MatrizMath matriz){
		
		VectorMath resultado=new VectorMath(this.dimension);
		try {
			
			if (this.dimension != matriz.getDimensionFil())
				throw new DistDimException(" Distinta Dimension ");
			
			for(int i=0; i<dimension; i++)
				for (int j = 0; j < matriz.getDimensionCol(); j++) {
					resultado.componentes[i] += this.componentes[j]*matriz.getComponentes()[j][i];
				}
			
		    } catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public VectorMath producto (double numero){
		double[] componentes  = new double[this.getDimension()];
		VectorMath vector = new VectorMath(this.getDimension());
		for (int i=0;i<this.getDimension();i++) {
			componentes[i]=this.getComponentes()[i]*numero;
		}
		vector.setComponentes(componentes);
		return vector;
	}
	
	public String toString(){
		String resultado="";
		
		resultado+="Dimension:"+this.dimension+"\n";
		resultado+="( ";
		for (int i = 0; i < componentes.length; i++) {
			resultado += componentes[i]+" ";
			
		}
		resultado+=")";
		return resultado;
	}
	
	public boolean equals(Object vector){
		if (vector==null){
			return false;
		}
		if(!(vector instanceof VectorMath)){
			return false;
		}
		VectorMath vectorMath = (VectorMath) vector;
		if(vectorMath.getDimension()!=this.getDimension())
		{
			return false;
		}
		for (int i = 0; i < this.getDimension(); i++) {
			if(this.getComponentes()[i]!=vectorMath.getComponentes()[i]){
				return false;
			}
		}
		return true;
	}
	
	public VectorMath clone(){
		VectorMath vector = new VectorMath(this.getDimension());
		vector.setComponentes(this.getComponentes());
		return vector;
	}
	
	public double normaUno(){
		double resultado=0;
		for (double f : this.getComponentes()) {
			resultado+=Math.abs(f);
		}
		return resultado;
	}	
	
	public double normaDos(){
		double resultado=0;
		for (double f : this.getComponentes()) {
			resultado+=Math.pow(f, 2);
		}
		return (double) Math.sqrt(resultado);
	}
	
	public double normaInfinito(){
		double maximo=Math.abs(this.getComponentes()[0]);
		for (double f : this.getComponentes()) {
			if(maximo<Math.abs(f))
				maximo=Math.abs(f);
		}
		return maximo;
	}
	
}
