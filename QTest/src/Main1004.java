import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Brick implements Comparable<Brick>{
    public int s, h, w;
    Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Brick o){
        return o.s-this.s;
    }
}
public class Main1004 {
    public static int N;
    public static int[] memo;
    public static ArrayList<Brick> arr;
    public static int solve() {
        int answer = 0;
        Collections.sort(arr);
        memo[0] = arr.get(0).h;
        answer = memo[0];

        for(int i = 1; i < N; i++) {
            int maxHeight = 0;
            for(int j = i-1; j >= 0 ;j--) {
                if(arr.get(i).w < arr.get(j).w && memo[j] > maxHeight) {
                    maxHeight = memo[j];
                }
            }
            memo[i] = maxHeight + arr.get(i).h;
            answer = Math.max(answer, memo[i]);
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new ArrayList<>();
        memo = new int[N];

        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Brick(a, b, c));
        }
        System.out.println(solve());
    }
}
