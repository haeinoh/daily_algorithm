import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main13913 {
    public static int N, K;
    public static int[] dir = {-1, 1, 2};
    public static boolean[] vtd;
    public static int[] arr;
    public static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        vtd = new boolean[100001];
        arr = new int[100001];
        q = new LinkedList<>();
        q.add(N);
        vtd[N] = true;
        int count = 0;
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        if(N == K) {
            sb.append(N);
        } else {
            loop:while(!q.isEmpty()) {
                int size = q.size();
                while(size > 0) {
                    int xx = q.poll();

                    int nx = 0;
                    for(int i = 0; i < 3; i++) {
                        if(i == 2) {
                            nx = xx * dir[i];
                        } else {
                            nx = xx + dir[i];
                        }

                        if(nx < 0 || nx > 100000 || vtd[nx]) continue;

                        arr[nx] = xx;
                        if(nx == K) {
                            count++;
                            int start = nx;
                            s.push(nx);
                            while(start != N) {
                                s.push(arr[start]);
                                start = arr[start];
                            }
                            break loop;
                        }
                        vtd[nx] = true;
                        q.add(nx);
                    }
                    size--;
                }
                count++;
            }
        }

        while(!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
}
