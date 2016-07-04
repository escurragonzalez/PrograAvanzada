package ar.unlam.cmc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CambioDeManoCalles {

	private Integer cantEsquinas;
	private Integer esquinaOrigen;
	private Integer esquinaEscuela;
	private Integer[][] matrizAdyacencia;
	private Integer[][] matrizNroCalles;
	private Integer cantCalles;
	private Integer[] distancias;
	private Integer recorridoOriginal;
	private Integer menorRecorrido;
	private Integer[][]matrizAdyacenciaDobleSentido;   
	private Integer[] vectorPrecedencias;
	private Integer[] vectorPrecedenciasDobleMano;
	private Integer[] vectorDistanciasSinCambioDeCalle;
	private Integer[] vectorDistanciasCambiandoCalles;
	private Integer distanciaAlColeSinCambiarCalles;
	private Integer distanciaAlColeCambiandoCalles;
	private Integer[] vectorCallesCambiadas;
	private Integer cantidadCallesCambiadas;
	private Arista[] vectorRecorridoCambiadas;
	private Integer cantidadRecorridoCambiadas;
	

	public void leerArchivo(String ruta) {

		File archivo;
		FileReader fr;
		BufferedReader br;
		String linea;
		String[] lineaSplit;
		try {

			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			if ((linea = br.readLine()) == null) {
				fr.close();
				throw new Exception();
			}

			lineaSplit = linea.split(" ");
			//Leo de la primer linea: las esquinas, la esquina de la que sale el colectivo y la esquina de la escuela
			cantEsquinas = Integer.parseInt(lineaSplit[0]);
			esquinaOrigen = Integer.parseInt(lineaSplit[1]);
			esquinaEscuela = Integer.parseInt(lineaSplit[2]);
			
			//Declaro las matrices: de adyacencia y una matriz para el nro de las calles.
			matrizAdyacencia = new Integer[cantEsquinas][cantEsquinas];
			matrizNroCalles = new Integer[cantEsquinas][cantEsquinas];
			//Inicializo ambas matrices
			inicializarMatrices(matrizAdyacencia, cantEsquinas);
			inicializarMatrices(matrizNroCalles, cantEsquinas);

			//Leo la cantidad de calles
			linea = br.readLine();
			cantCalles = Integer.parseInt(linea);
			
			//Guardo cada una de las calles (de donde sale, a donde va, su costo y su nro).
			Integer nroCalle = 1;
			for (int i = 0; i < cantCalles; i++) {
				linea = br.readLine();
				lineaSplit = linea.split(" ");
				int origenCalle = Integer.parseInt(lineaSplit[0]);
				int destinoCalle = Integer.parseInt(lineaSplit[1]);
				int distancia = Integer.parseInt(lineaSplit[2]);

				matrizAdyacencia[origenCalle - 1][destinoCalle - 1] = distancia;
				matrizNroCalles[origenCalle - 1][destinoCalle - 1] = nroCalle;
				nroCalle++;
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}//Hasta acá se leyó el archivo.

	//Inicializar las matrices (les pone un valor muy grande).
	private void inicializarMatrices(Integer[][] matrizAdyacencia, Integer cantNodos) {
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				matrizAdyacencia[i][j] = 999999;
			}

		}

	}

	//Resolver. Solamente llama a Dijkstra
	public Integer[] resolver() {
		
	
		return this.distancias = dijkstra(this.matrizAdyacencia, this.esquinaOrigen, this.cantEsquinas,this.vectorPrecedencias);

	}
	
	//Dijkstra
	private Integer[] dijkstra(Integer[][] mAdy, Integer nodoOrigen, Integer cantEsquinas, Integer[] vectorPrecedencia) {

		Integer caminoDirecto, caminoIndirecto;
		Integer vectorDistancias[] = new Integer[cantEsquinas];
		Integer vectorSolucion[] = new Integer[cantEsquinas];
		inicializarVectorSolucion(vectorSolucion, cantEsquinas);
		Integer minCosto;
		Integer ultimoVisitado = 0;
		
		// Inicializo el vector con la primera fila de la matriz.
		for (int i = 0; i < cantEsquinas; i++) {
			vectorDistancias[i] = mAdy[nodoOrigen - 1][i];
		}
		
		vectorSolucion[nodoOrigen-1] = 0;
		for (int cantEsquinasRestantes = 0; cantEsquinasRestantes < cantEsquinas-1; cantEsquinasRestantes++) {
			minCosto = 999999;
			for (int i = 0; i < cantEsquinas; i++) {
				if(vectorSolucion[i]==999999 && vectorDistancias[i]<minCosto){
					minCosto = vectorDistancias[i];
					ultimoVisitado = i;
					
				}
				
			}
			if(minCosto!=999999){
				vectorSolucion[ultimoVisitado]=0;
			}
			
			//Ahora busco adyacencias
			for (int i = 0; i < cantEsquinas; i++) {
				caminoDirecto = vectorDistancias[i];
				caminoIndirecto = vectorDistancias[ultimoVisitado]+mAdy[ultimoVisitado][i];
				if(caminoIndirecto<caminoDirecto ){
					vectorDistancias[i] = caminoIndirecto;
					vectorPrecedencia[i] = ultimoVisitado+1;
					
				}
				
			}
			
			
		}
		
		return vectorDistancias;

		
	}

	
	private Integer[][] MatrizDobleSentido(){
		Integer[][]matrizDobleSentido = new Integer[cantEsquinas][cantEsquinas];
		inicializarMatrices(matrizDobleSentido, cantEsquinas);
		
		for (int i = 0; i < cantEsquinas; i++) {
			for (int j = 0; j < cantEsquinas; j++) {
				if(matrizAdyacencia[i][j]!=999999){
					matrizDobleSentido[i][j]=matrizAdyacencia[i][j];
					matrizDobleSentido[j][i]=matrizAdyacencia[i][j];
				}
				
			}
			
		}
		return matrizDobleSentido;
	} 
	
	
	public void resolverCambiandoCalles(){

		vectorPrecedencias = new Integer[cantEsquinas];
		vectorPrecedenciasDobleMano = new Integer [cantEsquinas];
		inicializarVector(vectorPrecedencias, cantEsquinas);
		inicializarVector(vectorPrecedenciasDobleMano, cantEsquinas);
		vectorCallesCambiadas = new Integer[cantCalles];
		
		//Inicializo el vector que me dirá qué calles se cambiaron en 0. Más adelante si la calle se cambió la pondré en 1
		for (int i = 0; i < cantCalles; i++) {
			vectorCallesCambiadas[i]=0;
			
		}
		//Los caminos en una dirección ahora los voy a hacer doble mano.
		matrizAdyacenciaDobleSentido = new Integer [cantEsquinas][cantEsquinas];
		matrizAdyacenciaDobleSentido = MatrizDobleSentido();
		
		//Ahora ejecutaré Dijkstra con las 2 matrices. La oricinal y la de caminos con doble mano.
		vectorDistanciasSinCambioDeCalle = dijkstra(matrizAdyacencia, esquinaOrigen, cantEsquinas, vectorPrecedencias);
		vectorDistanciasCambiandoCalles = dijkstra(matrizAdyacenciaDobleSentido, esquinaOrigen, cantEsquinas, vectorPrecedenciasDobleMano);
		
		//Una vez que tengo los vectores de precedencias buscaré el minimo para ver si hubo o no cambio de calle.
		distanciaAlColeSinCambiarCalles = vectorDistanciasSinCambioDeCalle[esquinaEscuela-1];
		distanciaAlColeCambiandoCalles = vectorDistanciasCambiandoCalles[esquinaEscuela-1];
		//Si la distancia al colegio cambiando calles es menor, buscaré las calles cambiadas usando las precedencias
		if(distanciaAlColeCambiandoCalles<distanciaAlColeSinCambiarCalles){
			
			menorRecorrido = distanciaAlColeCambiandoCalles;
			
		}
		
		else{
			menorRecorrido = distanciaAlColeSinCambiarCalles;
		}
		
		
		
	}

	private void inicializarVector(Integer[] vec, Integer cantEsquinas) {
		for (int i = 0; i < cantEsquinas; i++) {
			vec[i]=esquinaOrigen;

		}

	}
	
	private void inicializarVectorSolucion(Integer[] vec, Integer cantEsquinas) {
		for (int i = 0; i < cantEsquinas; i++) {
			vec[i] = 999999;
			
		}

	}
	
	//Escritura del archivo
	public void escribirArchivo(String ruta){
		
		FileWriter fw = null;
		PrintWriter pw = null;

		try {

			fw = new FileWriter(ruta);
			pw = new PrintWriter(fw);
				
				//En primer lugar escribo la distancia mínima.
				pw.println(menorRecorrido);
				
				//Luego escribo por c/calle que se haya cambiado, su nro.
				for (int i = 0; i < cantCalles; i++) {
					if (vectorCallesCambiadas[i]==1){
						pw.print(i+1+" ");
					}
					
				}
			

		} catch (Exception e1) {
			System.out.println("Error de Escritura Archivo de Salida - " + e1.getMessage());
		} finally {
			if (ruta != null) {
				try {
					fw.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}
		
	}
	public Integer getDistanciaAlColeSinCambiarCalles() {
		return distanciaAlColeSinCambiarCalles;
	}

	public Integer getDistanciaAlColeCambiandoCalles() {
		return distanciaAlColeCambiandoCalles;
	}

	public void buscarDiferenciasRecorridos() {
		vectorCallesCambiadas = new Integer[cantCalles];
		
		//Inicializo el vector que me dirá qué calles se cambiaron en 0. Más adelante si la calle se cambió la pondré en 1
		for (int i = 0; i < cantCalles; i++) {
			vectorCallesCambiadas[i]=0;
		}
		
		this.vectorRecorridoCambiadas=new Arista[this.cantEsquinas*this.cantEsquinas/2];
		this.cantidadRecorridoCambiadas=new Integer(0);
		
		Integer esquinaOrigenAux=new Integer(this.vectorPrecedenciasDobleMano[this.esquinaEscuela-1]);
		Integer esquinaDestinoAux=this.esquinaEscuela;
		
		this.vectorRecorridoCambiadas[this.cantidadRecorridoCambiadas++]=new Arista(esquinaOrigenAux,esquinaDestinoAux,0);
		
		while(esquinaOrigenAux!=this.esquinaOrigen.intValue()){
			
			esquinaDestinoAux=esquinaOrigenAux;
			esquinaOrigenAux=new Integer(this.vectorPrecedenciasDobleMano[esquinaOrigenAux-1]);
			this.vectorRecorridoCambiadas[this.cantidadRecorridoCambiadas++]=new Arista(esquinaOrigenAux,esquinaDestinoAux,0);
		}
		
		for (int i = 0; i < this.cantidadRecorridoCambiadas; i++) {
			Integer esquinaOrigenAUX=vectorRecorridoCambiadas[i].getOrigen();
			Integer esquinaDestinoAUX=vectorRecorridoCambiadas[i].getDestino();
			
			if(this.matrizAdyacencia[esquinaDestinoAUX-1][esquinaOrigenAUX-1]!=999999){
				this.vectorCallesCambiadas[this.matrizNroCalles[esquinaDestinoAUX-1][esquinaOrigenAUX-1]-1]=1;
			}
		}
	}
		
}
