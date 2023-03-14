import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4641 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int n = sc.nextInt();
            if(n == -1) break;
            List<Integer> list = new ArrayList<>();
            list.add(n);
            while(true) {
                int a = sc.nextInt();
                if(a == 0) break;
                list.add(a);
            }

            int count = 0;
            for(int i = 0; i < list.size(); i++) {
                for(int j = 0; j < list.size(); j++) {
                    if(i != j && list.get(i) * 2 == list.get(j)) count++;
                }
            }
            System.out.println(count);
        }
    }
}
