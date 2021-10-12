import java.util.*;

public class Solution42627 {
    public static class Disk {
        int request;
        int working;

        public Disk(int request, int working) {
            this.request = request;
            this.working = working;
        }
    }
    public static int solution(int[][] jobs) {
        LinkedList<Disk> list = new LinkedList<>();

        PriorityQueue<Disk> pq = new PriorityQueue<>(new Comparator<>(){
           @Override
           public int compare(Disk o1, Disk o2) {
               return o1.working - o2.working;
           }
        });

        for(int j[]: jobs) list.offer(new Disk(j[0], j[1]));

        Collections.sort(list, new Comparator<Disk>(){
            @Override
            public int compare(Disk o1, Disk o2) {
                return o1.request - o2.request;
            }
        });

        int answer = 0;
        int time = list.peek().request;
        int count = 0;
        while(count < jobs.length) {
            while(!list.isEmpty() && list.peek().request <= time) {
                System.out.println(list.peek().request);
                pq.offer(list.pollFirst());
            }

            if(!pq.isEmpty()) {
                Disk disk = pq.poll();
                time += disk.working;
                answer += (time - disk.request);
                count++;
            } else time++;
        }


        return answer/jobs.length;
    }

    public static void main(String[] args) {
        int[][] j = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(j));
    }
}
