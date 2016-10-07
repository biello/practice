
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int key = sc.nextInt();
			int size = sc.nextInt();
			int[] a = new int[size];
			for(int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}
			
			int left = 0, right = a.length - 1;
			int index = (int) Math.floor(0.5 * (left + right));
			while(index != left) {
				if(key == a[index]) break;
				if(key < a[index]) {
					right = index - 1;
				} else {
					left = index + 1;
				}
				index = (int) Math.floor(0.5 * (left + right));
			}
			
			if(key == a[index]){
				while(index > 0 && key == a[index - 1] ) {
					index--;
				}
				System.out.println(index);
			}
			else {
				if(key > a[a.length-1])
					System.out.println(-1 - a.length);
				else
					System.out.println(-1 - index);
			}
		}
		sc.close();
	}	
}
