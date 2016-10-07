package sortAlgorithms;

public class BetterQuickSort implements SortAlgorithms {
	
	private void quickSort(int[] arr,int left,int right) {
		if(left >= right) return;
		preprogress(arr, left, right);
		int key = arr[right];
		int l = left, r = right;
		while(l != r){
			while(l < r && arr[r] >= key){
				r--;
			}
			arr[l] = arr[r];
			while(l < r && arr[l] <= key){
				l++;
			}
			arr[r] = arr[l];
		}
		arr[r] = key;
		
		if(l - left > 20) {
			quickSort(arr, left, l-1);
		} else {
			insertSort(arr, left, l-1);
		}
		if(right - l > 20) {
			quickSort(arr, l+1, right);
		} else {
			insertSort(arr, l+1, right);
		}
		
		
	}
	
	private void preprogress(int[] arr,int left,int right) {
		int rindex = (int) (left + Math.random() * (right - left));
		int temp = arr[rindex];
		arr[rindex] = arr[right];
		arr[right] = temp;
	}
	
	public void insertSort(int[] arr, int left, int right) {
		for(int i = left + 1; i <= right; i++) {
			int j = i;
			int key = arr[i];
			while(j > 0 && arr[j-1] > key) {
				arr[j] = arr[j-1];
				j -= 1;
			}
			arr[j] = key;
		}
	}
	
	public void sort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

}
