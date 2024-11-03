public class TreeNode1Key {
    protected int key1;
    protected TreeNode1Key left;
    protected TreeNode1Key middle;
    protected TreeNode1Key right;
    protected TreeNode1Key parent;

    public TreeNode1Key(int key1, TreeNode1Key left, TreeNode1Key middle, TreeNode1Key right, TreeNode1Key parent) {
        this.key1 = key1;
        this.left = left;
        this.middle = middle;
        this.right = right;
        this.parent = parent;
    }

    public TreeNode1Key(int key1) {
        this(key1, null, null, null, null);
    }

    public TreeNode1Key() {
        this(0, 0);
    }

    public int getScore() {
        return key1;
    }

    public void setScore(int key1) {
        this.key1 = key1;
    }

    public TreeNode1Key getLeft() {
        return left;
    }

    public void setLeft(TreeNode1Key left) {
        this.left = left;
    }

    public TreeNode1Key getMiddle() {
        return middle;
    }

    public void setMiddle(TreeNode1Key middle) {
        this.middle = middle;
    }

    public TreeNode1Key getRight() {
        return right;
    }

    public void setRight(TreeNode1Key right) {
        this.right = right;
    }

    public TreeNode1Key getParent() {
        return parent;
    }

    public void setParent(TreeNode1Key parent) {
        this.parent = parent;
    }
}
