package Tutorial.Tut10.Exercise3;

public class ETNode {
    private String label;

    public ETNode(String label) {
        this.label = label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public int getOperandLabel() {
        return label.charAt(0)-48;
    }
}