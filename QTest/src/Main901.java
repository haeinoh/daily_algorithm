import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Body implements Comparable<Body>{
    public int h, w;

    public Body(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Body o) {
        return o.h - this.h;
    }
}
public class Main901 {
    public static int solve(ArrayList<Body> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for(Body ob : arr) {

            if(ob.w > max) {
                max = ob.w;
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h, w));
        }
        System.out.println(solve(arr, N));
    }
}
