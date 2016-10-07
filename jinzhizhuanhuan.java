
public class jinzhizhuanhuan {

	/**
	 * @param args
	 */

	public void transform(int num,int n){
		int array[]=new int[100];
		int pos=0;
		while(num!=0){
			int remainder=num%n;
			num=num/n;
			array[pos]=remainder;
			pos++;
		}
		show(array,pos-1);

	}
	private void show(int[] arr,int n){
		for(int i=n;i>=0;i--){
			if(arr[i]>9){
				System.out.print((char)(arr[i]+55));
			}
			else
				System.out.print(arr[i]+"");
		}
	}
	public static void main(String[] args)
	{
		jinzhizhuanhuan t=new jinzhizhuanhuan();
		t.transform(7, 2);

	}

}