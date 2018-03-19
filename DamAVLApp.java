import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;

public class DamAVLApp {
  
  private static BinarySearchTree <DamData> bst = new BinarySearchTree <DamDat
  private static Scanner inputStream = null;
     
  public static void main ( String [] args ) {
    
    try {
      inputStream = new Scanner(
         new FileInputStream(
           (new File("Dam_Levels_Individual_Nov2015-Mar2016.csv")).getAbsolutePath()));
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("FAIL!! : File does not exist");
      System.out.println(" or could not be open.");
    }
    
    String line = null;
    
    inputStream.nextLine();
    
    while ( inputStream.hasNextLine() ) {
        
              while (inputStream.hasNextLine()) {
                       line = inputStream.nextLine();  
                                
                                         String[] rawdata = line.split(",");
                                                  
                                                           if (rawdata.length >= 26) {
                                                                       bst.insert(
                                                                                      new DamData(rawdata[2], rawdata[10], rawdata[25]));
                                                                                               }
                                                                                                        else if ((rawdata.length >= 11)
                                                                                                                    && (rawdata.length < 26)) { 
                                                                                                                                bst.insert(
                                                                                                                                               new DamData(rawdata[2], rawdata[10], null));
                                                                                                                                                        }
                                                                                                                                                                 else if (rawdata.length < 11){
                                                                                                                                                                             bst.insert(new DamData(rawdata[2], null, null));
                                                                                                                                                                                      }    
                                                                                                                                                                                            }  
    }
  }
}