package matriz;

public class MatrizMath{
	
	private int dimensionFil;
	private int dimensionCol;
	private boolean[][] componentes;
	
	public MatrizMath(String path){
	
	}
	
	public MatrizMath(int dimensionFil,int dimensionCol){
		this.dimensionFil = dimensionFil;
		this.dimensionCol = dimensionCol;
		this.componentes = new boolean[dimensionFil][dimensionCol];
	}

	public int getOrden() {
		return dimensionFil;
	}
	
	public boolean getElemento(int i,int j){
		 return componentes[i][j];
	}
	
	public void setElemento(int i,int j,boolean valor){
		this.componentes[i][j]=valor;
	}
}

