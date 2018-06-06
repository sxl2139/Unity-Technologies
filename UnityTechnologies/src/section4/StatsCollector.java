package section4;
import java.util.Comparator;
import java.util.PriorityQueue;
public class StatsCollector {
	//use max and min heaps which eases median and average computation
	PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int count = 0;
    long total = 0;

	//Assumptions:
	/*1. response time is in integer 
	 *2. input data is read as and when it occurs*/
    
    public StatsCollector() {
    		minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				//sorts in descending order
				return o2-o1;
			}
        	
		}); 
	}
    
    /*pushes response time into heap
	 * @Parameters: input parameter -> integer responseTimeMs
	 * returns nothing*/
	public void pushValue(int responseTimeMs) {
		count++;
		total += (long) responseTimeMs;
		
		if(maxHeap.isEmpty() || responseTimeMs <= maxHeap.peek()) {
            maxHeap.add(responseTimeMs);
        } else {
            minHeap.add(responseTimeMs);
        }
        if(minHeap.size() >= maxHeap.size()+2) {
            maxHeap.add(minHeap.remove());
        } else if(maxHeap.size() >= minHeap.size()+2){ 
            minHeap.add(maxHeap.remove());
        }
	}

	/*calculates median of data in queue
	 * @Parameters: input -> none
	 * returns median*/
	public double getMedian() {
		try {
			//when size of queue is even
			if(minHeap.size() == maxHeap.size()) {
	            return (double)(minHeap.peek()+maxHeap.peek())/2;
	        }
			//when size of queue is odd and min heap size is greater
			else if(minHeap.size() > maxHeap.size()) {
	            return minHeap.peek();
	        }
			//when size of queue is odd and min heap size is smaller
			else {
	            return maxHeap.peek();
	        }
			}
			catch (Exception e) {
				return -1;
			}
	}

	/*calculates average of data in queue
	 * @Parameters: input -> none
	 * returns average*/
	public long getAverage() {
		try {
			return total/count;
		}
		catch (Exception e) {
			return -1;
		}
	}
}
