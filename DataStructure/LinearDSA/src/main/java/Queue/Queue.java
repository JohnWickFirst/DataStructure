package Queue;

public interface Queue {

    public int peek();

    public boolean isEmpty();

    public void offer(int data);

    public int poll();

    public int remove(int data);

    public boolean contains(int data);

    public int size();

    public int search(int num);

    public void print();

}
