package generadorCasosFatiga;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import ar.unlam.cmc.Arista;

public class GeneradorCasosDeFatiga {
	
	private Integer cantidadNodos;
	private Integer cantidadAristas;

	public static void main(String[] args) {
				
		GeneradorCasosDeFatiga generador=new GeneradorCasosDeFatiga();
		
		generador.GenerarGrafoRandom();

	}

	private void GenerarGrafoRandom() {
		Set<Arista> aristas=new HashSet<Arista>();	
		
		Random rd= new Random();
		
		for (int i = 0; i < this.cantidadAristas; i++) {
			Integer nodoOrigenRAN=(int) (rd.nextFloat()*this.cantidadNodos);
			Integer nodoDestinoRAN=(int) (rd.nextFloat()*this.cantidadNodos);
			Integer ponderacionRAN=(int) (rd.nextFloat()*100);
			Integer valorSiArista=(int) (rd.nextFloat()*5);
			if(valorSiArista > 3) {
				aristas.add(new Arista (nodoOrigenRAN,nodoDestinoRAN,ponderacionRAN));
			}
			
			
		}
		
		
		
	}

}
