# HKUST COMP3021 Java Programming 

## Spring 2019 Programming Assignment #1 (Civilization – ASCII mode)
Deadline: 11:55 PM, 16 April 2019

## Notes
> This is an individual assignment; all the work must be your own.
>
> Download the project skeleton at
https://course.cse.ust.hk/comp3021/assignments/assignment1/PA1.zip and finish the implementations
using the skeleton.
>
> Zip your complete project directory to PA1.zip and submit it to CASS through
https://course.cse.ust.hk/cass/student/. Refer to http://cssystem.cse.ust.hk/UGuides/cass/index.html for
the details of uploading assignment using CASS.
>
> You can submit the assignment for as many times as you wish, we will only mark you latest submission.
>
> This PA accounts for 10% of the total course grade.
Cheating/plagiarism will be caught and punished HEAVILY!
University’s Honor code: http://tl.ust.hk/integrity/student-1.html
University’s Penalties for Cheating: http://tl.ust.hk/integrity/student-5.html

## Background
Civilization is a turn based strategy game where the objective is to conquer other players'
cities by developing our own resources and troops ([reference](https://en.wikipedia.org/wiki/Civilization_(video_game))). In this assignment, you
will complete a partial implementation of a simplified, ASCII-version civilization game.

This game involves two human players (according to the configuration in the
`players.txt` file that comes with the skeleton). In each turn, players are able to perform
tasks on cities through their ministers. Each human player has a set of cities under his/her
governance. The human player will have a list of ministers to carry out the various tasks
on the cities. Some of the possible actions are: collect tax, collect science and production
points, build improvements (banks, roads, universities) and recruit troops, see the
`selectAndPerformAction()` method in the `GameEngine.java` file for the list of
possible actions. Each minister has different intelligence, experience and leadership
values, these values are stored in the instance variables of the `minister` object. These
values affect how much gold, science and production collected. A minister of the player
can do one single task in each turn. If the player has 3 ministers, the player will be able
to perform three tasks per turn.

Gold, science points, and production points are the main resources of the game. The
player can spend these resources to perform various tasks in the game, such as building
banks, roads, universities, upgrading technologies, and recruiting troops. Using the
recruited troops, players can attack adjacent cities to conquer them. The game will end
when one player has conquered all cities on the map.
Please play with the supplied executable file on a Windows platform to see how the game
could be played.

## Getting Started
Importing the skeleton code
1. Download the skeleton code from the course website and unzip the file
2. In IntelliJ, go to `File > New > Project From Existing Sources...`
3. Choose the root directory of the skeleton code
4. Click Next, make sure the project format is .idea
5. When prompted to choose JDK version, choose JDK 10
6. Click finish
