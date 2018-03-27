/**
 * An object of this class represents a node for the AVL tree data structure. 
 * A node object has a left and right node also the data in the node. 
 * @author Hussein Suleman
 * @param <dataType> Any class type
 * @since 26 March 2017
 */
public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;
   
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   
   /**
    * Obtain the left node of BinaryTreeNode
    * @return the left node
    */
   BinaryTreeNode<dataType> getLeft () { return left; }
   /**
    * Obtain the right node of BinaryTreeNode
    * @return the right node
    */
   BinaryTreeNode<dataType> getRight () { return right; }
}
