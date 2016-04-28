package ecuacionesLineales;

import java.io.*;

public class Sel {

	private MatrizMath matrizCoeficientes;
	private VectorMath vectorIncognita;
	private VectorMath vectorTerminosIndependientes;
	private float errorSel;
	

	public Sel(String archIn) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea = "";
		String[] arraySplit;
		float[][] matriz = null;
		Integer orden = 0;
		float[] vector = null;
		try {
			archivo = new File(archIn);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			if (null != (linea = br.readLine())) {
				matriz = new float[Integer.parseInt(linea)][Integer
						.parseInt(linea)];
			}
			orden = Integer.parseInt(linea);
			int n = orden * orden;
			for (int i = 0; i < n; i++) {
				linea = br.readLine();
				arraySplit = linea.split(" ");
				matriz[Integer.parseInt(arraySplit[0])][Integer
						.parseInt(arraySplit[1])] = Float
						.parseFloat(arraySplit[2]);
			}
			this.matrizCoeficientes = new MatrizMath();
			this.matrizCoeficientes.setComponentes(matriz);
			this.vectorTerminosIndependientes = new VectorMath(orden);
			vector = new float[orden];
			for (int i = 0; i < orden; i++) {
				linea = br.readLine();
				vector[i] = Float.parseFloat(linea);
			}
			this.vectorTerminosIndependientes.setComponentes(vector);
			this.vectorIncognita = new VectorMath(orden);
			this.errorSel=0;
		} catch (Exception e) {
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

	public String toString() {
		String resultado = "";
		resultado += "Matriz de Coeficientes: \n"
				+ this.matrizCoeficientes.toString() + "\n";
		resultado += "Vector de Incognitas: \n"
				+ this.vectorIncognita.toString() + "\n";
		resultado += "Vector De Terminos Independientes: \n"
				+ this.vectorTerminosIndependientes.toString() + "\n";
		resultado += "Calculo de error: \n"
				+ this.errorSel + "\n";
		return resultado;
	}

/*	
 	public Sel clone() {
		Sel nuevo = new Sel();
		nuevo.matrizCoeficientes = this.matrizCoeficientes.clone();
		nuevo.vectorIncognita = this.vectorIncognita.clone();
		nuevo.vectorTerminosIndependientes = this.vectorTerminosIndependientes
				.clone();
		return nuevo;
	}*/

	public void resolver(String archOut) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		MatrizMath matrizInvertida = null;
		VectorMath vectorsolucion = null;
		try {
			matrizInvertida = this.matrizCoeficientes.invertir();
			vectorsolucion = matrizInvertida
					.producto(this.vectorTerminosIndependientes);
			this.vectorIncognita
					.setComponentes(vectorsolucion.getComponentes());
			fichero = new FileWriter(archOut);
			pw = new PrintWriter(fichero);
			pw.println(this.vectorIncognita.getDimension());
			for (int i = 0; i < this.vectorIncognita.getDimension(); i++) {
				pw.println(this.vectorIncognita.getComponentes()[i]);
			}
			pw.println();
			this.errorSel=calcularError();
			pw.print(this.errorSel);
		} catch (Exception e) {
			e.printStackTrace();
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

	private float calcularError(){
		
		float errorTermIndep;
		VectorMath vecTermIndepPrima = null;
		
		vecTermIndepPrima = this.matrizCoeficientes.producto(this.vectorIncognita); // B'
		errorTermIndep = (vecTermIndepPrima.restar(this.vectorTerminosIndependientes)).normaDos(); // ||B'-B||2
		
		/*System.out.println("VECTERMINDEPPRIMA: \n" + vecTermIndepPrima.toString());
		System.out.println("RESTA: \n" + vecTermIndepPrima.restar(this.vectorTerminosIndependientes));
		System.out.println("NORMA 2: " + (vecTermIndepPrima.restar(this.vectorTerminosIndependientes)).normaDos());
		System.out.println("ERRORTERMINDEP: " + this.errorSel);*/
		
		return errorTermIndep;
	}

}
