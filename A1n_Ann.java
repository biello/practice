import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class A1n_Ann {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"1","2","3"};
		List<String> l=(List<String>) Arrays.asList(a);
		Iterator<String> it=l.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		listAll(l,"");
	}
	
	static void listAll(List<String> l,String pre){
		if(l.isEmpty())
			System.out.println(pre);
		for(int i=0;i<l.size();i++){
			List temp = new LinkedList(l);
			listAll(temp,pre+temp.remove(i));

		}
	}

}
