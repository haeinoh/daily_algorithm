public class Solution42883 {
    static String solution(String number, int k) {
        int[] num = new int[number.length()];
        for(int i = 0; i < number.length(); i++) num[i] = Character.getNumericValue(number.charAt(i));
        StringBuilder answer = new StringBuilder();

        int len = number.length() - k;
        int idx = -1;
        while(true) {
            int max = -987654321;
            boolean flag = false;
            for(int j = idx+1; j <= number.length()-len; j++) {
                if(max < num[j]) {
                    flag = true;
                    max = num[j];
                    idx = j;
                }
            }
            len--;
            if(flag) answer.append(max);
            if(!flag || len == 0) {
                for(int p = idx+1; p < idx+1+len; p++) {
                    answer.append(num[p]);
                }
                break;
            }
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        String n = "4177252841";
        int nn = 4;
        System.out.println(solution(n, nn));
    }
}
