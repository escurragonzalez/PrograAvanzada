package alfiles;

public class Casillero {
	
	private int fila;
	private int columna;
	
	Casillero(int fila, int columna){
		this.setFila(fila);
		this.setColumna(columna);
		
	}
	
	
	
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	
}
