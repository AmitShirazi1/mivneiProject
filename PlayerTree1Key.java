public class PlayerTree1Key extends TwoThreeTree1Key {

    public PlayerTree1Key() {
        TreeNode1Key left = new PlayerNode1Key(Integer.MIN_VALUE);
        TreeNode1Key middle = new PlayerNode1Key(Integer.MAX_VALUE);
        this.root = new PlayerNode1Key(middle.getKey(), -1, left, middle, null, null);
        left.setParent(this.root);
        middle.setParent(this.root);
    }
}
