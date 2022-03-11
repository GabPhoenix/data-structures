package com.queues;

public class Test {

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		System.out.println("Length: "+ queue.getSize());
		queue.printQueue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		System.out.println("Length: "+ queue.getSize());
		queue.printQueue();
		queue.dequeue();
		queue.enqueue("n");
		queue.enqueue("y");
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		System.out.println("Length: "+ queue.getSize());
	}

}
