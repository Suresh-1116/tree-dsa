import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;



class AxisCombine{
    Node node;
    int xaxis;
    int yaxis;

    public AxisCombine(Node node, int xaxis, int yaxis){
        this.node = node;
        this.xaxis = xaxis;
        this.yaxis = yaxis;
    }
}

class Pair{
    Node node;
    int xaxis;

    public Pair(Node node, int xaxis){
        this.node = node;
        this.xaxis = xaxis;
    }
}



public class TreeProblems {

    //PROBLEM 1: MAXIMUM DEPTH OF THE BINARY TREE
    public static int maxDepth(Node node){
        if(node == null){
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return 1 + Math.max(left, right);
    }




    //PROBLEM 2: CHECK IF THE BINARY TREE IS BALANCED OR NOT
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





    //PROBLEM 3: DIAMETER OF THE BINARY TREE
    public static int diameterOfTree(Node node, int[] maxi){
        if(node == null){
            return 0;
        }
        int left = diameterOfTree(node.left, maxi);
        int right = diameterOfTree(node.right, maxi);
        maxi[0] = Math.max(maxi[0], left + right);
        return 1 + Math.max(left, right);
    }





    //PROBLEM 4: MAXIMUM PATH SUM IN THE BINARY TREE
    public static int maxPathSum(Node node, int[] maxi){
        if(node == null){
            return 0;
        }
        int left = Math.max(0, maxPathSum(node.left, maxi));
        int right = Math.max(0, maxPathSum(node.right, maxi));
        maxi[0] = Math.max(maxi[0], left + right + node.data);
        return Math.max(left, right) + node.data;
    }





    //PROBLEM 5: CHECK IF TWO TREES ARE IDENTICAL OR NOT
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





    //PROBLEM 6: ZIG-ZAG OR SPIRAL TRAVERSAL OF TREE
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






    //PROBLEM 7: BOUNDARY TRAVERSAL OF THE TREE
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





    //PROBLEM 8: VERTICAL TRAVERSAL FO BINARY TREE (CAN USE ARRAYLIST IF DON"T WANT TO SORT THE NODE VALUES)
    public static List<List<Integer>> verticalTraversal(Node node){
        List<List<Integer>> res = new ArrayList<>();
        if(node == null){
            return res;
        }
        Queue<AxisCombine> queue = new LinkedList<>();
        queue.offer(new AxisCombine(node, 0, 0));
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> hash = new TreeMap<>();
        while(!queue.isEmpty()){
            AxisCombine comb = queue.poll();
            Node cur = comb.node;
            int x = comb.xaxis;
            int y = comb.yaxis;
            if(!hash.containsKey(x)){
                hash.put(x, new TreeMap<>());
            }
            if(!hash.get(x).containsKey(y)){
                hash.get(x).put(y, new PriorityQueue<>());
            }
            hash.get(x).get(y).offer(cur.data);
            if(cur.left != null){
                queue.offer(new AxisCombine(cur.left, x - 1, y + 1));
            }
            if(cur.right != null){
                queue.offer(new AxisCombine(cur.right, x + 1, y + 1));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> map : hash.values()){
            List<Integer> sublist = new ArrayList<>();
            for(PriorityQueue<Integer> q: map.values()){
                while(!q.isEmpty()){
                    sublist.add(q.poll());
                }
            }
            res.add(sublist);
        }
        return res;
    }




    //PROBLEM 9: TOP VIEW OF BINARY TREE
    public static List<Integer> topView(Node node){
        List<Integer> result = new ArrayList<>();
        if(node == null){
            return result;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(node, 0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            Node cur = p.node;
            int x = p.xaxis;
            if(!map.containsKey(x)){
                map.put(x, cur.data);
            }
            if(cur.left != null){
                queue.offer(new Pair(cur.left, x - 1));
            }
            if(cur.right != null){
                queue.offer(new Pair(cur.right, x + 1));
            }
        }
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            result.add(m.getValue());
        }
        return result;
    }




    //PROBLEM 10: BOTTOM VIEW OF THE BINARY TREE
    public static List<Integer> bottomView(Node node){
        List<Integer> result = new ArrayList<>();
        if(node == null){
            return result;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(node, 0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            Node cur = p.node;
            int x = p.xaxis;
            map.put(x, cur.data);
            if(cur.left != null){
                queue.offer(new Pair(cur.left, x - 1));
            }
            if(cur.right != null){
                queue.offer(new Pair(cur.right, x + 1));
            }
        }
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            result.add(m.getValue());
        }
        return result;
    }


    
    //PROBLEM 10: RIGHT/LEFT VIEW OF BINARY TREE (FOR LEFT VIEW JUST SWAP .left AND .right RECURSIVE CALLS)
    public static void rightView(Node node, int level, List<Integer> result){
        if(node == null){
            return ;
        }
        if(level == result.size()){
            result.add(node.data);
        }
        rightView(node.right, level + 1, result);
        rightView(node.left, level + 1, result);
    }



    //PROBLEM 11: CHECK IF TWO TREES ARE SYMMETRICAL
    public static boolean isSymmetrical(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        if(node1.data != node2.data){
            return false;
        }
        return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
    }



    //PROBLEM 12: PRINT PATH FROM ROOT TO NODE
    public static boolean rootToNodePath(Node node, int target, List<Integer> result){
        if(node == null){
            return false;
        }
        result.add(node.data);
        if(node.data == target){
            return true;
        }
        if(rootToNodePath(node.left, target, result) || rootToNodePath(node.right, target, result)){
            return true;
        }
        result.remove(result.size() - 1);
        return false;
    }



    //PROBLEM 13: COMMON ANCESTOR BETWEEN TWO NODES
    public static Node lowestCommonAncestor(Node node, Node p, Node q){
        if(node == null || node == p || node == q){
            return node;
        }
        Node left = lowestCommonAncestor(node.left, p, q);
        Node right = lowestCommonAncestor(node.right, p, q);

        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else{
            return node;
        }
    }



    //PROBLEM 14: 
}
