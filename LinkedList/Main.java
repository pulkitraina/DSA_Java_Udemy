public class Main {
    public static void main(String[] args) {
        LinkedList myLL = new LinkedList(4);

        myLL.append(5);
        
        int t = myLL.removeFirst().value;
        System.out.println(t);
        
    }
}

