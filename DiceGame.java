/**
  * Code template - DiceGame.java
  * Simulates a Dice Poker game played between the computer and user.
  * This class definition contains a main() method that assumes 
  * that the user enters a name and an integer in the command line, for example: 
  * java PlayDice Wendy 7
  * If no arguments are passed, it will assume the call was with Dave and 5
  * @author   CS230 Staff & Xinhui Xu & Julia McDonald
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
        diceResults[ index ] = input[ i ];
        index++;
      }
      same = false;
    }
  }
  
  /** Given an input array storing five dice values, 
   * determines the rank of the set of values.
   * @param input  The array with the five dice values
   * @return    The rank of the hand; an integer between 0 and 6
   */
  private int getRank (int[] input) {
    //6: 5 of a kind ( 1 val )
    //5: 4 of a kind ( 2 val )
    //4: 3 of one value and 2 of another ( 2 val )
    //3: 3 of one value and 2 different values ( 3 val )
    //2: 2 pairs and 1 different value ( 3 val )
    //1: 1 pair and 3 different values ( 4 val )
    //0: Nothing; all 5 dice have different values ( 5 val )
    
    int[] diceResults = new int[ 5 ];
    accumulateValues( input, diceResults );
    
    int[] valueCounter = new int[ 6 ];
    for( int i = 0; i < input.length; i++ ){
      valueCounter[ input[ i ] - 1 ]++;
    }
    
    int numUnique = 0;
    for( int i = 0; i < diceResults.length; i++ ){
      if( diceResults[ i ] != 0 )
        numUnique++;
    }
    
    switch( numUnique ){
      case 1:
        return 6;
      case 4:
        return 1;
      case 5:
        return 0;
      case 2:{
        for( int i = 0; i < valueCounter.length; i++ ){
          if( valueCounter[ i ] == 4 )
            return 5;
        }
        return 4;
       }
      case 3: {
        for( int i = 0; i < valueCounter.length; i++ ){
          if( valueCounter[ i ] == 3 )
            return 3;
        }
        return 2;
      }
    }
    
    return 0;
  }
  


  /** Plays one round of the game: Starts with the computer's turn, 
    * then the player's turn.
    * @return 0 if computer wins the round, 1 if player wins, 2 if a tieabcd
    */
  private int playOneRound() {
    theComputer.playNewHand();
    int compRank = getRank( theComputer.getValues() );
    System.out.println( theComputer + rankString( compRank ));
    
    thePlayer.playNewHand();
    int playRank = getRank( thePlayer.getValues() );
    System.out.println( thePlayer + rankString( playRank ));
    
    if( playRank > compRank){
      return 1;
    }
    if( playRank < compRank){
      return 0;
    }
    return 2;
  }

  /**
   * This private helper method returns strings describing the ranks of hands
   * 
   * @param rank  the rank value of a hand
   * @return a string describing the rank
   */
  private String rankString( int rank ){
    switch( rank ){
      case 0:
        return "Nothing";
      case 1:
        return "One pair";
      case 2:
        return "Two pairs";
      case 3:
        return "Three of a kind";
      case 4:
        return "Full house";
      case 5:
        return "Four of a kind";
      case 6:
        return "Five of a kind";
    }
    return "";
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
    System.out.println("Would you like to play a game of Dice Poker? I play very well.\n");
    
    //play the specified number of rounds and record wins
    for( int i = 0; i < numRounds; i++ ){
      System.out.println( "*** ROUND " + (i+1) );
      
      int winner = playOneRound();
      if( winner == 1 ) pwin++;
      else if( winner == 2 ) cwin++;
      
      System.out.println();
    }
    
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
