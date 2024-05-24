//Full tree is a Complete tree in which every node has either 0 or 2 children
//Complete tree is a tree that has no gaps from left to right while filling by levels
//Perfect tree is a tree in which all nodes except leaf nodes have 2 children and all leaf nodes are at the same level

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Stack;


public class BSTree {
    Node root;

    class Node{
        int value;
        Node left;
        Node right;

        private Node(int value){
            this.value = value;
        }
    }

    public boolean insert(int value){
        Node temp = root;
        Node newNode = new Node(value);
        if(temp == null){
            root = newNode;
            return true;
        }
        while(true){
            if(value>temp.value && temp.right != null){
                temp = temp.right;
            }
            else if(value<temp.value && temp.left != null){
                temp = temp.left;
            }
            else{
                if(temp.value == value)
                    return false;
                break;
            }
        }
        if(value>temp.value){
            temp.right = newNode;
        }
        else{
            temp.left = newNode;
        }
        return true;
    }

    public boolean contains(int value){
        Node temp = root;
        while(temp != null){
            if(value>temp.value){
                temp = temp.right;
            }
            else if(value<temp.value){
                temp = temp.left;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public boolean recContains(Node currNode, int value){
        if(currNode == null){
            return false;
        }
        if(currNode.value == value){
            return true;
        }
        if(currNode.value > value){
            return recContains(currNode.left, value);
        }
        else{
            return recContains(currNode.right, value);
        }
    }

    public Node recInsert(Node currNode, int value){
        if(currNode == null){
            return new Node(value);
        }
        if(value>currNode.value){
            currNode.right = recInsert(currNode.right, value);
        }
        else{
            currNode.left = recInsert(currNode.left, value);
        }
        return currNode;
    }

    public Node recDelete(Node root, int value){
        if(root == null){
            return null;
        }
        if(value > root.value){
            root.right = recDelete(root.right, value);
        }
        else if(value < root.value){
            root.left = recDelete(root.left, value);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                Node min = findMinNode(root.right);
                root.value = min.value;
                root.right = recDelete(root.right, min.value);
                return root;
            }
        }
        return root;
    }

    private Node findMinNode(Node root){
        if(root.left != null){
            return findMinNode(root.left);
        }
        else{
            return root;
        }
    }
    
    public int minValue(Node root){
        if(root.left == null){
            return root.value;
        }
        Node temp = findMinNode(root.left);
        return temp.value;
    }

    public void postPrint(Node root){
        if(root != null){
            System.out.print(root.value + " ");
            postPrint(root.left);
            postPrint(root.right);
        }
    }

    public ArrayList<Integer> BFS(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Node currNode = root;
        queue.add(currNode);

        while(queue.size() > 0){
            currNode = queue.remove();
            result.add(currNode.value);
            if(currNode.left != null){
                queue.add(currNode.left);
            }
            if(currNode.right != null){
                queue.add(currNode.right);
            }
        }
        return result;
    }

    public ArrayList<Integer> DFSPreOrder(){
        ArrayList<Integer> results = new ArrayList<>();

        class DFS{
            DFS(Node currNode){
                results.add(currNode.value);
                if(currNode.left != null){
                    new DFS(currNode.left);
                }
                if(currNode.right != null){
                    new DFS(currNode.right);
                }
            }
        }
        new DFS(root);
        return results;
    }

    public ArrayList<Integer> DFSPostOrder(){
        ArrayList<Integer> results = new ArrayList<>();

        class DFS{
            DFS(Node currNode){
                if(currNode.left != null){
                    new DFS(currNode.left);
                }
                if(currNode.right != null){
                    new DFS(currNode.right);
                }
                results.add(currNode.value);
            }
        }
        new DFS(root);
        return results;
    }

    public ArrayList<Integer> DFSInOrder(){
        ArrayList<Integer> results = new ArrayList<>();

        class DFS{
            DFS(Node currNode){
                if(currNode.left != null){
                    new DFS(currNode.left);
                }
                results.add(currNode.value);
                if(currNode.right != null){
                    new DFS(currNode.right);
                }
            }
        }
        new DFS(root);
        return results;
    }

    public Integer kthSmallest(int k){
        if(k < 1)
            return null;
        if(k == 1)
            return root.value;
        Stack<Integer> stk = new Stack<>();

        class DFS{
            DFS(Node node){
                if(node.right != null){
                    new DFS(node.right);
                }
                stk.push(node.value);
                if(node.left != null){
                    new DFS(node.left);
                }
            }
        }

        new DFS(root);
        int temp = 0;
        for(int i = 0; i < k; i++){
            temp = stk.pop();
            if(stk.size() == 0)
                return null;
        }
        return temp;
    }


}
