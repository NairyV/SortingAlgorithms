/**
 * John Nairy Vardanyan
 * CSC 130
 * Assignment 4: Performance Evaluation of Heapsort, Mergesort, and Quicksort
 * Files: SortDriver.java, SortClass.java
 */
public class SortClass {
	public void heapSort(int a[]) {
		int size = a.length;
		for(int i = size/2 - 1; i >= 0; i--) {
			heapify(a,size,i);
		}
		
		for(int i = size-1; i > 0; i--) {
			// set current root to end
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;	
			heapify(a,i,0);
		}
	}
	public void heapify(int a[], int size, int i) {
		int max = i; // max = root
		int left = i * 2 + 1;
		int right = i * 2 + 2;

		if(left < size && a[left] > a[max]) max = left;
		if(right < size && a[right] >  a[max]) max = right;
		if(max != i) {
			int swap = a[i];
			a[i] = a[max];
			a[max] = swap;
			heapify(a,size,max);
		}
	}
    public void merge(int _left[],int _right[], int a[],int leftSize, int rightSize){
        int i = 0;
        int l = 0;
        int r = 0;
        while(l < leftSize && r < rightSize){
            if(_left[l]<_right[r]) a[i++] = _left[l++];
            else a[i++] = _right[r++];
        }
        while(l<leftSize) { a[i++] = _left[l++]; }  
        while(r<rightSize){ a[i++] = _right[r++]; }
    }
    public void mergeSort(int a[], int size){
        if (size < 2){return;}
        int middle = size / 2;
        int l[] = new int[middle];
        int r[] = new int[size-middle];
        int k = 0;
        for(int i = 0;i<size;++i){
            if(i<middle) l[i] = a[i];
            else {
                r[k] = a[i];
                k = k+1;
            }
        }
        mergeSort(l,middle);
        mergeSort(r,size-middle);
        merge(l,r,a,middle,size-middle);
    }

    public void quickSort(int a[], int start, int end){
        if (a == null || a.length == 0)return;
        if (start >= end) return;

        int middle = start + (end - start) / 2;
        int pivot = a[middle];

        int i = start, j = end;
        while (i <= j) {
            while (a[i] < pivot) { i++; }
            while (a[j] > pivot) { j--; }

            if (i <= j) {
                swap (a, i, j);
                i++;
                j--;
            }
        }
        if (start < j) quickSort(a, start, j);
        if (end > i) quickSort(a, i, end); 
    }
     
    public void swap (int a[], int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
