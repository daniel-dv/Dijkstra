package dijkstra;

public class App {
	public static void main(String[] args) {
		GrafoLista grafito = new GrafoLista(5);
		
		grafito.setArista(1, 4,30);
		grafito.setArista(1, 2,10);
		grafito.setArista(1, 5,100);
		grafito.setArista(2, 3,50);
		grafito.setArista(3, 5,10);
		grafito.setArista(4,5,60);
		grafito.setArista(4,3,20);
		System.out.println(grafito);
		
		double [] aux = grafito.dijkstra(1);
		for (double d : aux) {
			System.out.println(d);
		}
	}

}
