public class TwoThreeTree1Key {
    protected TreeNode1Key root;


    public void updateKey(TreeNode1Key x) {
        x.setKey(x.getLeft().getKey());
        if (x.getMiddle() != null) {
            x.setKey(x.getMiddle().getKey());
        }
        if (x.getRight() != null) {
            x.setKey(x.getRight().getKey());
        }
    }


    public void setChildren(TreeNode1Key parent, TreeNode1Key l, TreeNode1Key m, TreeNode1Key r) {
        parent.setLeft(l);
        parent.setMiddle(m);
        parent.setRight(r);
        l.setParent(parent);

        if (m != null) {
            m.setParent(parent);
        }
        if (r != null) {
            r.setParent(parent);
        }
        updateKey(parent);
    }


    public TreeNode1Key insertAndSplit(TreeNode1Key parent, TreeNode1Key child) {
        TreeNode1Key left = parent.getLeft();
        TreeNode1Key middle = parent.getMiddle();
        TreeNode1Key right = parent.getRight();

        if (right == null) {
            if (child.getKey() < left.getKey()) {
                setChildren(parent, child, left, middle);
            }
            else if (child.getKey() < middle.getKey()) {
                setChildren(parent, left, child, middle);
            }
            else {
                setChildren(parent, left, middle, child);
            }
            return null;
        }

        TreeNode1Key y = new TreeNode1Key();
        if (child.getKey() < left.getKey()) {
            setChildren(parent, child, left, null);
            setChildren(y, middle, right, null);
        }
        else if (child.getKey() < middle.getKey()) {
            setChildren(parent, left, child, null);
            setChildren(y, middle, right, null);
        }
        else if (child.getKey() < right.getKey()) {
            setChildren(parent, left, middle, null);
            setChildren(y, child, right, null);
        }
        else {
            setChildren(parent, left, middle, null);
            setChildren(y, right, child, null);
        }
        return y;
    }


    public void insert(TreeNode1Key leaf) {
        TreeNode1Key y = this.root;

        while (y.getLeft() != null) {
            if (leaf.getKey() < y.getLeft().getKey()) {
                y = y.getLeft();
            }
            else if (leaf.getKey() < y.getMiddle().getKey()) {
                y = y.getMiddle();
            }
            else {
                y = y.getRight();
            }
        }

        TreeNode1Key x = y.getParent();
        TreeNode1Key tempNode = insertAndSplit(x, leaf);

        while (x != this.root) {
            x = x.getParent();
            if (tempNode != null) {
                tempNode = insertAndSplit(x, tempNode);
            }
            else {
                updateKey(x);
            }
        }

        if (tempNode != null) {
            TreeNode1Key w = new TreeNode1Key();
            setChildren(w, x, tempNode, null);
            this.root = w;
        }
    }

    public TreeNode1Key borrowOrMerge(TreeNode1Key node) {
        TreeNode1Key parent = node.getParent();
        TreeNode1Key sibling;
        if (node.equals(parent.getLeft())) {
            sibling = parent.getMiddle();
            if (sibling.getRight() != null) {
                setChildren(node, node.getLeft(), sibling.getLeft(), null);
                setChildren(sibling, sibling.getMiddle(), sibling.getRight(), null);
            }
            else {
                setChildren(sibling, node.getLeft(), sibling.getLeft(), sibling.getMiddle());
                setChildren(parent, sibling, parent.getMiddle(), null);
            }
            return parent;
        }
        if (node.equals(parent.getMiddle())) {
            sibling = parent.getLeft();
            if (sibling.getRight() != null) {
                setChildren(node, sibling.getRight(), node.getLeft(), null);
                setChildren(sibling, sibling.getLeft(), sibling.getMiddle(), null);
            }
            else {
                setChildren(sibling, sibling.getLeft(), sibling.getMiddle(), node.getLeft());
                setChildren(parent, sibling, parent.getRight(), null);
            }
            return parent;
        }
        sibling = parent.getMiddle();
        if (sibling.getRight() != null) {
            setChildren(node, sibling.getRight(), node.getLeft(), null);
            setChildren(sibling, sibling.getLeft(), sibling.getMiddle(), null);
        }
        else {
            setChildren(sibling, sibling.getLeft(), sibling.getMiddle(), node.getLeft());
            setChildren(parent, parent.getLeft(), sibling, null);
        }
        return parent;
    }

    public void deleteLeaf(TreeNode1Key leaf) {
        TreeNode1Key parent = leaf.getParent();
        if (leaf.equals(parent.getLeft())) {
            setChildren(parent, parent.getMiddle(), parent.getRight(), null);
        }
        else if (leaf.equals(parent.getMiddle())) {
            setChildren(parent, parent.getLeft(), parent.getRight(), null);
        }
        else {
            setChildren(parent, parent.getLeft(), parent.getMiddle(), null);
        }
        while (parent != null) {
            if (parent.getMiddle() == null) {
                if (!(parent.equals(this.root))) {
                    parent = borrowOrMerge(parent);
                }
                else {
                    this.root = parent.getLeft();
                    parent.getLeft().setParent(null);
                    return;
                }
            }
            else {
                updateKey(parent);
                parent = parent.getParent();
            }
        }
    }

    public TreeNode1Key search(TreeNode1Key root, int key) {
        if (root.getLeft() == null) {
            if (root.getKey() == key) { return root; }
            else { return null; }
        }
        if (key <= root.getLeft().getKey()) { return search(root.getLeft(), key); }
        else if (key <= root.getMiddle().getKey()) { return search(root.getMiddle(), key); }
        else { return search(root.getRight(), key); }
    }
}
