package com.graphs;

import java.util.ArrayList;

public class Vertice<T> {
	private T info;
	private ArrayList<Edge<T>> edgesIn;
	private ArrayList<Edge<T>> edgesOut;
	
	public Vertice(T info) {
		this.info = info;
		this.edgesIn = new ArrayList<Edge<T>>();
		this.edgesOut =  new ArrayList<Edge<T>>();
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	public final void appendEdgesIn(Edge<T> edge) {
		this.edgesIn.add(edge);
	}
	
	public final void appendEdgesOut(Edge<T> edge) {
		this.edgesOut.add(edge);
	}

	public ArrayList<Edge<T>> getEdgesIn() {
		return edgesIn;
	}

	public void setEdgesIn(ArrayList<Edge<T>> edgesIn) {
		this.edgesIn = edgesIn;
	}

	public ArrayList<Edge<T>> getEdgesOut() {
		return edgesOut;
	}

	public void setEdgesOut(ArrayList<Edge<T>> edgesOut) {
		this.edgesOut = edgesOut;
	}
	
	
	
}
