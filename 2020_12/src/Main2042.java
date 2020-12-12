//https://www.acmicpc.net/problem/2042
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2042 {
    public static int N, M, K;
    public static long arr[], tree[];

    public static long init(int node, int start, int end) {
        if(start == end)  // ��������� �ǹ�
            return tree[node] = arr[start];

        int mid = (start + end) / 2;
        // left ,right
        return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
    }

    //idx - �ٲ� ��� ��ȣ , diff - ����
    public static void update(int node, int start, int end, int idx, long diff) {
        // index�� start�� end ���� ������ �Ѿ�� ���
        if(start > idx || idx > end) return;

        // diff��ŭ ���� �������Ƿ�, ����ü �յ� diff��ŭ ���ؾ���
        tree[node] += diff;

        if(start != end) {
            int mid = (start + end) / 2;
            update(node*2, start, mid, idx, diff);
            update(node*2+1, mid+1, end, idx, diff);
        }
    }

    public static long sum(int node, int start, int end, int left, int right) {
        if(left > end || right < start) return 0;

        if(left <= start && right >= end) return tree[node];

        int mid = (start + end) / 2;

        return sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1,end, left, right);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N+1];
        for(int i = 1; i <= N; i++) { // ��Ʈ�� 1���� �����Ѵ�
            st = new StringTokenizer(bf.readLine().trim());
            arr[i] = Long.parseLong(st.nextToken());
        }

        tree = new long[N*4];

        init(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M+K; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());


            if(a == 1) { // update
                long diff = c - arr[b];
                arr[b] = c; 
                update(1,1,N,b,diff);
            } else { // sum
                long answer = sum(1, 1, N, b, (int)c);
                sb.append(answer + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}