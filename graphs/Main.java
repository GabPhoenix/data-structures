package com.graphs;

public class Main {

	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<Integer>();
		graph.appendVertice(1);
		graph.appendVertice(2);
		graph.appendVertice(3);
		graph.appendVertice(4);
		graph.appendVertice(5);
		graph.appendVertice(6);
		graph.appendVertice(7);
		graph.appendVertice(8);
		
		graph.connect(1.0, 1, 2);
		graph.connect(2.0, 1, 3);
		graph.connect(3.0, 1, 4);
		graph.connect(1.0, 2, 1);
		graph.connect(3.0, 3, 1);
		graph.connect(2.0, 3, 5);
		graph.connect(3.0, 2, 5);
		graph.connect(1.0, 5, 2);
		graph.connect(1.0, 6, 5);
		graph.connect(2.0, 6, 7);
		graph.connect(1.0, 6, 8);
		graph.connect(3.0, 7, 6);
		graph.connect(1.0, 8, 6);
	 
		graph.print();
		
		graph.breadthFirstSearch(1);
	}

}
