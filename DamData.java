/**
 * An object of the class represents the dam information in the provided file.
 * A dam has a name, FSC and dam level
 * @author Oyama Plati 
 * @since 1.0
 */
public class DamData implements Comparable <DamData> {
   private String damName;
   private String fsc;
   private String damLevel;
   
   /**
    * Creates a DamData object and sets damName, fsc and damLevel null
    */
   public DamData () {
      damName = null;
      fsc = null;
      damLevel = null;
   }
   
   /**
    * Creates a DamData object that represents a dam with a given damName, fsc and damLevel
    * @param damName The name of the dam
    * @param fsc Amount of dam water per million cubic meters
    * @param damLevel The dam water level percentage full
    */
   public DamData (String damName, String fsc, String damLevel) {
      this.damName = damName;
      this.fsc = fsc;
      this.damLevel = damLevel;
   }
   
   /**
    * Obtain the dam name for this dam
    * @return The name of this dam water level object
    */
   public String getDamName() {
      return this.damName;
   }
   
  /**
   * Obtain the fsc for this dam           
   * @return The fsc of this dam water level object
   */
   public String getFSC() {
      return this.fsc;
   }
   
  /**    
   * Obtain the dam level for this dam                       
   * @return The percentage full of this dam water level object         
   */
   public String getDamLevel() {
      return this.damLevel;
   }
   
   /**
    * Set the dam name to damName
    * @param damName name of the dam
    */
   public void setDamName(String damName) {
      this.damName = damName;
   }
   
   /**
    * Set the fsc to fsc
    * @param fsc the dams fsc
    */
   public void setFSC(String fsc) {
      this.fsc = fsc;
   }
   
   /**
    * Set the dam level to damLevel
    * @param  damLevel the names water level
    */
   public void setDamLevel(String damLevel) {
      this.damLevel = damLevel;
   }
   
   /**
    * Obtain all the information for this dam water level object
    * @return The members of this dam water level
    */
   public String toString() {
      return ("Dam name: " + this.damName + ", " +
              "FSC: " + this.fsc + ", " +
              "Dam level: " + this.damLevel);
   }
   
   /**
    * This subroutine is implemented from the Comparable interface
    * It is a tool to order the fields of a DamData object
    * @return The comparison of corresponding DamData fields
    */
   public int compareTo(DamData other) {
	    int i = damName.compareTo(other.damName);
	    if (i != 0) {
	    	return i;
	    }

	    i = fsc.compareTo(other.fsc);
	    if (i != 0) {
	    	return i;
	    }

	    return damLevel.compareTo(other.damLevel);
  }
}