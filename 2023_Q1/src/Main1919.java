import java.util.Scanner;

public class Main1919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int[] aa = new int[27];
        int[] bb = new int[27];

        for(int i = 0; i < a.length(); i++) aa[a.charAt(i)-'0'-49]++;
        for(int i = 0; i < b.length(); i++) bb[b.charAt(i)-'0'-49]++;

        int count = 0;
        for(int i = 0; i < aa.length; i++) {
            if(aa[i] != bb[i]) count += Math.abs(aa[i] - bb[i]);
        }
        System.out.println(count);
    }
}
