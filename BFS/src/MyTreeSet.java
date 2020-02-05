// Implements a BST with TreeNode nodes

import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")

public class MyTreeSet implements Iterable<Object> {
  private TreeNode root;  // holds the root of this BST

  public MyTreeSet(){ root = null; }

  public boolean contains(Object value){ return contains(root, value); }

  public boolean add(Object value){
    if (contains(value)) return false;
    root = add(root, value);
    return true;
  }

  public boolean remove(Object value) {
    if (!contains(value)) return false;
    root = remove(root, value);
    return true;
  }

  public String toString(){
    String str = toString(root);
    if (str.endsWith(", ")) str = str.substring(0, str.length() - 2);
    return "[" + str + "]";
  }

  public Iterator<Object> iterator(){ return new MyTreeSetIterator(root); }

  private boolean contains(TreeNode node, Object value){
    if (node == null) return false;
    else {
      int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
      if (diff == 0) return true;
      else if (diff < 0) return contains(node.getLeft(), value);
      else return contains(node.getRight(), value);
    }
  }

/*
  // Iterative version:
  private boolean contains(TreeNode node, Object value)
  {
    while (node != null)
    {
      int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
      if (diff == 0)
        return true;
      else if (diff < 0)
        node = node.getLeft();
      else // if (diff > 0)
        node = node.getRight();
    }
    return false;
  }
*/

  private TreeNode add(TreeNode node, Object value){
    if (node == null) node = new TreeNode(value);
    else {
      int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
      if (diff < 0) node.setLeft(add(node.getLeft(), value));
      else node.setRight(add(node.getRight(), value));
    }
    return node;
  }

  private TreeNode remove(TreeNode node, Object value)
  {
    int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
    if (diff == 0) node = removeRoot(node);
    else if (diff < 0) node.setLeft(remove(node.getLeft(), value));
    else node.setRight(remove(node.getRight(), value));
    return node;
  }

  private TreeNode removeRoot(TreeNode root){
      if (root.getLeft() == null) return root.getRight();
      else if (root.getRight() == null) return root.getLeft();
      else {
          TreeNode min_node = root.getRight();
          while(min_node.getLeft() != null) {
              min_node = min_node.getLeft();
          }
          root.setValue(min_node.getValue());
          root.setRight(remove(root.getRight(), min_node.getValue()));
          return root;
      }
  }
  
  
  private String toString(TreeNode node) {
    if (node == null) return "";
    else return toString(node.getLeft()) + node.getValue() + ", " + toString(node.getRight());
  
  }

  // Implements an Iterator for this tree.
  private class MyTreeSetIterator implements Iterator<Object>{
      
      Stack<TreeNode> s;
      
      private void push_traverse(TreeNode r) {
          if (r != null) {
              push_traverse(r.getRight());
              s.push(r);
              push_traverse(r.getLeft());
          }
      }
      
      MyTreeSetIterator(TreeNode r){
          s = new Stack<TreeNode>();
          push_traverse(r);
      }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return !s.empty();
    }

    @Override
    public Object next() {
        // TODO Auto-generated method stub
        if (hasNext()) return s.pop().getValue();
        else return null;
    }
      
  }


  public static void main(String[] args)
  {
//    String[] words = {"One", "Two", "Three", "Four", "Five",
//                      "Six", "Seven", "Eight", "Nine", "Ten"};
      String[] words = {"a", "h", "c", "d", "e",
              "f", "g", "b", "j", "i"};
    MyTreeSet bst = new MyTreeSet();

    for (String word : words){
      System.out.println("Added: " + word + " " + bst.add(word));
      System.out.println("Contains: " + word + " " + bst.contains(word));
      if(bst.add(word)) System.out.println("*** Added a duplicate value ***");
      System.out.println(bst);
    }

    System.out.println("Traversal with an iterator:");
    for (Object obj : bst) System.out.print(obj + " ");
    System.out.println();

    for (String word : words){
      System.out.println(word);
      System.out.println("Removed: " +  word + " " + bst.remove(word));
      if(bst.remove(word)) System.out.println("*** Removed a non-existent value ***");
      System.out.println(bst);
    }
  }
}
