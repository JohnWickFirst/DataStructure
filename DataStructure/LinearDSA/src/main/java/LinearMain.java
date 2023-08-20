import LinkedList.SinglyLinkedList;

public class LinearMain{

    public static void main(String[] args){

        System.out.println("Linear Dsa and Git learning from scratch");

        SinglyLinkedList sl=new SinglyLinkedList(10);
        sl.add(12);
        sl.add(15);
        sl.add(20);



        System.out.println("After updating the list \n");
        sl.insert(23,0);
        sl.insert(50,0);
        sl.insert(50,10);
        sl.insert(100,3);
        sl.insert(120,12);
        sl.print();
        System.out.println(sl.NNodeFromEnd(5)+" "+sl.findMiddleTerm());

    }
}
