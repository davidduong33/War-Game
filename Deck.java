/**
   Deck class creates a deck of cards and shuffles them   
*/
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Deck
{
   private ArrayList<Card> deck; // Deck
 
   /**
		Constructor to create deck 
   */	    
   
   public Deck()
   {
     newDeck(); // method to create deck
   }
    
   /**
		 newDeck method creates the deck  
   */	  
   
   public void newDeck()
   {
      deck = new ArrayList<Card>(); 
      // loop through the cards, ranks and suits, and add them to the deck
      for (int r = Card.ACE; r<=Card.KING; r++)
      {
         for (int s = Card.SPADES; s <= Card.CLUBS; s++)
         {
            deck.add(new Card(r,s));
         }
      }
   }
   
   /**
      add method adds a new card to the deck
      @param newCard a new card to add
   */
   public void add(Card newCard)
   {
      deck.add(newCard);
   }

   /**
    getTop method gets the top card from the deck
    @return top card.
   */
   public Card getTop()
   {
      return deck.remove(0);
   }
   
 	/**
      size method gets the size of the deck
      @return size as an int  
   */
   public int size()
   {
      return deck.size();
   }
       
   /**
      shuffle method shuffles the cards   
   */    
   public void shuffle()
   {  
      Card temp;
      int rand;
      Random r = new Random();
      // loop through deck
      for (int i = 0; i < deck.size(); i++)
      {
         rand = r.nextInt(deck.size());
         temp = deck.get(i);                 // shuffle cards around
         deck.set(i,deck.get(rand));
         deck.set(rand,temp);
      }      
   } 
   
   
   /**
      isEmpty method determines if the deck is empty true  
      @return boolean true or false   
   */ 
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
   
    
   /**
      clear method clears the deck.   
   */   
   public void clear()
   {
      deck.clear();
   } 

   /**
    toString method 
    @return deck of cards array list of cards. 
   */    
   public String toString()
   {
      return deck.toString();
   }
       
}