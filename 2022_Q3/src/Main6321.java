import java.util.Scanner;

public class Main6321 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            String str = sc.next();
            sb.append("String #").append(i).append("\n");
            for(int j = 0; j < str.length(); j++) {
                char ch = (char) (str.charAt(j) + 1);
                if(str.charAt(j) == 'Z') sb.append("A");
                else sb.append(ch);
            }
            sb.append("\n\n");
        }
        System.out.println(sb.toString());
    }
}
