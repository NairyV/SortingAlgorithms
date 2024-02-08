/**
 * John Nairy Vardanyan
 * CSC 130
 * Assignment 4: Performance Evaluation of Heapsort, Mergesort, and Quicksort
 * Files: SortDriver.java, SortClass.java
 */
import java.util.Random;
import java.util.Scanner;

public class SortDriver {
	public static final int SIZE = 500000;
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		String input = "";
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int a[] = new int[SIZE];
		int _heapTester[] = new int[SIZE];
		int _mergeTester[] = new int[SIZE];
		int _quickTester[] = new int[SIZE];
		for(int i = 0; i < a.length; i++) { a[i] = rand.nextInt(SIZE); }
		copy(a,_heapTester);
		copy(a,_mergeTester);
		copy(a,_quickTester);
		SortClass obj = new SortClass();
		do {
			//heapSort
			long start = System.nanoTime();
			obj.heapSort(_heapTester);
			long end = System.nanoTime();
	    	long elapsedTime = end - start;
	    	double seconds = (double)elapsedTime / 1_000_000_000.0;
	    	System.out.printf("It took %.2f seconds to heapsort the array\n",seconds);
	    	//mergeSort
	    	start = System.nanoTime();
	    	obj.mergeSort(_mergeTester, _mergeTester.length);
	    	end = System.nanoTime();
	    	elapsedTime = end - start;
	    	seconds = (double)elapsedTime / 1_000_000_000.0;
	    	System.out.printf("It took %.2f seconds to mergeSort the array\n",seconds);

	    	//quickSort
	    	start = System.nanoTime();
	    	obj.quickSort(_quickTester,0, _quickTester.length-1);
	    	end = System.nanoTime();
	    	elapsedTime = end - start;
	    	seconds = (double)elapsedTime / 1_000_000_000.0;
	    	System.out.printf("It took %.2f seconds to quickSort the array\n",seconds);
	    	System.out.println("\nPlease press \"Enter\" to start the next round!\n");

			input = scan.nextLine();
			if(input.equals("")) {
				copy(a,_heapTester);
				copy(a,_mergeTester);
				copy(a,_quickTester);
			}
		}while(input.equals(""));
	}
	public static void copy(int a[], int b[]) {
		for(int i = 0; i < SIZE; i++) {
			b[i] = a[i];
		}
	}

}
