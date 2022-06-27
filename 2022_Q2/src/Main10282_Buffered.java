import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main10282_Buffered {
    public static class Hacking implements Comparable<Hacking>{
        int com;
        int seconds;

        public Hacking(int com, int seconds) {
            this.com = com;
            this.seconds = seconds;
        }

        @Override
        public int compareTo(Hacking o) {
            return this.seconds - o.seconds;
        }
    }
    public static List<List<Hacking>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());


        for(int ts = 1; ts <= T; ts++) {
            st = new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            //init
            for(int i = 0 ; i <= n; i++) list.add(new ArrayList<>());

            // d
            for(int i = 0; i < d; i++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list.get(b).add(new Hacking(a, s));
            }

            int answer = 1;
            PriorityQueue<Hacking> pq = new PriorityQueue<>();
            pq.add(new Hacking(c, 0));

            int[] dist = new int[n+1];
            Arrays.fill(dist, 987654321);
            dist[c] = 0;
            boolean[] vtd = new boolean[n+1];
            while(!pq.isEmpty()) {
                Hacking tmp = pq.poll();

                if(vtd[tmp.com]) continue;
                vtd[tmp.com] = true;

                for(Hacking h: list.get(tmp.com)) {
                    if(dist[h.com] > h.seconds + dist[tmp.com]) {
                        dist[h.com] = h.seconds + dist[tmp.com];
                        pq.add(new Hacking(h.com, dist[h.com]));
                    }
                }
            }

            int max = 0;
            for(int i = 1; i <= n; i++) {
                if(i != c && dist[i] != 987654321) {
                    answer++;
                    max = Math.max(max, dist[i]);
                }
            }

            System.out.println(answer + " " + max);
        }
    }
}
