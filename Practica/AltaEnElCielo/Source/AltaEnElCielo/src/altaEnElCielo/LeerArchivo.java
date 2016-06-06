package altaEnElCielo;  //nombre pack perteneciente


	import java.awt.List;
import java.io.*; //es como el include en C trae bibliotecas de I/O asterisco es comodin(incluir todas las cosas que tenga)
import java.util.ArrayList;

	public class LeerArchivo {
		private Integer cantidadEscuelas=0;
        private Integer metrosSobrantes=0;
        private Integer[] valoresCalculados=null;
		private Integer metrosRepartidos=0;
        
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
			         
			         linea=br.readLine();
			         if(linea!= null){
			         	cantidadEscuelas = Integer.parseInt(linea.split(" ")[1]);
			         	metrosSobrantes = Integer.parseInt(linea.split(" ")[0]);
			         	valoresCalculados=new Integer[cantidadEscuelas];
			         }
			         			         
			         for (int i = 0; i < cantidadEscuelas; i++) {
			        	linea=br.readLine(); 
						//System.out.print(linea+"\t");
						valoresCalculados[i]=Integer.parseInt(linea);
						metrosSobrantes -= valoresCalculados[i];
			         }
			         //System.out.print("\n");
			         
			         while(metrosSobrantes>-100000){
			        	 for (int i = 0; i < cantidadEscuelas; i++) {
			        		 	System.out.print(valoresCalculados[i]+"\t");
			        		 	
			        	 }
			        	 System.out.print("\n");
			        	 calcularValoresCalculadosQuitarSobrante();
			         }
			         
			         
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

			private void calcularValoresCalculadosQuitarSobrante() {
				for (int i = 0; i < this.valoresCalculados.length; i++) {
					this.valoresCalculados[i]=numeroMasSumaCifras(this.valoresCalculados[i]);
					metrosSobrantes -= valoresCalculados[i];
				}
			}

			private Integer numeroMasSumaCifras(Integer integer) {
				return integer+valorSumaCifras(integer);
			}

			private Integer valorSumaCifras(Integer integer) {
				if(integer<10)
					return integer;
				return (integer%10)+valorSumaCifras(integer/10);
			}
				
			  //declaraciones
		      
		}


