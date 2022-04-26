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
	public Node search(Node temp, int info) throws NullPointerException{
		if(!this.isEmpty()) {
			if(temp != null) {
				if(temp.getInfo() == info) {
					return temp;
				} else if(temp.getInfo() > info) {
					return search(temp.getLeft(), info);
				} else if(temp.getInfo() < info) {
					return search(temp.getRight(), info);
				}
			}
		}
		return null;
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
	public Node getMin(Node temp) {
		if(!this.isEmpty()) {
			if(temp!=null) {
				if(temp.getLeft() == null) {
					return temp;
				} else{
					return getMin(temp.getLeft());
				}
			}
		}
		return null;
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
	public int getHeight(Node temp) {
		if(!this.isEmpty()) {
			if(temp!=null) {
				// verifying witch side is greater 
				int left = getHeight(temp.getLeft()) + 1;
				int right = getHeight(temp.getRight()) + 1;
				if(left>right) {
					return left;
				}
				else {
					return right;
				}
			}
		}
		return -1;
	}
	
	// get root
	public Node getRoot() {
		return this.root;
	}
	
	//get next 
	public Node getNext(Node temp, int info) throws NullPointerException{
		Node current = this.search(temp, info);
		if(current != null) {
			// if has right node ->
			if(current.getRight() != null){
				return this.getMin(current.getRight());
			} else { // if hasn't right node
				Node next = null, predecessor = this.root;
				while(predecessor != current) {
					if(current.getInfo()<predecessor.getInfo()) {
						next = predecessor;
						predecessor = predecessor.getLeft();
					} else {
						predecessor = predecessor.getRight();
					}
				}
				return next;
			}
		}
		return null;
	}
	
	private boolean isLeaf(Node temp) {
		if(temp.getLeft() == null && temp.getRight() == null && temp!=this.root) {
			return true;
		}
		return false;
	}
	
	protected Node getParent(Node temp, int info) {
		Node current = this.search(temp, info);
		if(current!=null) {
			Node parent = this.root;
			if(current.equals(this.root)) {
				return null;
			}
			while(true) {
				if(parent.getLeft().equals(current) || parent.getRight().equals(current)) {
					break;
				} else if(current.getInfo()<parent.getInfo()) {
					parent = parent.getLeft();
				} else {
					parent = parent.getRight();
				}
			}
			return parent;
		}
		return null;
	}
	
	protected boolean remove(Node temp, int info) throws NullPointerException{
		Node current = this.search(temp, info);
		if(current!=null) {
			Node parent = this.getParent(current, current.getInfo());
			// CASE -> IS LEAF ->
			if(this.isLeaf(current)) {
				// if is leaf, verify if is on left/right side
				if(parent.getLeft().equals(current)) {
					parent.setLeft(null);
				} else {
					parent.setRight(null);
				}
			// CASE -> ONE CHILD ->
			} else if(current.getLeft()!=null && current.getRight() == null) { 
				// left side is not null
				if(parent.getLeft().equals(current)) {
					parent.setLeft(current.getLeft());
				} else {
					parent.setRight(current.getLeft());
				}
			} else if(current.getLeft() == null && current.getRight() != null) {
				// right side is not null
				if(parent.getLeft().equals(current)) {
					parent.setLeft(current.getRight());
				} else {
					parent.setRight(current.getRight());
				}
			}
			// CASE -> TWO CHILDREN ->
			else if(current.getLeft() != null && current.getRight() != null) {
				Node suc = this.getNext(current, current.getInfo());
				Node parent_suc = this.getParent(suc, suc.getInfo());
				current.setInfo(suc.getInfo());
				if(parent_suc.getLeft().equals(suc)) {
					if(suc.getLeft()!=null) {
						parent_suc.setLeft(suc.getLeft());
					} else{ 
						parent_suc.setLeft(suc.getRight());
					}
				} else {
					if(suc.getLeft()!=null) {
						parent_suc.setRight(suc.getLeft());
					} else{ 
						parent_suc.setRight(suc.getRight());
					}
				}
				return true;
			}
		}
		return false;
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
