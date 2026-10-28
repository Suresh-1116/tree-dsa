import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args){
        //List<List<Integer>> result = new ArrayList<>();

        Node n7 = new Node(7, null, null);
        Node n6 = new Node(6, null, null);
        Node n5 = new  Node(5, null, null);
        Node n4 = new Node(4, null, null);

        Node n3 = new Node(3, n6, n7);
        Node n2 = new Node(2, n4, n5);

        Node root = new Node(1, n2, n3);

        //usingRecursion(result, root);
        //PreOrderTraversal.usingIterative(result, root);

        //InOrderTraversal.usingRecursion(result, root);
        //InOrderTraversal.usingIterative(result, root);

       // PostOrderTraversal.usingRecursion(result, root);
       //PostOrderTraversal.usingIterative(result, root);

       //LevelOrderTraversal.levelOrderTraversal(result, root);
       //ThreeTraversal.threeTraversal(result, root);
        // for(List<Integer> num: result){
        //     System.out.println(num + " ");
        // }

        System.out.print(TreeProblems.balancedTree(root) != -1);
        
    }
}
