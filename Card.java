/**
	Card Class creates a card for the war game
*/
public class Card 
{
   public final static int  SPADES = 0, HEARTS = 1,   // Suits
                            DIAMONDS = 2, CLUBS = 3;
   public final static int ACE = 1, JACK = 11,       // Constants for ranks 
                           QUEEN = 12, KING = 13;
   private int suit;   // the suit of this card
                              
   private int rank;  // the rank of this card
                       
  /**
		Constructor creates cards
  */	      	
   public Card(int r, int s)
    {
      rank = r;
      suit = s;
   }
   
   /**
    getRank method gets the rank of the card
    @return rank as a value.
   */   
   public int getRank() 
   {
      return rank;
   }
	
   /**
    getSuit method gets the suit of the card
    @return suit as a value.
   */
   public int getSuit() 
   {
      return suit;
   }
   
   /**
    getRankString gets a description of the rank.
    @return rank of the card as a String.
   */
   public String getRankString() 
   {
      switch ( rank ) 
      {
         case 1:   
            return "ace";
         case 2:   
            return "2";
         case 3:   
            return "3";
         case 4:   
            return "4";
         case 5:   
            return "5";
         case 6:   
            return "6";
         case 7:   
            return "7";
         case 8:   
            return "8";
         case 9:   
            return "9";
         case 10:  
            return "10";
         case 11:  
            return "Jack";
         case 12:  
            return "Queen";
         case 13:  
            return "King";
        default:
        	return " ";
      }
      
   }
    
   /**
    getSuitString method gets a description of the suit.
    @return the suit as a string.
   */
   public String getSuitString() 
   {
      // Return a String representing the card's suit.
      switch ( suit ) 
      {
         case 0:   
            return "s";
         case 1:   
            return "h";
         case 2:  
            return "d";
         case 3:    
            return "c";
         default:       
            return "Invalid";
      }
   }         
      
   /**
   toString method returns the name of the card as a String
   @return name the name of the card.
   */
   public String toString() 
   {
      return getRankString() + " of " + getSuitString();
   }
  
  
   /**
   cardFile method gets the source of the card.
   @return filename of picture of the card.
   */
   public String cardFile() 
   {
      return "cardPics/" + getRankString()+ getSuitString()+".jpg";
   }
    
   /**
   equals method compares two cards to see if they are equal
   @param otherCard the other card
   @return true if cards have same rank and suit, false otherwise.
   */
   public boolean equals(Card otherCard ) 
   {
      if ( ( rank == otherCard.rank ) || ( suit == otherCard.suit ) )
         return true;
      else
         return false;
   }
   
}