/* -----------------------------------------------------------------------------
    Author: Saif Mahmud
    Date: 2023-02-08 (yyyy-dd-mm)

    Description: This program is a game of Connect 4. The user plays against the computer. 
    Computer uses the minimax algorithm and alpha-beta pruning to determine the best move.
*/

public class App {

    public static void main(String[] args) {

        Connect4 connect4 = new Connect4();
        connect4.runGame();

    }
}
