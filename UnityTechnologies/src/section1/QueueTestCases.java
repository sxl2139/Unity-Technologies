package section1;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class QueueTestCases {
	private Queue queue;

	@Before
	public void setUp() {
		queue = new Queue();
	}

	@Test
	public void test() {
		//when queue is empty
		assertEquals(-1, queue.Dequeue());
		assertEquals(0, queue.queueSize);
		
		queue.Enqueue(1);
		
		//Queue (head) 1 (tail)
		assertEquals(1, queue.queueSize);
		
		queue.Enqueue(4);
		
		//Queue (head) 1 4 (tail)
		queue.Enqueue(5);
		
		//Queue (head) 1 4 9 (tail)
		queue.Enqueue(9);
		
		//Queue (head) 1 4 5 9 (tail)
		assertEquals(4, queue.queueSize);
		
		//Queue (head) 1 4 5 9 (tail)
		assertEquals(1, queue.Dequeue());
		
		//Queue (head) 4 5 9 (tail)
		assertEquals(3, queue.queueSize);
		
		assertEquals(4, queue.Dequeue());
		
		//Queue (head) 5 9 (tail)
		assertEquals(5, queue.Dequeue());
		
		//Queue (head) 9 (tail)
		assertEquals(1, queue.queueSize);
		queue.Enqueue(12);
		
		//Queue (head) 9 12 (tail)
		assertEquals(2, queue.queueSize);
		assertEquals(9, queue.Dequeue());
		
		//Queue (head) 12 (tail)
		assertEquals(12, queue.Dequeue());
		
		//Queue Empty
		assertEquals(0, queue.queueSize);
	}
}
