# Connect 4: Minimax and Alpha-Beta Pruning

[![Hits](https://hits.sh/github.com/vmsaif/connect4-with-minimax-algorithm-in-java.svg?label=Visits&color=100b75)](https://hits.sh/github.com/vmsaif/connect4-with-minimax-algorithm-in-java/)

## Logic and Design of Program
The program is a digital version of the classic Connect 4 game. The game is played on a 6x7 grid, where two players, the user and an AI will take turns dropping white and black discs respectively into the grid. The goal of the game is to connect four discs of the same color vertically, horizontally, or diagonally. The AI uses the minimax algorithm with alpha-beta pruning to determine the best move. 

When the game starts, the user is presented with a blank grid. The user can click on a column to drop a disc into that column. The program checks if the move is valid (i.e., the column is not full), and then updates the grid with the new disc. The program then checks if the move resulted in a win or a draw. If neither, the program switches to the other player's turn.

### Minimax and Alpha-Beta Pruning
The AI uses the minimax algorithm with alpha-beta pruning to determine the best move. The AI will look ahead in depth of 4 moves recursively. The AI will then choose the move that results in the highest score. The score will prioritize winning moves in fewer moves, and losing moves in more moves.

The AI will also use alpha-beta pruning to reduce the number of nodes that need to be evaluated. Alpha-beta pruning will reduce the number of nodes that are bad moves by either the AI or the user. This will make the AI more efficient and faster. 

## Running the Program

- Make sure you have JRE installed on your computer. You can download JRE [here](https://adoptium.net/) or [here](https://www.oracle.com/java/technologies/javase-jre8-downloads.html).

Downloading the jar file is preferred. You can download the release version of the Game from the latest release [here](https://github.com/vmsaif/connect4-with-minimax-algorithm-in-java/releases). The program is packaged as a JAR file. You can run the program by double-clicking on the JAR file.

## **Ubuntu**

1. **Installing Java** (if it's not already installed):
   ```bash
   sudo apt update
   sudo apt install default-jre
   ```

2. **Navigate to the Download Location**:
   ```bash
   cd ~/Downloads
   ```

3. **Provide Execute Permissions** (Optional, but useful if you want to execute it directly):
   ```bash
   chmod +x connect4-1.0.0.jar # Replace the filename with the name of the JAR file you downloaded
   ```

4. **Run the JAR File**:
   ```bash
   java -jar connect4-1.0.0.jar # Replace the filename with the name of the JAR file you downloaded
   ```

## **macOS**

Make sure you have JRE installed on your computer. You can download JRE [here](https://adoptium.net/) or [here](https://www.oracle.com/java/technologies/javase-jre8-downloads.html).

1. **Navigate to the Download Location** (using Terminal):
   ```bash
   cd ~/Downloads
   ```

3. **Provide Execute Permissions** (Optional):
   ```bash
   chmod +x connect4-1.0.0.jar # Replace the filename with the name of the JAR file you downloaded
   ```

4. **Run the JAR File**:
   ```bash
   java -jar connect4-1.0.0.jar # Replace the filename with the name of the JAR file you downloaded
   ```

## **Windows**

1. **Confirming Java**:

   Make sure you have JRE installed on your computer. You can download JRE [here](https://adoptium.net/) or [here](https://www.oracle.com/java/technologies/javase-jre8-downloads.html).

   Ensure that Java is added to your `PATH` so that it can be accessed from the command prompt. (Most installers will do this for you.) To check if Java is installed, run the following command in Command Prompt or PowerShell:
   ```bash
   java -version
   ```
   If Java is installed, you should see the version number. If you see an error, you need to install Java. See above for instructions on installing Java.

2. **Navigate to the Download Location** (using Command Prompt or PowerShell):
   ```bash
   cd c:\Users\username\Downloads # Replace username with your username
   ```

3. **Run the JAR File**:
   ```bash
   java -jar connect4-1.0.0.jar
   ```

In all cases, once the commands are followed, the Java application packaged inside the JAR file should start running.


## Compiling and Running (Advanced)
### Compiling
The game is written in Java and can be compiled using the following steps:

- Go to the root directory
- Run the command `javac -d bin src/*.java` to compile the Java file.
- Run the command `java -cp bin/ App` to run the game.


## Bugs:
I have not found any bugs in the program yet. If you find any, please let me know by opening an issue from the issue tab.