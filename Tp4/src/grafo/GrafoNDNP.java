package grafo;

import java.io.BufferedReader;
import matriz.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class GrafoNDNP {
	private MatrizSimetrica matriz;
	private int cantNodos;
	private int cantAristas;
	private int gradMin;
	private int gradMax;
	private double porcentajeAdy;
	private Nodo[] vectorNodos;
	private int cantColores;
	private ArrayList<Integer> listaNoPintados = new ArrayList<Integer>();

	
	public MatrizSimetrica getMatriz() {
		return matriz;
	}
	public int getCantNodos() {
		return cantNodos;
	}
	public int getCantAristas() {
		return cantAristas;
	}
	public int getGradMin() {
		return gradMin;
	}
	public int getGradMax() {
		return gradMax;
	}
	public double getPorcentajeAdy() {
		return porcentajeAdy;
	}
	public Nodo[] getVectorNodos() {
		return vectorNodos;
	}
	public int getCantColores() {
		return cantColores;
	}
	
	public GrafoNDNP(GrafoNDNP aux){
		matriz = aux.matriz;
		cantNodos = aux.cantNodos;
		cantAristas = aux.cantAristas;
		gradMin = aux.gradMin;
		gradMax = aux.gradMax;
		porcentajeAdy = aux.porcentajeAdy;
		cantColores = 0;
		vectorNodos = new Nodo[cantNodos];
		for (int i = 0; i < cantNodos; i++){
			vectorNodos[i] = new Nodo(aux.vectorNodos[i]);
		}
		for (int i = 0; i < cantNodos; i++) 
			listaNoPintados.add(i);
	}
	

	public GrafoNDNP(String ruta){
		File file=null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea;
		String []datos;
		try{
			file = new File(ruta);	
			fr = new FileReader(file);
			br = new BufferedReader(fr);			
			linea= br.readLine();			
			datos = linea.split(" ");			
			cantNodos=Integer.parseInt(datos[0]); 
			cantAristas=Integer.parseInt(datos[1]);
			porcentajeAdy=Double.parseDouble(datos[2]);
			gradMax=Integer.parseInt(datos[3]);
			gradMin=Integer.parseInt(datos[4]);			
			vectorNodos = new Nodo[cantNodos];
			matriz= new MatrizSimetrica(cantNodos);			
			for (int i = 0; i < cantNodos; i++) {
				vectorNodos[i] = new Nodo(0,0,i);
			}
			for (int i = 0; i < cantNodos; i++) 
				listaNoPintados.add(i);
			for (int i = 0; i < cantAristas; i++) {
				linea = br.readLine();
				datos=linea.split(" ");
				matriz.setPosicion(Integer.parseInt(datos[0])-1, Integer.parseInt(datos[1])-1);
				vectorNodos[Integer.parseInt(datos[0])-1].agregarAdyacente(Integer.parseInt(datos[1])-1);
				vectorNodos[Integer.parseInt(datos[1])-1].agregarAdyacente(Integer.parseInt(datos[0])-1);
			}
			for (int i = 0; i < cantNodos; i++) 
				for (int j = 0; j < cantNodos; j++) 
					if(i!=j&&matriz.getElement(i, j)==1){
						vectorNodos[i].incrementarGrado();
						//vectorNodos[j].incrementarGrado();
					}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(br!=null)
				try{
					br.close();
				}catch(Exception e){
					e.printStackTrace();
				}
		}
	}
	
	public void coloreo() throws Exception{
		int nodosPintados=0;
		int color=1;
		int flag=0;
		while(nodosPintados!=cantNodos){
			for(int i = 0; i < cantNodos; i++){
				if(vectorNodos[i].getColor()==0){
					for (int j = 0; j < i; j++) {
						if(matriz.getElement(vectorNodos[i].getNumeroNodo(), vectorNodos[j].getNumeroNodo())==1 
								&& vectorNodos[j].getColor()==color){
							flag=1;
							break;
						}		
					}
					if(flag==0){
						nodosPintados++;
						vectorNodos[i].setColor(color);
					}
					flag=0;
				}
			}
			color++;
		}
		cantColores=color-1;
	}
	
	public int coloreo2() throws Exception{
		int color=1;
		int flag=0;
		int p = 0;
		//while(!listaNoPintados.isEmpty()){
		while(p <cantNodos){
			Iterator<Integer> itNP = listaNoPintados.iterator();
			while(itNP.hasNext()){
				int aux = itNP.next();
				if(vectorNodos[aux].getColor()==0){
					Iterator<Integer> it = vectorNodos[aux].getAdyacentes().iterator();					
					while(it.hasNext()){
						if(vectorNodos[it.next()].getColor()==color){
							flag=1;
							break;
						}
					}
					if(flag==0){
						vectorNodos[aux].setColor(color);
						itNP.remove();
					}
					flag=0;
				}
			}
			color++;
			p++;
		}
		return cantColores=color-1;
	}
	
	public void welsh_Powel() throws Exception{
		this.ordenarRand();
		this.ordenacionInsercion(1);
		this.coloreo();
	}
	public void matula() throws Exception{
		this.ordenarRand();
		this.ordenacionInsercion(0);
		this.coloreo();
	}
	
	public int aleatorio() throws Exception{
		long timeinimezcla = System.nanoTime()/1000000;
		this.ordenarRand();
		long timefinmezcla = System.nanoTime()/1000000;
		System.out.println("Tiempo en mezclar: " + (timefinmezcla - timeinimezcla));
		return this.coloreo2();
	}
	
	
	public void ordenarRand(){
		Collections.shuffle(listaNoPintados);
		/*for (int i = 0; i < cantNodos; i++) {
			int pos1 = (int) (Math.random()*cantNodos);
			int pos2 = (int) (Math.random()*cantNodos);
			Nodo aux = new Nodo(vectorNodos[pos1]);
			vectorNodos[pos1]= new Nodo(vectorNodos[pos2]);
			vectorNodos[pos2]= new Nodo(aux);
		}*/
	}
	
	public void ordenacionInsercion(int des) {
        for(int i=1; i<cantNodos; i++) {
            int j=i;
            if(des==0)
	            while(j>0 && vectorNodos[j].getGrado()<vectorNodos[j-1].getGrado() ){
	                Nodo tmp = vectorNodos[j];
	                vectorNodos[j]    = vectorNodos[j-1];
	                vectorNodos[j-1]  = tmp;
	                j--;
	            }
            else
            	while(j>0 && vectorNodos[j].getGrado()>vectorNodos[j-1].getGrado() ){
                Nodo tmp = vectorNodos[j];
                vectorNodos[j]    = vectorNodos[j-1];
                vectorNodos[j-1]  = tmp;
                j--;
            	}
        }
    }
	
	
	public void escribirArchivo(String pathOut) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        
        try {
        	fichero = new FileWriter(pathOut);
            pw = new PrintWriter(fichero);
            
            pw.println(cantNodos + " " + cantColores + " " + cantAristas + " " + porcentajeAdy + " " + gradMax + " " + gradMin);
            
            for(int i = 0; i < cantNodos; i++)
            	pw.println((vectorNodos[i].getNumeroNodo()+1) + " " + vectorNodos[i].getColor());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
           try {
	           if(fichero != null)
	        	   fichero.close();
           }
           catch(Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	public void calcularCantidadColores() {
		this.cantColores=0;
		for (int i = 0; i < this.getVectorNodos().length; i++) {
			if(this.getVectorNodos()[i].getColor()>this.cantColores)
				this.cantColores=this.getVectorNodos()[i].getColor();
		}
		
	}
}
