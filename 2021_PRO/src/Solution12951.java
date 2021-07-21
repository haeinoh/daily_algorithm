import java.util.Arrays;

public class Solution12951 {
    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        if(s.length() == 0) return "";
        String[] arr = s.toLowerCase().split(" ");
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].length() > 0) {
                answer.append(arr[i].replaceFirst(String.valueOf(arr[i].charAt(0)), String.valueOf(arr[i].charAt(0)).toUpperCase()));
                answer.append((i == arr.length - 1 && s.charAt(s.length() - 1) != ' ') ? "" : " ");
            } else answer.append(" ");
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        String s = "aaaa   aa a aaa a a a ";
//        String s = "3people unFo d ef llowed me y";
        System.out.println(solution(s));
    }
}
