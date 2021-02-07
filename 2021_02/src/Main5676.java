import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main5676 {
    public static int N, K, arr[], tree[];

    public static int init(int node, int start, int end) {
        // leaf node
        if(start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;

        return tree[node] = init(node*2, start, mid) * init(node*2+1, mid+1, end);
    }

    public static void update(int node, int start, int end, int idx, int change) {
        // idx out of range
        if(start > idx || end < idx) return;

        // leaf node
        if(start == end) {
            tree[node] = change;
            return;
        }
        // not leaf node
        if(start != end) {
            int mid = (start + end) / 2;
            update(node*2, start, mid, idx, change);
            update(node*2+1, mid+1, end, idx, change);
            tree[node] = tree[2*node] * tree[2*node+1];
        }
    }

    public static long multiple(int node, int start, int end, int left, int right) {
        // 1) left, right가 start, end 범위를 완전히 벗어났을 때
        if(left > end || right < start) return 1;

        // 2) left, right가 start, end를 완전히 포함하는 경우
        if(left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return multiple(node*2, start, mid, left, right) *
                multiple(node*2+1,mid+1, end, left, right);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while((temp = bf.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(temp);
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N+1];
            tree = new int[N*4];
            st = new StringTokenizer(bf.readLine());
            // 루트 노드는 1부터 시작한다.
            for(int i = 1; i <= N; i++) {
                int x = Integer.parseInt(st.nextToken());
                if(x > 0) arr[i] = 1;
                else if(x < 0) arr[i] = -1;
                else arr[i] = 0;
            }
            // init
            init(1, 1, N);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < K; i++) {
               st = new StringTokenizer(bf.readLine());
               String order = st.nextToken();
               int a = Integer.parseInt(st.nextToken());
               int b = Integer.parseInt(st.nextToken());

               if(order.equals("C")) { // change arr[a] <- b
                    if(b > 0) b = 1;
                    else if(b < 0) b = -1;
                    arr[a] = b;
                    update(1, 1, N, a, b);
               } else { // delete
                    long answer = multiple(1, 1, N, a, b);
                    if(answer > 0) sb.append("+");
                    else if(answer < 0) sb.append("-");
                    else sb.append("0");
               }
            }
            System.out.println(sb.toString());
        }
    }
}
