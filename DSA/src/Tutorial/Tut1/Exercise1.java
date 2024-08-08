package Tutorial.Tut1;

import java.util.Scanner;

public class Exercise1 {
    public static int countChars(String s) {
        int count=0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)!=' ') {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Please enter a name (containing characters and spaces): ");
        String name=sc.nextLine();
        System.out.println("The name has " + countChars(name) + " characters (exclusive the spaces)");
    }
}
