import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    
    public static void usingRecursion(List<Integer> result, Node root){
        if(root == null){
            return;
        }

        usingRecursion(result, root.left);
        usingRecursion(result, root.right);

        result.add(root.data);
    }

    public static void usingIterative(List<Integer> result, Node root){
        if(root == null){
            return;
        }

        Stack<Node> stack1 = new Stack<>();

        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty()){
            Node node = stack1.pop();

            stack2.push(node);

            if(node.left != null){
                stack1.push(node.left);
            }

            if(node.right != null){
                stack1.push(node.right);
            }
        }

        while(!stack2.isEmpty()){
            result.add(stack2.pop().data);
        }
    }
}
