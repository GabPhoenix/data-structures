package com.trees.binaries;

public class Tree {
	private Node root;
	private int size = 0;
	
	public Tree() {
		this.root = null;
	}
	
	public void add(int element) {
		Node node = new Node(element);
		if(this.isEmpty()) {
			this.root = node;
			this.size++;
		} else {
			Node temp = this.root;
			while(true) {
				if(element < temp.getInfo()) {
					if(temp.getLeft() != null) {
						temp = temp.getLeft();
					} else {
						temp.setLeft(node);
						this.size++;
						break;
					}
				} else {
					if(temp.getRight() != null) {
						temp = temp.getRight();
					} else {
						temp.setRight(node);
						this.size++;
						break;
					}
				}
			}
		}
	}
	
	public boolean search(Node temp, int info) {
		if(!this.isEmpty()) {
			if(temp != null) {
				if(temp.getInfo() == info) {
					return true;
				} else if(temp.getInfo() > info) {
					return search(temp.getLeft(), info);
				} else if(temp.getInfo() < info) {
					return search(temp.getRight(), info);
				}
			}
		}
		return false;
	}
	
	public int getSize() {
		return this.size++;
	}
	
	public boolean isEmpty(){
		if(this.root == null) {
			return true;
		}
		return false;
	}
	
	public int getHeight() {
		if(!this.isEmpty()) {
			return (int) (Math.log(this.size)/Math.log(2));
		}
		return -1;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	public void preOrder(Node temp) {
		if(this.isEmpty()) {
			System.out.println("The tree is empty!");
			return;
		} else if(temp != null) {
			System.out.print("[" + temp.getInfo() + "]");
			preOrder(temp.getLeft());
			preOrder(temp.getRight());
		}
	}
	
	
	public void inOrder(Node temp) {
		if(this.isEmpty()) {
			System.out.println("The tree is empty!");
			return;
		} else if(temp != null) {
			inOrder(temp.getLeft());
			System.out.print("[" + temp.getInfo() + "]");
			inOrder(temp.getRight());
		}
	}
	
	public void postOrder(Node temp) {
		if(this.isEmpty()) {
			System.out.println("The tree is empty!");
			return;
		} else if(temp != null) {
			postOrder(temp.getLeft());
			postOrder(temp.getRight());
			System.out.print("[" + temp.getInfo() + "]");
		}
	}
	
	
}
