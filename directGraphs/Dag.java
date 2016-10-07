package directGraphs;

import java.util.*;

public class Dag {
	
	public static final int INFINITY = 10000;
	
	public int[][] AdjMatrix;
	public ArrayList<LinkedList<Integer>> AdjList;
	
	public Dag(int[][] a) {		//将邻接矩阵表示的图转换为邻接链表
		AdjMatrix = a.clone();
		AdjList = new ArrayList<LinkedList<Integer>>();
		for(int i = 0; i < AdjMatrix.length; i++) {
			AdjList.add(new LinkedList<Integer>());
			for(int j = 0; j < AdjMatrix[i].length; j++) {
				if(AdjMatrix[i][j] != 0)
					AdjList.get(i).add(AdjMatrix[i][j]);
			}
		}
	}
	
	public static void main(String[] args) {
		/*
		 * 0表示无边，大于0表示有边，值为权值
		 */
		int[][] a ={{0, 1, 0, 1, 0},
					{0, 0, 1, 1, 0},
					{0, 0, 0, 0, 1},
					{0, 1, 1, 0, 1},
					{1, 0, 1, 0, 0},
					};
		int[][] b ={{0,0,1,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,1,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,1,1,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,1,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,1,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,1,0,0,0,1,0,0,0},
					{0,0,0,0,0,0,0,1,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{0,0,0,0,0,0,0,0,0,1,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,1,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,1,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					};
		int[][] c ={{0, 6, 4, 0, 0},
					{0, 0, 2, 3, 0},
					{0, 1, 0, 9, 3},
					{0, 0, 0, 0, 4},
					{7, 0, 0, 5, 0},
					};
		Dag dag1 = new Dag(a);	//此图有环，不能做拓扑排序
		Dag dag2 = new Dag(b);
		Dag dag3 = new Dag(c);
		
		for(int i : topologicalSort(dag2))
			System.out.print(i + " ");
		System.out.println();
		
		for(int i : dagShortestPath(dag2, 0)) {
			if(i == INFINITY)
				System.out.print("∞" + " ");
			else
				System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i : dijkstra(dag1, 0)) {
			if(i == INFINITY)
				System.out.print("∞" + " ");
			else
				System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i : dijkstra(dag3, 0)) {
			if(i == INFINITY)
				System.out.print("∞" + " ");
			else
				System.out.print(i + " ");
		}
		
	}
	
	/*
	 * 拓扑排序，不可用于有环图
	 */
	static int[] topologicalSort(Dag g) {	//邻接矩阵的存储方式
		int[] result = new int[g.AdjMatrix.length];	//存放拓扑排序的结果
		int pos = 0;	//指示result数组的下一个该存放的位置
		int[] inDegree = new int[g.AdjMatrix.length];	//存放个顶点的入度
		LinkedList<Integer> next = new LinkedList<Integer>();	//存放入度为0的顶点
		for(int i = 0; i < g.AdjMatrix.length; i++) {
			for(int j = 0; j < g.AdjMatrix[0].length; j++){
				if(g.AdjMatrix[i][j] != 0) {
					inDegree[j]++;
				}
			}
		}
		for(int i = 0; i < inDegree.length; i++) {	//将入度为0的节点放入next数组
			if(inDegree[i] == 0)
				next.add(i);
		}
		while(!next.isEmpty()) {
			int u = next.remove(0);		//从next里删除一个节点
			result[pos++] = u;			//放到结果数组中
			for(int j = 0; j < g.AdjMatrix[u].length; j++){
				if(g.AdjMatrix[u][j] != 0) {
					if(--inDegree[j] == 0)		//将u有边指向的节点入度减1
						next.add(j);			//如果入度为零则放入next
				}
			}
			
		}
		
		return result;
	}
	
	/*
	 * 有向无环图的最短路径
	 * 返回从s到各个节点的最短路径带权和，没有路径到达的为10000
	 */
	static int[] dagShortestPath(Dag g, int s) {	//计算从s出发到各个节点的最短路径
		int[] shortest = new int[g.AdjMatrix.length];	//从s到各个节点的最短路径带权和
		int[] pred = new int[g.AdjMatrix.length];	//存放最短路径中各节点的前驱
		int[] topo = topologicalSort(g);

		for(int i = 0; i < shortest.length; i++) {	//将shortest数组除了s之外的其他节点置为正无穷，s置为0，prev都置为-1（表示无前驱）
			shortest[i] = INFINITY;
			pred[i] = -1;
		}
		shortest[s] = 0;
		
		for(int i = 0; i < topo.length; i++) {
			for(int j = 0; j < g.AdjMatrix[i].length; j++)
				if(g.AdjMatrix[i][j] != 0)
					if(shortest[i] + g.AdjMatrix[i][j] < shortest[j]) {
						shortest[j] = shortest[i] + g.AdjMatrix[i][j];
						pred[j] = i;
					}
		}
		
		return shortest;
	}
	

	/*
	 * dijkstra求两节点间的最短路径，也适用于有环图，要求所有权值是非负的
	 * 简单的数组实现
	 */
	static int[] dijkstra(Dag g, int s) {
		int[] shortest = new int[g.AdjMatrix.length];	//从s到各个节点的最短路径带权和
		int[] pred = new int[g.AdjMatrix.length];	//存放最短路径中各节点的前驱
		LinkedList<Integer> rest = new LinkedList<Integer>();	//dijkstra算法维护着的一个节点表，表示剩余shortest值未确定的节点
		
		for(int i = 0; i < shortest.length; i++) {	//将shortest数组除了s之外的其他节点置为正无穷，s置为0，prev都置为-1（表示无前驱）
			shortest[i] = INFINITY;	//Notice: 此处不可用Integer.maxValue,因为后面的操作会加这个值，否则将会溢出
			pred[i] = -1;
		}
		shortest[s] = 0;
		
		for(int i = 0; i < g.AdjMatrix.length; i++)		//把所有节点都放入rest表
			rest.add(i);
		
		while(!rest.isEmpty()) {		//当rest表不空
			int minpos = 0;
			int min = shortest[rest.get(minpos)];
			for(int i = 0; i < rest.size(); i++) {
				if(min > shortest[rest.get(i)]) {
					min = shortest[rest.get(i)];
					minpos = i;
				}
			}
			int u = rest.remove(minpos);		//找出最小shortest值得节点u移除
			for(int j = 0; j < g.AdjMatrix[u].length; j++) {	//对每一个与u相邻的节点v,调用relax(u,v)
				if(g.AdjMatrix[u][j] != 0)
					if(shortest[u] + g.AdjMatrix[u][j] < shortest[j]) {
						shortest[j] = shortest[u] + g.AdjMatrix[u][j];
						pred[j] = u;
					}
			}
		}
		
		return shortest;
			
		
	}
	
}
