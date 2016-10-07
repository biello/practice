package string;

/*
 * 动态规划求LCS
 */
public class LCSequence {
	public static void main(String[] args) {
		char[] a = "CATCGA".toCharArray();
		char[] b = "GTACCGTCA".toCharArray();
		System.out.println(new String(lcs(a, b)));
 	}
	
	public static char[] lcs(char[] a, char[] b) {
		
		int[][] table = new int[a.length+1][b.length+1];
		for(int i = 0; i < a.length; i++) {				//时间复杂度O(i*j)
			for(int j = 0; j < b.length; j++) {
				if(a[i] == b[j])
					table[i+1][j+1] = table[i][j] + 1;
				else
					table[i+1][j+1] = Math.max(table[i][j+1], table[i+1][j]);
			}
		}

		int lcsLength = table[a.length][b.length];
		char[] lcs = new char[lcsLength];
		int lcspos = lcsLength - 1;
		
//		lcs = assembleLCS(a, b, table, a.length, b.length).toCharArray();
		
		int i = a.length, j = b.length;
		while(table[i][j] != 0) {		//时间复杂度O(i+j)
			if(a[i-1] == b[j-1]) {
				lcs[lcspos--] = a[i-1];
				i -= 1; j -= 1;
			} else if(table[i][j-1] >= table[i-1][j]) {
				j -= 1;
			} else {
				i -= 1;
			}
		}
		
		return lcs;
	}
	
	/*
	 * 递归实现
	 */
	public static String assembleLCS(char[] a, char[] b, int[][] table, int i, int j) {
		if(table[i][j] == 0)	return "";
		if(a[i-1] == b[j-1])	return assembleLCS(a, b, table, i-1, j-1) + a[i-1];
		else if(table[i-1][j-2] >= table[i-2][j-1])	return assembleLCS(a, b, table, i, j-1);
		else return assembleLCS(a, b, table, i-1, j);
	}
}
