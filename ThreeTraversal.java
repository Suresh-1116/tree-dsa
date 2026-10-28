import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Combine{
    Node node;
    int index;

    public Combine(Node node, int index){
        this.node = node;
        this.index = index;
    }
}


public class ThreeTraversal {

    
    
    public static void threeTraversal(List<List<Integer>> result, Node root){

        if(root == null){
            return;
        }

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();


        Stack<Combine> stack = new Stack<>();

        stack.push(new Combine(root, 1));

        while(!stack.isEmpty()){
            Combine combine = stack.pop();

            if(combine.index == 1){
                preOrder.add(combine.node.data);
                stack.push(new Combine(combine.node, 2));

                if(combine.node.left != null){
                    stack.push(new Combine(combine.node.left, 1));
                }
            }

            if(combine.index == 2){
                Node node = combine.node;
                inOrder.add(node.data);
                stack.push(new Combine(node, 3));

                if(node.right != null){
                    stack.push(new Combine(node.right, 1));
                }
            }

            if(combine.index == 3){
                postOrder.add(combine.node.data);
            }
        }

        result.add(preOrder);
        result.add(inOrder);
        result.add(postOrder);
    }
}
