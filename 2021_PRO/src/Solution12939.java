import java.util.Arrays;

public class Solution12939 {
    public static String solution(String s) {
        String answer = "";
        String[] tmp = s.split(" ");
        int[] arr = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++) arr[i] = Integer.parseInt(tmp[i]);
        Arrays.sort(arr);
        answer += arr[0] + " " + arr[arr.length-1];
        return answer;
    }

    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        System.out.println(solution(s));
    }
}
