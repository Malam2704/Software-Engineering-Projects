package stu;

/**
 * Node implementation for binary trees
 */
public class BinaryNode {
    private int value;
    private BinaryNode left;
    private BinaryNode right;

    /**
     * Constructor
     * @param value Node value
     */
    public BinaryNode (int value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString () {
        return "BinaryNode {value: " + value + ", left: " + left +
               ", right: " + right + "}";
    }

    /**
     * Returns the node's value
     * @return value
     */
    public int getValue () {
        return value;
    }

    /**
     * Sets the node's value
     * @param value Value to be assigned to the node
     */
    public void setValue (int value) {
        this.value = value;
    }

    /**
     * Returns the node's left reference
     * @return left reference
     */
    public BinaryNode getLeft () {
        return left;
    }

    /**
     * Sets the node's left reference
     * @param left
     */
    public void setLeft (BinaryNode left) {
        this.left = left;
    }

    /**
     * Returns the nodes right reference
     * @return right reference
     */
    public BinaryNode getRight () {
        return right;
    }

    /**
     * Sets the node's right reference
     * @param right
     */
    public void setRight (BinaryNode right) {
        this.right = right;
    }

    /**
     * Performs an infix traversal of the binary tree
     * @return Stringifyed version of the Binary Tree
     */
    public String infixTraversal () {
        String tree = "";
        if (left != null) {
            tree += left.infixTraversal ();
        }

        tree += value + " ";

        if (right != null) {
            tree += right.infixTraversal ();
        }

        return tree;
    }

    /**
     * Searches the tree for a target value
     * @param target Value to search for in the tree
     * @return true if the target is found false otherwise
     */
    public boolean search (int target) {
        if (value == target) {
            return true;
        }

        if (left != null) {
            if (left.search (target) == true) {
                return true;
            }
        }

        if (right != null) {
            if (right.search (target)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Searchs the tree as a Binary Search Tree
     * @param target Value to search for in the tree
     * @return true if the target is found false otherwise
     */
    public boolean binarySearch (int target) {
        if (value == target) {
            return true;
        }

        if (left != null && target < value) {
            if (left.binarySearch (target) == true) {
                return true;
            }
        }
        else if (right != null) {
            if (right.binarySearch (target)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Insert a value into the tree as a BST node
     * @param value value to insert
     */
    public void binaryInsert (int value) {
        if (value < this.value) {
            if (left == null) {
                left = new BinaryNode (value);
            }
            else {
                left.binaryInsert (value);
            }
        }
        else {
            if (right == null) {
                right = new BinaryNode (value);
            }
            else {
                right.binaryInsert (value);
            }            
        }
    }

    public static void main(String[] args) {
        BinaryNode two = new BinaryNode (2);
        BinaryNode three = new BinaryNode (3);
        BinaryNode nine = new BinaryNode (9);
        BinaryNode four = new BinaryNode (4);
        BinaryNode seven = new BinaryNode (7);
        BinaryNode one = new BinaryNode (1);
        BinaryNode six = new BinaryNode (6);

        BinaryNode root = new BinaryNode (2);
        root.binaryInsert (3);
        root.binaryInsert (9);
        root.binaryInsert (4);
        root.binaryInsert (7);
        root.binaryInsert (1);
        root.binaryInsert (6);

        System.out.println (root.infixTraversal ());
        System.out.println (root.binarySearch (6));
        System.out.println (root.binarySearch (9));
        System.out.println (root.binarySearch (15));
    }
}