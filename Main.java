import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] pos=new int[10000];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int cap=in.nextInt();
		double per;
		Candy candies[]= new Candy[n];
		for(int i=0;i<n;++i){
			int a=in.nextInt();
			int b=in.nextInt();
			per=1.0*b/a;
			candies[i]=new Candy(i,a,per);
		}		
		Arrays.sort(candies);
		int c=0;
		int pi=0;
		for(int i=0;(c+candies[i].c)<=cap;c+=candies[i].c,i++){
			pos[i]=candies[i].id+1;
			pi+=candies[i].c*candies[i].per;
		}		
		System.out.println(pi);
/*		for (Candy candy : candies) {
			System.out.println(candy.id);
		}*/
		for (int i=0;pos[i]!=0;i++) {
			System.out.print(pos[i]+" ");
		}
		in.close();
	}
	
	static class Candy implements Comparable<Candy>{
		int id;
		int c;
		double per;
		
		
		public Candy(int id, int c, double per) {
			super();
			this.id = id;
			this.c = c;
			this.per = per;
		}


		@Override
		public int compareTo(Candy c) {
			// TODO Auto-generated method stub
			if(this.per<c.per)
				return 1;
			else if(this.per>c.per)
				return -1;
			else
				return 0;
		}
	}
}
