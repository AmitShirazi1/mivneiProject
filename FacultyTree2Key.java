public class FacultyTree2Key extends TwoThreeTree2Key {

    public FacultyTree2Key() {
        TreeNode1Key left = new FacultyNode(Integer.MIN_VALUE);
        TreeNode1Key middle = new FacultyNode(Integer.MAX_VALUE);
        this.root = new FacultyNode(middle.getKey(), left, middle, null, null);
        left.setParent(this.root);
        middle.setParent(this.root);
    }

}
