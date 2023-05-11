import java.util.Scanner;

public class Main11328 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int[] aa = new int[26];
            int[] bb = new int[26];
            String a = sc.next();
            String b = sc.next();

            for(int j = 0; j < a.length(); j++) aa[(int)(a.charAt(j) - 'a')]++;
            for(int j = 0; j < b.length(); j++) bb[(int)(b.charAt(j) - 'a')]++;

            boolean flag = false;
            for(int j = 0; j < aa.length; j++) {
                if(aa[j] != bb[j]) {
                    flag = true;
                    break;
                }
            }
            if(!flag) System.out.println("Possible");
            else System.out.println("Impossible");
        }
    }
}
