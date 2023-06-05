/**
 * File name: GameController
 * identification: Boyu Li 041003345
 * Course: CST8221 - JAP, Lab Section: 302
 * Assignment: A12
 * Professor: Paulo Sousa
 * Date: 6/2/2023
 * Compiler: Oracle Open JDK - version: 20.0.1 2023-04-18
 * Purpose: To implement the game controller by utilizing Action Listener and  Item Listener
 * */

package BattleshipGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Class name: GameController
 * Methods list:
 * 1. GameController(Overload Constructor)
 * Constants list: NULL
 * Purpose: The class will invoke the method to add listener for the game
 * @author Boyu Li
 * @version 1.0
 * @see java.awt
 * @since 20.0.1
 * */
public class GameController {
    Battleship battleship;

    /**
     * Method name: GameController
     * Purpose: Overload constructor
     * Algorithm: no
     * @param battleship - the class of Battleship
     * */
    GameController(Battleship battleship) {
        this.battleship = battleship;
        battleship.launchInterface();
        battleship.addListenerForComboBox(new ComboBoxListener());
        battleship.addListenerForButton(new ButtonListener());
    }

    /**
     * Class name: ButtonListener
     * Methods list:
     * 1. actionPerformed
     * Constants list: NULL
     * Purpose: The class implement the ActionListener to implement the components for all the buttons in the game
     * @author Boyu Li
     * @version 1.0
     * @see java.awt
     * @since 20.0.1
     * */
    class ButtonListener implements ActionListener {

        /**
         * Method name: actionPerformed
         * Purpose: The override method to implement the functionalities of the listener
         * for each specific components of a button
         * Algorithm: double for loop to check the position of the grid which needs to be performed
         * @param e - the event which needs to be performed
         * */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == battleship.playButton){
                System.out.println("You just hit the play button");
            }

            for (int i = 0; i < battleship.userPanelGridButtons.length; i++){
                for (int j = 0; j < battleship.userPanelGridButtons[0].length;j++){
                    if (e.getSource().equals(battleship.userPanelGridButtons[i][j])) {
                        System.out.println("You just hit the grid of the user panel");
                    }
                    if (e.getSource().equals(battleship.adversaryPanelGridButtons[i][j])) {
                        System.out.println("You just hit the grid of the adversary panel");
                    }
                }
            }

            if (e.getSource().equals(battleship.userPanelGridButtons)) {
                System.out.println("You just hit the grid of the user panel");
            }

            if (e.getSource() == battleship.resetButton){
                System.out.println("You just hit the reset button");
            }

            if (e.getSource() == battleship.randModeButton){
                System.out.println("You just set up the game mode to random mode");
            }

            if (e.getSource() == battleship.designModeButton){
                System.out.println("You just set up the game mode to design mode");
            }
        }
    }

    /**
     * Class name: ComboBoxListener
     * Methods list:
     * 1. itemStateChanged
     * Constants list: NULL
     * Purpose: The class implement the AItemListener to implement the components for all the Combo Box in the game
     * @author Boyu Li
     * @version 1.0
     * @see java.awt
     * @since 20.0.1
     * */
    class ComboBoxListener implements ItemListener{
        /**
         * Method name: itemStateChanged
         * Purpose: The override method to implement the functionalities of the listener
         * for each specific components of a combo box
         * Algorithm:no
         * @param e - the event which needs to be performed
         * */
        @Override
        public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == battleship.languageBox) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                    int option = battleship.languageBox.getSelectedIndex();
                    if (option == 0) {
                        System.out.println("You just set up the language to English");
                    }
                    if (option == 1) {
                        System.out.println("You just set up the language to Chinese");
                    }
                }
            }
                if(e.getSource() == battleship.dimensionBox){
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Integer option = (Integer) battleship.dimensionBox.getSelectedItem();
                        System.out.println("You just set up the game dimension to "+option);
                        }
                    }
                }
        }
    }

