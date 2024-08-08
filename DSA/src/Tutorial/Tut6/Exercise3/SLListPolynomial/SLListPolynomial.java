package Tutorial.Tut6.Exercise3.SLListPolynomial;

import java.util.Scanner;

public class SLListPolynomial {
    public static void main(String[] args) {
        System.out.print("Please enter the degree n of the polynomial: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); scanner.nextLine();
        SLList polynomial = new SLList();
        for (int i = 0; i <= n; i++) {
            System.out.print("Please enter the coefficient of the degree " + i + ": ");
            double coefficient = scanner.nextDouble(); scanner.nextLine();
            polynomial.add(new SLNode(coefficient, i));
        }
        polynomial.printPolynomial();
        System.out.print("Please enter the value of x: ");
        double x = scanner.nextDouble(); scanner.nextLine();
        System.out.println("The value P(" + x + ") = " + polynomial.EvaluateP(x));
    }
}
