import java.util.Arrays;

public class Solution77885 {
    /*
    //프로그래머스 다른 사람 풀이
    long[] a = numbers.clone();
    for(int i = 0; i< a.length; i++){
        a[i]++;
        a[i] += (a[i]^numbers[i])>>>2;
    }*/
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0 || numbers[i] % 4 == 1) answer[i] = numbers[i] + 1;
            else {
                String val = Long.toBinaryString(numbers[i]);
                if ((numbers[i] + 1) % 4 == 0) val = "0" + val;
                int index = val.lastIndexOf("01");
                val = val.substring(0, index) + "10" + val.substring(index + 2);
                answer[i] = Long.parseLong(val, 2);
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        long[] n = {2, 7};
        System.out.println(Arrays.toString(solution(n)));
    }
}
