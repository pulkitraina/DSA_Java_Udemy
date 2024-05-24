public class Queue {
    private Node first;
    private Node last;
    private int length;
    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    Queue(int value){
        Node newNode = new Node(value);
        first = last = newNode;
        length = 1;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        
        if(first == null){
            first = last = newNode;
        }
        else{
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        if(first == null){
            return null;
        }
        Node temp = first;
        if(first.next == null){
            first = last = null;
            length--;
            return temp;
        }
        first = first.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void printQueue(){
        Node temp = first;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
