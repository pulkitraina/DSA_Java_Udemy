import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Heap heap = new Heap();

        // heap.insert(95);
        // heap.insert(75);
        // heap.insert(80);
        // heap.insert(55);
        // heap.insert(60);
        // heap.insert(50);
        // heap.insert(65);

        // heap.printHeap();
        // System.out.println("After: ");
        // heap.remove();

        // heap.printHeap();

        int[] arr = {7,10,4,3,20,15};
        Heap heap2 = new Heap();
        heap2.makeHeap(arr);
        
    }

    public static int findKthSmallest(int[] nums, int k){
        int n = nums.length - k + 1;
        Heap heap = new Heap();

        heap.makeHeap(nums);
        int i;
        for(i = 0; i < n-1; i++){
            heap.remove();
        }
        return heap.remove();
    }

    public static List<Integer> streamMax(int[] nums){
        List<Integer> result = new ArrayList<>();

        Heap heap = new Heap();
        for(int i = 0; i < nums.length; i++){
            heap.insert(nums[i]);
            result.add(heap.getHeap().get(0));
        }
        Arrays.asList(result);
        return result;

    }

}
