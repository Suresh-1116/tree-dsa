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
}
