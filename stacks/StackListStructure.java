package com.stacks;

public class StackListStructure {
	Node top;
	int size = 0;

	public StackListStructure() {
		
	}
	
	public StackListStructure(Node NewTop) {
		this.top = NewTop;
	}
	
	public void push(String element) {
		if(this.isEmpty()) {
			Node node = new Node(element);
			node.setNext(null);
			this.top = node;
			this.size++;
		} else {
			Node node = new Node(element);
			node.setNext(top);
			this.top = node;
			this.size++;
		}
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if(this.top == null) {
			return true;
		}
		return false;
	}
	
	public void pop() {
		
	}
	
	public void printStack() {
		if(this.isEmpty()){
			System.out.println("The Stack is empty!");
		}
		Node temp = this.top;
		for(int i=0; i<this.size; i++) {
			System.out.print("[");
			System.out.print(temp.getInfo());
			System.out.print("]");
			temp = temp.getNext();
		}
		System.out.println("");
	}
	
	
}
