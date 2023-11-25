import LinkedList.SinglyLinkedList;
import Queue.DynamicQueue;

import Queue.Queue;

public class LinearMain{

    public static void main(String[] args){

        Queue ds= new DynamicQueue();
        System.out.println(ds.isEmpty()+"  "+ds.size());
        for(int i=0;i<10;i++){
            ds.offer(i);
        }
        ds.print();
        System.out.println(ds.poll()+" Popped \n");
        System.out.println(ds.isEmpty()+"  "+ds.size());
        System.out.println(ds.peek()+" Peek\n");

        System.out.println("Search: "+ds.contains(12)+" "+ds.contains(5));
        System.out.println("Index: "+ds.search(5)+" "+ds.search(0)+" "+ds.search(12));

        ds.offer(14);

        ds.print();





    }
}
