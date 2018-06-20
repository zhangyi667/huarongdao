# puzzle huarongdao 华容道 Klotski

## Brief description of the project
* A simple maven project, compiled and run in Java 8
* Source files are in src/main/java. 
* Test files are in src/test/java. Using JUnit as test framework.
* Main class is in com.medopad.game.Main. It takes a String[][] as input, which is already initialized. It finds the shortest moves to make it to the exit and print all moves.
   
## Assumptions I've made
* Input is String[][]
* For invalid params, throw Exception.
* Assume the initial puzzle contains all kinds of pieces.

## Example input is like:

XXXXXX
XADDHX
XADDHX
XBEEIX
XBFGIX
XC  JX
XXZZXX

A B H I are vertical pieces.
EE is horizon piece.
C F G J are single pieces.
D is the 2 x 2 piece.
X is the border. ZZ is the exit, and space is space.
