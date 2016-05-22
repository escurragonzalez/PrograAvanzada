package entradaSalida;  //nombre pack perteneciente


	import java.io.*; //es como el include en C trae bibliotecas de I/O asterisco es comodin(incluir todas las cosas que tenga)

	public class LeerArchivo {
			  public LeerArchivo (String path){
				  File archivo = null;//variable de tipo file (objeto file de la biblio io)
			      FileReader fr = null;//conecta objeto con archivo en FS
			      BufferedReader br = null;//instancia intermedia utilizada para leer

			      try {//manejo de excepciones recomendado para manipulaciones IO
			         // Apertura del fichero y creacion de BufferedReader para poder
			         // hacer una lectura comoda (disponer del metodo readLine()).
			         archivo = new File (path); //construyo variable archivo (instanciacion) objeto que utiliza referencia
			         //llamada a constructor con parametros paso la ruta del archivo a leer(aca poner ruta de archivo a leer-usar \\ o /)
			         //por default toma la carpeta del proyecto
			         fr = new FileReader (archivo);
			         br = new BufferedReader(fr);

			         // Lectura del fichero
			         String linea;
			         while((linea=br.readLine())!=null)//buffereo de la linea - cada linea del archivo, cuando termina da null
			            System.out.println(linea);//impresion de cada linea
			      }
			      catch(Exception e){//error
			         e.printStackTrace();
			      }finally{//esto se hace siempre
			         // En el finally cerramos el fichero, para asegurarnos
			         // que se cierra tanto si todo va bien como si salta 
			         // una excepcion.
			         try{                    
			            if( null != fr ){   
			               fr.close(); //liberacion recursos
			            }                  
			         }catch (Exception e2){ 
			            e2.printStackTrace();
			         }
			      }
  
			  }
				
			  //declaraciones
		      public static void main(String [] arg) {
		    	  LeerArchivo leerArchivo=new LeerArchivo("inpruebas\\h_clinicas.in");
		    	   	  
		    	  
		      		   }
		}


