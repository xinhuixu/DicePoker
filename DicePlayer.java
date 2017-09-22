/** 
 * Code template:
 * Creates the "hand" of a player by creating an object of 
  * 5 randomly rolled dice, and place them in an array
  * 
  * @author  CS230 Staff
  */

public class DicePlayer {

  
  final private int hand = 5;
  
  //Instance variables
  private String playerName;
  private Die[] FiveDice = new Die[hand];

 
  /**
   * Creates a player's hand by creating and rolling dice. 
   * @param name The player's name
    */   
  public DicePlayer(String name) {
  }
  
  /**
   * Creates a player's hand by creating and rolling dice. <br>
   * If no name is provided, the default is Dave.
    */   
  public DicePlayer() {
    // Your code here
  }

   /**
   * Simulates the player rolling the five dice.
   */
  public void playNewHand() {
    // Your code here
  }
  
   /** Prints the name of the player, 
     * and the contents of the hand that she holds. 
    * @return The hand that the player holds
    */
  public String toString()  {
    String s = "";
    // Your code here
    return  s;
  }
  
  
   /** Returns an array the contents of the hand that a player holds. 
    * @return Integer array of face values in the player's hand
    */
    public int[] getValues() {
      int [] values = new int[hand];
      // Your code here
      return values;
    }
    
    /**
   * Gets the name of the player.
   * @return The name of the player
   */
    public String getName(){
      // Your code here
      return "";
    }
    
    /**
     * Changes the name of the player.
     * @param newName The new name to use
     */
    public void setName(String newName){
      // Your code here
    }
  
   /**
   Main method, used to test the class.
   **/
    public static void main (String args[]) {
      DicePlayer hal = new DicePlayer();
      System.out.println(hal);
      DicePlayer dave = new DicePlayer();
      System.out.println(dave);
 
  }
}
