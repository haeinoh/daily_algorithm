import java.util.Scanner;

public class Main3449 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            int count = 0;
            sb.append("Hamming distance is ");
            for(int j = 0; j < b.length(); j++) if(a.charAt(j) != b.charAt(j)) count++;
            sb.append(count).append(".\n");
        }
        System.out.println(sb.toString());
    }
}
