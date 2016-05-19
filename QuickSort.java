
public class QuickSort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		int[] array=new int[10000];
		for(int i=0;i<array.length;i++)
			array[i]=(int) (Math.random()*100);
		long t0=System.currentTimeMillis();
		quicksort(array,0,array.length-1);
//		bubble(array);
//		selectsort(array);
		long t1=System.currentTimeMillis();
		System.out.println("time spent: "+(t1-t0)+"ms");
		for(int a : array){	System.out.print(a+",");	} System.out.println();
		
		
	}
	static void quicksort(int[] arr,int left,int right){
		if(left>=right) return;
		int key=arr[left];
		int l=left,r=right;
		while(l!=r){
			while(l<r && arr[r]>=key){
				r--;
			}
			arr[l]=arr[r];
			while(l<r && arr[l]<=key){
				l++;
			}
			arr[r]=arr[l];
		}
		arr[r]=key;
		quicksort(arr,left,l-1);
		quicksort(arr,l+1,right);
		
	}
	
	static void bubble(int[] arr){
		for(int i=0;i<arr.length-1;i++)
			for(int j=i+1;j<arr.length;j++)
				if(arr[i]>arr[j]){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
	}
	
	static void selectsort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int min=arr[i],minpos=i+1;
			for(int j=i+1;j<arr.length;j++)
				if(arr[j]<min){
					min=arr[j];
					minpos=j;
				}
			arr[minpos]=arr[i];
			arr[i]=min;
		}		
	}
}
