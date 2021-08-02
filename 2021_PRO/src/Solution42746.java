import java.util.Arrays;
import java.util.Comparator;

public class Solution42746 {

    static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] arr = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++) arr[i] = String.valueOf(numbers[i]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2); //내림차순
            }
        });

        if(arr[0].equals("0")) return "0";
        for(String str: arr) answer.append(str);
        return answer.toString();
    }
    public static void main(String[] args) {
        int[] n = {3, 30, 34, 9, 6};
        System.out.println(solution(n));
    }
}
