class Node{
    int value;
    Node left;
    Node right;

    public Node (int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    Node rootNode;

    public BinarySearchTree (int value){
        rootNode = new Node(value);
    }

    public void insert(int value){
        addNode(rootNode, value);
    }

    private void addNode(Node node, int value ){
        if (value > node.value){
            if (node.right == null) node.right = new Node(value);
            else addNode(node.right, value);
        }
        else {
            if(node.left == null) node.left = new Node(value);
            else addNode(node.left, value);
        }
    }

    public void printTree() {
        printTreeHelper(rootNode, 0);
    }

    private void printTreeHelper(Node node, int indentLevel) {
        if (node == null) {
            return;
        }

        String indent = "  ".repeat(indentLevel);
        System.out.println(indent + node.value);

        printTreeHelper(node.left, indentLevel + 1);
        printTreeHelper(node.right, indentLevel + 1);

    }
}
