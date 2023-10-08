import LinkedList.SinglyLinkedList;
import Stack.DynamicStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class LinearMain{

    public static void main(String[] args){

        DynamicStack ds= new DynamicStack();
        System.out.println(ds.isEmpty()+"  "+ds.size());
        for(int i=0;i<10;i++){
            ds.push(i);
        }
        ds.print();
        System.out.println(ds.pop()+" Popped \n");
        System.out.println(ds.isEmpty()+"  "+ds.size());
        System.out.println(ds.peek()+" Peek\n");

        System.out.println("Search: "+ds.search(12)+" "+ds.search(5));
        System.out.println("Index: "+ds.getIndex(5)+" "+ds.getIndex(0)+" "+ds.getIndex(12));


        ds.print();



    }
}
