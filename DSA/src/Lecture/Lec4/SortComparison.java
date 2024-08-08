package Lecture.Lec4;
import java.util.Random;
public class SortComparison {
    // insert the greatest to the right
    public static void Selection_Sort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int max = a[i], pos = i;
            for (int j = i - 1; j >= 0; j--) {
                if (max < a[j]) {
                    max = a[j]; pos = j;
                }
            }
            a[pos] = a[i]; a[i] = max;
        }
    }

    /**
     * 1 3 2 5 1
     * j=1 -> 1 3 2 5 1
     * j=2 -> 1 2 2 5 1 -> 1 2 3 5 1
     * j=3 -> 1 2 3 5 1
     * j=4 -> 1 2 3 5 5 -> 1 2 3 3 5 -> 1 2 2 3 5 -> 1 1 2 3 5
     */
    //insert the elements its range between
    public static void Insertion_Sort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j], i = j - 1;
            while ((i >= 0) && (a[i] > key)) {
                a[i + 1] = a[i]; i--;
            }
            a[i + 1] = key;
        }
    }

    /**
     * e.g. 5 1 4 3
     * (1) isSorted=true; i=0; 1 5 4 3; isSorted=false
     * i=1; 1 4 5 3; isSorted=false
     * i=2; 1 4 3 5; isSorted=false
     * (2) isSorted=true; i=0; 1 4 3 5;
     * i=1; 1 3 4 5; isSorted=false
     * (3) isSorted=true; i=0; 1 3 4 5;
     * ---> 1 3 4 5;
     */
    //swap each pair
    public static void Bubble_Sort(int[] a) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < a.length - 1; i++)
                if (a[i] > a[i + 1]) {
                    int tmp = a[i]; a[i] = a[i + 1]; a[i + 1] = tmp;
                    isSorted = false;
                }
        }
    }

    /**
     * e.g. 5 1 4 7 2
     * Merge_Sort(a, 0, 4)
     *      left=0; right=4; mid=2;
     *      Merge_Sort(a, 0, 2)
     *          mid = 1;
     *          Merge_Sort(a, 0, 1)
     *              mid = 0;
     *              Merge_Sort(a, 0, 0);
     *              Merge_Sort(a, 1, 1);
     *              *Merge(a, 0, 0, 1)     :c[2]; i=0; j=1; k=0; {1} {5}
     *                                  -> c[2] = {1;5}; k=2;
     *                                  -> a = {1;5;4;7;2}
     *          Merge_Sort(a, 2, 2)
     *          *Merge(a, 0, 1, 2)          :c[3]; i=0; j=1; k=0; {1;5} {4}
     *                                  -> c[3] = {1;4;5}; k=3;
     *                                  -> a = {1;4;5;7;2}
     *      Merge_Sort(a, 3, 4)
     *          mid = 3;
     *          Merge_Sort(a, 3, 3)
     *          Merge_Sort(a, 4, 4)
     *          *Merge(a, 3, 3, 4)         :c[2]; i=3; j=4; k=0; {7} {2}
     *                                  -> c[2] = {2;7}; k=2;
     *                                  -> a = {1;4;5;2;7}
     *      *Merge(a, 0, 2, 4)             :c[5]; i=0; j=2; k=0; {1;4;5} {2;7}; k=5;
     *                                  -> c[5] = {1;2;4;5;7}
     *                                  -> a = {1;2;4;5;7}
     */
    //pick up and lie out
    public static void Merge(int[] a, int left, int mid, int right) {
        int[] c = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while ((i <= mid) && (j <= right)) {
            if (a[i] < a[j]) {
                c[k] = a[i]; i++;
            } else {
                c[k] = a[j]; j++;
            }
            k++;
        }
        for (int t = i; t <= mid; t++) {
            c[k] = a[t]; k++;
        }
        for (int t = j; t <= right; t++) {
            c[k] = a[t]; k++;
        }
        for (int t = 0; t < k; t++) a[left + t] = c[t];
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
        int[] data;
        int[] a;
        n = 1000;
        data = new int[n];
        a = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = rand.nextInt(65000) + 1;
        }
        for (int i = 0; i < n; i++) {
            a[i] = data[i];
        }
        long startTime, stopTime, elapsedTime;
        System.out.println("Sorting a list of " + n + " random integers using Selection sort algorithm ...");
        startTime = System.currentTimeMillis();
        Selection_Sort(a);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("Algorithm took : " + elapsedTime + " milliseconds to finish");
        for (int i = 0; i < n; i++) {
            a[i] = data[i];
        }
        System.out.println("Sorting a list of " + n + " random integers using Insertion sort algorithm ...");
        startTime = System.currentTimeMillis();
        Insertion_Sort(a);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("Algorithm took : " + elapsedTime + " milliseconds to finish");
        for (int i = 0; i < n; i++) {
            a[i] = data[i];
        }
        System.out.println("Sorting a list of " + n + " random integers using Bubble sort algorithm ...");
        startTime = System.currentTimeMillis();
        Bubble_Sort(a);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("Algorithm took : " + elapsedTime + " milliseconds to finish");
        for (int i = 0; i < n; i++) {
            a[i] = data[i];
        }
        System.out.println("Sorting a list of " + n + " random integers using Merge sort algorithm ...");
        startTime = System.currentTimeMillis();
        Merge_Sort(a, 0, n - 1);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("Algorithm took : " + elapsedTime + " milliseconds to finish");
    }
}
