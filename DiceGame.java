/**Code template 
  * Simulates a Dice Poker game played between the computer and user.
  * This class definition contains a main() method that assumes 
  * that the user enters a name and an integer in the command line, for example: 
  * java PlayDice Wendy 7
  * If no arguments are passed, it will assume the call was with Dave and 5
  * @author   CS230 Staff 
  */
 

public class DiceGame {
 
  private DicePlayer thePlayer; 
  private DicePlayer theComputer;
  private int numRounds; 
  private int pwin; //rounds won by player
  private int cwin; //rounds won by the computer


  /** Creates client-specific game settings. 
    * @param playerName The name of the player
    * @param numGames The number of rounds to play
    */  
  public DiceGame(String playerName, int numGames) {
    thePlayer = new DicePlayer( playerName );
    theComputer = new DicePlayer( "Computer" );
    numRounds = numGames;
  }

  /** Counts how many distinct values appear in the input array
  * and stores each count onto the diceResults array.
  * PRE-CONDITION: diceResults[] should have enough length 
  * to accomodate the values found in the input array.
  *
  * @param input   The input array
  * @param diceResults  Holds the multiplicity of values found in input.
  *       Note that this is actually the output parameter
  */
  private void accumulateValues(int[] input, int[] diceResults) {
    int index = 0; //this is the index that diceResults will fill next
    boolean same = false;
    
    for( int i = 0; i < input.length; i++ ){
      for( int j = 0; j < diceResults.length; j++ ){
        if( input[ i ] == diceResults[ j ] ){
          same = true;
        }
      }
      if( !same ){
        input[ i ] = diceResults[ index ];
        index++;
      }
    }
 // Your code here
 
  }
  
  /** Given an input array storing five dice values, 
   * determines the rank of the set of values.
   * @param input  The array with the five dice values
   * @return    The rank of the hand; an integer between 0 and 6
   */
  private int getRank (int[] input) {
 
 // Your code here

      return 0;
  }
  


  /** Plays one round of the game: Starts with the computer's turn, 
    * then the player's turn.
    * @return 0 if computer wins the round, 1 if player wins, 2 if a tie
    */
  private int playOneRound() {

    // Your code here
  
    return 0;
  }
  



  /**  Simulates the playing of numRounds of the Dice Poker game between the
    * Computer and player, and prints the winner at the end.
    */

  public void playDiceGame () {
   
    // Be nice to the player!
    System.out.println("Good evening, " + thePlayer.getName()+"!");
    System.out.println("Everything's running smoothly. How are you?");
    System.out.print("I'm completely operational and ");
    System.out.println("all my circuits are functioning perfectly.");
    System.out.println("Would you like to play a game of Dice Poker? I play very well.");
    
   
    // Your code here
    
    // After all rounds played, determine the final winner of the game and print the results
    if (pwin>cwin) System.out.print("The game was won by "+ thePlayer.getName() + " with a score of " + pwin + " to " + cwin);
    else if (cwin>pwin) System.out.print("The game was won by the Computer with a score of " + cwin + " to " + pwin);
    else System.out.print("The game was tied with a score of " + cwin + " to " + pwin);
    
    System.out.println(" in " + numRounds + " rounds.");
    System.out.println("Thank you for a very enjoyable game!");


  }


/** Start the homework by reading this method. 
 */
  public static void main (String args[]) {
     
    String name = (args.length >  0)? args[0] : "Dave";  // the default
    int numRounds = (args.length >  1)? Integer.parseInt(args[1]) : 5; // the default
    // Create an instance of a new game and play the rounds
    DiceGame game = new DiceGame(name, numRounds);
    game.playDiceGame();
  }

}
