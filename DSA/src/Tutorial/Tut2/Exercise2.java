//The Big-Oh of the new algorithm: O(n)

package Tutorial.Tut2;
import java.util.Scanner;
public class Exercise2 {
    public static void print_poly(double[] c) {
        System.out.print("The polynomial is: ");
        for(int i = c.length - 1; i > 0; --i) {
            if (i != 1) {
                System.out.print(c[i] + "*x^" + i + " + ");
            } else {
                System.out.print(c[i] + "*x" + " + ");
            }
        }
        System.out.println(c[0]);
    }
    //The Big-Oh of the new algorithm: O(n)
    public static double Evaluate(double[] c, double x) {
        double s = 0.0D, p = 1.0D;
        for(int i = 0; i < c.length; ++i) {
            s += c[i] * p;
            p = p * x;
        }
        return s;
    }
    public static void main(String[] args) {
        System.out.print("Please enter the degree n of the polynomial: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] c = new double[n + 1];
        for(int i = 0; i < c.length; ++i) {
            System.out.print("Please enter the coefficient c[" + i + "]: ");
            c[i] = scanner.nextDouble();
            scanner.nextLine();
        }
        print_poly(c);
        System.out.print("Please enter the value of x: ");
        double x = scanner.nextDouble(); scanner.nextLine();
        System.out.println("The value P(" + x + ") = " + Evaluate(c, x));
    }
}
