package binaryTrees;

/** Implementation of a binary search tree.
 *  The course has been modified from the code of Prof. Galles.
 */
class BinarySearchTree {

    /** An inner class representing a node in a BST tree */
    private class BSTNode {
        public Comparable data; // value stored at the node
        public BSTNode left; // left subtree
        public BSTNode right;  // right subtree

        BSTNode(Comparable newdata) {
            data = newdata;
        }
    }

    private BSTNode root; // the root of the tree

    /** Insert a given element into the BST tree */
    public void insert(Comparable elem) {
        root = insert(root, elem);
    }

    /** Return true if a given element is in the tree */
    public boolean find(Comparable elem) {
        return find(root, elem);
    }

    /** Delete the node with the given element from the tree */
    public void delete(Comparable elem) {
        root = delete(root, elem);
    }

    /** Print the values at the nodes of the tree (inorder) */
    public void print() {
        print(root);
    }

    // private helper methods ---------------------
    /** Find elem in the tree with the given root */
    private boolean find(BSTNode tree, Comparable elem) {
        if (tree == null)
            return false;
        if (elem.compareTo(tree.data) == 0)
            return true;
        if (elem.compareTo(tree.data) < 0)
            return find(tree.left, elem);
        else
            return find(tree.right, elem);
    }

    /** Find the node with the minimum value in a given tree */
    private Comparable minimum(BSTNode tree) {
        if (tree == null)
            return null;
        if (tree.left == null)
            return tree.data;
        else
            return minimum(tree.left);
    }

    /** Print the nodes of the given tree using inorder traversal */
    private void print(BSTNode tree) {
        if (tree != null) {
            print(tree.left);
            System.out.print(" " + tree.data + " ");
            print(tree.right);
        }
    }

    /** Insert elem into the tree with the given root */
    private BSTNode insert(BSTNode tree, Comparable elem) {
        if (tree == null) {
            return new BSTNode(elem);
        }
        if (elem.compareTo(tree.data) < 0) {
            tree.left = insert(tree.left, elem);
            return tree;
        } else {
            tree.right = insert(tree.right, elem);
            return tree;
        }
    }

    /** Find the node with the value of elem in the tree with given
     *  root and delete it */
    private BSTNode delete(BSTNode tree, Comparable elem) {
        if (tree == null)
            return null;
        if (tree.data.compareTo(elem) == 0) { // found node with elem
            if (tree.left == null) // has one child
                return tree.right;
            else if (tree.right == null) // has one child
                return tree.left;
            else { // has two children
                if (tree.right.left == null) {
                    // if the right subtree has no left tree
                    // then the value at the root of the right subtree
                    // is the smallest value in the right subtree

                    // replace the value of this node with
                    // the value of the root of the
                    // right subtree
                    tree.data = tree.right.data;
                    // delete the root of the right subtree
                    tree.right = tree.right.right;
                    return tree;
                } else {
                    // need to find the node with the smallest value
                    // in the right subtree
                    tree.data = removeSmallest(tree.right);
                    return tree;
                }
            }
        } else if (elem.compareTo(tree.data) < 0) { // find and delete in left subtree
            tree.left = delete(tree.left, elem);
            return tree;
        } else {
            tree.right = delete(tree.right, elem); // find and delete in right subtree
            return tree;
        }
    }

    /** Find and remove the node with the smallest value in the tree */
    private Comparable removeSmallest(BSTNode tree) {
        // the smallest value is always in the left most subtree
        if (tree.left.left == null) {
            Comparable smallest = tree.left.data;
            tree.left = tree.left.right;
            return smallest;
        } else {
            return removeSmallest(tree.left);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(1);
        bst.insert(7);
        bst.insert(11);
        bst.insert(8);
        bst.insert(0);
        bst.delete(5);
        bst.print();



    }
}

