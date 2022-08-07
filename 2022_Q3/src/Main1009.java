import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 1009 부하분산
public class Main1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int ts = 1; ts <= T; ts++) {
            int a = sc.nextInt() % 10; // 1의 자리
            int b = sc.nextInt();

            List<Integer> list = new ArrayList<>();
            list.add(a);
            int num = a;
            while(true) {
                num = (num * a) % 10;
                if(list.get(0) == num) break;
                list.add(num);
            }
            int ans = list.get((b-1)%list.size());
            if(ans == 0) System.out.println("10");
            else System.out.println(ans);
        }
    }
}