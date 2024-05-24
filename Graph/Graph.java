import java.util.*;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex){
        if(!adjList.containsKey(vertex)){
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String v1, String v2){
        if(!adjList.containsKey(v1) || !adjList.containsKey(v2)){
            return false;
        }
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
        return true;
    }

    public boolean removeEdge(String v1, String v2){
        if(!adjList.containsKey(v1) || !adjList.containsKey(v2)){
            return false;
        }
        adjList.get(v1).remove(v2);
        adjList.get(v2).remove(v1);
        return true;
    }

    public boolean removeVertex(String v1){
        if(!adjList.containsKey(v1)){
            return false;
        }
        // adjList.remove(v1);
        // for(Map.Entry<String, ArrayList<String>> i : adjList.entrySet()){
        //     if(i.getValue().contains(v1)){
        //         i.getValue().remove(v1);
        //     }
        // }
        // return true;

        for(String i : adjList.get(v1)){
            adjList.get(i).remove(v1);
        }
        adjList.remove(v1);
        return true;
    }

    public void printAdjList(){
        System.out.println(adjList);
    }

}
