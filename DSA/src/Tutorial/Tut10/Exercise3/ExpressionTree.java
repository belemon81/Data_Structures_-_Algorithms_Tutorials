package Tutorial.Tut10.Exercise3;

public class ExpressionTree {
    private ETNode root;
    private ExpressionTree leftSubTree;
    private ExpressionTree rightSubTree;

    public ExpressionTree(ETNode rootValue, ExpressionTree left, ExpressionTree right) {
        if (rootValue == null) {
            root = null;
            //leftSubTree = rightSubTree = null;
        } else
            root = rootValue;
        leftSubTree = left;
        rightSubTree = right;
    }

    public void preOrderTraversal(ExpressionTree t) {
        if (t != null) {
            System.out.print(t.getTreeValue());
            preOrderTraversal(t.getLeftSubTree());
            preOrderTraversal(t.getRightSubTree());
        }
    }

    public void inOrderTraversal(ExpressionTree t) {
        if (t != null) {
            inOrderTraversal(t.getLeftSubTree());
            System.out.print(t.getTreeValue());
            inOrderTraversal(t.getRightSubTree());
        }
    }

    public void postOrderTraversal(ExpressionTree t) {
        if (t != null) {
            postOrderTraversal(t.getLeftSubTree());
            postOrderTraversal(t.getRightSubTree());
            System.out.print(t.getTreeValue());
        }
    }

    public boolean isLeaf() {
        return ((root != null) && (leftSubTree == null) && (rightSubTree == null));
    }

    public ExpressionTree getLeftSubTree() {
        return leftSubTree;
    }

    public ExpressionTree getRightSubTree() {
        return rightSubTree;
    }

    public String getTreeValue() {
        return root.getLabel();
    }

    public int getLeaf() {
        return root.getOperandLabel();
    }

    public int evaluate(ExpressionTree t) {
        if (t.isLeaf())
            return t.getLeaf();
        else {
            String operator = t.getTreeValue();
            int operand1 = evaluate(t.getLeftSubTree());
            int operand2 = evaluate(t.getRightSubTree());
            return applyOperator(operand1, operator, operand2);
        }
    }

    public int applyOperator(int operand1, String operator, int operand2) {
        if (operator.equals("+")) return operand1 + operand2;
        if (operator.equals("-")) return operand1 - operand2;
        if (operator.equals("*")) return operand1 * operand2;
        if (operator.equals("/")) return operand1 / operand2;
        return 0;
    }
}
