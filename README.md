# Spotify Playlist WebApp
Austin Maldonado, Max Murray, Israel Carcamo, Daniel McPherson

We are creating a Spotify webapp that will create playslists for listeners of songs they haven't heard before based on their listening history.

Audience is spotify users who aren't always happy with the spotify created playlists.

We are doing this becauuse the provided playlist creator on spotify has some flaws that could be improved upon.

## Sprint 1 accomplishments
-Research for Spotify API (locating the GET lines needed for acquaring music info)
				Artifact: Word document with the GET lines for music.
				          Word document with links that have info on what is needed to extract music for app
		Artifact Location:Israel branch

## Spring 1 


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
Web application that will, 

•	generate playlist based off of criterion 

	o	Favorite

			Artist

			Genre

			other Metadata

	o	Ignore

			Song

			Artist

			Genre

			other Metadata

•	allow for editing of criterion – criterion editor menu

•	have song playback functionality

•	export playlist to Spotfiy interface


## Screenshots
![Example screenshot](./img/screenshot.png)

## Technologies
* [Spotify Api](https://developer.spotify.com/documentation/web-api/)
* [Spotify Api Endpoints](https://developer.spotify.com/documentation/web-api/reference/#category-playlists)
* [Spotify Api (possible wrappers)](https://developer.spotify.com/documentation/web-api/libraries/)
* [Spotify Web Playback SDK](https://developer.spotify.com/documentation/)
* [Tech 3 - version 3.0]()
* [IndexedDB](https://developer.mozilla.org/en-US/docs/Web/API/IndexedDB_API)
* [Dexie.js](https://dexie.org/)

## Setup
N/A

## Code Examples
Show examples of usage:
`put-your-code-here`

## Features
* Do Not Play Button - Feature will allow users to select Do Not Play for song or artist that will stop that song/artist from being included in future playlists.(Austin, Dan user stories)


* Explicit Filter - Feature will allow users to control whether or not explicit content will be included in their playlists. Maybe will add on to have it have the option to ONLY play explicit tracks.(Israel user story)


* Favorites Info Playlist creator - Feature will allow users to have "New Music" playlists created based on their favorites playlist. (Dan user story)

* Database Implementation - Feature will allow songs and artist info to be stored locally on the machine. This will also include spotify credentials. (Max)

* Client Credentials retrieval/User Authentication - Will allow the user to access the spotify api with their spotify account credentials. (Austin)

Favorite Criterion: will use the user’s Spotify info to access their “Liked Song’s” playlist to create initial Favorite Criterion. 
After initial creation, the lists are stored on the user’s machine. User will be able to add to the list by “liking” a song in the 
app and will be able to remove it in the criterion editor menu, or by hitting the “like” button again. 

Ignore Criterion: initially an empty list stored on user’s machine. User will be able to add to the list by disliking a 
song, artist or genre, and can remove them from the ignore list through the criterion editor menu, or by hitting the dislike button again.

Generated playlist: List of songs and song info, that allow songs to be played or paused, and to be liked or disliked.

Playlist Controller: Located at bottom of window and is static through all menus, has controls for song order (Shuffle/Repeat), 
controls for the currently playing song (Play/Pause/Restart), as well as “Next song”, “Previous song”, and volume control.

Playlist generator: finds songs similar to favorites/mood criterion and ignores songs that match the ignore criteria.

## To-do list:
Get simple application running

Apply User Interface

Implement Spotify Login

Implement Logged in Unser Interface

Implement Playlist Gentration and UI

Implement Playback Functionality

## Status
Austin - Out due to Emergency

Daniel - Assigned to get a blank web app functional. blocked due to inexperiance developing web applications.

## Inspiration
We are doing this becauuse the provided playlist creator on spotify has some flaws that could be improved upon.

## Contact
Created by [@flynerdpl](https://www.flynerd.pl/) - feel free to contact me!
Daniel McPherson dam344@txstate.edu 