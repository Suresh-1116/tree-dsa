import java.util.*;
public class LevelOrderTraversal {
    
    public static void levelOrderTraversal(List<Integer> result, Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            result.add(node.data);
            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right != null){
                queue.offer(node.right);
            }

        }

    }
}
