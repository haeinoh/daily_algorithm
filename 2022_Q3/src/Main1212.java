import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main1212 {
    public static String[] arr =  {"000", "001", "010", "011", "100", "101", "110", "111"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String octal = sc.next();

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < octal.length(); i++) {
            int ch = octal.charAt(i) - '0';
            for(int j = 0; j < arr[ch].length(); j++) list.add(arr[ch].charAt(j)-'0');
        }

        boolean flag = false;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == 1) {
                flag = true;
            }

            if(flag) {
                sb.append(list.get(i));
            }
        }
        if(octal.equals("0")) System.out.println("0");
        else System.out.println(sb.toString());
    }
}
