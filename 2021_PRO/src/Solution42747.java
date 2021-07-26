import java.util.Arrays;

public class Solution42747 {
    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int index = citations.length % 2 == 0 ? citations.length/2-1 : citations.length/2;
        int h = citations.length - index;

        boolean flag = false;
        while(true) {
            if(index >= citations.length) break;
            if(citations[index] >= h) {
                if(index == 0) break;
                else index--;
                h++;
                flag = true;
            } else {
                if(flag) {
                    h--;
                    break;
                } else {
                    index++;
                    h = citations.length - index;
                }
            }
        }
        return h;
    }
    public static void main(String[] args) {
        int[] c = {0, 0, 1, 0, 0};
        System.out.println(solution(c));
    }
}