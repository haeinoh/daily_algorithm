//https://www.acmicpc.net/problem/10999
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10999 {
	public static int N, M, K;
	public static long arr[], tree[], lazy[];
	
	public static long init(int node, int start, int end) {
		if(start == end) return tree[node] = arr[start];
		
		int mid = (start + end) / 2;
		
		return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
	
	public static void updateLazy(int node, int start, int end) {
		if(lazy[node] != 0) { //lazy값이 0이 아닌 경우
			tree[node] += (end-start+1)*lazy[node]; //해당하는 노드가 담당하는 노드의 총 갯수 * 해당 노드의 lazy 값	
			//leaf노드가 아닌 경우
			if(start != end) {
				lazy[node*2] += lazy[node]; //자식들에게 lazy 값을 물려준다
				lazy[node*2+1] += lazy[node];
			}
			lazy[node] = 0; // 물려준 후 해당 노드 lazy는 초기화
		}
	}
	
	public static void updateRange(int node, int start, int end, int left, int right, long diff) {
		updateLazy(node, start, end); //해당 노드에 lazy가 있다면 업데이트
		if(left > end || right < start) return;
		
		if(left <= start && end <= right) { //범위에 해당할때
			tree[node] += (end-start+1)*diff; //해당하는 노드가 담당하는 노드의 총 갯수 * 더하거나 빼야할 값
			if(start != end) { // leaf노드가 아닌 경우
				lazy[node*2] += diff; // 자식들에게 lazy 값을 물려준다
				lazy[node*2+1] += diff;
			}
			return;
		}
		
		int mid = (start + end) / 2;
		updateRange(node*2, start, mid, left, right, diff);
		updateRange(node*2+1, mid+1, end, left, right, diff);
		tree[node] = tree[node*2] + tree[node*2+1];
	}
	
	public static long sum(int node, int start, int end, int left, int right) {
		//남은 lazy들을 update시켜준다
		updateLazy(node, start, end); //updateLazy
		if(left > end || right < start) return 0;
		
		if(left <= start && right >= end) return tree[node]; // 범위안에 있는 경우만 
		
		int mid = (start + end) / 2;
		return sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		tree = new long[N*4];
		lazy = new long[N*4]; //update를 미루는 배열
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine().trim());
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		init(1, 1, N);
		
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); 
			
			//기존 세그먼트 트리에서 하냐의 값을 변경할 때에는 O(logN)의 시간이 걸렸다. 
			//이 알고리즘을 활용하여 구간의 값들을 변경하면 (c-b+1)만큼 변경해야하므로 O(NlogN)만큼 걸리게 되고 TLE가 된다.
			//이것을 해결하기 위해 Lazy Propagation을 활용해야한다. O(logN)^2이 걸린다.
			if(a == 1) {
				long d = Long.parseLong(st.nextToken());
				updateRange(1, 1, N, b, c, d); // b번째 수부터 c번째 수에 d를 더한다.
			} else {
				System.out.println(sum(1, 1, N, b, c)); //b번재 수부터 c번째 수까지 합을 구한다.
			}
		}
	}
}
