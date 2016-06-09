package altaEnElCielo;  //nombre pack perteneciente


	
	import java.io.*; //es como el include en C trae bibliotecas de I/O asterisco es comodin(incluir todas las cosas que tenga)

	public class LeerArchivo {
		private Integer cantidadEscuelas=0;
        private Integer metrosTotales=0;
        private Integer[] valoresCalculados=null;
        private Integer[] valoresTotales=null;
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
			         metrosRepartidos=0;
			         Integer metrosTotal=0;
			         
			         linea=br.readLine();
			         if(linea!= null){
			         	cantidadEscuelas = Integer.parseInt(linea.split(" ")[1]);
			         	metrosTotales = Integer.parseInt(linea.split(" ")[0]);
			         	valoresCalculados=new Integer[cantidadEscuelas];
			         	valoresTotales=new Integer[cantidadEscuelas];
			         }
			         
			         Integer metrosASumar=null;
			         mostrarNumerosCorrelativosHasta(cantidadEscuelas);
			         
			         for (int i = 0; i < cantidadEscuelas ; i++) {
			        	linea=br.readLine(); 
						//System.out.print(linea+"\t");
			        	metrosASumar=Integer.parseInt(linea);			        	
			        	valoresCalculados[i]=metrosASumar;
			        	valoresTotales[i]=metrosASumar;
			        	metrosRepartidos+=metrosASumar;
			        	
			        	calcularValorPosicionIndividual(i);
						
			         }
			         
			         mostrarVectorTotales();
			         mostrarVectorCalculados();
			         metrosTotal+=metrosRepartidos;
			         //calcularValoresCalculadosQuitarSobrante();
			         
			        boolean procesar=true;
					while (procesar) {
						procesar=false;
						
						
						for (int i = 0; i < valoresCalculados.length ; i++) {
							metrosASumar=this.valoresCalculados[i];
							
							if((metrosTotal+metrosASumar) <= metrosTotales){
								this.valoresTotales[i]+=metrosASumar;
								metrosTotal+=metrosASumar;
								calcularValorPosicionIndividual(i);
								
								procesar=true;
							}
							//if(i==99)
							System.out.print(i+"-"+metrosTotal+"-"+metrosASumar+"\t");
						}
						System.out.println("");
						//mostrarVectorTotales();
						mostrarVectorCalculados();
						
						
					}
					
					System.out.println("***END***");
			         
			         
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

			private void mostrarVectorCalculados() {
				for (int i = 0; i < valoresCalculados.length; i++) {
					System.out.print(this.valoresCalculados[i]+"\t");
					
				}
				System.out.print("\n");
			}

			private void calcularValorPosicionIndividual(int i) {
				this.valoresCalculados[i]=numeroMasSumaCifras(this.valoresCalculados[i]);
				
			}

			private void mostrarNumerosCorrelativosHasta(Integer cantidadEscuelas2) {
				for (int i = 0; i < cantidadEscuelas2; i++) {
					System.out.print(i+1+"\t");
					
				}
				System.out.print("\n");
				
			}

			private void mostrarVectorTotales() {
				for (int i = 0; i < valoresTotales.length; i++) {
					System.out.print(this.valoresTotales[i]+"\t");
					
				}
				System.out.print("\n");
				
			}

			private void recorrerCalculadosActualizandoTotales(Integer cantidadEscuelas2) {
				for (int i = 0; i < cantidadEscuelas; i++) {
					this.valoresTotales[i]+=this.valoresCalculados[i];
				}
				
			}

			private void calcularValoresCalculadosQuitarSobrante() {
				for (int i = 0; i < this.valoresCalculados.length; i++) {
					calcularValorPosicionIndividual(i);
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


