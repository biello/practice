package sortAlgorithms;

public class MergeSort implements SortAlgorithms{
	
	private void merge(int[] arr, int p, int q, int r) {
		int[] a = new int[q-p+2];
		int[] b = new int[r-q+1];
		for(int i = 0; i < a.length - 1; i++) {
			a[i] = arr[p+i];
		}
		a[a.length-1] = Integer.MAX_VALUE;
		for(int i = 0; i < b.length - 1; i++) {
			b[i] = arr[q+1+i];
		}
		b[b.length-1] = Integer.MAX_VALUE;
		int ai = 0, bi = 0;
		for(int i = p; i <= r; i++) {
			if(a[ai] <= b[bi])
				arr[i] = a[ai++];
			else
				arr[i] = b[bi++];
		}
	}

	private void mergeSort(int[] arr, int p, int r) {
		if(p >= r) return;
		int q = (int) (0.5*(p+r));
		mergeSort(arr, p, q);
		mergeSort(arr, q+1, r);
		merge(arr, p, q, r);
	}
	
	public void sort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}
}
