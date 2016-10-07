package sortAlgorithms;

public class QuickSort implements SortAlgorithms {
	
	@SuppressWarnings("unused")
	private void quickSort1(int[] arr,int left,int right) {
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
		quickSort1(arr, left, l-1);
		quickSort1(arr, l+1, right);
		
	}
	
	private void quickSort2(int[] arr,int left,int right) {
		if(left>=right) return;
		preprogress(arr, left, right);
		int key = arr[right];
		int p = left, temp; 
		for(int i = left; i < right; i++) {
			if(arr[i] < key) {
				temp = arr[i];
				arr[i] = arr[p];
				arr[p] = temp;
				p += 1;
			}
		}
		temp = arr[right];
		arr[right] = arr[p];
		arr[p] = temp;
		quickSort2(arr, left, p-1);
		quickSort2(arr, p+1, right);
		
	}
	
	private void preprogress(int[] arr,int left,int right) {
		int rindex = (int) (left + Math.random() * (right - left));
		int temp = arr[rindex];
		arr[rindex] = arr[right];
		arr[right] = temp;
	}
	
	

	public void sort(int[] array) {
		quickSort2(array, 0, array.length - 1);
	}

}
