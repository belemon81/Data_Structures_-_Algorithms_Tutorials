package Tutorial.Tut5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Exercise1 {
    public static class List {
        String name;
        int mark;
        public List(String name, int mark) {
            this.name = name;
            this.mark = mark;
        }
    }
    public static void sortScore(ArrayList<List> list) {
        list.sort(new Comparator<List>() {
            @Override
            public int compare(List student1, List student2) {
                return Double.compare(student2.mark, student1.mark);
            }
        });
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = sc.nextInt(); sc.nextLine();
        ArrayList<List> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Input name of student " + (i + 1) + ": ");
            String name=sc.nextLine();
            System.out.print("Input score of student " + (i + 1) + ": ");
            int mark=sc.nextInt(); sc.nextLine();
            List student=new List(name,mark);
            students.add(student);
        }
        System.out.print("\nInput m: ");
        int m = sc.nextInt(); sc.nextLine();
        sortScore(students);
        System.out.println("The name of " + m + " students who has the highest mark: ");
        for (int i = 0; i < m; i++) {
            System.out.println((i+1) + ". " + students.get(i).name);
        }
    }
}
