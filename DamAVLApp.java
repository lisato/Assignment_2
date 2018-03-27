import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
//DamAVLApp class
//
//******************PUBLIC OPERATIONS*********************
//Comparable find( x ) --> Return item that matches x
//void printOpCount( x ) --> print results of counts from insert
//						  --> & search method
//void printDam( x ) --> Find x in BST if found print; 
//					  --> else print dam not found 
//void printAllDams( ) --> print all dam data to stdout

/**
 * This class is implementation for the user interface. 
 * This class scans data from the dam database and 
 * stores it in a AVL tree to perform some operations. 
 * @author Oyama Plati
 */
public class DamAVLApp {
  
  private static AVLTree <DamData> avl = new AVLTree <DamData> ();
  private static Scanner inputStream = null;
  private static int searchCounter = 0;

  public static void main ( String [] args ) {
    
    try {
      
    	File file = new File("Dam_Levels_Individual_Nov2015-Mar2016-1.csv");
    	boolean perms = file.setReadable(true, false);
    
    	if (perms)
    		inputStream = new Scanner(new FileInputStream(file.getAbsoluteFile()));
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("File does not exist");
      System.out.println(" or could not be open.");
      System.exit(0);
    }
    
    String line = null;
    
    inputStream.nextLine();
    
    while ( inputStream.hasNextLine() ) {
	line = inputStream.nextLine();
        
        String[] rawdata = line.split(",");

        if (rawdata.length >= 26) {
            avl.insert(
               new DamData(rawdata[2], rawdata[10], rawdata[25]));
         }
         else if ((rawdata.length >= 11)
            && (rawdata.length < 26)) {
             avl.insert(
               new DamData(rawdata[2], rawdata[10], ""));
         }
         else if (rawdata.length < 11){
            avl.insert(new DamData(rawdata[2], "", ""));                                                                                               }
    }
    
     if (args.length != 0) {
         StringBuilder builder = new StringBuilder();
         for (String s: args) {
            if (builder.length() > 0) {
               builder.append(" ");
            }
            builder.append(s);
         }
         printDam(builder.toString().trim());
      }
      else {
         printAllDams();
      }
  
  inputStream.close();
  } // END OF MAIN
  
  /**
   * This subroutine prints all dam data
   */
  public static void printAllDams () {
     avl.treeOrder();
     printOpCount(searchCounter, AVLTree.insertCounter);
  } // END OF PRINTALLDAMS
  
  /**
   * This subroutine prints all dam data
   * @param searchcount Search method count
   * @param insertcount Insert method count
   */
  private static void printOpCount (int searchcount, int insertcount) {
      PrintWriter outputStreamSearch = null;
      PrintWriter outputStreamInsert = null;
      
      try {
         outputStreamSearch = new PrintWriter (
                              new FileWriter("OpAVLSearchReport.dat", true));
         outputStreamInsert = new PrintWriter(
	 	 	      new FileWriter("OpAVLInsertReport.dat", true));
      }
      catch (FileNotFoundException e0) {
         e0.printStackTrace();
         System.out.println("File not found \n or file does not exist.");
         System.exit(0);
      }
      catch (IOException e1) {
         e1.printStackTrace();
         System.exit(0);
      }
      
      outputStreamSearch.println(Integer.toString(searchcount));
      outputStreamInsert.println(Integer.toString(insertcount));
      
      outputStreamSearch.close();
      outputStreamInsert.close();
   }// END OF printOpCounter 

  /**
   * This subroutine finds x in BST if found print dam data; else print dam not found
   * @param damName Name of dam to be search for in the tree and printed
   */
   public static void printDam (String damName) {
      BinaryTreeNode <DamData> result = find (damName);
      if (result == null) {
    	  printOpCount(searchCounter, AVLTree.insertCounter);
         System.out.println("Dam not found");
      }
      else {
    	  printOpCount(searchCounter, AVLTree.insertCounter);
         System.out.println(result.data); 
      }  
   } // END OF PRINTDAM
   
   /**
    * This subroutine returns the item that matches name
    * @param name Name of dam to be search for in the tree
    * @return item that matches name
    */
   private static BinaryTreeNode<DamData> find (String name) {
      return find (avl.root, name);   
   } // END OF FIND

   private static BinaryTreeNode<DamData> find 
               (BinaryTreeNode <DamData> t, String name) {
      BinaryTreeNode <DamData> result = null;
      if (t != null) { 
         searchCounter++;
         if (name.equals(t.data.getDamName().trim())) { 
            return t;
         }
         else {
            result = find (t.getLeft(), name); 
            if (result == null) {
               result = find (t.getRight(), name);
            }
            return result;
         }
      }
      else {
         return null;
      }
   } // END OF FIND
} // END OF DAMAVLAPP CLASS
