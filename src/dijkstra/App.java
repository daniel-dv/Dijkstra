package dijkstra;

public class App {
	public static void main(String[] args) {
		GrafoLista grafito = new GrafoLista(5);
		
		grafito.setArista(0, 3,30);
		grafito.setArista(0, 1,10);
		grafito.setArista(0, 4,100);
		grafito.setArista(1, 2,50);
		grafito.setArista(2, 4,10);
		grafito.setArista(3,4,60);
		grafito.setArista(3,2,20);
		System.out.println(grafito);
		
		double [] aux = grafito.dijkstra(0);
		for (double d : aux) {
			System.out.println(d);
		}
	}

}
