class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Constructor for creating a new Node
    public BinaryTree() {
        root = null;
    }

    // Function to perform the conversion
    public void toSkewedTree() {
        root = toSkewed(root);
    }

    // Function to convert BST to right skewed tree
    private Node toSkewed(Node node) {
        if (node == null) {
            return null;
        }

        // If left child exists, recursively convert the left subtree
        if (node.left != null) {
            Node rightChild = toSkewed(node.left);
            Node rightmost = findRightmost(rightChild);
            rightmost.right = new Node(node.data); // Create a new node for current data
            rightmost.right.right = toSkewed(node.right); // Recursively convert the right subtree
            return rightChild;
        } else {
            Node newNode = new Node(node.data);
            newNode.right = toSkewed(node.right);
            return newNode;
        }
    }

    // Helper function to find the rightmost node of a skewed tree
    private Node findRightmost(Node node) {
        if (node.right == null) {
            return node;
        }
        return findRightmost(node.right);
    }

    // Function to print the nodes of the skewed tree in ascending order
    public void printTree() {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(60);
        tree.root.left.left = new Node(10);
        tree.root.right.left = new Node(55);

        tree.toSkewedTree(); // Convert the BST into a right skewed tree
        tree.printTree(); // Print the nodes of the skewed tree
    }
}


