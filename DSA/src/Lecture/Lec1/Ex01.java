package Lecture.Lec1;

import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input 1st floating-point number: ");
        double numberOne = scanner.nextDouble();
        System.out.print("Input 2nd floating-point number: ");
        double numberTwo = scanner.nextDouble();

        numberOne = Math.round(numberOne * 1000);
        numberOne = numberOne / 1000;

        System.out.println(numberOne);


        numberTwo = Math.round(numberTwo * 1000);
        numberTwo = numberTwo / 1000;

        System.out.println(numberTwo);

        if (numberOne == numberTwo) {
            System.out.println("Two numbers are the same up to three decimal places");
        } else {
            System.out.println("Two numbers are different");
        }
    }
}