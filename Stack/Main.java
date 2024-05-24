public class Main {
    public static void sortStack(Stack2<Integer> stack){
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
    public static void main(String[] args) {
        Stack2<Integer> stack = new Stack2<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(4);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();
    }
}

