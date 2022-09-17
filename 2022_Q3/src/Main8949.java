import java.util.Scanner;

public class Main8949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int asize = a.length() - 1;
        int bsize = b.length() - 1;

        String answer = "";

        while(asize >= 0 && bsize >= 0) {
            answer = ((a.charAt(asize) - '0') + (b.charAt(bsize) - '0')) + answer;
            asize--;
            bsize--;
        }

        if(asize >= 0) for(int i = asize; i >= 0; i--) answer = (a.charAt(i) - '0') + answer;
        if(bsize >= 0) for(int i = bsize; i >= 0; i--) answer = (b.charAt(i) - '0') + answer;

        System.out.println(answer);
    }
}
