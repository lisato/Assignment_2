/**
 * An object of this class represents a queue data structure 
 * @author Hussein Suleman
 * @since 26 March 2017
 * @param <dataType> Any class type
 */
public class BTQueue<dataType>
{   
   BTQueueNode<dataType> head;
   BTQueueNode<dataType> tail;
      
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   
   /**
    * This subroutine obtains the next node in queue
    * @return return the next node in queue
    */
   public BinaryTreeNode<dataType> getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode<dataType> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   
   /**
    * This subroutine creates a queue
    * @param node Starting with the given node
    */
   public void enQueue ( BinaryTreeNode<dataType> node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode<dataType> (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode<dataType> (node, null);
         tail = tail.next;
      }   
   }   
}
