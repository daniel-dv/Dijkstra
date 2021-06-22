package dijkstra;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class GrafoLista extends Grafo {
	
	private List<List<Nodo>> grafo;
	
	public GrafoLista(int tamano) {
		this.grafo = new LinkedList <List<Nodo>>();
		for (int i=0; i<tamano; i++) {
			this.grafo.add(new LinkedList <Nodo>());
		}
		
		//Los nodos son siempre consecutivos.
	}
	
	@Override
	public int getNodos() {
		return this.grafo.size();
	}

	@Override
	public void setArista(int desde, int hasta, double costo) {
		this.grafo.get(desde-1).add(new Nodo(hasta-1, costo));
		this.grafo.get(desde-1).sort(null);
	}

	@Override
	public Double getArista(int desde, int hasta) {
		for (Nodo actual : this.grafo.get(desde)) {
			if (actual.getId()==hasta)
				return actual.getPeso();
		}
		return null;
	}
	
	@Override
	public String toString() {
		String sal="";
		for (List<Nodo> set : grafo) {
			sal+=set;
		}
		return sal;
	}
	
	
	public double [] dijkstra (int desde) {
		desde--;
		double [] distancias = new double[getNodos()];
		int [] predecesores = new int [getNodos()];
		
		
		Set<Integer> s = new HashSet<Integer>();
		
		s.add(desde);
		
		Set <Integer> vMenosS= new HashSet<Integer>();
		
		for (int i=0; i< this.getNodos() ; i++) {
			if (desde!=i)
				vMenosS.add(i);
		}
		for (int i=0; i<distancias.length ; i++) {
			distancias[i]=Double.MAX_VALUE;
		}
		distancias[desde] = 0;

		
		for (Nodo nodo : this.grafo.get(desde)) {
			distancias[nodo.getId()] = nodo.getPeso();
		}
		
		for (int i = 0; i < predecesores.length; i++) {
			predecesores[i] = desde+1;
		}
		
		while(!vMenosS.isEmpty()) {
			boolean bandera=false;
			double min=0;
			int w = 0;
			for (Integer integer : vMenosS) {
				if (!bandera) {
					min=distancias[integer];
					w=integer;

					bandera=true;
				}
				else {
					if (distancias[integer] < min) {
						min=distancias[integer];
						w=integer;
						
					}
				}
					
			}
			//ya calcule el minimo
			vMenosS.remove(w);
			s.add(w);
			
			for(Nodo nodo : this.grafo.get(w)) {
				if (distancias[nodo.getId()]>distancias[w] + nodo.getPeso()) {
					distancias[nodo.getId()]=distancias[w] + nodo.getPeso();
					predecesores[nodo.getId()] =w+1;
				}
			}
			
		}
		for (int i=0; i<predecesores.length; i++) {
			System.out.println(i + ": " + (predecesores[i]));
		}
		return distancias;
	}
}
