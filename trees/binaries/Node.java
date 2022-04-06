package com.trees.binaries;

public class Node {
	private int info;
	private Node left, right;
	
	public Node() {
		
	}
	
	public Node(int info) {
		this.info = info;
		this.left = null;
		this.right = null;
	}

	public int getInfo(){
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	
	
}
