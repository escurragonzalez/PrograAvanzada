package patronesDeDisenio;

public class HistorialDeAccesos {
	private int linea;
	private String registro;
	//private static HistorialDeAccesos instance = new HistorialDeAccesos();//const privado y variable estatica
	private static HistorialDeAccesos instance;//const privado y variable estatica
	
	
	public static HistorialDeAccesos getInstance(){//getter - clase se levanta por medio de la runtime
													//solucion hacer un if preguntando si se instancio
													//en getinstance:podria tener pull array de instancias
													//instancias limitadas(singleton se extiende)
		if(instance==null)
			instance=new HistorialDeAccesos();
		return instance;//no hay objeto
	}
	
	private HistorialDeAccesos(){
		this.linea=1;
		this.registro="";
	}
	public void registrarEvento(String evento){
		this.registro+=(linea++)+""+evento+"\n";
	}
	
}
