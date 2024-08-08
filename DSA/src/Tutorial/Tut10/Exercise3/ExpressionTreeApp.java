package Tutorial.Tut10.Exercise3;

import java.util.Scanner;

public class ExpressionTreeApp {
    private static Scanner sc = new Scanner(System.in);
    private static ExpressionStack es = new ExpressionStack();

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
        copyStack(st, tmp);
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

    public static String toPostfix(String infix) {
        StringBuilder string = new StringBuilder();
        SLLStack s = new SLLStack();
        s.push(new StackNode('#'));
        int top_priority = 0, count = 0;
        for (int i = 0; i < infix.length(); i++) {
            //printStack(s);
            char c = infix.charAt(i);
            if (c >= '0' && c <= '9') string.append(c);
            else if (c == '(') {
                s.push(new StackNode(c));
                top_priority = 1;
                count++;
            } else if (c == '*' || c == '/' || c == '+' || c == '-') {
                int priority = 1;
                if (c == '+' || c == '-') priority = 2;
                if (c == '*' || c == '/') priority = 3;
                if (priority > top_priority) s.push(new StackNode(c));
                else {
                    string.append((char) s.pop().getData());
                    s.push(new StackNode(c));
                }
                top_priority = priority;
            } else if (c == ')') {
                count--;
                while (s.peek().getData() != '(') {
                    string.append((char) s.pop().getData());
                }
                s.pop();
                char prec = (char) s.peek().getData();
                if (prec == '#') top_priority = 0;
                else if (prec == '(') top_priority = 1;
                else if (prec == '+' || prec == '-') top_priority = 2;
                else if (prec == '*' || prec == '/') top_priority = 3;
                if (count == 0) {
                    while (s.peek().getData() != '#') string.append((char) s.pop().getData());
                    top_priority = 0;
                }
            }
        }
        while (s.peek().getData() != '#') string.append((char) s.pop().getData());
        return string.toString();
    }

    public static ExpressionTree buildTree(String postfix) {
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (c > '0' && c < '9') {
                String s = postfix.substring(i, i + 1);
                //System.out.println(s);
                es.push(new ESNode(new ExpressionTree(new ETNode(s), null, null)));
            } else {
                String s = postfix.substring(i, i + 1);
                ExpressionTree op2 = es.pop().getData();
                ExpressionTree op1 = es.pop().getData();
                es.push(new ESNode(new ExpressionTree(new ETNode(s), op1, op2)));
            }
        }
        return es.pop().getData();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("* Input an expression E in infix notation (with the parentheses): ");
        String infix = sc.nextLine();
        String postfix = toPostfix(infix);
        System.out.print("--> The postfix expression E of input: ");
        System.out.println(postfix);
        ExpressionTree E = buildTree(postfix);
        System.out.print("---> Expression tree in pre-order:     ");
        E.preOrderTraversal(E);
        System.out.print("\n---> Expression tree in in-order:      ");
        E.inOrderTraversal(E);
        System.out.print("\n---> Expression tree in post-order:    ");
        E.postOrderTraversal(E);
        System.out.println("\n----> Evaluate the result: " + E.evaluate(E));
    }
}
