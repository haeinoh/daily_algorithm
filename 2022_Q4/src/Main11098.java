import java.util.Scanner;

public class Main11098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++) {
            int n = sc.nextInt();

            int max = 0;
            String name = "";
            for(int i = 0; i < n; i++) {
                int value = sc.nextInt();
                String str = sc.next();

                if(max < value) {
                    max = value;
                    name = str;
                }
            }
            sb.append(name).append("\n");
        }
        System.out.println(sb.toString());
    }

}
