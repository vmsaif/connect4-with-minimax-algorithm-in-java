/* -----------------------------------------------------------------------------
    Author: Saif Mahmud
    Date: 2023-02-08 (yyyy-dd-mm)

    Description: This class is the computer player. It uses the minimax algorithm and alpha-beta pruning to determine the best move.
*/



public class Computer {

    private char[][] board;
    private int MAX_DEPTH;

    private char EMPTY;
    private char WHITE;
    private char BLACK;
    private int bestMove[]; // [0] = row, [1] = col
    private int winningLength;

    public Computer(char[][] board, int MAX_DEPTH, int WINNING_LENGTH) {
        this.winningLength = WINNING_LENGTH;
        this.board = board;
        this.MAX_DEPTH = MAX_DEPTH;
        this.EMPTY = Connect4.getEmpty();
        this.WHITE = Connect4.getWhite();
        this.BLACK = Connect4.getBlack();
        this.bestMove = new int[2];
    }


    // make the line buildup
    // check linebuildup for WHITE player
    public void makeComputerMove() {

        if(Connect4.isWhiteTurn() == false) {
            // computer's turn
            int alpha = Integer.MIN_VALUE;
            int beta = Integer.MAX_VALUE;            
            int evaluation = Integer.MIN_VALUE;
            
            for(int row = board.length-1; row >= 0 ; row--) {
                for(int col = 0; col < board[row].length; col++) {
                    if(board[row][col] == EMPTY) {
                        // check if this is a valid move
                        if(row == board.length-1 || board[row+1][col] != EMPTY) {
                            // try this move
                            board[row][col] = BLACK;
                            int temp = minimax(MAX_DEPTH, alpha, beta, false);

                            // now reset the move
                            board[row][col] = EMPTY; 

                            if(temp > evaluation) {
                                // got a better move
                                evaluation = temp;
                                bestMove[0] = row;
                                bestMove[1] = col;
                            }
                        }
                    }
                }
            } // end for loop
            // now make the best move
            board[bestMove[0]][bestMove[1]] = BLACK;
            Connect4.printBoard("BLACK");
            // now switch turns
            Connect4.switchTurn();
        }
    }

    private int evaluateBoardForPlayer(char player) {
        int score = 0;

        // For each column, row, and direction
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                for (int[] dir : new int[][]{{0,1}, {1,0}, {1,1}, {1,-1}}) {  // Right, Down, Down-right, Down-left
                    int countPlayerPieces = 0;
                    int countEmpty = 0;

                    for (int i = 0; i < winningLength; i++) {
                        int newRow = row + dir[0] * i;
                        int newCol = col + dir[1] * i;

                        if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                            if (board[newRow][newCol] == player) {
                                countPlayerPieces++;
                            } else if (board[newRow][newCol] == EMPTY) {
                                countEmpty++;
                            }
                        }
                    }

                    if (countPlayerPieces + countEmpty == winningLength) {
                        int initialScore = (winningLength * 10) + 10; // for winningLength = 4, initialScore = 50
                        for (int i = 1; i < winningLength; i++){
                            if (countPlayerPieces == winningLength - i) {
                                score += initialScore/i;  // Adjust as needed
                                initialScore = initialScore - 10;
                            }
                        }
                    }
                }
            }
        }
        return score;
    }

    
       // minimax algorithm with alpha-beta pruning
    private int minimax(int depth, int alpha, int beta, boolean isWhitesTurn) {
        int result = 0;
        boolean stopSearch = false;
        boolean blackWon = Connect4.checkWin(BLACK);
        boolean whiteWon = Connect4.checkWin(WHITE);
        boolean draw = Connect4.checkDraw();

        // base case
        if(depth == 0 || blackWon || whiteWon || draw) {
            // evaluate the board from the computer's perspective
            if(blackWon){
                result = 100 + depth;
            } else if(whiteWon){
                result = -(100 + depth);
            } else if(draw){
                result = 0;
            } else {
                int blackScore = evaluateBoardForPlayer(BLACK);
                int whiteScore = evaluateBoardForPlayer(WHITE);
                result = blackScore - whiteScore;
            }
        } else { // recursive case
            if(!isWhitesTurn) {
                // minimizing player COMPUTER (BLACK)
                result = Integer.MAX_VALUE;
                for(int row = board.length-1; row >= 0 && !stopSearch; row--) {
                    for(int col = 0; col < board[row].length && !stopSearch; col++) {
                        if(board[row][col] == EMPTY) {

                            // check if this is a valid move
                            if(row == board.length-1 || board[row+1][col] != EMPTY) {
                                // try this move
                                board[row][col] = WHITE;
                                int temp = minimax(depth-1, alpha, beta, true);
                                // now reset the move
                                board[row][col] = EMPTY;
                                result = Math.min(result, temp);
                                beta = Math.min(beta, result);

                                // if poor beta value, stop searching
                                if(beta <= alpha) {
                                    stopSearch = true;
                                }
                            }
                        }
                    }
                } // end for loop
            } else {
                // maximizing player USER (WHITE)
                result = Integer.MIN_VALUE;
                for(int row = board.length-1; row >= 0 && !stopSearch; row--) {
                    for(int col = 0; col < board[row].length && !stopSearch; col++) {
                        if(board[row][col] == EMPTY) {
                            // check if this is a valid move
                            if(row == board.length-1 || board[row+1][col] != EMPTY) {
                                // try this move
                                board[row][col] = BLACK;
                                int temp = minimax(depth-1, alpha, beta, false);
                                // now reset the move
                                board[row][col] = EMPTY;
                                result = Math.max(result, temp);
                                alpha = Math.max(alpha, result);

                                // if beta is less, prune
                                if(beta <= alpha) {
                                    stopSearch = true; 
                                }
                            }
                        }
                    }
                }
            } // end for loop
        }
        
        return result;
    }

}// end class Computer

