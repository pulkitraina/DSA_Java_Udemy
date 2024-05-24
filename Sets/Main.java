import java.util.*;

public class Main {

    public static List<Integer> removeDuplicates(List<Integer> myList){
        Set<Integer> set1 = new HashSet<>();
        for(int i : myList){
            set1.add(i);
        }
        List<Integer> l2 = new ArrayList<>(set1);
        return l2;
    }

    public static boolean hasUniqueChars(String string){
        char c;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < string.length(); i++){
            c = string.charAt(i);
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target){
        List<int[]> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }
        int temp;
        for(int i = 0; i < arr2.length; i++){
            temp = target - arr2[i];
            if(set.contains(temp)){
                result.add(new int[]{temp, arr2[i]});
            }
        }
        
        return result;
    }

    public static int longestConsecutiveSequence(int[] arr){  //longest sequence in which each element is one greater than the other
        Set<Integer> set = new HashSet<>();
        for(int i : arr)
            set.add(i);

        int maxCount = 0;
        for(int i : arr){
            if(!set.contains(i-1)){
                maxCount = maxCount>1?maxCount:1;
            }
            int t = i;
            int temp = 1;
            while(set.contains(t+1)){
                temp += 1;
                t += 1;
            }
            maxCount = temp>maxCount?temp:maxCount;
            System.out.println(maxCount);
        }
        return maxCount;
    }

    public static void main(String[] args) {

        // List<Integer> myList = Arrays.asList(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
        // List<Integer> newList = removeDuplicates(myList);
        // System.out.println(newList);

        int[] arr = new int[]{200, 4, 100, 1, 3, 2};
        System.out.println(longestConsecutiveSequence(arr));
    }
}
