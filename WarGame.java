/**
	WarGame class for the game war
*/


public class WarGame extends Deck
{
   private Card topP1, topP2, downP1, 
           downP2, upP1, upP2;
   private Deck deck;
   private Deck cardsP1;
   private Deck cardsP2; 
   private String winner;
   private boolean flag; 
   
   /**
		Constructor creates deck 
   */	 
  public WarGame()
  {
      deck = new Deck();         
      deck.shuffle();  // shuffle deck
  }
   
  /**
		getHandP1 gets cards in player 1's hands
		@return cardsP1
	*/	   
  public Deck getHandP1()
  {
      return cardsP1;
  }
   
   /**
		getHandP2 gets cards in player 2's hands
		@return cardsP2
	*/
  public Deck getHandP2()
  {
      return cardsP2;
  }
  
  /**
      deal method deals cards to both players 	
  */
   public void deal()
   {
      // Player 1
      cardsP1 = new Deck();
      cardsP1.clear();
      // Player 2
      cardsP2 = new Deck();
      cardsP2.clear();
      
      // Split deck between both players
      for(int i = 0; i < 26; i++)
      {
         cardsP1.add(deck.getTop());
         cardsP2.add(deck.getTop());
      }
   }

   /**
		flip method gets top card of deck 
   */
    
    public void flip()
    {
      topP1 = cardsP1.getTop();
      topP2 = cardsP2.getTop();
    }
    
    /**
		getTopP1 gets the card image for player 1;s top card
   	@return topP1 file name of image
    */

    public String getTopP1()
    {
      return topP1.cardFile();     
    }
    
   /**
		getTopP2 gets the card image for player 2's top card
   	@return topP2 string of file name
   */  
    public String getTopP2()
    {
      return topP2.cardFile(); 
    }

   /**
		getUpP1 gets the card image for player 1's war card.
      @return upP1 filename of image
   */ 
   public String getUpP1()
   {
     return upP1.cardFile();
   }
   
   /**
		getUpP2 gets the card image for player 2's war card.
      @return upP2 filename of image
   */ 
   public String getUpP2()
   {
     return upP2.cardFile();
   }
   
   /**
		getSizeP1 gets number of cards in player 1's hand 
      @return cardsP1 as a int
   */  
   public int getSizeP1()
   {
      return cardsP1.size();
   }

   /**
		getSizeP2 gets number of cards in player 2's hand 
      @return cardsP2 as a int
   */  
   public int getSizeP2()
   {
      return cardsP2.size();
   }
   
   /**
		winner method determines the winner of each round
   */

   public void winner()
   {
      if (topP1.getRank() < (topP2.getRank())) // if player 2 wins
      {
         cardsP2.add(topP1);
         cardsP2.add(topP2);     // add both cards to player 2's deck
         winner = "Player 2 Wins the Round";
      }    
      else if (topP1.getRank() > (topP2.getRank())) // if player 1 wins          
      {  
         cardsP1.add(topP1); // add to player 1's deck
         cardsP1.add(topP2); 
         winner = "Player 1 Wins the Round";    
      }
      else 
      { 
         winner = "WAR!!!!!!!!";
         flag = true;
      }
                
                     
   }
   
   /**
	   WarBattle method simulates a war when both players play a card
      of the same rank
   */
   public void warBattle()
   {
      // Get one card for war, and get next top card
      downP1 = cardsP1.getTop(); 
      downP2 = cardsP2.getTop();
      upP1 = cardsP1.getTop();
      upP2 = cardsP2.getTop(); 
      if (upP1.getRank() > (upP2.getRank())) // if player 1 wins
      {
         cardsP1.add(topP1);       // Add all 6 six cards to player 1's hand
         cardsP1.add(topP2);           
         cardsP1.add(upP1);
         cardsP1.add(upP2);
         cardsP1.add(downP1);
         cardsP1.add(downP2);
         flag = false;              // war is over
         cardsP1.shuffle();         // shuffle cards so that the game isnt the same
         cardsP2.shuffle(); 
         winner = "Player 1 Wins the Battle"; 
      }
      else if (upP2.getRank() > (upP1.getRank())) // if player 2 wins
      {
         cardsP2.add(topP1);       // Add all 6 six cards to player 2's hand
         cardsP2.add(topP2);           
         cardsP2.add(upP1);
         cardsP2.add(upP2);
         cardsP2.add(downP1);
         cardsP2.add(downP2);
         flag = false;              // war is over
         cardsP1.shuffle();         // shuffle cards so that the game isnt the same
         cardsP2.shuffle(); 
         winner = "Player 2 Wins the Battle"; 
      } 
      else
      {  
         winner = "THE WAR RAGES ON!!";                     
      }
   }

  /**
     getFlag method determines if there is a war or not.
     @return flag 
  */
  public boolean getFlag()
  {
   return flag;
  }

  /**
		getWinMessage gets the message of who won the round 
      @return winner the message       
  */
   public String getWinMessage()
   {
      return winner;
   }   
}