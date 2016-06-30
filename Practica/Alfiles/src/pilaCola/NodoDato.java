package pilaCola;

public class NodoDato {
	private Integer valor;
	private Integer costo;


public void setCosto(Integer costo) {
		this.costo = costo;
	}

public NodoDato(int valor,int costo){
	this.valor = valor;
	this.costo=costo;
}

public int getValor(){
	return valor;
}

public int getCosto(){
	return costo;
}



}
