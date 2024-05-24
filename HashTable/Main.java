import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashTable myHash = new HashTable();
        myHash.printTable();
    }

    public static boolean itemInCommon(int[] arr1, int[] arr2){  //Checks if two arrays have a common Element
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        for(int i : arr1){
            hm.put(i, true);
        }
        for(int i : arr2){
            if(hm.get(i) != null){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> findDuplicates(int[] nums){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer, Integer> i : hm.entrySet()){
            if(i.getValue() > 1){
                arr.add(i.getKey());
            }
        }
        return arr;
    }

    public static Character firstNonRepeatingChar(String s){
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        char[] charSeq = s.toCharArray();

        for(char i : charSeq){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        for(char i : charSeq){
            if(hm.get(i) == 1){
                return i;
            }
        }
        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strings){
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String s : strings){
            char[] chr = s.toCharArray();
            Arrays.sort(chr);
            String s2 = new String(chr);
            if(!hm.containsKey(s2)){
                List<String> arr = new ArrayList<>();
                arr.add(s);
                hm.put(s2, arr);
            }
            else{
                List<String> arr = hm.get(s2);
                arr.add(s);
                hm.put(s2, arr);
            }
        }
        return new ArrayList<>(hm.values());
    }

    public static int[] twoSum(int arr[], int target){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int temp;
        for(int i = 0; i < arr.length; i++){
            temp = target - arr[i];
            if(hm.containsKey(temp)){
                return new int[]{hm.get(temp), i};
            }
            else{
                hm.put(arr[i], i);
            }
        }
        return new int[]{};
    }

    public static int[] subarraySum(int nums[], int target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int temp;
        hm.put(0, -1);
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            temp = target - currSum;
            if(hm.containsKey(temp)){
                return new int[]{hm.get(temp) + 1, i};
            }
            else{
                hm.put(currSum, i);
            }
        }
        return new int[]{};
    }

}

 