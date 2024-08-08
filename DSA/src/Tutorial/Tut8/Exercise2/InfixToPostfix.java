package Tutorial.Tut8.Exercise2;

import java.util.Scanner;

public class InfixToPostfix {
    public static void copyStack(SLLStack scr, SLLStack des) {
        SLLStack tmp = new SLLStack();
        StackNode item;
        do {
            item = scr.pop();
            if (item != null)
                tmp.push(item);
        } while (item != null);
        do {
            item = tmp.pop();
            if (item != null) {
                scr.push(item);
                des.push(item);
            }
        } while (item != null);
    }

    public static void printStack(SLLStack st) {
        SLLStack tmp = new SLLStack();
        copyStack(st,tmp);
        StackNode item;
        System.out.print("/");
        do {
            item = tmp.pop();
            if (item != null)
                System.out.print(item.getData() + " ");
        }
        while (item != null);

        System.out.println("/");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLLStack s = new SLLStack();
        System.out.print("Input: ");
        String infix = sc.nextLine();
        System.out.print("Final result: ");
        int top_precedence = 1, count = 0;
        for (int i = 0; i < infix.length(); i++) {
            //printStack(s);
            char c = infix.charAt(i);
            if (c >= '0' && c <= '9') System.out.print(c);
            else if (c == '(') {
                s.push(new StackNode(c)); top_precedence = 1;
                count++;
            } else if (c == '*' || c == '/' || c == '+' || c == '-') {
                int precedence = 1;
                if (c == '+' || c == '-') precedence = 2;
                if (c == '*' || c == '/') precedence = 3;
                if (precedence > top_precedence) s.push(new StackNode(c));
                else {
                    System.out.print(((char) s.pop().getData()));
                    s.push(new StackNode(c));
                }
                top_precedence = precedence;
            } else if (c == ')') {
                count--;
                while (s.peek().getData()!='(') {
                    System.out.print((char) s.pop().getData());
                }
                s.pop();
                if (count==0) {
                    while (!s.isEmpty()) System.out.print((char) s.pop().getData());
                    top_precedence=1;
                } else {
                    char prec=s.peek().getData();
                    if (prec == '(') top_precedence = 1;
                    else if (prec == '+' || prec == '-') top_precedence = 2;
                    else if (prec == '*' || prec == '/') top_precedence = 3;
                }
            }
        }
        while (!s.isEmpty()) System.out.print((char) s.pop().getData());
    }
}
