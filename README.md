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

## The List and Map interfaces
We use the List and Map interfaces extensively to store references to game objects. The
List interface defines the set of methods you can do on a List (ArrayList, LinkedList, etc).
Whereas the Map interface defines the methods of a Map (key, value data structure such
as HashMap).

You can refer to the following documentations on the methods of these interfaces:
● List: https://docs.oracle.com/javase/10/docs/api/java/util/List.html
● Map: https://docs.oracle.com/javase/10/docs/api/java/util/Map.html

You will need the following methods for this assignment:
● List: size(), add(), get()
● Map: put(), get()

Since List and Map are interfaces, they can’t be instantiated. Instead, you can assign a
class that implements the interface. For example:
`List<T> list = new ArrayList<>();`
`Map<K, V> map = new HashMap<>();`

The `T, K, V` letters above are generic datatypes. See the following examples for the details
of replacing these generic datatypes with a real existing datatype. 

If you wish the ArrayList to store a particular type of elements, you will need to create an
ArrayList and indicate the type of elements being stored. For example, the following
statement:
`List<Player> players=new ArrayList<Player>();`
creates an empty ArrayList, players, which contains player reference as the elements.
To add new player to the ArrayList, we can do:
`// Create a player object with name being “Alex”, and the
// initial gold being 100 units
Player player = new Player(“Alex”,100,100,100);
// add the “player” to the “players” ArrayList
Players.add(player);`

A Map on the other hand acts as a “dictionary”. For each element in the Map, there are
two fields, one is the Key (K), the other field is the Value (V). The lines below create a
Map and each element of the Map consists of a String and a Double type data. Mind that
the K, and V are generic datatypes, so they can be any non-primitive data types (but
cannot be primitive). 
`Map<String,Double> fruitPrices=new HashMap<String,Double>();`

After creating the Map, we add the prices of fruits to the Map fruitPrices:
`fruitPrices.put("Apple",3.5);
fruitPrices.put("Pineapple",35.0);`

The fruit name Strings (“Apple” and “Pineapple”) will become the Keys of the two entries,
and if you wish to retrieve the Value field of “Pineapple”, you simply do this:
`Double price=fruitPrices.get(“Pineapple”);`

Then the variable, price, will hold the price of the “Pineapple”, which is 35.0. As
you can see, Map provides you an extremely convenient way of retrieving data using a
more meaningful index (a String representing the name of a fruit here, instead of the
meaningless index numbers 0,1,2,…n-1 in the case of an array).

To Use ArrayList and Map, you will need to have the following line in your Java file:
`import java.util.*;`

## UML Diagram Notation
The UML diagrams used in this document is generated by IntelliJ (Ctrl + Alt + Shift + U to
enter UML diagram edition mode). The notations used by IntelliJ is slightly different than
the standard notations we discussed during our lectures. We will illustrate the difference
using the Sample.java class UML diagram below:


The character “c” in the blue circle on the top row indicates that this is a class, the
character “f” in the yellow circle indicates this is a field (i.e. variable), and the character
“m” in the red circle indicates this is a “method”. The hollow dot at the left of the variable
“a” indicates that “a” has the “default” access right, the locked red lock at the left of the
variable “b” indicates that “b” has the “protected” access right, the gray key at the left of
the variable “c” indicates that “c” has the “private” access right. The opened lock at the
left of the variable “d” indicates that “d” has the “public” access right. For a method or a
constructor, the input type is shown in the parentheses and the output type is shown at
the right of the method name.

## Tasks
Your tasks are to complete all the TODO items in the skeleton code. A detailed
description of what you need to do is given in the Javadoc comments above each
TODO. In IntelliJ, you can go to View > Tool Windows > TODO to jump to each
TODO in the project.

## Running the executable file
An executable file for the PA could be downloaded from the PA1 link at the course web.
You could use it to verify the correctness of your finished PA. To run the executable file
under Windows (we only have Windows machine to compile it :( ), first you have to make
sure the two .txt files (Map.txt and Players.txt files) are in the same directory as the
executable file. Then Open a Windows command window, adjust the width of the
command window as indicate below for a better display:

Then issue the command:
`ASCII_civilization.exe`

## After you are done with the PA
Congratulations! Hope you have enjoyed it! Now you can Zip your complete project
directory to PA1.zip and submit this file to the CASS link shown on page 1. You can
submit for as many times as you wish before the deadline, but we will only mark you latest
submission.

## Late Submission Policy
There will be a penalty of -1 point (out of a maximum 100 points) for every minute you
submit the PA late. If you submit your PA1 at 00:30am on 17 April 2019 (Wednesday),
there will be a penalty of -35 points for your assignment. The lowest score you may get
from the assignment is zero. If you submit your PA1 at 2:35am on 17 April 2019 or later,
you will have zero for the PA1. So be sure to submit the finished PA1 as early as possible.
