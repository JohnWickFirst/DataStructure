package BinaryTree;

import java.util.ArrayList;

public class MainTree {
    public static void main(String[] args){

        Tree tree=new Tree();
        Tree.Node node=new Tree.Node();
        node=null;

        int[] num={5,1,4};
        for(int i=0;i<num.length;i++){
            System.out.println("Inserting Data "+num[i]+"\n");
            node=tree.insertToAVL(node,num[i]);
            System.out.println("\n\n");
        }

        tree.inOrderTraversal(node);
        System.out.println(tree.isBalanced(node));

    }
}
