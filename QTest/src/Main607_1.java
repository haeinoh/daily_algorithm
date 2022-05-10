import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main607_1 {
    public static class Point implements Comparable<Point> {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(o.x == this.x) return this.y - o.y; // this - 매개변수 : -> 이 순서로 정렬 (음수값이 리턴되어야 함) this가 커야지
            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Point> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(Point o: arr) sb.append(o.x).append(" ").append(o.y);
//        for(int i = 0; i < N; i++) sb.append(arr.get(i).x).append(" ").append(arr.get(i).y);
        System.out.println(sb.toString());
    }
}
