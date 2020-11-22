import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	int n;
	int w;
	
	Node(int n, int w){
		this.n = n;
		this.w = w;
	}
}

public class Main1167 {
	public static int N, answer, leaf;
	public static boolean vtd[];
	public static List<Node> list[];
	
	public static void solve(int idx, int sum) {
		vtd[idx] = true;
		
		if(sum > answer) {
			answer = Math.max(sum, answer);
			leaf = idx;
		}
		
		for(Node node: list[idx]) {
			if(!vtd[node.n]) {
				solve(node.n, sum+node.w);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new ArrayList[N];
		vtd = new boolean[N];
		for(int i = 0; i < N; i++) list[i] = new ArrayList();
		
		for(int i = 0; i < N; i++) {
			int p = sc.nextInt()-1;
			while(true) {
				int x = sc.nextInt()-1;
				if(x == -2) break;
				int w = sc.nextInt();
				list[p].add(new Node(x, w));
			}
		}
		
		//dfs (1)
		answer = 0;
		leaf = 0;
		solve(0, 0);
		//dfs (2)
		answer = 0;
		for(int i = 0; i < N; i++) vtd[i] = false;
		solve(leaf, 0);
		System.out.println(answer);
	}
}
