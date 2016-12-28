package ProgramPackage;

import java.util.LinkedList;

public class BigONotation {
	public static LinkedList<DblListnode<String>> items = new LinkedList<DblListnode<String>>();
	public static LinkedList<DblListnode<String>> items2 = new LinkedList<DblListnode<String>>();
	public static LinkedList<DblListnode<String>> items3 = new LinkedList<DblListnode<String>>();

	private int[] theArray;

	private int arraySize;

	private int itemsInArray = 0;

	static long startTime;

	static long endTime;

	public static void main(String[] args) {
		for (int i = 0; i < 90000; i++) {

			DblListnode<String> nodeNew = new DblListnode<String>(Integer.toString(i));
			items.add(nodeNew);
		}

		for (int i = 0; i < 180000; i++) {

			DblListnode<String> nodeNew = new DblListnode<String>(Integer.toString(i));
			items2.add(nodeNew);
		}

		for (int i = 0; i < 270000; i++) {

			DblListnode<String> nodeNew = new DblListnode<String>(Integer.toString(i));
			items3.add(nodeNew);
		}
		// DblListnode<String> e = new DblListnode<String>("cluck");
		// DblListnode<String> f = new DblListnode<String>("oink");

		// items.add(e);
		// items.add(f);
		// System.out.println("first");
		// for (DblListnode<String> item : items) {

		// System.out.println(item.getData());
		// }

		// swap(0, 1);
		// System.out.println("second");
		// for (DblListnode<String> item : items) {

		// System.out.println(item.getData());
		// }

		/*
		 * 0(1) Test BigONotation testAlgo = new BigONotation(10);
		 * 
		 * testAlgo.addItemToArray(10);
		 * 
		 * System.out.println(Arrays.toString(testAlgo.theArray));
		 */

		BigONotation testAlgo2 = new BigONotation(100000);
		testAlgo2.generateRandomArray();

		BigONotation testAlgo3 = new BigONotation(200000);
		testAlgo3.generateRandomArray();

		BigONotation testAlgo4 = new BigONotation(30000);
		testAlgo4.generateRandomArray();

		BigONotation testAlgo5 = new BigONotation(400000);
		testAlgo5.generateRandomArray();

		/*
		 * O(N) Test
		 * 
		 * testAlgo2.linearSearchForValue(20);
		 * 
		 * testAlgo3.linearSearchForValue(20);
		 * 
		 * testAlgo4.linearSearchForValue(20);
		 * 
		 * testAlgo5.linearSearchForValue(20);
		 */

		// O(N^2) Test
		/*
		 * testAlgo2.bubbleSort();
		 * 
		 * testAlgo3.bubbleSort();
		 * 
		 * testAlgo4.bubbleSort();
		 * 
		 * // 0 (log N) Test
		 * 
		 * testAlgo2.binarySearchForValue(20);
		 * testAlgo3.binarySearchForValue(20);
		 */

		// O (n log n) Test

		// startTime = System.currentTimeMillis();
		//
		// endTime = System.currentTimeMillis();
		//
		// System.out.println("swap took" + (endTime - startTime));
		swap(0, 89999, items);
		swap(0, 179999, items2);
		swap(0, 269999, items3);
	}

	public static void swap(int pos1, int pos2, LinkedList<DblListnode<String>> items) {
		startTime = System.currentTimeMillis();

		if (items.size() > 0) {
			if (pos1 < 0 || pos1 >= items.size() || pos2 < 0 || pos2 >= items.size())
				throw new IndexOutOfBoundsException();

			if (pos1 == pos2) {
				return;
			} else {
				int lowNum = 0;
				int highNum = 0;
				if (pos1 < pos2) {
					lowNum = pos1;
					highNum = pos2;
				} else {
					highNum = pos1;
					lowNum = pos2;
				}
				DblListnode<String> pos1El = null;
				DblListnode<String> pos2El = null;
				DblListnode<String> pos1Next = null;
				DblListnode<String> pos1Prev = null;
				String pos1Dat = null;
				String pos2Dat = null;
				DblListnode<String> pos2Next = null;
				DblListnode<String> pos2Prev = null;

				int i = 0;

				for (DblListnode<String> item : items) {

					if (i == lowNum) {
						pos1Next = item.getNext();
						pos1Prev = item.getPrev();
						pos1Dat = item.getData();
						pos1El = item;
					}
					if (i == highNum) {
						pos2Next = item.getNext();
						pos2Prev = item.getPrev();
						pos2Dat = item.getData();
						item.setNext(pos1Next);
						item.setPrev(pos1Prev);
						item.setData(pos1Dat);
						pos1El.setNext(pos2Next);
						pos1El.setPrev(pos2Prev);
						pos1El.setData(pos2Dat);
					}
					i++;

				}

			}

		}
		endTime = System.currentTimeMillis();
		System.out.println("Swap: with " + items.size() + " took " + (endTime - startTime));
	}
	// O(1) An algorithm that executes in the same
	// time regardless of the amount of data
	// This code executes in the same amount of
	// time no matter how big the array is

	public void addItemToArray(int newItem) {

		theArray[itemsInArray++] = newItem;

	}

	// 0(N) An algorithm thats time to complete will
	// grow in direct proportion to the amount of data
	// The linear search is an example of this

	// To find all values that match what we
	// are searching for we will have to look in
	// exactly each item in the array

	// If we just wanted to find one match the Big O
	// is the same because it describes the worst
	// case scenario in which the whole array must
	// be searched

	public void linearSearchForValue(int value) {

		boolean valueInArray = false;
		String indexsWithValue = "";

		startTime = System.currentTimeMillis();

		for (int i = 0; i < arraySize; i++) {

			if (theArray[i] == value) {
				valueInArray = true;
				indexsWithValue += i + " ";
			}

		}

		System.out.println("Value Found: " + valueInArray);

		endTime = System.currentTimeMillis();

		System.out.println("swap took" + (endTime - startTime));

	}

	// O(N^2) Time to complete will be proportional to
	// the square of the amount of data (Bubble Sort)
	// Algorithms with more nested iterations will result
	// in O(N^3), O(N^4), etc. performance

	// Each pass through the outer loop (0)N requires us
	// to go through the entire list again so N multiplies
	// against itself or it is squared

	public void bubbleSort() {

		startTime = System.currentTimeMillis();

		for (int i = arraySize - 1; i > 1; i--) {

			for (int j = 0; j < i; j++) {

				if (theArray[j] > theArray[j + 1]) {

					swapValues(j, j + 1);

				}
			}
		}

		endTime = System.currentTimeMillis();

		System.out.println("Bubble Sort Took " + (endTime - startTime));
	}

	// O (log N) Occurs when the data being used is decreased
	// by roughly 50% each time through the algorithm. The
	// Binary search is a perfect example of this.

	// Pretty fast because the log N increases at a dramatically
	// slower rate as N increases

	// O (log N) algorithms are very efficient because increasing
	// the amount of data has little effect at some point early
	// on because the amount of data is halved on each run through

	public void binarySearchForValue(int value) {

		startTime = System.currentTimeMillis();

		int lowIndex = 0;
		int highIndex = arraySize - 1;

		int timesThrough = 0;

		while (lowIndex <= highIndex) {

			int middleIndex = (highIndex + lowIndex) / 2;

			if (theArray[middleIndex] < value)
				lowIndex = middleIndex + 1;

			else if (theArray[middleIndex] > value)
				highIndex = middleIndex - 1;

			else {

				System.out.println("\nFound a Match for " + value + " at Index " + middleIndex);

				lowIndex = highIndex + 1;

			}

			timesThrough++;

		}

		// This doesn't really show anything because
		// the algorithm is so fast
		//
		// endTime = System.currentTimeMillis();
		//
		// System.out.println("Binary Search Took " + (endTime - startTime));
		//
		// System.out.println("Times Through: " + timesThrough);

	}

	// O (n log n) Most sorts are at least O(N) because
	// every element must be looked at, at least once.
	// The bubble sort is O(N^2)
	// To figure out the number of comparisons we need
	// to make with the Quick Sort we first know that
	// it is comparing and moving values very
	// efficiently without shifting. That means values
	// are compared only once. So each comparison will
	// reduce the possible final sorted lists in half.
	// Comparisons = log n! (Factorial of n)
	// Comparisons = log n + log(n-1) + .... + log(1)
	// This evaluates to n log n

	public void quickSort(int left, int right) {

		if (right - left <= 0)
			return;

		else {

			int pivot = theArray[right];

			int pivotLocation = partitionArray(left, right, pivot);

			quickSort(left, pivotLocation - 1);
			quickSort(pivotLocation + 1, right);

		}

	}

	public int partitionArray(int left, int right, int pivot) {

		int leftPointer = left - 1;
		int rightPointer = right;

		while (true) {

			while (theArray[++leftPointer] < pivot)
				;

			while (rightPointer > 0 && theArray[--rightPointer] > pivot)
				;

			if (leftPointer >= rightPointer) {

				break;

			} else {

				swapValues(leftPointer, rightPointer);

			}

		}

		swapValues(leftPointer, right);

		return leftPointer;

	}

	BigONotation(int size) {

		arraySize = size;

		theArray = new int[size];

	}

	public void generateRandomArray() {

		for (int i = 0; i < arraySize; i++) {

			theArray[i] = (int) (Math.random() * 1000) + 10;

		}

		itemsInArray = arraySize - 1;

	}

	public void swapValues(int indexOne, int indexTwo) {

		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;

	}

}