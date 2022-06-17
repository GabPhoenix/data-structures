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
			ArrayList<Edge<T>> edg = new ArrayList<Edge<T>>();
			for(int i=0; i<this.vertices.size(); i++) {
				edg = vertices.get(i).getEdgesOut();
				System.out.print("["+vertices.get(i).getInfo()+", ");
				for(Edge<T> edge: edg) {
					System.out.print(edge.getEnd().getInfo()+", ");
				}
				System.out.print("]");
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
 	
 	private final boolean hasElement(T element) {
 		if(!this.isEmpty()) {
			for(int i=0; i<this.vertices.size(); i++) {
				if(vertices.get(i).getInfo().equals(element)) {
					return true;
				}
			}
		}
		return false;
 	}
 	
 	public void breadthFirstSearch(T element) {
 		ArrayList<Vertice<T>> m = new ArrayList<Vertice<T>>();
		ArrayList<Vertice<T>> q = new ArrayList<Vertice<T>>(); // simulate a queue
		int distance = 0;
		if(this.hasElement(element)) {
			Vertice<T> current = this.vertices.get(indexOf(element));
			current.setDistance(0);
			m.add(current);
			System.out.println("Element: "+String.valueOf(current.getInfo()));
			// get parent
			ArrayList<T> parents = this.getParents(element);
			System.out.print("Parents: ");
			for(T parent: parents) {
				System.out.print(String.valueOf(parent)+", ");
			}
			System.out.print("\nDistance: "+String.valueOf(distance));
			q.add(current);
			while(q.size()> 0) {
				Vertice<T> visited = q.get(0);
				for(int i=0; i<visited.getEdgesOut().size(); i++) {
					Vertice<T> next = visited.getEdgesOut().get(i).getEnd();
					Vertice<T> predecessor = current;
					if(!m.contains(next)) {
						m.add(next);
						next.setDistance(predecessor.getDistance()+1);
						System.out.println("\nElement:"+String.valueOf(next.getInfo()));
						// get parent
						ArrayList<T> parentsn = this.getParents(next.getInfo());
						System.out.print("Parents: ");
						for(T parent: parentsn) {
							System.out.print(String.valueOf(parent)+", ");
						}
						
						System.out.print("\nDistance: "+String.valueOf(next.getDistance()));
						q.add(next);
						predecessor = next;
					}
					predecessor.setDistance(predecessor.getDistance()+1);
				}
				q.remove(0);				
			}
		} else {
			System.out.println("There is no element '"+element+"'");
		}
	}
 	
 	private final ArrayList<T> getParents(T element){
 		ArrayList<Edge<T>> edg = new ArrayList<Edge<T>>();
 		ArrayList<T> info = new ArrayList<T>();
		for(int i=0; i<this.vertices.size(); i++) {
			if(this.vertices.get(i).getInfo().equals(element)) {
				edg = vertices.get(i).getEdgesIn();
			}
		}
		for(Edge<T> edge: edg) {
			info.add(edge.getStart().getInfo());
		}
		return info;
 	}
			
}