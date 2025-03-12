import java.util.Scanner;

public class FibonacciWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();
        
        int a = 0, b = 1, i = 1;
        while (i <= n) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
            i++;
        }
    }
}
