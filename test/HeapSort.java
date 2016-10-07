package test;


public class HeapSort {

	private static void heap(int[] a, int i) {
		int temp, foo = (int) (0.5*(i-1));
		while(a[i] < a[foo]) {
			temp = a[i];
			a[i] = a[foo];
			a[foo] = temp;
			i = foo;
			foo = (int) (0.5*(i-1));
		}
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static int pop(int[] a, int size) {
		int result = a[0];
		a[0] = a[size-1];
		for(int i = 0; i < size; ) {
			int left = i*2+1, right = i*2+2;
			if(left < size && right < size) {
				if(a[i] < a[left] && a[i] < a[right]){
					break;
				}else {
					if(a[left] <= a[right]) {
						swap(a, i, left);
						i = left;
					}else {
						swap(a, i, right);
						i = right;
					}
				} 
			} else if(left < size) {
				if(a[i] < a[left]){
					break;
				}else {
					swap(a, i, left);
					i = left;
				} 
			} else {
				break;
			}
		}
		return result;
	}
	
	private static void heapSort(int[] array) {
		int[] a = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			a[i] = array[i];
			heap(a, i);
		}
		
		for(int i = 0; i < array.length; i++) {
			array[i] = pop(a, a.length-i);
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] a = {9,12,17,30,50,20,60,65,4,49};
		heapSort(a);
		for(int n : a)
			System.out.print(n + " ");
	}
}






