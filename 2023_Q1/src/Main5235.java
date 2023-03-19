import java.util.Scanner;

public class Main5235 {
    private static int checkEvenSumMoreThanOddSum(int[] sequence) {

        /* Return value (ret) should be set to 1 if the sum of even numbers
         * is larger than the sum of odd numbers in the sequence,
         * to -1 if the reverse is true, and to 0 if the two sums are identical */

        /* ------------------- INSERT CODE HERE ---------------------*/
        int even = 0;
        int odd = 0;
        for(int i = 0; i < sequence.length; i++) {
            if(sequence[i] % 2 == 0) even += sequence[i];
            else odd += sequence[i];
        }

        /* -------------------- END OF INSERTION --------------------*/
        return even-odd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();

        for(int i = 0; i < numCases; i++)
        {
            int lengthOfSequence = sc.nextInt();

            int [] sequence = new int[lengthOfSequence];

            for(int j = 0; j < lengthOfSequence; j++) {
                sequence[j] = sc.nextInt();
            }

            int res = checkEvenSumMoreThanOddSum(sequence);
            if(res > 0) {
                System.out.println("EVEN");
            } else {
                if(res < 0) {
                    System.out.println("ODD");
                } else {
                    System.out.println("TIE");
                }
            }
        }
    }
}
