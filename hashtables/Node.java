package com.hashtables;

public class Node {
	private String info, description;
	private Node prox;
	
	public Node(String info, String description) {
		this.info = info;
		this.description = description;
		this.prox = null;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Node getProx() {
		return prox;
	}

	public void setProx(Node prox) {
		this.prox = prox;
	}
	
	
	
}
