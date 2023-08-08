/* -----------------------------------------------------------------------------
    Author: Saif Mahmud
    Date: 2023-02-08 (yyyy-dd-mm)
    Course: COMP 452
    Student ID: 3433058
    Assignment: 3
    Part: 1
    Description: This program is a game of Connect 4. The user plays against the computer. 
    Computer uses the minimax algorithm and alpha-beta pruning to determine the best move.
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Connect4 extends JFrame {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final int WINNING_LENGTH = 4;
    private static final int MAX_DEPTH = 4;

    private static final char EMPTY = ' ';
    private static final char WHITE = 'W';
    private static final char BLACK = 'B';

    private JPanel boardPanel;
    private JButton[] columnButtons;

    private static char[][] board = new char[ROWS][COLUMNS];
    private static boolean isWhiteTurn = true;
    private boolean gameOver = false;
    private Computer computer;

    public Connect4 (){}

    public void runGame() {
        initializeBoard();
        computer = new Computer(board, MAX_DEPTH);
        setTitle("Connect 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardPanel = new JPanel(new GridLayout(ROWS + 1, COLUMNS));
        columnButtons = new JButton[COLUMNS];

        createDropButtons();

        // set each tile as an unclickable button with a white background to just add circles on top
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                JButton button = new JButton();
                button.setEnabled(false);
                button.setPreferredSize(new Dimension(50, 50));
                button.setBackground(Color.WHITE);
                boardPanel.add(button);
            }
        }

        add(boardPanel);
        pack();
        setVisible(true);
    }

    private void createDropButtons() {
        for (int col = 0; col < COLUMNS; col++) {
            JButton button = new JButton("Drop");
            button.setActionCommand(Integer.toString(col));
            button.addActionListener(new ColumnButtonListener());
            columnButtons[col] = button;
            boardPanel.add(button);
        }
    }

    public void updateBoard() {
        Component[] components = boardPanel.getComponents();
        int index = COLUMNS; // start at the bottom left of the board by reducing the indexes of drop buttons
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                JButton button = (JButton) components[index];
                
                if (board[row][col] == WHITE) {
                    button.setIcon(new Circle(Color.WHITE, Color.BLACK));
                } else if (board[row][col] == BLACK) {
                    button.setIcon(new Circle(Color.BLACK, Color.BLACK));
                }
                index++;
            }
        }
    }

    private class ColumnButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!gameOver) {
                int column = Integer.parseInt(e.getActionCommand());
                makeUserMove(column);
                computer.makeComputerMove();
                
                updateBoard();

                if (checkWin(WHITE)) {
                    JOptionPane.showMessageDialog(Connect4.this, "WHITE wins!");
                    gameOver = true;
                } else if (checkWin(BLACK)) {
                    JOptionPane.showMessageDialog(Connect4.this, "BLACK wins!");
                    gameOver = true;
                } else if (checkDraw()) {
                    JOptionPane.showMessageDialog(Connect4.this, "Draw!");
                    gameOver = true;
                }
            }
        }
    }

    public static void printBoard() {
        System.out.println("    [0][1][2][3][4][5][6]");
        for (int row = 0; row < ROWS; row++) {
            System.out.print("["+row+"]");
            System.out.print("|");
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print(board[row][col] + " |");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public void makeUserMove(int column) {
        boolean moveMade = false;
        for (int row = ROWS - 1; row >= 0 && !moveMade; row--) {
            if (board[row][column] == EMPTY) {
                if(isWhiteTurn) {
                    board[row][column] = WHITE;
                    moveMade = true;
                    printBoard();
                } 
            }
        }
        switchTurn();
    }

    // Switch turns
    public static void switchTurn() {
        isWhiteTurn = !isWhiteTurn;
    }

    public static boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    public void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    public static boolean checkWin(char player) {
        
        // Check rows
        boolean result = false;

        for (int row = 0; row < ROWS && !result; row++) {
            for (int col = 0; col <= COLUMNS - WINNING_LENGTH && !result; col++) {
                boolean win = true;
                for (int i = 0; i < WINNING_LENGTH && win; i++) {
                    if (board[row][col + i] != player) {
                        win = false;
                    }
                }
                if (win) {
                    result = true;
                }
            }
        }

        // Check columns
        for (int col = 0; col < COLUMNS && !result; col++) {
            for (int row = 0; row <= ROWS - WINNING_LENGTH && !result; row++) {
                boolean win = true;
                for (int i = 0; i < WINNING_LENGTH && win; i++) {
                    if (board[row + i][col] != player) {
                        win = false;
                    }
                }
                if (win) {
                    result = true;
                }
            }
        }

        // Check diagonals
        for (int row = 0; row <= ROWS - WINNING_LENGTH && !result; row++) {
            for (int col = 0; col <= COLUMNS - WINNING_LENGTH && !result; col++) {
                boolean win = true;
                for (int i = 0; i < WINNING_LENGTH && win; i++) {
                    if (board[row + i][col + i] != player) {
                        win = false;
                    }
                }
                if (win) {
                    result = true;
                }
            }
        }

        for (int row = 0; row <= ROWS - WINNING_LENGTH && !result; row++) {
            for (int col = WINNING_LENGTH - 1; col < COLUMNS && !result; col++) {
                boolean win = true;
                for (int i = 0; i < WINNING_LENGTH && win; i++) {
                    if (board[row + i][col - i] != player) {
                        win = false;
                    }
                }
                if (win) {
                    result = true;
                }
            }
        }

        return result;
    }

    // Check if the board is full
    // return true if it is a draw
    public static boolean checkDraw() {
        boolean result = true;
        for(int row = 0; row < ROWS && result == true; row++) {
            for(int col = 0; col < COLUMNS && result == true; col++) {
                if(board[row][col] == EMPTY) {
                    result = false;
                }
            }
        }
        return result;
    }

    public static char getBlack() {
        return BLACK;
    }

    public static char getWhite() {
        return WHITE;
    }

    public static char getEmpty() {
        return EMPTY;
    }
} // end class Connect4