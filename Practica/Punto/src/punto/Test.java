package punto;

public class Test {	
	public static void main(String[] args) {
		Punto2D p2D = new Punto2D(2,1);
		Punto3D p3D = new Punto3D(0,0,1);
		Punto3D a3D = null;
		Punto3D b3D = null;
		Punto2D pLoco;
		pLoco=new Punto2D(3,4);
		pLoco=p3D;
		//p2D=p3D;
		
		System.out.println("debe mostrar 0.0 0.0 1.0 : "+pLoco);
		Punto3D d1 = new Punto3D(0,0,1);
		Punto3D d2 = new Punto3D(0,0,-1);
		System.out.println("debe mostrar 2.0 1.0 : "+p2D);
		System.out.println("debe mostrar 0.0 0.0 1.0 : "+p3D);
		System.out.println(pLoco.equals(p3D));//true
		System.out.println(p3D.equals(p2D));// false
		System.out.println(p2D.equals(a3D));//false
		System.out.println(p3D.equals(a3D));//false
		
		a3D = new Punto3D(0,0,0);
		System.out.println(p2D.equals(a3D));//false
		System.out.println(a3D.equals(p2D));//false
		System.out.println(a3D.equals(p3D));//false
		b3D = new Punto3D(0,0,1);
		System.out.println(p3D.equals(b3D));//true
		System.out.println(b3D.equals(p3D));//true
		System.out.println(b3D.modulo());// 1.0
		System.out.println(d2.distancia(d1));//2.0
		Punto3D p3=new Punto3D(2,2,2);
		Punto3D p2=new Punto3D(1,1,1);		
		
		//p3.desplazamiento(p2);
		System.out.println("debe mostrar 3 3 3 : "+ p3.desplazamiento(p2));
		
		Punto2D [] vec = new Punto2D [4];
		for (int i=0;i<4;i++)
		{vec[i]=new Punto3D(1,1,1);
		}
		vec[2]=p2D;
		
		for (int i=0;i<4;i++)
		{
			if(i==2)
				System.out.println("debe mostrar vec 2.0 1.0 : "+ vec[i]);
			else
				System.out.println("debe mostrar vec 1 1 1 : "+ vec[i]);
		}	
	}
}
