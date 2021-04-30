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

Daniel - (Sprint 3) Completed Refactoring of GUI Layout. The gui is now a JFrame with a Boarder layout 
manager object that handels the organization of the gui layout. The layout is divided into TOP, BOTTOM, LEFT, RIGHT,
and CENTER. The CENTER takes priority of the space allocated, and any leftover space is given to the other sections.
The main game buttons are located in the TOP section. The TOP Section has a JPanel with a Grid Layout Manager
to contain the buttons. This way if one button is deactivated, all others remain in the sameplace. The CENTER which
contain the board and logo images and the BOTTOM which has the reset and save buttons, uses a JPanel with the 
default Flow layout, which reallocates space if an element is removed, or added. Afterwards I did some bug fixing and code 
clean up, deleting unused code or comments. The last few days were spent helping others with their tasks, but issues
with my machine made it difficult to code and test in my enviroment. Last issues and bug fixes were completed as a team.


Max - (Sprint 2)Board class design. refactored reference file into a new usable [board class](https://bitbucket.org/cs3398s21klingons/connect-4-app/src/Master/src/Board.java) That holds information related to the board and operations for adding to the board. Save/load function design(Sprint 2)/implementation(Sprint 3)[(lines 108-196 in gameMGR)](https://bitbucket.org/cs3398s21klingons/connect-4-app/src/Master/src/gameMGR.java). Allows the user to save the game state and load it back at a later time. (Sprint 3)Tile place sound effect[(lines 143-158 in GameGUI)](https://bitbucket.org/cs3398s21klingons/connect-4-app/src/Master/src/GameGUI.java) will play the check.wav sound file when the user places a piece on the board. Next steps are to do a code clean up, and add some more sound effects.


Israel - class integration. Sprint 2 achievements. Methods for start and restart button implemented (which start or restart the game).
Implemented methods and action listeners that saves the piece in the column that the player choses. Implemented methods that let the 
players know the state of the game (wether the player has won/tied). All located in (src/gameMGR.java). gameMGR.java also shows what is 
saved in the 2D array (game board). Next step is designing an Ai for the user to play with. 

Israel - Sprint 3 achievements: ai method implemented. The method checks if the user wants to play an easy or normal mode and activates
the if statements that will allow for that mode to be played. Loaction(src/gameMGR/ line 547). The nrmlDfclty method checks the last column
the user selected, and does the math needed to block the user depending on how many of the users pieces are connected. If 2 or 3 of the 
users pieces are connected, then the ai would try to block the user. If none of the users pieces are connected, then the ai would make
a random selection to play its piece. The nrmlDfclty is like the isWin method in the Board file, but nrmlDfclty also updates the columnSaver
variable which is used in the ai method to select the column needed for the ai. src/gameMGR/line 649. The clickChecker method is 
used to update the button clicks if the user is playing with the ai. src/gameMGR/line 602. Towards the end of the sprint I began to work
on the avatars for the game. Due to spending more time on debbuging and implementing code for the ai, the avatar task was not able to be finished. 
Which would have been the next step if had given more time.



## Inspiration
We are doing this because we wanted to work on something fun, and within our skill set

## Contact

Daniel McPherson dam344@txstate.edu 