import java.util.Scanner;

public class Main1296 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = new char[4];
        str[0] = 'L';
        str[1] = 'O';
        str[2] = 'V';
        str[3] = 'E';

        String yeondu = sc.next();
        int n = sc.nextInt();

        String answer = "";
        int count = -1;

        int[] yy = new int[str.length];

        for(int j = 0; j < str.length; j++) {
            int len = yeondu.length();
            if(yeondu.contains(String.valueOf(str[j]))) yeondu = yeondu.replaceAll(String.valueOf(str[j]), "");
            yy[j] = len - yeondu.length();
        }

        for(int i = 0; i < n; i++) {
            String word = sc.next();
            String tmp = word;
            int[] arr = new int[str.length];

            for(int j = 0; j < str.length; j++) {
                int len = tmp.length();
                if(tmp.contains(String.valueOf(str[j]))) tmp = tmp.replaceAll(String.valueOf(str[j]), "");
                arr[j] = len - tmp.length();
                arr[j] += yy[j];
            }

            int sum = 1;

            for(int j = 0; j < str.length; j++) {
                for(int k = j+1; k < str.length; k++) {
                    sum *= (arr[j]+arr[k]);
                }
            }

            sum %= 100;
            if(count <  sum) {
                count = sum;
                answer = word;
            } else if(count == sum) {
                if(answer.compareTo(word) > 0) answer = word;
            }
        }
        System.out.println(answer);
    }
}
