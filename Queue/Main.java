public class Main{
    public static void main(String[] args) {
        Queue queue = new Queue(1);
        for(int i = 2; i<10; i++){
            queue.enqueue(i);
        }
        queue.printQueue();
    }
}