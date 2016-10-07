package sortAlgorithms;



public class SortController {
	private int[] backup;
	private SortAlgorithms sa;
	
	public void sort(int[] array) {
		
		backup = array.clone();	
		long t0, t1;
		
/*		sa = new BubbleSort();
		t0 = System.currentTimeMillis();
		sa.sort(array);
		t1 = System.currentTimeMillis();
		System.out.println("bubbleSort " + isSorted(array) + " time spent: "+(t1-t0)+"ms");
			
		array = backup.clone();
		sa = new SelectionSort();
		t0 = System.currentTimeMillis();
		sa.sort(array);
		t1=System.currentTimeMillis();
		System.out.println("selectSort " + isSorted(array) + " time spent: "+(t1-t0)+"ms");
			
		array = backup.clone();
		sa = new InsertionSort();
		t0 = System.currentTimeMillis();
		sa.sort(array);
		t1=System.currentTimeMillis();
		System.out.println("insertSort " + isSorted(array) + " time spent: "+(t1-t0)+"ms");
			
		array = backup.clone();
		sa = new MergeSort();
		t0 = System.currentTimeMillis();
		sa.sort(array);
		t1=System.currentTimeMillis();
		System.out.println("mergeSort  " + isSorted(array) + " time spent: "+(t1-t0)+"ms");
			
		array = backup.clone();
		sa = new QuickSort();
		t0 = System.currentTimeMillis();
		sa.sort(array);
		t1=System.currentTimeMillis();
		System.out.println("quickSort  " + isSorted(array) + " time spent: "+(t1-t0)+"ms");
*/		
		array = backup.clone();
		sa = new BetterQuickSort();
		t0 = System.currentTimeMillis();
		sa.sort(array);
		t1=System.currentTimeMillis();
		System.out.println("betterQuickSort  " + isSorted(array) + " time spent: "+(t1-t0)+"ms");
		
		array = backup.clone();
		sa = new HeapSort();
		t0 = System.currentTimeMillis();
		sa.sort(array);
		t1=System.currentTimeMillis();
		System.out.println("HeapSort  " + isSorted(array) + " time spent: "+(t1-t0)+"ms");
		
			
	}
		
		
		
	
	String isSorted(int[] array) {
		boolean sorted = true;
		for(int i = 0; i < array.length -1; i++) {
			if(array[i] > array[i+1])
				sorted = false;
		}
		if(sorted) {
			return "OK!";
		} else {
			return "ERROR!";
		}
	}
	
}
