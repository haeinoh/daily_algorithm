public class Solution76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++) answer += (signs[i] == true) ? +absolutes[i] : -absolutes[i];
        return answer;
    }
    public static void main(String[] args) {
        System.out.println();
    }
}