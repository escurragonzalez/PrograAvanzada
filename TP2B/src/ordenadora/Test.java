package ordenadora;

public class Test {

	public static void main(String[] args) {
		
		double vector[] = new double[]{4,2,1,3};
		Ordenadora vec;
		
		vec = new Ordenadora (vector);
		vec.QuickSort(vec, 0, (vec.vector.length-1));
		System.out.println("");

	}

}
