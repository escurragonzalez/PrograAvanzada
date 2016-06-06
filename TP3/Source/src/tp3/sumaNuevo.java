package tp3;


import org.junit.Assert;
import org.junit.Test;

public class sumaNuevo {

	@Test
	public void suma() {
		Operando tres = new Constante(3);
		Constante dos = new Constante(2);
		//dos.setValor(22);		
		Suma suma = new Suma(tres,dos);
		
		Assert.assertEquals(5, suma.resolver(),3);
		
		VariableX x = VariableX.getInstance();
		x.setValor(20);
		System.out.println(x.resolver());;
		
		VariableY y = VariableY.getInstance();
		y.setValor(30);
		System.out.println(y.resolver());;
		
		VariableZ z = VariableZ.getInstance();
		z.setValor(60);
		System.out.println(z.resolver());;
		
		Suma suma2 = new Suma(x,y);
		Assert.assertEquals(50, suma2.resolver(),3);
		
		Suma suma3=new Suma(suma2,z);
		Assert.assertEquals(110, suma3.resolver(),3);
		
		}

}
