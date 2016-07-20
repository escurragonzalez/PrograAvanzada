package tp3;

public class NodoDato {
	private IOperacion termino;


public NodoDato(IOperacion termino){
	this.termino=termino;
}


public IOperacion getTermino() {
	return termino;
}


public void setTermino(IOperacion termino) {
	this.termino = termino;
}



}
