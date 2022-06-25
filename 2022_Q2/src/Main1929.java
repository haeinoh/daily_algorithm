import java.util.Scanner;

public class Main1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] vtd = new boolean[N+1]; 
        vtd[0] = vtd[1] = true;
        for(int i = 2; i <= Math.sqrt(N); i++) {
//            if(vtd[i]) continue;
            for(int j = i; (i*j) <= N; j++) {
                vtd[i*j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = M; i <= N; i++) if(!vtd[i]) sb.append(i).append("\n");

        System.out.println(sb.toString());
    }
}
