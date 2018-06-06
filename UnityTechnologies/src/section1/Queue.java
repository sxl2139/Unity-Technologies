package section1;

import java.util.Stack;

public class Queue {
	/*stack1 holds elements in the form of queue*/
	Stack<Integer> stack1;
	/*used to maintain queue size*/
	int queueSize = 0;
    public Queue() {
        stack1 = new Stack<Integer>();
    }
    
    /*inserts new node at the tail of queue
     * @Parameters: x -> input integer
     * Output -> void
     * Time Complexity: O(2n) => O (n) where n is the size of queue*/
    public void Enqueue(int x) {
    		/*stack2 is used as a helper to maintain head of the queue at the top of stack1*/
        Stack<Integer> stack2 = new Stack<Integer>();
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        /*maintain head of the queue at the top of stack1*/
        stack1.push(x);
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        if(!stack1.isEmpty()) {
        		/*increase size of the queue*/
        		queueSize++;
        }
    }
    
    /*removes and returns the head of queue
     * @Parameters: x -> input integer
     * Output -> void
     * Time Complexity: O(1) => since we just remove the head of queue from top of the stack*/
    public int Dequeue() {
    		/*returns head of the queue*/
	    	if(!stack1.isEmpty()) {
	    		/*decrease size of the queue*/
	    		queueSize--;
	    }else {
	    		return -1;
	    }
        return stack1.pop();
    }
    
    public boolean empty() {
    		/*checks if queue is empty*/
        return stack1.isEmpty();
    }
}
