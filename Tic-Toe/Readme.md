# Tic Tac Toe Game

## Overview
This project is a simple implementation of the classic Tic-Tac-Toe game, where two players take turns placing their symbols (X or O) on a 3x3 grid. The goal is to be the first player to get three of their symbols in a row, either horizontally, vertically, or diagonally.

## Features
1. **3x3 Grid**: The game is played on a 3x3 board.
2. **Two Players**: Each player marks their symbol (X or O) in turns on the grid.
3. **Win Condition**: The first player to align three symbols in a row (horizontal, vertical, or diagonal) wins.
4. **Draw Condition**: If all the grid cells are filled without a winner, the game results in a draw.
5. **User Interface**: A simple user interface to display the grid and let players make their moves.
6. **Player Turns**: The game alternates between players, and only valid moves are allowed.
7. **Game Result**: The game detects and announces a winner or a draw at the end.


## Classes and Methods

1. **Player**: This class represents each player in the game. It stores the player’s name and their symbol (X or O).
2. **Board**: This class handles the 3x3 game board. It has methods to:
    - Make a move on the board
    - Check if there is a winner
    - Verify if the board is full (indicating a draw)
3. **Game**: This class manages the game flow, including:
    - Alternating between players
    - Validating moves
    - Declaring a winner or draw
4. **TicTacToe**: The main class that starts the game. It creates player instances and initializes the game.

