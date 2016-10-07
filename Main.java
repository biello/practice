
public class Main {

    public static void main(String[] args) {
    	System.out.println(isPowerOfThree(243));
    }
    
    public static boolean isPowerOfThree(int n) {
    	double t = Math.log10(n)/Math.log10(3);
    	if(t == (int)t)	return true;
    	else	return false;
    }
    
}