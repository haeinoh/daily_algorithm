import java.util.Scanner;

public class Main4539 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            String answer = "";
            int real = Integer.parseInt(tmp);
            int idx = 1;
            for(int j = tmp.length() - 1; j > 0; j--) {
                int val = Character.getNumericValue(tmp.charAt(j));
                if(val >= 5) real += (int) Math.pow(10, idx);
                idx++;
                answer += "0";
                tmp = String.valueOf(real);
            }
            answer = (real/(int)Math.pow(10, tmp.length()-1)) + answer;
            System.out.println(answer);
        }
    }
}
