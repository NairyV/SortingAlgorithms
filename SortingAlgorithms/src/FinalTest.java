
public class FinalTest {
	public static void main(String[] args) {
		int a[] = {16,44,23,19,25,16,57,87,44};
		SortClass h = new SortClass();
		h.heapSort(a);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
