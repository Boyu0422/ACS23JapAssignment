/**
 * File name: LaunchGame
 * identification: Boyu Li 041003345
 * Course: CST8221 - JAP, Lab Section: 302
 * Assignment: A12
 * Professor: Paulo Sousa
 * Date: 6/2/2023
 * Compiler: Oracle Open JDK - version: 20.0.1 2023-04-18
 * Purpose: The start point of the game
 * */

package BattleshipGame;

/**
 * Class name: LaunchGame
 * Methods list:
 * 1. main
 * Constants list: NULL
 * Purpose: The class is the starting point of the battleship game
 * @author Boyu Li
 * @version 1.0
 * @since 20.0.1
 * */
public class LaunchGame {
    /**
     * Method name: LaunchGame
     * Purpose: Overload constructor
     * Algorithm: no
     * */
    LaunchGame(){}
    /**
     * Method name: main
     * Purpose: The starting point of the project
     * Algorithm: no
     * @param args - the command line arguments that used to run the project
     * */
    public static void main(String[] args){
        Battleship battleship = new Battleship();
        GameController gameController = new GameController(battleship);
    }
}
