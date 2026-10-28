import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    
    public static void usingRecursion(List<Integer> result, Node root){
        if(root == null){
            return;
        }

        usingRecursion(result, root.left);
        result.add(root.data);
        usingRecursion(result, root.right);
    }

    public static  void usingIterative(List<Integer> result, Node root){
        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();

        //stack.push(root);

        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                Node node = stack.pop();
                result.add(node.data);
                root = node.right;
            }

        }
    }
}
