/**
   Demonstration of War class
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WarGameGUI extends JFrame 
{
   private WarGame game;
   private final int HEIGHT = 700, WIDTH = 950;
   private String cardString1, cardString2;
   private ImageIcon back, faceP1, faceP2;
   private JLabel player1, player2, player1War, player2War, player1Down, player2Down, player1Up, player2Up;
   private JLabel cardCount1, cardCount2, roundWinnerMessage, title;
   private int countP1, countP2;
   private JButton play, start;
   private boolean flag;
      
   public WarGameGUI(String f)
   {
      // Make the frame
      super(f);
      setLayout(new BorderLayout());
      setSize(WIDTH, HEIGHT);
    
      // Introduction Page
      title = new JLabel("The Card Game of War");
      title.setFont(new Font("Papyrus", Font.BOLD, 28));
      title.setVisible(true);
      game = new WarGame();
      
      //Create start button    
      start = new JButton("Start");
      start.setPreferredSize(new Dimension(120,50));
      start.addActionListener(new Start());
      
	   //Create a label for the card counts
	   cardCount1 = new JLabel(" ");
	   cardCount2 = new JLabel(" ");
	   cardCount1.setVisible(false);
	   cardCount2.setVisible(false);       
	   //Create a label to display winner
	   roundWinnerMessage = new JLabel(" ");
	   roundWinnerMessage.setVisible(false);
	   roundWinnerMessage.setFont(new Font("Papyrus", Font.BOLD, 24));
	       
      // Button for playing each round   
      play = new JButton("Play");
      play.setPreferredSize(new Dimension(120,50));
      play.addActionListener(new Play());
      play.setVisible(false);
     
      // Create panels 
      JPanel north = new JPanel();
      north.setPreferredSize(new Dimension(300, 300));
      JPanel east = new JPanel();
      east.setPreferredSize(new Dimension(250, 250));
      JPanel south = new JPanel(); 
      south.setPreferredSize(new Dimension(100, 60));   
      JPanel west = new JPanel();
      west.setPreferredSize(new Dimension(250, 250));
      JPanel center = new JPanel();
      center.setPreferredSize(new Dimension(500, 500));

   //Create the card piles and all the cards    
    back = new ImageIcon("cardPics/back.jpg");
    player1 = new JLabel(back);
    player1Down = new JLabel(back);
    player1War = new JLabel(back);
    player1Up = new JLabel(back);
    player2 = new JLabel(back);
    player2Up = new JLabel(back);
    player2War = new JLabel(back);
    player2Down = new JLabel(back);
       
    // Add the cards to the panel.
    north.add(player1War); 
    north.add(player1Down);
    north.add(player2Down);
    north.add(player2War); 
    east.add(cardCount2);
    east.add(player2);
    west.add(player1);
    west.add(cardCount1);
    center.add(player1Up);
    center.add(player2Up);
    center.add(roundWinnerMessage);
    center.add(title);

    //Add both buttons to south panel
    south.add(play);
    south.add(start);
    
    //Add panels
    add(north, BorderLayout.NORTH);
    add(east, BorderLayout.EAST);
    add(south, BorderLayout.SOUTH);
    add(west, BorderLayout.WEST);    
    add(center, BorderLayout.CENTER);
   
    
    // Cards do not show until game is started
    player1.setVisible(false); 
    player2.setVisible(false);
    player1Up.setVisible(false);
    player2Up.setVisible(false); 
    player1War.setVisible(false);
    player2War.setVisible(false);
    player1Down.setVisible(false); 
    player2Down.setVisible(false);
       
    setVisible(true);
    }
  /** Play button Action Listener.
  */
    class Play implements ActionListener
    {
      public void actionPerformed(ActionEvent e)
      {  
        flag = false;
        // set visibility of facedown cards to false
        player1Down.setVisible(false); 
        player2Down.setVisible(false);
        //flip the top cards of the deck
        game.flip();  
        // set card images for both players
        cardString1= game.getTopP1();
        faceP1 = new ImageIcon(cardString1);       
        player1Up.setIcon(faceP1);
        cardString2 = game.getTopP2();
        faceP2 = new ImageIcon(cardString2);       
        player2Up.setIcon(faceP2);
        // set the card to display
        player1Up.setVisible(true);
        player2Up.setVisible(true);
        // Get the winner and display message
        game.winner();
        roundWinnerMessage.setText(game.getWinMessage());
        roundWinnerMessage.setVisible(true);
        // Keep track of the decks of the players
        countP1 = game.getSizeP1();
        countP2 = game.getSizeP2();
        
       // Determine the winners and set appropriate message
       if(countP1 < 1 )
       {
         title.setText("Player 2 Wins the War! GAME OVER!");
         title.setVisible(true);
         // Hide everything but title message.
         roundWinnerMessage.setVisible(false); 
         player1.setVisible(false); 
         player2.setVisible(false);
         player1Up.setVisible(false);
         player2Up.setVisible(false); 
         player1War.setVisible(false);
         player2War.setVisible(false);
         player1Down.setVisible(false); 
         player2Down.setVisible(false);
         // Set up to restart the game
         flag = true;
         start.setVisible(true);
         play.setVisible(false);
       }
            
       else if(countP2 < 1 ) // same code as first if statement
       { 
         title.setText("Player 1 Wins the War! GAME OVER!");
         title.setVisible(true);
         // Hide everything but title message.
         roundWinnerMessage.setVisible(false); 
         player1.setVisible(false); 
         player2.setVisible(false);
         player1Up.setVisible(false);
         player2Up.setVisible(false); 
         player1War.setVisible(false);
         player2War.setVisible(false);
         player1Down.setVisible(false); 
         player2Down.setVisible(false);
         // Set up to restart the game
         flag = true;
         start.setVisible(true);
         play.setVisible(false);
       } 
               
       else // if there isnt a winner yet, keep playing.
       {
         title.setVisible(false);
         cardCount1.setText(" " +countP1);
         cardCount2.setText(" " +countP2);
         if (countP1 > 0 || countP2 > 0)
         {           
            if(game.getFlag()) // if war flag is true then battle
            {
               game.warBattle();
               // get cards and images for both playes          
               cardString1= game.getUpP1();
               faceP1 = new ImageIcon(cardString1);       
               player1War.setIcon(faceP1);
               cardString2 = game.getUpP2();
               faceP2 = new ImageIcon(cardString2);       
               player2War.setIcon(faceP2);
               player1War.setVisible(true);
               player2War.setVisible(true);
               player1Down.setVisible(true); 
               player2Down.setVisible(true);
            } 
           
            else
            {  
               player1Down.setVisible(false); 
               player2Down.setVisible(false);
               player1War.setVisible(false);
               player2War.setVisible(false);       
            }
         }
         else if(countP2 < countP1)    
         {
            title.setText("Player 1 Wins the War! GAME OVER!");
            title.setVisible(true);
         }
         
         else 
         {
            title.setText("Player 2 Wins the War! GAME OVER!");
            title.setVisible(true);
         }
       
        cardCount1.setText(" " +countP1);
        cardCount2.setText(" " +countP2);
        roundWinnerMessage.setText(game.getWinMessage());
        roundWinnerMessage.setVisible(true);       
       }
      }
    }
     /** Start button Action Listener.
    */ 
     
    class Start implements ActionListener
    {
      public void actionPerformed(ActionEvent d)
      { 
         if(flag)
         { 
            // Start new game
            roundWinnerMessage.setVisible(false);
            game = new WarGame();
            game.deal();
         }
         else
         {
            // otherwise deal the cards and show appropriate fields/ labels
            game.deal();
            countP1 = game.getSizeP1();
            countP2 = game.getSizeP2();
            cardCount1.setText(" " +countP1);
            cardCount2.setText(" " +countP2);
            cardCount1.setVisible(true);
            cardCount2.setVisible(true);       
            player1.setVisible(true);
            player2.setVisible(true);
            start.setVisible(false);
            play.setVisible(true);
            title.setVisible(false);
         }
      }
    }              
       
}