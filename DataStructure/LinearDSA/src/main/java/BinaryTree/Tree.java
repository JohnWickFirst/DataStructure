package BinaryTree;

public class Tree {

    public Tree(){}

    Node head;
    int count;

    public static class Node{
        int data;
        Node left;
        Node right;
        int height;

        Node(){       }

        public Node(int data, Node left, Node right, int height) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = height;
        }
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
            this.height=0;
        }
    }

    public Node insertToAVL(Node node, int data){
       // System.out.println((node==null)+" "+node.left+" "+node.right+" "+node.data);
        if(node==null){
            Node temp=getNode(data);
            node=temp;
            System.out.println("Value Inserted in Node==NULL "+data);
            return node;
        }else if(node.data<data){
            System.out.println("NODE Right "+data+" :: "+node.data);
            Node temp=insertToAVL(node.right,data);
            node.right=temp;


        } else if (node.data>data) {
            System.out.println("NODE left "+data+" :: "+node.data);
            Node temp=insertToAVL(node.left,data);
            node.left=temp;


        }
        balanceNode(node);
        return node;
    }

    public void balanceNode(Node node){
        System.out.println(node.data+" Balanced Tree");
        int lcl=0,lcr=0,rcl=0,rcr=0;
        if(node.left!=null){
            if(node.left.left!=null){
                lcl=getHeight(node.left.left);
            }
            if(node.left.right!=null){
                lcr=getHeight(node.left.right);
            }
        }
        if(node.right!=null){
            if(node.right.left!=null){
                rcl=getHeight(node.right.left);
            }
            if (node.right.right!=null){
                rcr=getHeight(node.right.right);
            }
        }

        if((lcl>lcr+1) &&(lcr>rcl+1)){
            leftRightRotation(node);
        }else if((rcr>rcl+1) &&(rcl>lcr+1)){
            rightLeftRotation(node);
        } else if(lcl>lcr+1){
            leftRotaion(node);
        } else if (rcr>rcl+1) {
            rightRotation(node);            
        }
    }

    private void rightRotation(Node node) {
        System.out.println("Right Rotation");
        Node temp=node;
        Node right=node.right;
        node.right=null;
        right.left=temp;
        node=right;
    }

    private void leftRotaion(Node node) {
        System.out.println("Left Rotation");
        Node temp=node;
        Node left=node.left;
        node.left=null;
        left.right=temp;
        node=left;
    }

    private void rightLeftRotation(Node node) {
        rightRotation(node);
        leftRotaion(node);
    }

    private void leftRightRotation(Node node) {
        leftRotaion(node);
        rightRotation(node);

    }

    public int getBalancedFactor(Node node, String path){
        return 0;
    }



    public Node getNode(int data){
        Node node =new Node(data);
        return node;
    }

    public void inOrderTraversal(Node node){
        if(node!=null){
            inOrderTraversal(node.left);
//            System.out.print(node.data+" ");
            System.out.println(getHeight(node)+" "+node.data);
            inOrderTraversal(node.right);
        }
        return;
    }
    public  boolean isBalanced(Node root) {
        if (root == null) {
            return true; // An empty tree is considered balanced
        }

        // Check the balance condition for the current node
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Check if the subtree rooted at the current node is balanced
        if (Math.abs(leftHeight - rightHeight) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right)) {
            return true;
        }

        // If the subtree is not balanced, return false
        return false;
    }

    // Function to calculate the height of a subtree
    private  int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // Return the height of the subtree rooted at the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

}
