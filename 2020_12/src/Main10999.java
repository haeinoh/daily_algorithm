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
		if(lazy[node] != 0) { //lazy���� 0�� �ƴ� ���
			tree[node] += (end-start+1)*lazy[node]; //�ش��ϴ� ��尡 ����ϴ� ����� �� ���� * �ش� ����� lazy ��	
			//leaf��尡 �ƴ� ���
			if(start != end) {
				lazy[node*2] += lazy[node]; //�ڽĵ鿡�� lazy ���� �����ش�
				lazy[node*2+1] += lazy[node];
			}
			lazy[node] = 0; // ������ �� �ش� ��� lazy�� �ʱ�ȭ
		}
	}
	
	public static void updateRange(int node, int start, int end, int left, int right, long diff) {
		updateLazy(node, start, end); //�ش� ��忡 lazy�� �ִٸ� ������Ʈ
		if(left > end || right < start) return;
		
		if(left <= start && end <= right) { //������ �ش��Ҷ�
			tree[node] += (end-start+1)*diff; //�ش��ϴ� ��尡 ����ϴ� ����� �� ���� * ���ϰų� ������ ��
			if(start != end) { // leaf��尡 �ƴ� ���
				lazy[node*2] += diff; // �ڽĵ鿡�� lazy ���� �����ش�
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
		//���� lazy���� update�����ش�
		updateLazy(node, start, end); //updateLazy
		if(left > end || right < start) return 0;
		
		if(left <= start && right >= end) return tree[node]; // �����ȿ� �ִ� ��츸 
		
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
		lazy = new long[N*4]; //update�� �̷�� �迭
		
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
			
			//���� ���׸�Ʈ Ʈ������ �ϳ��� ���� ������ ������ O(logN)�� �ð��� �ɷȴ�. 
			//�� �˰����� Ȱ���Ͽ� ������ ������ �����ϸ� (c-b+1)��ŭ �����ؾ��ϹǷ� O(NlogN)��ŭ �ɸ��� �ǰ� TLE�� �ȴ�.
			//�̰��� �ذ��ϱ� ���� Lazy Propagation�� Ȱ���ؾ��Ѵ�. O(logN)^2�� �ɸ���.
			if(a == 1) {
				long d = Long.parseLong(st.nextToken());
				updateRange(1, 1, N, b, c, d); // b��° ������ c��° ���� d�� ���Ѵ�.
			} else {
				System.out.println(sum(1, 1, N, b, c)); //b���� ������ c��° ������ ���� ���Ѵ�.
			}
		}
	}
}
