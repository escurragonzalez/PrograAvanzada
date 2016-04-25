package ecuacionesLineales;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		VectorMath v1 = new VectorMath(4);
//		VectorMath v2 = new VectorMath(4);
//		VectorMath v3 = new VectorMath(4);
//		float[] componentes1 = {1,1,1,1};
//		float[] componentes2 = {2,-20,2,2};
//		float[] componentes3 = {2,5,8,4};
//		v1.setComponentes(componentes1);
//		v2.setComponentes(componentes2);
//		v3.setComponentes(componentes3);
//		System.out.println(v1.equals(v2));
//		System.out.println(v1.equals(v3));
//		MatrizMath mat1 = new MatrizMath("matriz.in");
//		MatrizMath mat2 = new MatrizMath("matriz2.in");
//		MatrizMath mat4 = new MatrizMath("matriz4.in");
//		//System.out.println(mat1.toString());
//		System.out.println(mat4.toString());
//		System.out.println("**************");
//		System.out.println(mat4.toString());
//--------------------------------------------- PRUEBA PRODUCTO
//		MatrizMath matcuadrada = new MatrizMath("matriz.in");
//		VectorMath vprueba = new VectorMath(3);
//		float[] componentesvec = {1,2,1};
//		vprueba.setComponentes(componentesvec);
//		
//		System.out.println(vprueba.toString());
//		System.out.println(matcuadrada.toString());
//		
//		System.out.println(matcuadrada.producto(vprueba));
		/*Sel prueba = new Sel();
		
		System.out.println("SIN RESOLVER:");
		System.out.println(prueba.toString());
		
		prueba.resolver();
		
		System.out.println("RESUELTO:");
		System.out.println(prueba.toString());*/
		
		Probador prueba = new Probador();
	
		System.out.println("EL OUTPUT ES CORRECTO: " + prueba.probarSel());
		
	}

}
