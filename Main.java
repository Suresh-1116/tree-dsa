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

        Node root1 = new Node(1, n2, n3);

        root1 = null;


        Node nr7 = new Node(7, null, null);
        Node nr6 = new Node(6, null, null);
        Node nr5 = new  Node(5, null, null);
        Node nr4 = new Node(4, null, null);

        Node nr3 = new Node(3, nr6, nr7);
        Node nr2 = new Node(2, nr4, nr5);

        Node root2 = new Node(1, nr2, nr3);


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

        //System.out.print(TreeProblems.balancedTree(root) != -1);

        int[] maxi = new int[1];

        maxi[0] = Integer.MIN_VALUE;

        //TreeProblems.diameterOfTree(root, maxi);

        //TreeProblems.maxPathSum(root, maxi);

        //List<List<Integer>> result = TreeProblems.zigZag(root1);

        // for(List<Integer> subList: result){
        //     System.out.println(subList);
        // }

        List<Integer> result = new ArrayList<>();


        if(root1 != null && !TreeProblems.isLeaf(root1)){
            result.add(root1.data);
        }


        if(root1 != null){
            TreeProblems.leftBoundaryNodes(root1, result);
            TreeProblems.leafNodes(root1, result);
            TreeProblems.rightBoundaryNodes(root1, result);
        }

        System.out.println(result);
        

        //System.out.println(TreeProblems.indenticalOrNot(root1, root2));
        
    }
}
