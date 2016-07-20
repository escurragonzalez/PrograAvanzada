package grafo;

import java.util.*;
public class Nodo {
	private int grado;
	private int color;
	private int numeroNodo;	
	private ArrayList<Integer> adyacentes = new ArrayList<Integer>();
	public Nodo(){
		grado = 0;
		color = 0;
		numeroNodo = 0;
		//adyacentes = new ArrayList<Integer>();
	}
	
	@SuppressWarnings("unchecked")
	public Nodo(Nodo nodo){
		grado = nodo.grado;
		color = 0;
		numeroNodo = nodo.numeroNodo;
		adyacentes = (ArrayList<Integer>) nodo.adyacentes.clone();
	}
	
	public void agregarAdyacente(Integer nodo){
		adyacentes.add(nodo);
	}	
	
	public ArrayList<Integer> getAdyacentes() {
		return adyacentes;
	}
	public Nodo(int grado,int color,int numeroNodo){
		this.grado = grado;
		this.color = color;
		this.numeroNodo = numeroNodo;
	}	
	public int getGrado() {
		return grado;
	}
	public void incrementarGrado(){
		this.grado++;
	}
	public void setGrado(int grado) {
		this.grado = grado;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getNumeroNodo() {
		return numeroNodo;
	}
	public void setNumeroNodo(int numeroNodo) {
		this.numeroNodo = numeroNodo;
	}
}