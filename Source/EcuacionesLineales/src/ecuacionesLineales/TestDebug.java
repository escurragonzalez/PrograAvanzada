package ecuacionesLineales;

public class TestDebug {
	
	public static final String FOLDER_ARCH_IN="inpruebas\\";
	public static final String PATH_ARCH_IN = FOLDER_ARCH_IN+"sel.in" ;
	public static final String PATH_ARCH_OUT = "outpruebas\\solucion.out";

	public static void main(String[] args) {
		//VectorMath vector=new VectorMath(PATH_ARCH_IN);
		//System.out.println(vector.toString());
		//System.out.println(); 
		//System.out.println("**************************");
//		System.out.println(vector.sumar(vector.clone()).toString());
//		System.out.println(vector.producto(33).toString());
		
	    Sel prueba = new Sel(PATH_ARCH_IN);
		
	    if (prueba.tieneAtributosIncompletos()) {
			System.out.println("Error - El programa se cerrara");
			return;
		}
	    		
		System.out.println("***RESOLVIENDO SISTEMAS DE ECUACIONES***");
		
		prueba.resolver();
		
		System.out.println("RESUELTO. ESCRIBIENDO ARCHIVO");
		
		prueba.escribirArchivoSalida(PATH_ARCH_OUT);
		
		System.out.println("FIN");

	}	
}
