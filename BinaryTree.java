/**
 * An object of this class represents a Binary Tree data structure 
 * @author Hussein Suleman
 * @since 26 March 2017
 * @param <dataType> Any class type
 */
public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   
   public BinaryTree ()
   {
      root = null;
   }
   
   /**
    * This subroutine obtains the height of the binary tree
    * @return Height of tree
    */
   public int getHeight ()
   {
      return getHeight (root);
   } 
   /**
    * This subroutine obtains the height of the binary tree starting at the given node
    * @param node Starting point or node of the tree
    * @return Height of the tree
    */
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   /**
    * This subroutine obtains the size of the binary tree
    * @return Size of the tree
    */
   public int getSize ()
   {
      return getSize (root);
   } 
   
   /**
    * This subroutine obtains the size of the binary tree starting at the given node
    * @param node Starting point or node of the tree
    * @return Size of the tree
    */
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   /**
    * This subroutine print the data at the given node
    * @param node Node data to be printed 
    */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   
   /**
    * This subroutine prints the contents of the binary tree in pre-order format
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   /**
    * This subroutine prints the contents of the binary tree in pre-order format starting at the given node
    * @param node Starting point of printing
    */
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }
   
   /**
    * This subroutine prints the contents of the binary tree in post-order format
    */
   public void postOrder ()
   {
      postOrder (root);
   }
   /**
    * This subroutine prints the contents of the binary tree in post-order format starting at the given node
    * @param node Starting point of printing
    */
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }
   
   /**
    * This subroutine prints the contents of the binary tree in in-order format
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   /**
    * This subroutine prints the contents of the binary tree in in-order format starting at the given node
    * @param node Starting point of printing
    */
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
   
   /**
    * This subroutine prints the contents of the binary tree in level-order format
    */
   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}
