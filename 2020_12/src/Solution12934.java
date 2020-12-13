import java.math.BigDecimal;

public class Solution12934 {
	public static void main(String[] args) {
		long n = 121;
		BigDecimal dec = new BigDecimal(Math.sqrt(n));
		BigDecimal check = dec.movePointRight(0);
		if(check.scale() == 0) System.out.println((long)Math.pow((Math.sqrt(n)+1), 2));
		else System.out.println("-1");
	}
}
