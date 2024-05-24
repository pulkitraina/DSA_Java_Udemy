public class Stack{
    private int height;
    private Node top;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack(){
        Node temp = top;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public int getHeight() {
        return height;
    }

    public Node getTop() {
        return top;
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(top == null){
            top = newNode;
        }
        else{
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        if(top == null){
            return null;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

    public void sortStack(Stack2<Integer> stack){
        Stack2<Integer> stk = new Stack2<>();
        while(!stack.isEmpty()){
            stack.printStack();
            stk.printStack();

            Integer temp = (Integer)stack.pop();
            if(stk.peek() == null){
                stk.push(temp);
                continue;
            }
            if(temp>=stk.peek()){
                stk.push(temp);
            }
            else{
                while((stk.peek() != null) && (stk.peek()>temp)){
                    stack.push((Integer)stk.pop());
                }
                stk.push(temp);
            }
        }
        while(true){
            Integer temp = (Integer)stk.pop();
            if(temp != null){
                stack.push(temp);
            }
            else{
                break;
            }
        }
    }
}
