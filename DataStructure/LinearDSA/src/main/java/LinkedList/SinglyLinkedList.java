package LinkedList;

public class SinglyLinkedList {
    // Singly Linked List Class
    Node head;
    int count;
    // Node class to basically act as a container
    static class Node{

        int data;
        Node next;


        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    // To initialize Singly Linked List
    public SinglyLinkedList( int data){
        Node node= new Node(data);
        head=node;
        count=1;
    }

    // To add element in singly Linked List
    public void add(int data)  {

            Node cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            Node node=new Node(data);
            cur.next=node;
            cur=cur.next;
            count++;

    }

    public void print()  {

            Node cur=head;
            while(cur!=null){
                System.out.println(cur.data+" ");
                cur=cur.next;
            }

    }

    // delete the first element of the list matched with data
    public void delete(int num){

        Node cur=head;
        Node prev=null;
        while(cur!=null){
            if(cur.data==num){
                prev.next=cur.next;
                count--;
                break;
            }
            prev=cur;
            cur=cur.next;
        }
    }

    public void insert(int num, int pos){
        // if pos =0 that is initial element
        if(pos==0){
            insertFirst(num);
        }
        else if (pos>count){
            insertLast(num);
        }else{
            insertAtPos(num,pos);
        }


    }
    private void insertAtPos(int num, int pos){
        Node temp=new Node(num);
        Node cur=head;
        Node prev=null;
        while(pos>0){
            prev=cur;
            cur=cur.next;
            pos--;
        }
        prev.next=temp;
        temp.next=cur;
    }
    private void insertFirst(int num){
        Node node=new Node(num);
        node.next=head;
        head=node;
    }
    private void insertLast(int num){
        Node node=new Node(num);
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }


    //find nth node from the end
    public  int NNodeFromEnd(int n){
        Node cur=head;
        while(n>0){
            cur=cur.next;
            n--;
        }
        Node temp=head;
        while(cur!=null){
            cur=cur.next;
            temp=temp.next;
        }
        return temp.data;

    }

    public int findMiddleTerm(){
        Node fast=head;
        Node slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.data;
    }


}

