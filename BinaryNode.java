/**
 * An object of this class represents a node. 
 * It contains the data in the node, the left and right node. 
 * @author Oyama Plati
 *
 * @param <AnyType>
 */
class BinaryNode<AnyType> {
   // Data accessible by other package routines
   public AnyType element;              // The data in the node
   public BinaryNode<AnyType> left;     // Left child
   public BinaryNode<AnyType> right;    // Right child
   
   // Constructor
   BinaryNode (AnyType theElement) {
      element = theElement;
      left = right = null;
   }
}