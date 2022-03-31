package com.trees.binaries;

public class Tree {
	private Node root;
	private int size = 0;
	
	public Tree() {
		this.root = null;
	}
	
	// insert
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
	
	// search
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
	
	// get max value
	public int getMax(Node temp) {
		if(!this.isEmpty()) {
			if(temp!=null) {
				if(temp.getRight() == null) {
					return temp.getInfo();
				} else{
					return getMax(temp.getRight());
				}
			}
		}
		return -1;
	}
	
	// get min value
	public int getMin(Node temp) {
		if(!this.isEmpty()) {
			if(temp!=null) {
				if(temp.getLeft() == null) {
					return temp.getInfo();
				} else{
					return getMin(temp.getLeft());
				}
			}
		}
		return -1;
	}
	
	// get size
	public int getSize() {
		return this.size++;
	}
	
	// verify if 'tree' is empty
	public boolean isEmpty(){
		if(this.root == null) {
			return true;
		}
		return false;
	}
	
	// get height
	public int getHeight() {
		if(!this.isEmpty()) {
			return (int) (Math.log(this.size)/Math.log(2));
		}
		return -1;
	}
	
	// get root
	public Node getRoot() {
		return this.root;
	}
	
	// print in pre order
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
	
	// print in order
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
	
	// print in post order
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
