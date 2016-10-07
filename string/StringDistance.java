package string;
/*
 * 动态规划求字符串距离：一个字符串转化成另一个字符串的最小代价
 */
public class StringDistance {
	
	public static int del = 1;	//删除的代价
	public static int ins = 1;	//插入的代价
	public static int rep = 1;	//替换的代价
	
	public static void main(String[] args) {
		char[] a = "atgatcggcat".toCharArray();
		char[] b = "caatgtgaatc".toCharArray();
		int alen = 11, blen = 11;
		System.out.println(dis(a, alen, b, blen));
		System.out.println(dis1(a, alen, b, blen));
	}
	
	/*
	 * 递归解决方案
	 */
	public static int dis(char[] a, int alen, char[] b, int blen) {
		if(alen == 0) return ins * blen;
		else if(blen == 0) return ins * alen;
		else if(a[alen-1] == b[blen-1])	return dis(a, alen-1, b, blen-1);
		else return min(ins + dis(a, alen, b, blen-1), del + dis(a, alen-1, b, blen),
				rep + dis(a, alen-1, b, blen-1));
	}
	
	/*
	 * 数组解决方案
	 */
	public static int dis1(char[] a, int alen, char[] b, int blen) {
		int[][] cost = new int[alen+1][blen+1];
		for(int i = 0; i < alen+1; i++) {
			for(int j = 0; j < blen+1; j++) {
				if(i == 0)	cost[i][j] = ins * j;
				else if(j == 0)	cost[i][j] = del * i;
				else if(a[i-1] == b[j-1])	cost[i][j] = cost[i-1][j-1];
				else cost[i][j] = min(cost[i-1][j-1] + rep,
						cost[i-1][j] + del, cost[i][j-1] + ins);
			}
		}
		
		return cost[alen][blen];
	}
	
	public static int min(int a, int b, int c) {
		int min = a;
		if(a > b)	min = b;
		if(min > c)	min = c;
		return min;
	}
	
	
}
