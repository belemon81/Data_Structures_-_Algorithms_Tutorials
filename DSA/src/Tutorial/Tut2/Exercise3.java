//The Big-Oh of the new algorithm: O(logn)

package Tutorial.Tut2;
import java.util.Scanner;
public class Exercise3 {
    //The Big-Oh of the new algorithm: O(logn)
    public static double Pow(double x, int n) {
        if (n==0) return 1;
        if (n==1) return x;
        if (n%2==0) {
            return Pow(x*x,n/2);
        } else {
            return x*Pow(x*x,(n-1)/2);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the value of x:");
        double x = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Please enter the degree n:");
        int n = scanner.nextInt();scanner.nextLine();
        System.out.println("The value of (" + x + ")^" + n + " is: " + Pow(x, n));
    }
}