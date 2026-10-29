import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeProblems {
    public static int maxDepth(Node node){

        if(node == null){
            return 0;
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        return 1 + Math.max(left, right);
    }

    public static int balancedTree(Node node){
        if(node == null){
            return 0;
        }
        int left = balancedTree(node.left);
        if(left == -1){
            return -1;
        }
        int right = balancedTree(node.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
            return -1;
        }
        return 1 + Math.max(left, right);
    }

    public static int diameterOfTree(Node node, int[] maxi){
        if(node == null){
            return 0;
        }

        int left = diameterOfTree(node.left, maxi);
        int right = diameterOfTree(node.right, maxi);

        maxi[0] = Math.max(maxi[0], left + right);

        return 1 + Math.max(left, right);
    }


    public static int maxPathSum(Node node, int[] maxi){
        if(node == null){
            return 0;
        }

        int left = Math.max(0, maxPathSum(node.left, maxi));
        int right = Math.max(0, maxPathSum(node.right, maxi));

        maxi[0] = Math.max(maxi[0], left + right + node.data);

        return Math.max(left, right) + node.data;
    }

    public static boolean indenticalOrNot(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1 == null || node2 == null){
            return false;
        }

        if(node1.data != node2.data){
            return false;
        }

        return indenticalOrNot(node1.left, node2.left) && indenticalOrNot(node1.right, node2.right);
    }


    public static List<List<Integer>> zigZag(Node node){

        if(node == null){
            return new ArrayList<>();
        }
        

        Queue<Node> q = new LinkedList<>();

        boolean leftToRight = true;

        List<List<Integer>> result = new ArrayList<>();

        q.offer(node);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node curNode = q.poll();
                subList.add(curNode.data);

                if(curNode.left != null){
                    q.offer(curNode.left);
                }

                if(curNode.right != null){
                    q.offer(curNode.right);
                }

            }

            if(!leftToRight){
                Collections.reverse(subList);
            }
            
            result.add(subList);
            leftToRight = !leftToRight;
            
        }

        return result;
    }


    public static boolean isLeaf(Node node){
        return (node.left == null && node.right == null);
    }

    public static void leftBoundaryNodes(Node node, List<Integer> result){

        Node cur = node.left;

        while(cur != null){
            if(!isLeaf(cur)){
                result.add(cur.data);
            }

            if(cur.left != null){
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
    }

    public static void leafNodes(Node node, List<Integer> result){
        if(isLeaf(node)){
            result.add(node.data);
            return;
        }

        if(node.left != null)
            leafNodes(node.left, result);

        if(node.right != null)
            leafNodes(node.right, result);
    }

    public static void rightBoundaryNodes(Node node, List<Integer> result){
        Node cur = node.right;

        Stack<Integer> stack = new Stack<>();

        while(cur != null){
            if(!isLeaf(cur)){
                stack.push(cur.data);
            }

            if(cur.right != null){
                cur = cur.right;
            }
            else{
                cur = cur.left;
            }
        }

        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
    }
}
