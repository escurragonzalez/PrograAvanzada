package tp3;

import java.io.File;

public class Test {

	public static void main(String[] args) {

		Expresion expresion=null;
		
		try {
			File folder = new File("inpruebas\\");
			File[] allFiles = folder.listFiles();

			for (File file : allFiles) {
				System.out.println(file.getName());
				LecturaArchivo lecturaArchivo=new LecturaArchivo(file.getPath());
				expresion=new Expresion(lecturaArchivo.getExpresion());
				EscrituraArchivo escrituraArchivo=new EscrituraArchivo();
				escrituraArchivo.setCantidadValoresSalida(lecturaArchivo.getCantidadPuntos());
				
				for (int i = 0; i < lecturaArchivo.getCantidadPuntos(); i++) {
					Double[] vectorValoresPunto=lecturaArchivo.getPuntos()[i];
					asignarValoresXYZ(vectorValoresPunto);
					
					escrituraArchivo.getValoresSalida()[i]=expresion.resolver();
					
				}
				
				escrituraArchivo.escribirArchivoSalida("outpruebas\\"+cambiarExtensionArchivoEntrada(file));
				
				
			}	
		} catch (Exception e){
			e.printStackTrace();
		}
			
	
	}

	private static String cambiarExtensionArchivoEntrada(File file) {
		String fileName = file.getName();
		String[] tokens = fileName.split("\\.(?=[^\\.]+$)");
		fileName = tokens[0]+".out";
		return fileName;
	}

	private static void asignarValoresXYZ(Double[] vectorValoresPunto) {
		VariableX.getInstance().setValor(vectorValoresPunto[0]);
		if(vectorValoresPunto.length>1){
			VariableY.getInstance().setValor(vectorValoresPunto[1]);
			if(vectorValoresPunto.length>2){
				VariableZ.getInstance().setValor(vectorValoresPunto[2]);
			}
		}
	}

}
