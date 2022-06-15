package com.graphs;

import java.util.ArrayList;

public class Graph<T> {
	private ArrayList<Vertice<T>> vertices;
	private ArrayList<Edge<T>> edges;
	
	public Graph() {
		this.vertices = new ArrayList<Vertice<T>>();
		this.edges = new ArrayList<Edge<T>>();
	}
	
	public void appendVertice(T info) {
		Vertice<T> v = new Vertice<T>(info); 
		this.vertices.add(v);
	}
	
	public Vertice<T> getVertice(T info){
		Vertice<T> v = null;
		for(int i=0; i<this.vertices.size(); i++) {
			if(this.vertices.get(i).getInfo().equals(info)) {
				v = this.vertices.get(i);
			}
		}
		return v;
	}
	
	// "conecta method" ==> 
	public void connect(Double weight, T start, T end) {
		Vertice<T> verticeStart = this.getVertice(start);
		Vertice<T> verticeEnd = this.getVertice(end);
		Edge<T> edge = new Edge<T>(weight, verticeStart, verticeEnd);
		// append out way start -> end 
		verticeStart.appendEdgesOut(edge);
		
		// append in way end <- start
		verticeEnd.appendEdgesIn(edge);
		this.edges.add(edge);
	}
	
	public boolean isEmpty() {
		if(this.vertices.size()>0) {
			return false;
		}
		return true;
	}
	
	// "imprime method" ==> 
 	public void print() {
		if(!this.isEmpty()) {
			for(int i=0; i<this.vertices.size(); i++) {
				System.out.print(vertices.get(i).getInfo()+", ");
			}
			System.out.println("");
			return;
		}
		System.out.println("The graph is empty");
	}
 	
 	private int indexOf(T element) {
		if(!this.isEmpty()) {
			for(int i=0; i<this.vertices.size(); i++) {
				if(vertices.get(i).getInfo().equals(element)) {
					return i;
				}
			}
		}
		return -1;
	}
 	
 	public void breadthFirstSearch(T element) {
 		ArrayList<Vertice<T>> m = new ArrayList<Vertice<T>>();
		ArrayList<Vertice<T>> q = new ArrayList<Vertice<T>>(); // simulate a queue
		Vertice<T> current = this.vertices.get(indexOf(element));
		m.add(current);
		System.out.println(String.valueOf(current.getInfo()));
		q.add(current);
		while(q.size()> 0) {
			Vertice<T> visited = q.get(0);
			for(int i=0; i<visited.getEdgesOut().size(); i++) {
				Vertice<T> next = visited.getEdgesOut().get(i).getEnd();
				if(!m.contains(next)) {
					m.add(next);
					System.out.println(String.valueOf(next.getInfo()));
					q.add(next);
				}
			}
			q.remove(0);
		}
	}
			
}