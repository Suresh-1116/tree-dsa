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
            return node1 == node2;
        }

        if(node1.data != node2.data){
            return false;
        }



        return indenticalOrNot(node1.left, node2.left) && indenticalOrNot(node1.right, node2.right);
    }
}
