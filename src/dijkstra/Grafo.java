package dijkstra;

import java.util.Set;
import java.util.HashSet;

public abstract class Grafo {
	
	
	public abstract int getNodos();
	public abstract void setArista (int desde, int hasta, double costo);
	public abstract Double getArista (int desde, int hasta);
	
	
	public double [] dijkstra (int desde) {
		double [] distancias = new double[getNodos()];
		distancias[desde] = 0;
		
		Set<Integer> s = new HashSet<Integer>();
		
		s.add(desde);
		
		Set <Integer> vMenosS= new HashSet<Integer>();
		
		
		
		
		return distancias;
	}
	
}
