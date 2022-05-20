import java.util.*;
class Wedding implements Comparable<Wedding>{
    public int time;
    public char state;
    Wedding(int time, char state) {
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Wedding ob){
        if(this.time == ob.time) return this.state - ob.state;
        else return this.time - ob.time;
    }
}

class Main903 {
    public static int solution(ArrayList<Wedding> arr){
        int answer=Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for(Wedding ob : arr){
            if(ob.state=='s') cnt++;
            else cnt--;
            answer=Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Wedding> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int sT = sc.nextInt();
            int eT = sc.nextInt();
            arr.add(new Wedding(sT, 's'));
            arr.add(new Wedding(eT, 'e'));
        }
        System.out.println(solution(arr));
    }
}