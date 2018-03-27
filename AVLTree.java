/**
 * An object of the class represents an AVL tree
 * @author Hussein Suleman 
 * @since 2 April 2017
 */
public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   public static int insertCounter = 0;
   /**
    * This subroutine obtains the height of the AVL tree starting at the given node
    * @param node Starting point or node of the tree
    * @return Height of the tree
    */
   public int height ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   /**
    * This subroutine determines the height difference between left and right subtree
    * @param node Starting point of calculation 
    * @return Height difference 
    */
   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }
   
   /**
    * This subroutine fixes the heights of subtrees in order to maintain AVL tree form
    * @param node Starting point of re-adjustment
    */
   public void fixHeight ( BinaryTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   /**
    * This subroutine performs insertion into right subtree of right child
    * @param p Use rotations at the given node 
    * @return New node position
    */
   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }
   
   /**
    * This subroutine performs insertion into left subtree of left child
    * @param q Use rotations at the given node 
    * @return New node position
    */
   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   /**
    * This subroutine re-balances all nodes potentially affected
    * @param p Starting point of balancing
    * @return new node position
    */
   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }
   /**
    * This subroutine insert the given value into AVL Tree
    * @param d The value to be inserted
    */
   public void insert ( dataType d )
   {
      root = insert (d, root);
   }
   /**
    * This subroutine insert the given value into the AVL tree at the given node
    * @param d Value to be inserted 
    * @param node Position of inserting
    * @return New subtree
    */
   public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return new BinaryTreeNode<dataType> (d, null, null);
         
      insertCounter++;
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
   }
   /**
    * This subroutine deletes the given value from AVL tree
    * @param d The value to be deleted
    */
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
   /**
    * This subroutine deletes the given value from AVL tree at the given point
    * @param d The value to be deleted
    * @param node Position of deletion 
    * @return new subtree
    */
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else
      {
         BinaryTreeNode<dataType> q = node.left;
         BinaryTreeNode<dataType> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<dataType> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   /**
    * This subroutine find the minimum in the AVL tree
    * @param node Starting node 
    * @return Node containing minimum
    */
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }
   
   /**
    * This subroutine removes the minimum in the AVL tree
    * @param node Starting node 
    * @return New subtree
    */
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }
   
   /**
    * This subroutine prints the contents of the AVL tree in tree-order format
    */
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   /**
    * This subroutine prints the contents of the AVL tree in tree-order format starting at the given node
    * @param node Starting point of printing
    * @param level The AVL tree level
    * 
    */
   public void treeOrder ( BinaryTreeNode<dataType> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}

