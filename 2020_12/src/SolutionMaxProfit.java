
public class SolutionMaxProfit {
	public static int maxProfit(int[] prices) {
		int answer = -987654321;
		
		for(int i = 0; i < prices.length; i++) {
			for(int j = i+1; j < prices.length; j++) {
				if((prices[j] - prices[i]) > answer) answer = prices[j] - prices[i];
			}
		}
		if(answer < 0) answer = 0;
		return answer;
	}
	 
	public static void main(String[] args) {
		int p[] = {7, 6, 4, 3, 1};
		System.out.println(maxProfit(p));
	}
}
