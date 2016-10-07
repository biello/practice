package sortAlgorithms;

public class SelectionSort implements SortAlgorithms {
	public void sort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int minpos=i;
			for(int j=i+1;j<arr.length;j++)
				if(arr[j]<arr[minpos]){
					minpos=j;
				}
			int min = arr[minpos];
			arr[minpos] = arr[i];
			arr[i] = min;
		}		
	}
}
