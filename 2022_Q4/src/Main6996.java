import java.util.Scanner;

public class Main6996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();

            int[] aa = new int[27];
            int[] bb = new int[27];

            for(int j = 0; j < a.length(); j++) aa[a.charAt(j)-'a']++;
            for(int j = 0; j < b.length(); j++) bb[b.charAt(j)-'a']++;

            boolean flag = false;
            for(int j = 0; j < 27; j++) {
                if(aa[j] != bb[j]) {
                    flag = true;
                    break;
                }
            }
            sb.append(a).append(" & ").append(b);
            if(flag) sb.append(" are NOT anagrams");
            else sb.append(" are anagrams.");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
