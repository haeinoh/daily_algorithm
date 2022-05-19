import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
class Lecture implements Comparable<Lecture>{
    public int money;
    public int time;
    Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }
    @Override
    public int compareTo(Lecture ob){
        return ob.time-this.time;
    }
}
public class Main904 {
    public static int N, max;
    public static ArrayList<Lecture> arr;
    public static int solution() {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        Collections.sort(arr);
        int j = 0;
        for(int i = max; i >= 1; i--) {
            for( ; j < N; j++) {
                if(arr.get(j).time < i) break; // 날짜가 더 적으면
                pq.offer(arr.get(j).money);
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        max = Integer.MAX_VALUE;
        arr = new ArrayList<>();
        for(int i=0; i< N; i++){
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m, d));
            if(d > max) max=d;
        }
        System.out.println(solution());
    }
}
