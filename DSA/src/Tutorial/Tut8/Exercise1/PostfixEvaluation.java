package Tutorial.Tut8.Exercise1;

import java.util.Scanner;

public class PostfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        String postfix = sc.nextLine();
        SLLStack s = new SLLStack();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (c >= '0' && c <= '9') {
                s.push(new StackNode(c-48));
            } else {
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    int x = s.pop().getData();
                    int y = s.pop().getData();
                    int result = 0;
                    if (c == '+') result = y + x;
                    else if (c == '-') result = y - x;
                    else if (c == '*') result = y * x;
                    else if (c == '/') result = y / x;
                    s.push(new StackNode(result));
                }
            }
        }
        System.out.println("Final result: " + s.pop().getData());
    }
}
