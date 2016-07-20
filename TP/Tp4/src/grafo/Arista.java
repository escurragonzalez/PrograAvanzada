package grafo;

public class Arista {
	int origen, destino;
	double valorRandom;
	
	public Arista (int origen,int destino,double valorRandom){
		this.origen=origen;
		this.destino=destino;
		this.valorRandom=valorRandom;
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

	public double getValorRandom() {
		return valorRandom;
	}

	public void setValorRandom(double valorRandom) {
		this.valorRandom = valorRandom;
	}
	
	
	
	
}
