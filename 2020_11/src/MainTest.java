
public class MainTest {
	static void align(int a[]) {
		int temp ;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4-i; j++) {
				if(a[j] > a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			for(int x = 0; x < 5; x++) {
				System.out.print(a[x] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int a[] = {7, 4, 5, 1, 3};
		align(a);
	}
}
