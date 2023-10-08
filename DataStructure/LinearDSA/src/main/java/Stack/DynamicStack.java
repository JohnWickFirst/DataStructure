package Stack;

public class DynamicStack {

    private static int size=0;
    Node head;
    Node top;
    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
        Node(){

        }
    }
   public DynamicStack(){
        this.head=null;
        this.top =null;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void push(int data){
        Node node= new Node(data);
        if(head==null){
            head=node;
            top=node;
        }else{
            top.next=node;
            top=node;
        }
        size++;
    }

    public int pop(){
        if(top==null){
            return -1;
        }
        Node temp=head;
        int data=top.data;
        top=iteratorNode(top);
        top.next=null;
        size--;
        return data;
    }

    public int peek(){
        if(top==null){
            return -1;
        }
        return top.data;
    }

    public boolean search(int data){
        if(top==null){
            return false;
        }

        Node temp=iteratorInt(data);
        if(temp==null){
            return false;
        }
        return true;
    }

    public int getIndex(int num){
        if(top==null){
            return -1;
        }
        Node temp=head;
        int count=0;
        while(temp!=null){
            if(temp.data==num){
                count++;
                return count;
            }
             temp=temp.next;
        }
        return -1;
    }

    public void clear(){
        this.top=null;
        this.head=null;
    }


    private Node iteratorNode(Node topPos){
        Node temp=head;
        while(temp.next!=topPos){
            temp=temp.next;
        }
        return temp;
    }

    private Node iteratorInt(int intData){
        Node temp=head;
        while(temp!=null && temp.data!=intData){
            temp=temp.next;
        }
        return temp;
    }



}
