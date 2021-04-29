# Connect Four Desktop App
Austin Maldonado, Max Murray, Israel Carcamo, Daniel McPherson

We have taken code designed for a 2 player Connect 4 console game. We are redesigninging to be easily implemented with GUI, 
designing our own GUI using java.swing, and adding features such as saving and loading games and implementing an AI player.

## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)
* [Contact](#contact)

## General info
	Connect Four rules: 2 players take turns adding checkers to an 8x8 grid of spaces. Checkers are added into columns until the colums are filled (bottom to top).
	Someone wins when they get 4 of their pieces in a row (vetical, horizontal, or diagonal). If all spaces are filled without a declared winner, the game is a tie.
## Screenshots


## Technologies
Java 

Javax.swing

## Setup
Complie scripts and run main.java

## Code Examples


## Features
GUI(Daniel)

save/load(Max)

Local 2 player(Israel)

1 player vs AI(Easy/Normal)(Israel)

## Status
Austin - Leave of Absence

Daniel - Intial Project Design (notes: ./documents/Battle_plan.docx). GUI design, Implemented GUI (./src/GameGUI.java): class extends Jframe from javax.swing. Jframe has the default layout. Has one panel that holds the all the buttons and the textbox. 
Core game buttons are implmented. Some buttons are place holders until other fetures are functional. Ex: save/load buttons. Issues getting images to appear. 
Issue could be related to layout setting. Game board gui implemntation has been backlogged. Next steps are to redesign Jframe layout then address the board images.

<<<<<<< HEAD
Max - (Sprint 2)Board class design. refactored reference file into a new usable [board class](https://bitbucket.org/cs3398s21klingons/connect-4-app/src/Master/src/Board.java) That holds information related to the board and operations for adding to the board. Save/load function design(Sprint 2)/implementation(Sprint 3)[(line 108-196 in gameMGR)](https://bitbucket.org/cs3398s21klingons/connect-4-app/src/Master/src/gameMGR.java). Allows the user to save the game state and load it back at a later time. (Sprint 3)Tile place sound effect[(lines 143-158 in GameGUI)](https://bitbucket.org/cs3398s21klingons/connect-4-app/src/Master/src/GameGUI.java) will play the check.wav sound file when the user places a piece on the board. Next steps are to do a code clean up, and add some more sound effects.



Isreal - class integration. Sprint 2 achievements. Methods for start and restart button implemented (which start or restart the game).
Implemented methods and action listeners that saves the piece in the column that the player choses. Implemented methods that let the 
players know the state of the game (wether the player has won/tied). All located in (src/gameMGR.java). gameMGR.java also shows what is 
saved in the 2D array (game board). Next step is designing an Ai for the user to play with. 


## Inspiration
We are doing this because we wanted to work on something fun, and within our skill set

## Contact

Daniel McPherson dam344@txstate.edu 