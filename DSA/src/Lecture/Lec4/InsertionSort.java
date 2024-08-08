package Lecture.Lec4;

import java.util.Scanner;

public class InsertionSort {
    public static void print_array(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }

    public static void Insertion_Sort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j], i = j - 1;
            while ((i >= 0) && (a[i] > key)) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = key;
        }
    }

    public static void main(String[] args) {
        int n;
        int[] a;
        System.out.println("Please input the integer N:");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Please input the integer a[" + i + "]:");
            a[i] = scanner.nextInt();
        }
        System.out.println("The list of integers is: ");
        print_array(a);
        Insertion_Sort(a);
        System.out.println("The list of sorted integers is: ");
        print_array(a);
    }
}