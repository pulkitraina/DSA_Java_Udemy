public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;
    
        Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public LinkedList() {
    }

    public void printList(){
        Node temp = head;
        if(temp == null){
            System.out.println("NULL");
        }
        else{
            while(temp != null){
                System.out.println(temp.value);
                temp = temp.next;
            }
            System.out.println("NULL");
        }
    }

    public void getHead(){
        System.out.println("Head: " + head.value);
    }

    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

    public void append(int value){
        Node newNode = new Node(value);

        if(length == 0){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = tail.next;
        }
        length++;
    }

    public Node removeLast(){
        Node temp = head;
        if(temp!=null && temp.next != null){
            while(temp.next!=tail){
                temp = temp.next;
            }
            tail = temp;
            Node temp2 = tail.next;
            tail.next = null;
            length--;
            return temp2;
        }
        else{
            head = tail = null;
            length = 0;
            return temp;
        }
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if(length==0){
            tail = head;
        }
        length++;
    }

    public Node removeFirst(){
        if(head!=null){
            if(head.next != null){
                Node temp = head;
                head = head.next;
                temp.next = null;
                length--;
                return temp;
            }
            else{
                return removeLast();
            }
        }
        else{
            return null;
        }
    }

    public Node getIndex(int index){
        if(index<0 || index>length-1){
            return null;
        }
        else{
            Node temp = head;
            for(int i = 0; i<index; i++){
                temp = temp.next;
            }
            return temp;
        }
    }

    public boolean setIndex(int index, int value){
        Node temp = getIndex(index);

        if(temp == null){
            return false;
        }
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value){
        if(index<0 || index>length){
            return false;
        }
        else{
            if(index == 0){
                prepend(value);
            }
            else{
                Node temp = head;
                for(int i = 0; i<index-1; i++){
                    temp = temp.next;
                }
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;
                length++;
            }
            return true;
        }
    }

    public Node remove(int index){
        if(index<0 || index>length-1){
            return null;
        }
        if(index==0){
            return removeFirst();
        }
        if(index==length-1){
            return removeLast();
        }
        Node temp = head;
        for(int i = 0; i < index-1; i++){
            temp = temp.next;
        }
        Node temp2 = temp.next;
        temp.next = temp.next.next;
        temp2.next = null;
        length--;
        return temp2;
    }

    public void reverse(){
        if(head == null || head.next == null){
            Node temp = head;
            head = tail;
            tail = temp;
            return;
        }
        Node temp = head;
        Node before = null;
        Node after = head.next;
        while(after != null){
            temp.next = before;
            before = temp;
            temp = after;
            after = after.next;
        }
        temp.next = before;
        tail = head;
        head = temp;
    }

    public Node findMiddleNode(){
        Node Hare = head;
        Node Tortoise = head;
        while(Hare != null && Hare.next != null){
            Hare = Hare.next.next;
            Tortoise = Tortoise.next;
        }
        return Tortoise;
    }

    public boolean hasLoop(){
	    Node hare;
	    Node tort;
	    hare = tort = head;
	    
	    while(hare != null && hare.next != null){
	        hare = hare.next.next;
	        tort = tort.next;
	        if(hare == tort){
	            return true;
	        }
	    }
	    return false;
	}

    public Node findKthFromEnd(int k){
	    Node fast;
	    Node slow;
	    fast = slow = head;
	    for(int i = 0; i<k; i++){
	        if(fast==null){
	            return null;
	        }
	        fast = fast.next;
	    }
	    while(fast!=null){
	        fast = fast.next;
	        slow = slow.next;
	    }
	    return slow;
	}

    public void partitionList(int x){
        if(head == null || head.next == null){
            return;
        }
        
        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-2);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node temp = head;
        
        while(temp!=null){
            if(temp.value<x){
                prev1.next = temp;
                prev1 = temp;
            }
            else{
                prev2.next = temp;
                prev2 = temp;
            }
            temp = temp.next;
        } 
        prev1.next = dummy2.next;
        prev2.next = null;
        head = dummy1.next;
        dummy2.next = dummy1.next = null;
    }

    public void removeDuplicates(){
        if(head == null || head.next == null)
            return;
        
        Node current = head;
        
        while(current != null){
            Node runner = current.next;
            Node runfollow = current;
            while(runner != null){
                if (runner.value==current.value){
                    runfollow.next = runner.next;
                    runner.next = null;
                    runner = runfollow.next;
                }
                else{
                    runner = runner.next;
                    runfollow = runfollow.next;
                }
            }
            current = current.next;
        }
        
    }

    public void reverseBetween(int m, int n){
        if (head == null) return;
    
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;
    
        for (int i = 0; i < m; i++) {
            previousNode = previousNode.next;
        }
    
        Node currentNode = previousNode.next;
    
        for (int i = 0; i < n - m; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }
    
        head = dummyNode.next;
    }
}
