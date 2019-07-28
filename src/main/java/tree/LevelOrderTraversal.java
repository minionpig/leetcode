import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String [] args){
    }

    public static String level_order_traversal2(BinaryTreeNode root){
        String result = "";
        if(root==null) return result;
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        BinaryTreeNode currNode;
        while(!queue.isEmpty()){
            currNode = queue.remove();
            if (currNode == null){
                queue.add(null);
            } else {
                result = result+currNode.data+",";
                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right!=null) queue.add(currNode.right);
            }
        }
        return result;
    }

    public static String level_order_traversal(
            BinaryTreeNode root) {
        String result = "";

        ArrayDeque<BinaryTreeNode> currQueue = new ArrayDeque<BinaryTreeNode>();
        ArrayDeque<BinaryTreeNode> nextQueue = new ArrayDeque<BinaryTreeNode>();

        if(root!= null){
            currQueue.addLast(root);
        }

        while(!currQueue.isEmpty() || !nextQueue.isEmpty()){
            if(currQueue.isEmpty()){
                currQueue = nextQueue;
                nextQueue = new ArrayDeque<BinaryTreeNode>();
            }
            BinaryTreeNode currNode = currQueue.removeFirst();
            result = result + currNode.data + ",";
            if(currNode.left!=null) nextQueue.addLast(currNode.left);
            if(currNode.right!=null) nextQueue.addLast(currNode.right);
        }
        return result;
    }
}

class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public  BinaryTreeNode(int data){
        this.data = data;
    }
}
