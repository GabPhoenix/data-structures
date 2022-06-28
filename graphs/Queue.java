package com.graphs;

public class Queue<T> {
	public Node<T> start =  null, end;
	public int size = 0;
	
	public Queue() {
		
	}
	
	public Queue(Node<T> node) {
		this.end = node;
	}
	
	public void enqueue(T element) {
		Node<T> node = new Node<T>(element);
		if(this.isEmpty()) {
			this.start = node;
			this.end = node;
		} else {
			this.end.setNext(node);
			this.end = node;
		}
		this.size++;
	}
	
	public void dequeue() {
		if(this.isEmpty()) {
			System.out.println("The queue is already empty!");
			return;
		} 
		this.start = this.start.getNext();
		this.size--;
	}
	
	
	public boolean isEmpty() {
		if(this.start == null) {
			return true;
		}
		return false;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void printQueue() {
		if(this.isEmpty()) {
			System.out.println("The queue is empty!");
			return;
		}
		Node<T> temp = this.start;
		for(int i=0; i<this.size; i++) {
			System.out.print("[" + temp.getInfo() + "]");
			temp = temp.getNext();
		}
		System.out.println("");
	}
	
}
