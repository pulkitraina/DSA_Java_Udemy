import java.util.*;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;
    
    public HashTable(){
        dataMap = new Node[size];
    }

    class Node{
        private String key;
        private int value;
        private Node next;

        Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public void printTable(){
        for(int i = 0; i < dataMap.length; i++){
            System.out.println(i + ": ");
            Node temp = dataMap[i];
            while(temp != null){
                System.out.print(temp.key + ":" + temp.value + " ");
                temp = temp.next;
            }
        }
    }

    private int hash(String key){
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for(int i = 0; i<keyChars.length; i++){
            hash += ((int)keyChars[i] * 23)%dataMap.length;  //Multiply by 23 cause 23 is prime and makes the hash more random
        }
        return hash;
    }

    public void set(String key, int value){
        int hash = hash(key);
        Node newNode = new Node(key, value);
        if(dataMap[hash] == null){
            dataMap[hash].next = newNode;
        }
        else{
            Node temp = dataMap[hash];
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key){
        int hash = hash(key);

        Node temp = dataMap[hash];
        while(temp != null){
            if(temp.key == key){
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList<String> keys(){
        ArrayList<String> arr = new ArrayList<>();

        for(int i = 0; i < dataMap.length; i++){
            Node temp = dataMap[i];
            while(temp != null){
                arr.add(temp.key);
                temp = temp.next;
            }
        }
        return arr;
    }

}
