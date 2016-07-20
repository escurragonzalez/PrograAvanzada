package test;

import org.junit.Assert;
import org.junit.Test;

import tp3.Constante;
import tp3.Expresion;
import tp3.Operando;
import tp3.Resta;
import tp3.Suma;
import tp3.VariableX;
import tp3.VariableY;
import tp3.VariableZ;

public class UnitTest {
	
	@Test	
	public void sumaDosConstantes() {
		Operando tres = new Constante(3);
		Constante dos = new Constante(2);
		Suma suma = new Suma(tres,dos);
		Assert.assertEquals(5.0, suma.resolver(),0);
	}
	
	@Test	
	public void sumaConstanteVariableX() {
		VariableX x = VariableX.getInstance();
		Operando tres = new Constante(3);
		x.setValor(20);
		Suma s= new Suma(x,tres);
		Assert.assertEquals(23.0,s.resolver(),0);
	}
	
	@Test	
	public void sumaConstanteVariabley() {
		VariableY y = VariableY.getInstance();
		Operando op = new Constante(12);
		y.setValor(30);
		Assert.assertEquals(42.0,new Suma(y,op).resolver(),0);
	
	}
	@Test	
	public void restaConstanteVariableZ() {
		VariableZ z = VariableZ.getInstance();
		z.setValor(60);
		Operando op = new Constante(4);
		Assert.assertEquals(-56.0, new Resta(z,op).resolver(),0);	
	}
	
	@Test
	public void resolverExpresionConUnaResta() {	
		String linea="2 9 -";
		Expresion ex=new Expresion(linea);
		Assert.assertEquals(-7,ex.resolver(),0);
	}
	
	@Test
	public void resolverExpresionConUnaSuma() {	
		String linea="4 4 +";
		Expresion ex=new Expresion(linea);
		Assert.assertEquals(8,ex.resolver(),0);
	}
	
	@Test
	public void resolverExpresionConUnProducto() {	
		String linea="4 9 *";
		Expresion ex=new Expresion(linea);
		Assert.assertEquals(36,ex.resolver(),0);
	}
	
	@Test
	public void resolverExpresionConUnCociente() {	
		String linea="24 2 /";
		Expresion ex=new Expresion(linea);
		Assert.assertEquals(12,ex.resolver(),0);
	}
	
	@Test
	public void resolverExpresionPotencia() {	
		String linea="2 4 ^";
		Expresion ex=new Expresion(linea);
		Assert.assertEquals(16,ex.resolver(),0);
	}
	
	@Test
	public void resolverExpresionLogaritmo() {	
		String linea="2.89 ln";
		Expresion ex=new Expresion(linea);
		Assert.assertEquals(1,ex.resolver(),0.1);
	}
	
	@Test
	public void resolverExpresionLogaritmo2() {	
		String linea="15 ln";
		Expresion ex=new Expresion(linea);
		Assert.assertEquals(2.71,ex.resolver(),0.1);
	}
	
	@Test
	public void resolverExpresion() {	
		String linea="5 1 2 + 4 * + 3 -";
		Expresion ex=new Expresion(linea);
		Assert.assertEquals(14,ex.resolver(),0);
	}
	
	
}

