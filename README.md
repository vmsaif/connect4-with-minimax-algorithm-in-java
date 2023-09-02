# Connect 4: Minimax and Alpha-Beta Pruning

[![Hits](https://hits.sh/github.com/vmsaif/connect4-with-minimax-algorithm-in-java.svg?label=Visits&color=100b75)](https://hits.sh/github.com/vmsaif/connect4-with-minimax-algorithm-in-java/)

## Logic and Design of Program
The program is a digital version of the classic Connect 4 game. The game is played on a 6x7 grid, where two players, the user and an AI will take turns dropping white and black discs respectively into the grid. The goal of the game is to connect four discs of the same color vertically, horizontally, or diagonally. The AI uses the minimax algorithm with alpha-beta pruning to determine the best move. 

When the game starts, the user is presented with a blank grid. The user can click on a column to drop a disc into that column. The program checks if the move is valid (i.e., the column is not full), and then updates the grid with the new disc. The program then checks if the move resulted in a win or a draw. If neither, the program switches to the other player's turn.

### Minimax and Alpha-Beta Pruning
The AI uses the minimax algorithm with alpha-beta pruning to determine the best move. The AI will look ahead in depth of 4 moves recursively. The AI will then choose the move that results in the highest score. The score will prioritize winning moves in fewer moves, and losing moves in more moves.

The AI will also use alpha-beta pruning to reduce the number of nodes that need to be evaluated. Alpha-beta pruning will reduce the number of nodes that are bad moves by either the AI or the user. This will make the AI more efficient and faster. 

## Running the Program

- Make sure you have JRE installed on your computer. You can download JRE [here](https://www.oracle.com/java/technologies/javase-jre8-downloads.html).

You can download the release version of the Game from the latest release [here](https://github.com/vmsaif/connect4-with-minimax-algorithm-in-java/releases). The program is packaged as a JAR file. You can run the program by double-clicking on the JAR file.

After downloading the JAR file, you might need to give the JAR file permission to run. You can do this by running the following command in the terminal:

- Go the directory where the JAR file is downloaded
- `cd ~/Downloads` (or wherever the JAR file is downloaded)
- Run `chmod +x connect4.jar`



## Compiling and Running
### Compiling
The game is written in Java and can be compiled using the following steps:

- Go to the root directory
- Run the command `javac -d bin src/*.java` to compile the Java file.
- Run the command `java -cp bin/ App` to run the game.



## Bugs:
I have not found any bugs in the program yet. If you find any, please let me know.