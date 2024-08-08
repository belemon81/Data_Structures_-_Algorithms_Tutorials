//The Big-Oh of the new algorithm: O(logn)

package Tutorial.Tut2;
import java.util.Scanner;
public class Exercise4 {
    //The Big-Oh of the new algorithm: O(logn)
    public static int GCD(int m, int n) {
        int mediator;
        while (n!=0) {
            mediator=m%n;
            m=n;
            n=mediator;
        }
        return m;
    }
    public static void main(String[] args) {
        System.out.print("Please enter the integer m:");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(); scanner.nextLine();
        System.out.print("Please enter the integer n (n<=m):");
        int n = scanner.nextInt(); scanner.nextLine();
        System.out.print("The gcd(" + m + "," + n + ") is: " + GCD(m, n));
        scanner.close();
    }
}