/**
 * A object of this class represents a node of queue
 * @author Hussein Suleman
 * @since 26 March 2017
 * @param <dataType> Any class type
 */
public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
   
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
