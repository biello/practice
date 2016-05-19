
public class queen{
	int num,resultNum;
	int[] desk;
	queen(){
		num=8;
		desk=new int[num+1];
		trail(1);
	}
	queen(int num){
		this.num=num;
		desk=new int[num+1];
		trail(1);
	}
	int getResultNum(){
		return resultNum;
	}
	
	void trail(int i){
		if(i>num)	{resultNum++; printdesk();}
		else for(int j=1;j<=num;++j){
			desk[i]=j;
			if(valid(i)) trail(i+1);
		}
	}
	
	void printdesk() {
		for(int i=1;i<=num;++i){
			if(desk[i]==0)	System.out.println("error!");
			else{
				for(int j=1;j<desk[i];++j)
					System.out.print("o"+" ");
				System.out.print("x"+" ");
				for(int j=desk[i]+1;j<=num;++j)
					System.out.print("o"+" ");
				System.out.println();
			}
				
		}
		System.out.println();
		
	}
	boolean valid(int n){
		for(int i=1;i<n;i++){
			for(int j=i+1;j<=n;j++){
				if(desk[i]==desk[j] || Math.abs(desk[i]-desk[j])==j-i)
					return false; 
			}
		}
		return true;
	}
	public static void main(String[] args) {
		queen f=new queen(8);
		System.out.println(f.getResultNum());
	}
}
