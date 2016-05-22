package entradaSalida;

import java.io.*;

public class LeerEnteros {
	public static void main(String [] arg) {
	int suma=0;
	File f = null;
	FileReader fr = null;
	BufferedReader br =null;
	
	
	try
	{
		f = new File( "inpruebas\\Enteros.in" );
		fr = new FileReader(f);
		br = new BufferedReader(fr);
		String linea;
		
		while((linea=br.readLine())!=null)
					
			suma=suma+Integer.parseInt(linea);//conversion a enteros clase Integer(Clase de envoltura) metodo ParseInt
			//suma=suma+Double.parseDouble(linea);//conversion a enteros calse Integer(Clase de envoltura) metodo ParseInt
			
		System.out.println(suma);
		
	}
	catch(Exception e){
        e.printStackTrace();
	}
    finally //segunda impresion de suma
    {
    System.out.println(suma);	
    }
}
}
	


