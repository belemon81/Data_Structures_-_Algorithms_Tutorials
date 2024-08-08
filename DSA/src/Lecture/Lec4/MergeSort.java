package Lecture.Lec4;

import java.util.Scanner;

public class MergeSort {
    public static void print_array(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }

    public static void Merge(int[] a, int left, int mid, int right) {
        int[] c = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while ((i <= mid) && (j <= right)) {
            if (a[i] < a[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = a[j];
                j++;
            }
            k++;
        }
        //move all the items left in the array a to c
        for (int t = i; t <= mid; t++) {
            c[k] = a[t];
            k++;
        }
        for (int t = j; t <= right; t++) {
            c[k] = a[t];
            k++;
        }
        //copy c to a
        for (int t = 0; t < k; t++)
            a[left + t] = c[t];
    }

    public static void Merge_Sort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            Merge_Sort(a, left, mid);
            Merge_Sort(a, mid + 1, right);
            Merge(a, left, mid, right);
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

        Merge_Sort(a, 0, n - 1);

        System.out.println("The list of sorted integers is: ");
        print_array(a);

    }
}
