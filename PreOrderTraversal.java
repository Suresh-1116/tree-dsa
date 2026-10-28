import java.util.*;

public class PreOrderTraversal {
    
    

    public static void main(String[] args){
        List<Integer> result = new ArrayList<>();

        Node n7 = new Node(7, null, null);
        Node n6 = new Node(6, null, null);
        Node n5 = new  Node(5, null, null);
        Node n4 = new Node(4, null, null);

        Node n3 = new Node(3, n6, n7);
        Node n2 = new Node(2, n4, n5);

        Node root = new Node(1, n2, n3);

        //usingRecursion(result, root);
        usingIterative(result, root);

        for(int num: result){
            System.out.print(num + " ");
        }
    }

    public static void usingRecursion(List<Integer> result, Node root){

        if(root == null){
            return;
        }

        result.add(root.data);

        usingRecursion(result, root.left);

        usingRecursion(result, root.right);


    }

    public static void usingIterative(List<Integer> result, Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            result.add(node.data);

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }
        }
    }
}
