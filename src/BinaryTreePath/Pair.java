package BinaryTreePath;

public class Pair<T extends TreeNode, T1 extends String> {
    TreeNode key;
    String value;

    public Pair(TreeNode key, String val) {
        this.key = key;
        this.value = val;
    }

    public TreeNode getKey() {
        return key;
    }

    public void setKey(TreeNode key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
