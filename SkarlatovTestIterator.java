package hw5;

import java.util.Random;

public class SkarlatovTestIterator {

	static final int NUM_VALUES = 10;

	public static void main(String[] args) {
		//

		// Create BST and BSTWithFastIter
		Random rand = new Random(50);
		BST<Integer> bst = new BST<>();
		BST<Integer> bstWithFastIter = new BSTWithFastIter<>();
		long startTime = System.currentTimeMillis();
		System.out.println("Adding " + NUM_VALUES + " random values to plain BST and to BSTWithFastIter.");
		for (int i = 0; i < NUM_VALUES; i++) {
			int value = rand.nextInt();
			bst.add(value);
			bstWithFastIter.add(value);
			System.out.println(i);
		}
		long endTime = System.currentTimeMillis();
		double seconds = (endTime - startTime) / 1000.0;
		System.out.printf("Time to create trees:  %1.3f seconds\n", seconds);

	}

}
