package com.stacks;

public class Node {
	private String info;
	private Node next;
	
	public Node(String info) {
		this.info = info;
	}

	public Node(String info, Node next) {
		this.info = info;
		this.next = next;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
