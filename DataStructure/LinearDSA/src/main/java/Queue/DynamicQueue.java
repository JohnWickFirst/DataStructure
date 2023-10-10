package Queue;




public class DynamicQueue implements Queue {

    public DynamicQueue(){
        this.rear=null;
        this.front=null;
        this.size=0;
    }
    public DynamicQueue(int data){
        this.rear=null;
        this.front=null;
        this.size=0;
        this.offer(data);
    }

    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }

    }

    Node rear;

    Node front;

    int size;


    @Override
    public int peek() {
        if(front==null){
            return -1;
        }
        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return front==null;
    }

    @Override
    public void offer(int data) {
        Node temp= new Node(data);
        if(rear==null){
            front=temp;
            rear=temp;
        }else {
            rear.next=temp;
            rear=temp;
        }
        size++;
        return;
    }

    @Override
    public int poll() {
        if(front==null){
            return -1;
        }
      //  int data=front.data;
        Node temp=front;
        front=front.next;
        temp.next=null;
        size--;
        return temp.data;
    }

    @Override
    public int remove(int num) {
        if(front==null){
            return -1;
        }
        Node temp=front;
        if(front.data==num){
            front=front.next;
            temp.next=null;
            size--;
            return temp.data;
        }
        Node prev=null;
        while(temp!=null){
            if(temp==rear){
                if(temp.data==num){
                    prev.next=null;
                    rear=prev;
                    size--;
                    return num;
                }else{
                    return -1;
                }
            }else {
                if(temp.data==num){
                    prev.next=temp.next;
                    temp.next=null;
                    size--;
                    return num;
                }
            }
            prev=temp;
            temp=temp.next;
        }
        return -1;
    }

    @Override
    public boolean contains(int num) {
        if(front==null){
            return false;
        }else if(front==rear){
            return front.data==num;
        }
        Node temp=front.next;
        while(temp!=null){
            if(temp.data==num){
                return  true;
            }
            temp=temp.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int search(int num) {
        if(front==null){
            return -1;
        }else if(front==rear){
            return 1;
        }
        Node temp=front.next;
        int count=2;
        while(temp!=null){
            if(temp.data==num){
               return count;
            }
            temp=temp.next;
            count++;
        }
        return -1;
    }

    public void print(){
        Node temp=front;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
