import java.util.Scanner;

public class Main3062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            StringBuilder str = new StringBuilder(sc.next());
            int val = Integer.parseInt(str.toString()) + Integer.parseInt(str.reverse().toString());
            StringBuilder ans = new StringBuilder(String.valueOf(val));
            if(ans.toString().equals(ans.reverse().toString())) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
