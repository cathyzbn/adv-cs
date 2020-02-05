
public class BinaryTree {
   
    private class TreeNode{
        Object item;
        TreeNode left, right;
        
        TreeNode(Object it) {
            item = it;
            left = null;
            right = null;
        }
        
        TreeNode(Object it, TreeNode l, TreeNode r) {
            item = it;
            left = l;
            right = r;
        }
        
        Object get_item() { return item; }
        TreeNode get_left() { return left; }
        TreeNode get_right() { return right; }
        void set_value(Object it) { item = it; }
        void set_right(Object it) { right.set_value(it); }
        void set_left(Object it) { left.set_value(it); }
        
    }    
    private TreeNode root;
    public BinaryTree() { root = null; }
    
    public void add(String word) {
        TreeNode n = new TreeNode(word);
        if (root == null){ root = n; }
        else { add_helper(root, n); }
    }
    
    public void add_helper(TreeNode node, TreeNode n) {
        
    }
    

    
    public static void main(String[] args) {
        
    }
    
}
