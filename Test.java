
public class Test {
	
	public static void main(String[] args) {
/*		int inum = Integer.parseInt(args[0]);//inum就是要分解的整数    String strResult = “””; 
		String strResult = "";
		while(pnum(inum)!=0){
			strResult+=String.valueOf(pnum(inum))+"*";
			inum/=pnum(inum);
		}
		strResult+=inum;
		 System.out.println(strResult);//输出分解结果，如2*3*3*5 */
		Test t=new Test(null);
		double d=1.2231222d;
		System.out.println(d);
		long l=0xfffffl;
		System.out.println(l);
		if(null instanceof String)
			System.out.println(true);
		else
			System.out.println(false);
		String[] s=new String[5];
		System.out.println(s[1]);
		char x='x';
		int i=5;
		System.out.println(false ? i : x);
		System.out.println(false ? 10000 : x);

		
		
	}
	
	public static int pnum(int num){
		for(int i=2;i<=Math.sqrt(num);i++)
			if(num%i==0) return i;
		return 0;
	}
	Test(Object obj){
		System.out.println("Object!");
	}
	Test(String s){
		System.out.println("String!");
	}
	Test(int i){
		System.out.println("int!");
	}
	
		
}

