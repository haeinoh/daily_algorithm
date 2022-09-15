import java.util.Arrays;

public class Solution118666 {
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        String mbti = "RTCFJMAN";
        int[] arr = new int[mbti.length()];

        for(int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            int value = choices[i];

            if(value>= 5) {
                value -= 4;
                arr[mbti.indexOf(agree)] += value;
            }
            else if(value < 4) {
                if(value != 2) value = value == 3 ? 1 : 3;
                arr[mbti.indexOf(disagree)] += value;
            }
        }

        for(int i = 0; i < arr.length; i+=2) {
            if(arr[i] >= arr[i+1]) answer += mbti.charAt(i);
            else answer += mbti.charAt(i+1);
        }


        return answer;
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(solution(survey, choices));
    }
}
