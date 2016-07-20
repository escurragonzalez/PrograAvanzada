package ar.unlam.cmc;

public class Prueba {

	public static void main(String[] args) {

		String pathArchivo = "caso00_enunciado";
		CambioDeManoCalles camino = new CambioDeManoCalles();
		camino.leerArchivo("INProfesor\\" + pathArchivo + ".in");

		camino.resolverCambiandoCalles();

		if (camino.getDistanciaAlColeCambiandoCalles() < camino.getDistanciaAlColeSinCambiarCalles()) {
			camino.buscarDiferenciasRecorridos();
		} else {
			System.out.println("***NO SE CAMBIO NINGUNA CALLE***");
		}
		camino.escribirArchivo("OUTProfesor\\" + pathArchivo + ".out");

	}

}
