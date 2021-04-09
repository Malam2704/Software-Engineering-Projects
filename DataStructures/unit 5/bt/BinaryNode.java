package bt;

public class BinaryNode<E> {
    private E value;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    public BinaryNode(E value, BinaryNode<E> left, BinaryNode<E> right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
    public BinaryNode(E value){
        this.value = value;
        this.right = null;
        this.left  = null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public BinaryNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<E> left) {
        this.left = left;
    }

    public BinaryNode<E> getRight() {
        return right;
    }

    public void setRight(BinaryNode<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return " BinaryNode[ value = " + value
            + " , left = " + left
            + " , right = " + right
            + " ]";
    }

    public String infixTraversal(){
        String eh = "";
        // left subtree into a string
        if(left != null){
            eh += left.infixTraversal();
        }
        // add the value, which is at teh middle
        eh += value + " ";

        // add the rights parts of the bianry tree
        if(right != null){
            eh += right.infixTraversal();
        }
        return eh;
    }

    public boolean search(E target){
        // check if the value parameterized is our current value
        if(value == target){
            return true;
        }

        // didfind is default false, and if the left bianry
        //  node is not null, we apply did find to the left node
        // This will loop to all values in the left
        boolean didfind = false;
        if(left != null){
            didfind = left.search(target);
        }

        // basically above but for the right values.
        if(didfind && right!= null){
            didfind = right.search(target);
        }

        return didfind;
    }

    // 

    public static void main(String[] args) {
        BinaryNode<Integer> root = new BinaryNode(2,
            new BinaryNode(3,
                new BinaryNode(9),
                new BinaryNode(4)),
            new BinaryNode(7,
                new BinaryNode(9),
                new BinaryNode(4)));

        BinaryNode<String> stroot = new BinaryNode("a",
            new BinaryNode("b",
                new BinaryNode(9),
                new BinaryNode(4)),
            new BinaryNode(7,
                new BinaryNode(9),
                new BinaryNode(4)));

        System.out.println(stroot);
        System.out.println(stroot.infixTraversal());
    }
}