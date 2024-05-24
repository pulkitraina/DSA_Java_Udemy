public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
    }

    DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printDLL(){
        Node temp = head;

        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(head == null){
            return null;
        }
        Node temp = tail;
        tail = tail.prev;
        temp.prev = null;
        if(tail == null){
            head = null;
        }
        else{
            tail.next = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);

        if(head == null){
            head = tail = newNode;
            length++;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        length++;
    }

    public Node removeFirst(){
        if(head == null){
            return null;
        }
        if(head.next == null){
            Node temp = head;
            head = tail = null;
            length--;
            return temp;
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        length--;
        return temp;        
    }

    public Node getIndex(int index){
        if(index<0 || index>=length){
            return null;
        }
        Node temp;
        if(index<length/2){
            temp = head;
            for(int i = 0; i<index; i++){
                temp = temp.next;
            }
        }
        else{
            temp = tail;
            for(int i = 0; i<length-index-1; i++){
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean setIndex(int index, int value){
        Node temp = getIndex(index);
        if(temp == null){
            return false;
        }
        else{
            temp.value = value;
        }
        return true;
    }

    public boolean insert(int index, int value){
        if(index<0 || index>length){
            return false;
        }

        Node newNode = new Node(value);
        if(index == 0){
            prepend(value);
        }
        else if(index == length){
            append(value);
        }
        else{
            Node temp = getIndex(index);
            temp.prev.next = newNode;
            newNode.prev = temp.prev;
            newNode.next = temp;
            temp.prev = newNode;
            length++;
        }
        return true;
    }

    public Node remove(int index){
        if(index<0 || index>length-1){
            return null;
        }
        
        if(index == 0){
            return removeFirst();
        }

        if(index == length-1){
            return removeLast();
        }

        Node temp = getIndex(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = temp.prev = null;
        length--;
        return temp;        
    }

    public void swapFirstLast(){
        if(length<2){
            return;
        }
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse(){
        Node temp = head;
        for(int i = 0; i<length; i++){
            Node temp2 = temp.next;
            temp.next = temp.prev;
            temp.prev = temp2;
            temp = temp2;
        }
        temp = head;
        head = tail;
        tail = temp;
    }

    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        for(int i = 0; i<length/2; i++){
            if(head.value != tail.value){
                return false;
            }
            head = head.next;
            tail = tail.prev;
        }
        return true;
    }

    public void swapPairs(){
        if(head == null || head.next == null){
            return;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        Node temp = dummy;

        while(temp.next != null && temp.next.next != null){
            Node first = temp.next;
            Node second = first.next;
            temp.next = second;

            first.next = second.next;
            first.prev = second;

            if(second.next != null){
                second.next.prev = first;
            }
            second.next = first;
            second.prev = temp;

            temp = temp.next.next;
        }
        head = dummy.next;
        head.prev = null;
        dummy.next = null;

        if(temp.next == null){
            tail = temp;
        }
        else{
            tail = temp.next;
        }
    }
}
