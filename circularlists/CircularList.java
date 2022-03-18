package com.circularlists;

public class CircularList {
	private Node ref, first;
	private int size;
	private int aux1;
	
	public CircularList() {
		
	}
	
	public CircularList(Node newRef) {
		this.ref = newRef;
		this.size = 0;
		this.aux1 = 0;
		this.first = null;
	}
	
	// get size
	public int getSize() {
		return this.size;
	}
	
	// inserts
	private void insert(int element) {
		Node node = new Node(element);
		node.setNext(node);
		this.ref = node;
		this.first = node;
		this.size++;
	}
	
	public void sortInsert(int element) {
		if(this.isEmpty()) {
			insert(element);
			return;
		} else {
			// first position
			if(element <= this.first.getInfo()) {
				Node node = new Node(element);
				node.setNext(this.first);
				this.first = node;
				this.ref.setNext(node);
				this.size++;
				return;
			} else {
				Node bef = this.first, p = this.first.getNext();
				while(p != this.first && element > p.getInfo() && this.aux1 < this.size+1) {
					bef = p;
					p = p.getNext();
					this.aux1 += 1;
				}
				this.aux1 = 0;
				Node temp = new Node(element);
				bef.setNext(temp);
				temp.setNext(p);
				if(temp.getNext() == this.first) {
					this.ref = temp;
				} else if(p.getNext() == this.first) {
					this.ref = p;
//					this.ref = first;
				}
				this.size++;
				return;
			}
		}
	}
	
	// empty
	public boolean isEmpty() {
		if(this.ref == null) {
			return true;
		}
		return false;
	}
	
	
	// remove
	public void remove(int element) {
		Node bef = this.first;
		Node p = this.first.getNext();
		for(int aux = 0; aux < this.size +1; aux++) {
			if(element > bef.getNext().getInfo()) {
				System.out.println("element ("+ element +") Not founded!");
				return;
			}
			if(p.getInfo() == element) {
				if(p == this.first) { // remove first position
					this.first = p.getNext();
					bef.setNext(this.first);
					this.size--;
					reset();
					return;
				} else {
					bef.setNext(p.getNext()); // middle position
					this.size--;
					reset();
					return;
				}
			}
			bef = p;
			p = p.getNext();
		}
		System.out.println("element ("+ element +") Not founded!");
	}

	private void reset() {
		if(this.size == 0) {
			this.ref = null;
		}
	}
	
	// print
	public void printCircularList() {
		if(this.isEmpty()) {
			System.out.println("The list is empty!");
			return;
		} 
		Node p = this.first;
		for(int i=0; i<this.size; i++) {
			System.out.print("[");
			System.out.print(p.getInfo() + "");
			System.out.print("]");
			p = p.getNext();
		}
		System.out.println("");
		return;
	}
	
}
