package Tutorial.Tut10.Exercise2;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree t = new BinarySearchTree();
        System.out.print("Input n = ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Input array: ");
        int[] A = new int[n];
        for (int i = 0; i < A.length; i++) {
            System.out.print("A[" + i + "] = ");
            A[i] = sc.nextInt();
            sc.nextLine();
            boolean check = t.insert(A[i], t);
            if (check == false) System.out.println("! Duplicated element: " + A[i]);
        }
        System.out.println("Built tree in pre-order: ");
        t.preOrderTraversal(t);

    }
}
