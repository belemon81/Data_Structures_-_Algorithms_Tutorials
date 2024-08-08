package Tutorial.Tut5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Exercise2 {
    public static void sortString(ArrayList<String> list, int index) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String student1, String student2) {
                return Integer.compare(student1.charAt(index), student2.charAt(index));
            }
        });
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = sc.nextInt(); sc.nextLine();
        System.out.print("Input m: ");
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Input string " + (i+1) + ": ");
            String str = sc.nextLine().substring(0, m);
            strings.add(str);
        }
        for (int i = m-1; i >=0; i--) {
            sortString(strings,i);
        }
        System.out.println("The sorted String: ");
        for (int i = 0; i < n; i++) {
            System.out.println(strings.get(i));
        }
    }
}
