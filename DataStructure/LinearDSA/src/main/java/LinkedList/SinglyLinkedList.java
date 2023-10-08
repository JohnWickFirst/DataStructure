package LinkedList;

import java.util.LinkedList;

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

        Node(){
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
    // This Method is Tested
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
        count++;

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

    public int getCount(){
        return this.count;
    }

    // Reverse a linked list
    public void reverseLinkedList(){
//        if(count==1 || head==null){
//            return ;
//        }

        Node cur=head;
        Node prev=null;
        Node fast=head;

        while(fast!=null){
            fast=fast.next;
            cur.next=prev;
            prev=cur;
            cur=fast;
        }
        this.head=prev;
    }
//Check if ist in palindrome
    //Tested

    public boolean isPalindrome(){
        Node temp=head;
        String num="";
        while(temp!=null){
            num=num+""+temp.data;
            temp=temp.next;
        }
        int len=num.length();
        int i=0, j=len-1;
        while(i<=j){
            if(num.charAt(i)!=num.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }


// Detect Loop in the linked List
    public boolean isLoopPresent(){
        Node temp=head;
        Node current=head;
        while(temp!=null && temp.next!=null)
        {
            temp=temp.next.next;
            current=current.next;
            if(temp==current)
                return true;

        }
        return false;
    }

//  removeLoopFrom    the list

    public void removeLoopFromList(){
        Node dummy = new Node();
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) break;
        }

        if(slow != fast) return;

        Node tempHead = dummy;

        while(tempHead.next != slow.next) {
            tempHead = tempHead.next;
            slow = slow.next;
        }

        slow.next = null;
        head = dummy.next;
    }


    // Remove Duplicates from the Sorted Linked List

    public void removeDuplicates(){
        // Your code here
        if(head==null || head.next==null)
            return ;

        Node temp=head;
        while(temp!=null && temp.next!=null)
        {
            if(temp.data==temp.next.data)
            {
                //        System.out.print(temp.data+"inside temp "+temp.next.data);
                temp.next=temp.next.next;

            }
            else
                temp=temp.next;

        }

        return ;
    }



}

