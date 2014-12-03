/** 
   Driver for the WarGameGUI
*/

import javax.swing.*;
public class WarGameDriver
{
   public static void main(String [] args)
   {
      WarGameGUI game = new WarGameGUI("War Card Game");
      game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
}