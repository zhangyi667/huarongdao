# puzzle huarongdao 华容道 Klotski
# This directory contains:
* A README.md file
* A zip file contains the whole maven project.

## Brief description of the project
* A simple maven project, compiled and run in Java 8
* Source files are in src/main/java. 
* Test files are in src/test/java. Using JUnit as test framework.
* Main class is in com.medopad.game.Main. It takes a String[][] as input, which is already initialized. 

## My understanding of the project
* The best way to do this is to use BFS to try to get all the possible moves, and save all intermediate status.
Once reached the end of the game(in this case the D block moved to exit), travel all back to the start status and we can show all the moves.

* To make it work, use class Snapshot to save the status of one move. For every snapshot, it has a list to save all the possible next moves as "children", and a pointer to its previous status as "parent".
Once reached the end status, travel back by calling parent, and use a stack to save them thus we can have all start-to-end moves in order.

* Not all the intermediate status are worth saving. Only when we have NOT reached this status before.
* For an intermediate status(or a "snapshot"), generate its hashKey to judge if this status ever occured. Use a Set to save all the hashKey and judge if we've seen a status.
* And for the vertical blocks("AA"/"BB"/"HH"/"II") and single block("C F G J"), since they are symmetrical we can improve the algorithm by regarding them as same.    
   
## Assumptions I've made
* Input is String[][]
* For invalid params, throw Exception.
* Assume the initial puzzle contains all kinds of pieces.


## Had I got more time, I would...
* Consider using an int[][] to represent the intermediate status. At the moment I'm using a String[][], which is a little bit slow when doing clone() or generating hashKey. 
* Complete tests. Insufficient unit tests for all abstract classes.
* Refactor code. The logic is mess when generating intermediate status. I used Snapshot.createSnapshot1() and Snapshot.createSnapshot2() to generate all possible next moves, which is quite confusing because in the beginning there's no createSnapshot2().
I found this part of logic missing after writing most of the code so I had to add it as it is.  
