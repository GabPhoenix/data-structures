package com.stacks;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		/* Test Cases
		StackListStructure stack = new StackListStructure();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.printStack();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.printStack();
		stack.pop();
		stack.push("y");
		stack.push("n");
		stack.printStack();
		System.out.println("Length: " + stack.getSize()); */
		
		// scanner
		Scanner sc = new Scanner(System.in);
		
		StackListStructure stack = new StackListStructure();
		
		System.out.println("Inform a string: ");
		String string = sc.nextLine();
		
		for(int i=0; i<string.length(); i++) {
			char c = string.charAt(i);
			if(c == '(') {
				stack.push(String.valueOf(c));
			} else if(c == ')') {
				if(stack.isEmpty()) {
					System.out.println("Uncaught error at [)]");
					System.exit(c);
				} else {
					stack.pop();
				}
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("Ok");
			System.exit(0);
		} else {
			System.out.print("Uncaught error at ");
			stack.printStack();
		}
		
		try {
			sc.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
