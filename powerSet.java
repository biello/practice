import java.util.*;

public class powerSet {
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		A.add(1);A.add(2);A.add(3);A.add(4);
		power(0,A,B);
	}
	
	static void power(int i,ArrayList<Integer> A,ArrayList<Integer> B){
		if(i>=A.size()){
			for (int obj : B) {
				System.out.print(obj+" ");				
			}
			System.out.println();
		}
		else{
			int x = A.get(i); int k = B.size();
			B.add(k,x);		power(i+1,A,B);
			B.remove(k);	power(i+1,A,B);
		}
	}

}
