//https://www.acmicpc.net/problem/2042
import java.util.Scanner;

public class Main2042 {
	public static int N, M, K, arr[], tree[];
	
	public static long init(int node, int start, int end) {
		if(start == end) return tree[node] = arr[start];
		else return tree[node] = init(node*2, start, (start+end)/2 + init(node*2+1, (start+end)/2+1, end));
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		arr = new int[N];
		tree = new int[4*N]; // range
		
		
		
	}
}
