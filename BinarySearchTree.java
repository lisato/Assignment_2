// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x ) --> Insert x
// Comparable find( x ) --> Return item that matches x
// boolean isEmpty( ) --> Return true if empty; else false
// void postOrder( x ) --> print all items in post order format
// ******************ERRORS********************************
// Exceptions are thrown by insert if warranted

/**
 * An object of this class represents a binary search tree. 
 * It contains a BinaryNode root and a count for the comparisons made in the insert method.
 * @author Oyama Plati
 *
 * @param <AnyType> Any class type
 */
public class BinarySearchTree <AnyType extends Comparable<? super AnyType>> {
   
   protected BinaryNode<AnyType> root;
   public static int insertCount = 0;
   
   public BinarySearchTree () {
      root = null;
   }
   
   /**
    * This subroutine inserts data into the Binary search tree.
    * @param x AnyType generic 
    */
   public void insert (AnyType x) {
      try {
         root = insert (x, root);
      } 
      catch (DuplicateItemException e) {
         System.out.println(e.getMessage());
      }
   }
   
   /**
    * This subroutine determines whether the Binary search tree is empty
    * @return True/False
    */
   public boolean isEmpty () { 
      return root == null;
   }
   
   /**
    * Internal method to insert into a subtree.
    * @param x the item to insert.
    * @param t the node that roots the tree.
    * @return the new root.
    * @throws DuplicateItemException if x is already present.
    */
   protected BinaryNode<AnyType> insert
      (AnyType x, BinaryNode<AnyType> t) throws DuplicateItemException { 
      
      if (t == null) {
         t = new BinaryNode<AnyType> (x);
      }
      else if (x.compareTo (t.element) < 0) {
    	 insertCount++;
         t.left = insert (x, t.left);
      }
      else if (x.compareTo (t.element) > 0) {
    	 insertCount++;
         t.right = insert (x, t.right);
      }
      else { 
         throw new DuplicateItemException (x.toString()); // Duplicate
      }
      return t;   
   }
   
   /**
    * This subroutine prints the contents of a Binary search tree in post-order format
    */
   public void postOrder () {
      postOrder(root);
   }
   
   /**
    * This subroutine prints the contents of a Binary search tree in post-order format
    * @param t Starting point of print order
    */
   protected void postOrder (BinaryNode<AnyType> t) {
      if (t != null)
      {
          postOrder (t.left);             
          postOrder (t.right);
          System.out.println (t.element);
      }
   }  
}