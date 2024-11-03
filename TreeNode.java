public class TreeNode {
    protected int key;
    protected TreeNode left;
    protected TreeNode middle;
    protected TreeNode right;
    protected TreeNode parent;

    public TreeNode(int key, TreeNode left, TreeNode middle, TreeNode right, TreeNode parent) {
        this.key = key;
        this.left = left;
        this.middle = middle;
        this.right = right;
        this.parent = parent;
    }

    public TreeNode(int key) {
        this(key, null, null, null, null);
    }

    public TreeNode() {
        this(0);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getMiddle() {
        return middle;
    }

    public void setMiddle(TreeNode middle) {
        this.middle = middle;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
