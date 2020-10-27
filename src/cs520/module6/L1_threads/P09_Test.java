package cs520.module6.L1_threads;

public class P09_Test {

	public static void main(String[] args) {
		// Create an account object and share it with the two threads
		P06_Account jointAccount = new P06_Account();
		P07_Producer producer = new P07_Producer(jointAccount);
		P08_Consumer consumer = new P08_Consumer(jointAccount);
		producer.start();
		consumer.start();
	}
}
