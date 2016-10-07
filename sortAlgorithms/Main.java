package sortAlgorithms;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		SortController sortController = new SortController();
		Scanner sc = new Scanner(System.in);
		System.out.println("please input the size, 0 to quit.");
		while(sc.hasNext()) {
			int size = 0;
			try {
				size = sc.nextInt();
			} catch (Exception e) {
				size = 0;
				System.out.println(e.toString() + ", please try again.");
				continue;
			}
			if(size == 0) break;
			int[] array=new int[size];
			for(int i=0;i<array.length;i++)
				array[i]=(int) (Math.random()*10000);
			
			System.out.println("when original array is random:");
			sortController.sort(array);
			System.out.println();
			
			System.out.println("when original array is ordered:");
			sortController.sort(array);
			
			
		
			
		}
		
		sc.close();
		
	}
	
}
