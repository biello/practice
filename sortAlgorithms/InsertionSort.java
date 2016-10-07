package sortAlgorithms;

public class InsertionSort implements SortAlgorithms {
	public void sort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int j = i;
			int key = arr[i];
			while(j > 0 && arr[j-1] > key) {
				arr[j] = arr[j-1];
				j -= 1;
			}
			arr[j] = key;
		}
	}
}
