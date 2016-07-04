package algoritmosGrafos;

public class Arista {
	int origen, destino, valorAgrupador;
	
	
	public Arista (int origen,int destino,int valorAgrupador){
		this.origen=origen;
		this.destino=destino;
		this.valorAgrupador=valorAgrupador;
	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public int getvalorAgrupador() {
		return valorAgrupador;
	}

	public void setvalorAgrupador(int valorAgrupador) {
		this.valorAgrupador = valorAgrupador;
	}
	
	
	
	
}
