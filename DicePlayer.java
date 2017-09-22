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
      playerName = name;
      for (int i = 0; i<hand; i++){
	  FiveDice[i] = new Die(); //need to initiate Die objects
	  FiveDice[i].setFaceValue(FiveDice[i].roll());
      }
      
  }
  
  /**
   * Creates a player's hand by creating and rolling dice. <br>
   * If no name is provided, the default is Dave.
    */   
  public DicePlayer() {
      playerName = "dave";
      for (int i = 0; i<hand; i++){
	  FiveDice[i] = new Die();
	  FiveDice[i].setFaceValue(FiveDice[i].roll());
      }
  }

   /**
   * Simulates the player rolling the five dice.
   */
  public void playNewHand() {
      for (int i = 0; i<hand; i++){
	  Die die = FiveDice[i];
	  die.setFaceValue(die.roll());
      }
  }
  
   /** Prints the name of the player, 
     * and the contents of the hand that she holds. 
    * @return The hand that the player holds
    */
  public String toString()  {
    String s = playerName + " rolled ";
    for (int i = 0; i<hand; i++){
	s += FiveDice[i] + " ";
    }
    return  s;
  }
  
  
   /** Returns an array the contents of the hand that a player holds. 
    * @return Integer array of face values in the player's hand
    */
    public int[] getValues() {
      int [] values = new int[hand];
      for (int i = 0; i<hand; i++){
	  values[i] = FiveDice[i].getFaceValue();
      }
      return values;
    }
    
    /**
   * Gets the name of the player.
   * @return The name of the player
   */
    public String getName(){
      return playerName;
    }
    
    /**
     * Changes the name of the player.
     * @param newName The new name to use
     */
    public void setName(String newName){
	playerName = newName;
    }
  
   /**
   Main method, used to test the class.
   **/
    public static void main (String args[]) {
      DicePlayer hal = new DicePlayer("hal");
      System.out.println(hal);
      DicePlayer dave = new DicePlayer();
      System.out.println(dave);
 
  }
}
