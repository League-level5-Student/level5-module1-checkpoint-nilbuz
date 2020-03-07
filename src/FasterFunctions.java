
public class FasterFunctions {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		//Your Code Here
		
		
		Thread sort = new Thread(()-> SlowFunctions.slowSortLargeArray());
		Thread ackermann = new Thread(()->System.out.println("ackermann(3, 14): " + SlowFunctions.ackermann(3, 14)));
		Thread root = new Thread(()->SlowFunctions.millionsOfSqrts());
		
		
		System.out.println("Starting slowSortLargeArray()...");
		sort.start();
		try {
			sort.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("slowSortLargeArray() Complete.");
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("slowSortLargeArray() Time: " + endTime + "\n\n");
		
		startTime = System.currentTimeMillis();
		System.out.println("Starting ackermann(3, 14)...");
		ackermann.start();
		try {
			ackermann.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ackermann(3, 14) Complete.");
		endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("ackerman(3, 14) Time: " + endTime + "\n\n");
		
		System.out.println("Starting millionsOfSqrts()...");
		root.start();
		try {
			root.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("millionsOfSqrts() Complete.");
		endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		
		
		
		
		root.start();
		try {
			root.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}
}
