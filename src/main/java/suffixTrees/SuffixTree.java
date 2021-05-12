package suffixTrees;

public class SuffixTree {
    private Node root; // the root of the suffix tree

    // ------------------ A node of the SuffixTree ------------------------
    private class Node {
        private String string;
        private Node[] children;
        private int index;

        public Node(String string, int index) {
            children = new Node[27]; // 26 letters + "$"
            this.string = string;
            this.index = index;
        }
    } // class Node ----------

    /** Create a SuffixTree for a given string s (use the agorithm we discussed in class. */
    public SuffixTree(String s) {
        // Concatenate a "$" to the end
        String newS = s + "$"; // add a $ to the end

        // Iterate backwards
        int indLast = newS.length();
        insert("", -1);
        for (int i = newS.length() - 1; i >= 0; i--) {
            String currSuffix = newS.substring(i, indLast);
            // System.out.println(currSuffix);
            insert(currSuffix, i); // insert into the tree
        }
    }

    /**
     * Return true if a string represented by a given suffix tree contains a given
     * word. Return false otherwise.
     */
    public boolean containsSubstring(String word) {

        return containsSubstring(word, root);
    }

    /**
     * Return true if a string represented by the suffix tree with the given root,
     * contains a given substring (word). Return false otherwise. Recursive method.
     */
    public boolean containsSubstring(String word, Node node) {
        if (node == null)
            return false; // did not find
        String nodePrefix = node.string;
        // FILL IN CODE


        return false; // change
    }

    /** Insert a new suffix into the suffix tree; new suffix starts at index i in the string. */
    public void insert(String word, int i) {
        root = insert(word.toLowerCase(), i, root);
    }

    /**
     * Insert a new suffix that starts at index = ind, into the suffix tree with
     * the given root
     */
    private Node insert(String word, int ind, Node tree) {
        if (tree == null) {
            Node temp = new Node(word, ind);
            return temp;
        }

        // FILL IN CODE
        return null;
    }

    /** Return the index in the children array that corresponds to the first letter of the given word. If
     * the first letter is 'a', the method returns 0; if the first letter is 'b', the method returns 1 etc.
     * '$' is handled separately: the index of the '$' child is 26 (the last one in the array).
     * @param word word
     * @return index in the array of children
     */
    private int getChildIndex(String word) {
        int childIndex = word.charAt(0) - 97;
        if (word.charAt(0) == '$')
            childIndex = 26;
        return childIndex;
    }


}
