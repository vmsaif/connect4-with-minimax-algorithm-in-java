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

### Option 1: Downloading the DEB File (simpler)

1. Open the terminal and navigate to the directory where you downloaded the .deb file.

```bash
cd ~/Downloads
```

2. Run the following command to install the package:

```bash
sudo dpkg -i ./connect4-v1.1.0-linux_amd64.deb # Replace the filename/version with the name of the DEB file you downloaded
```
3. If you get an error, run the following command to install the dependencies:

```bash
sudo apt-get install -f
```

4. Run the following command to start the game:

You can start the game by searching for it in the applications menu named `connect4` or by running the following command in the terminal:
```bash
/opt/connect4/bin/connect4
```


### Option 2: Downloading the JAR File

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
There are 2 methods. Downloading the dmg file or downloading the jar file. 
### Option 1: Downloading the DMG File (simpler)
I am not a registered Apple developer, That is why you will get a warning when you try to open the app. Thus, you will have to bypass the security settings to run the app.
Here are the steps:

1. Click on the .dmg file you have downloaded. 

2. Drag the app to the Applications folder.

3. In the Finder <img src="https://help.apple.com/assets/63BCA927AAE78C58DD7FBE35/63BCA92EAAE78C58DD7FBE76/en_US/058e4af8e726290f491044219d2eee73.png" alt="" height="15" width="15" originalimagename="SharedGlobalArt/AppIconTopic_Finder.png"> on your Mac, locate the Connect4 app.

   (Don’t use Launchpad to do this. Launchpad doesn’t allow you to access the shortcut menu.)

4. Press and hold Control then click the app icon.

5. Click Open.

   The app is saved as an exception to your security settings, and you can open it in the future by double-clicking it just as you can any registered app.


### Option 2: Downloading the JAR File
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

   Ensure that Java is added to your `PATH` so that it can be accessed from the command prompt. During the jre installation, You will have option to add to your path. Is is unchecked by default. Make sure to enable it.  To check if Java is installed, run the following command in Command Prompt or PowerShell:
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

## Acknowledgements
- [Icon](https://icon-icons.com/icon/grid-board-cell-table/187134)