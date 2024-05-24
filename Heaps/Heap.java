import java.util.*;

//If given 1-indexing,
//given node = i
//left child = 2*i
//right child = 2*i + 1
//parent = i//2

//If given 0-indexing,
//given node = i
//left child = 2*i + 1
//right child = 2*i + 2
//parent = i//2

public class Heap {
    private List<Integer> heap;
    Heap(){
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap(){
        return new ArrayList<Integer>(heap);
    }

    private int leftChild(int index){
        return 2*index + 1;
    }

    private int rightChild(int index){
        return 2*index + 2;
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value){
        heap.add(value);
        int curr = heap.size() - 1;

        while(curr>0 && heap.get(curr) > heap.get(parent(curr))){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public Integer remove(){  //Removal in heaps is always of the root node
        if(heap.size() == 0)
            return null;
        
        if(heap.size() == 1){
            return heap.remove(0);
        }
        else{
            int maxVal = heap.get(0);
            heap.set(0, heap.remove(heap.size()-1));
            
            heapify(0);

            return maxVal;
        }
    }

    private void heapify(int index){

        int curr = index;

        while(curr<heap.size()){
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if(rightIndex < heap.size() && heap.get(rightIndex) > heap.get(curr)){
                curr = rightIndex;
            }
            if(leftIndex < heap.size() && heap.get(leftIndex) > heap.get(curr)){
                curr = leftIndex;
            }

            if(curr != index){
                swap(curr, index);
                index = curr;
            }
            else{
                break;
            }
        }   
    }

    public void makeHeap(int[] nums){
        for(int i = 0; i < nums.length; i++){
            insert(nums[i]);
        }
    }

    public void printHeap(){
        System.out.println(heap);
    }





}
