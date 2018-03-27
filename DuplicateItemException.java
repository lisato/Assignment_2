/**
 * An object of this class represents duplicate error. 
 * It contains an error message providing detail about the nature of the duplicate.
 * This class is created to be used in conjunction with the BST data structure. 
 * @author Oyama Plati
 *
 */
public class DuplicateItemException extends Exception {
   public static final long serialVersionUID = 42L;
   private String message;
   public DuplicateItemException (String message) {
      super (message);
   }
   /**
    * Obtain the error message for the duplicate item exception
    * @return The error messege
    */
   public String getMessage() {
      return message;
   }
}